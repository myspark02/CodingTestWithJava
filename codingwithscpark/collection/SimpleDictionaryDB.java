package codingwithscpark.collection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class SimpleDictionaryDB extends JPanel implements ActionListener {
    private JTextField inputField = new JTextField(30);
    private JButton searchBtn = new JButton("검색");   
    private JButton addBtn = new JButton("추가"); 
    private JPanel searchAddPanel = new JPanel();
    private Map<String, String> dict = new HashMap<>();

    private String driverClassName ;
    private String dbUrl ;
    private String userName, userPassword;
 
    public SimpleDictionaryDB() {
        searchAddPanel.add(inputField);
        searchAddPanel.add(searchBtn);
        searchBtn.addActionListener(this);
        searchAddPanel.add(addBtn);
        addBtn.addActionListener(this);
        searchAddPanel.setPreferredSize(new Dimension(600, 50));

        this.setLayout(new BorderLayout());
        this.add(searchAddPanel, BorderLayout.CENTER);

        initialize();

    }

    private void initialize() {
        Connection con = null;
        try {
            Properties dbconfig = new Properties();
            File file = new File("dbconfig.props");
            System.out.println(file.getAbsolutePath());
            FileReader reader = new FileReader(file);
            dbconfig.load(reader);

            driverClassName = dbconfig.getProperty("driverClassName");
            dbUrl = dbconfig.getProperty("Url");
            userName = dbconfig.getProperty("userName");
            userPassword = dbconfig.getProperty("userPassword");
            System.out.printf("%s\n%s\n%s\n%s\n", driverClassName, dbUrl, userName, userPassword);

            dbconfig.load(reader);
            Class.forName(driverClassName);  // JDBC 드라이버를 찾아서 메모리에 적재
            con = DriverManager.getConnection(dbUrl, userName, userPassword); // 데이터베이스 서버와 연결 

            PreparedStatement pstmt = con.prepareStatement("select * from simple_dict");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {  // DB에서 읽어와 HashMap에 등록한다. 
                String key = rs.getString("keyword");
                String value = rs.getString("value");
                dict.put(key, value);
            }
        } catch(ClassNotFoundException e) {
            System.out.println(driverClassName + "를 찾을 수 없습니다.");
        } catch(SQLException e) {
            System.out.println("데이터베이스 서버에 연결할 수 없습니다...:" + e.getMessage());
        } catch(IOException e) {
            System.out.println("dbconfig.props 파일을 읽을 수 없습니다...:" + e.getMessage());
        } finally {
            try {
                con.close();  // 데이터베이스와의 연결 해제 
            } catch(Exception e) {}   
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == searchBtn) {
            String key = inputField.getText();
            String value = dict.get(key);
            if (key.trim().length() == 0 || value == null) {
                JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다.", "단어찾기 실패", JOptionPane.ERROR_MESSAGE);
            } else  {        
                JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
            }
            inputField.requestFocus();
       } else if (e.getSource() == addBtn) {
            String key = inputField.getText();
            String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영어 단어를 입력하세요.");
            
            if (key.trim().length() > 0 && value.trim().length() > 0) {
                dict.put(key, value);    
                addToDB(key, value);
                JOptionPane.showMessageDialog(this, "영어단어가 추가되었습니다." , "추가성공", JOptionPane.INFORMATION_MESSAGE);
            }  
       }
       repaint();
    }

    private void addToDB(String key, String value)  {
        try (Connection con = DriverManager.getConnection(dbUrl, userName, userPassword)) {
            String sql = "insert into simple_dict(keyword, value) values(?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, key);
            pstmt.setString(2, value);
            pstmt.executeUpdate();

        } catch(SQLException e) {
            System.out.println("DB에 데이터를 삽입할 수 없습니다. : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JPanel panel = new SimpleDictionaryDB();

        JFrame frame = new JFrame();
        frame.setTitle("나의 영어 단어장");
        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    
}
