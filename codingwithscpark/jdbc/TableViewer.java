package codingwithscpark.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TableViewer extends JFrame implements ActionListener {
    private JTextField idField, titleField, publisherField, yearField, priceField, authorField;
    private JButton previousBtn, nextBtn, insertBtn, finishBtn; //, deleteBtn, searchBtn;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private Connection con = null;

    public TableViewer() {
        super("Database Viewer"); // new JFrame("Database Viewer");
        
        con = null;
        try { 
            con = makeConnection();
        } catch(Exception e) {
            System.out.println("데이터베이스에 연결할 수 없어 프로그램을 종료합니다.");
            System.out.println(e.getMessage());
            return;
        }
        try {
            String sql = "select * from books";
            pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            rs = pstmt.executeQuery();
        } catch(Exception e) {
            System.out.println("SQL 문을 실행에 문제 발생.");
            System.out.println(e.getMessage());
            System.out.println("프로그램을 종료합니다.");
            return;
        }
        
        this.setLayout(new GridLayout(0, 2));
        
        this.add(new JLabel("ID", JLabel.CENTER));
        idField = new JTextField();
        this.add(idField);

        this.add(new JLabel("Title", JLabel.CENTER));
        titleField = new JTextField();
        this.add(titleField);

        this.add(new JLabel("Publisher", JLabel.CENTER));
        publisherField = new JTextField();
        this.add(publisherField);

        this.add(new JLabel("Year", JLabel.CENTER));
        yearField = new JTextField();
        this.add(yearField);

        this.add(new JLabel("Price", JLabel.CENTER));
        priceField = new JTextField();
        this.add(priceField);

        // this.add(new JLabel("저자검색", JLabel.CENTER));
        // authorField = new JTextField();
        // this.add(authorField);

        previousBtn = new JButton("Previoues");
        previousBtn.addActionListener(this);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);

        this.add(nextBtn);
        this.add(previousBtn);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // this.addWindowListener(new WindowAdapter() {
        //     @Override
        //     public void windowClosing(WindowEvent event) {
        //         try {
        //             con.close();
        //         }catch(Exception e) {}
        //         this.dispose();
        //         System.exit(0);
        //     }
        // });

        this.setSize(350, 200);
        this.setResizable(false);


        this.setVisible(true);
    }

    private static Connection makeConnection() throws Exception {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == nextBtn) {
                rs.next();
            } else if(e.getSource() == previousBtn){
                rs.previous();
            }

            int bookId = rs.getInt("book_id");
            idField.setText(String.valueOf(bookId));

            String title = rs.getString("title");
            titleField.setText(title);

            String publisher = rs.getString("publisher");
            publisherField.setText(publisher);

            Date date = rs.getDate("year");
            yearField.setText(String.valueOf(date));

            int price = rs.getInt("price");
            priceField.setText(String.valueOf(price));
        } catch(Exception err) {
            err.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        new TableViewer();
    }
}
