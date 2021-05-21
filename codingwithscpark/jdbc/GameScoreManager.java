package codingwithscpark.jdbc;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;

public class GameScoreManager extends JFrame implements ActionListener{
     private JTable table;
     private JTextField nameField;
     private JTextField scoreField;
     private JButton submitBtn;

     private MyTableModel model;

     public GameScoreManager() {
         super("명예의 전당");
         this.setSize(600, 300);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         model = new MyTableModel();
         model.fillTable();

         JLabel label = new JLabel("명예의 전당", JLabel.CENTER);
         label.setFont(new Font("SansSerif", Font.PLAIN, 30));
         this.add(label, BorderLayout.NORTH);

         table = new JTable(model);

         JScrollPane scrollPane = new JScrollPane(table);
        
         scrollPane.setPreferredSize(new Dimension(500, 200));
         this.add(scrollPane, BorderLayout.CENTER);

         JPanel panel = new JPanel();

         panel.add(new JLabel("이름"));
         nameField = new JTextField(10);
         panel.add(nameField);

         panel.add(new JLabel("점수"));
         scoreField = new JTextField(10);
         panel.add(scoreField);

         submitBtn = new JButton("점수 제출");
         submitBtn.addActionListener(this);
         panel.add(submitBtn);

         this.add(panel, BorderLayout.SOUTH);
         this.setVisible(true);
     }
    @Override
    public void actionPerformed(ActionEvent e) {
       String name = nameField.getText();
       String score = scoreField.getText();

       try (Connection con = makeConnection()) {
           String sql = "insert into gamescore values(?, ?)";
           PreparedStatement pstmt = con.prepareStatement(sql);
           pstmt.setString(1, name);
           pstmt.setString(2, score);

           pstmt.executeUpdate();

       }catch(Exception err) {
           System.err.println(err.getMessage());
       }

       model.fillTable();
        
    }

    public static Connection makeConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/oop";
        String id = "root";
        String password = "mysql!23";

        Connection con = null;
 
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("드라이버 적재 성공");

        con = DriverManager.getConnection(url, id, password);
        System.out.println("데이터베이스 연결 성공");

        return con;
    
    }

    public static void main(String[] args) {
        GameScoreManager mgr = new GameScoreManager();
    }
    
}


class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"이름", "점수"};
    private static final int ROWS = 10;
    private static final int COLS = 2;
    Object[][] data = new String[ROWS][COLS];

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public void fillTable() {
        try(Connection con = GameScoreManager.makeConnection()) {
            String sql = "select * from gamescore order by score desc limit " + ROWS;
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            int row = 0;
            while (rs.next()) {
                data[row][0] = rs.getString("name");
                data[row][1] = rs.getString("score");
                System.out.println(Arrays.toString(data[row]));
                row++;
            }
            this.fireTableDataChanged();
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        this.fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
}