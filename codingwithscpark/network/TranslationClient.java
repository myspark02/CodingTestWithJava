package codingwithscpark.network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class TranslationClient extends JFrame implements ActionListener{
    private BufferedReader reader;
    private PrintWriter writer;
    private JTextField textField;
    private JTextArea textArea;

    public TranslationClient() throws Exception {
        this.setTitle("단어 번역(?) 클라이언트");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textField = new JTextField(50);
        textField.addActionListener(this);

        textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(textField, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        Socket socket = new Socket("localhost", 9101);
        InputStream inStream = socket.getInputStream();
        OutputStream outStream = socket.getOutputStream();
        
        reader = new BufferedReader(new InputStreamReader(inStream));
        writer = new PrintWriter(outStream, true);

        // 클라이언트가 서버에 접속하면 보내주는 두 개의 메시지를 읽어 textArea에 추가하자.
        // 이것도 이 클라이언트와 서버와의 통신 프로토콜이다. 
        String msgFromServer = reader.readLine();
        // 서버의 메시지를 한 라인씩 읽었을 때 개행문자는 반환되는 문자열에 포함되지 않기 때문에 강제로 붙여준다.
        textArea.append(msgFromServer + "\n"); 

        msgFromServer = reader.readLine();
        textArea.append(msgFromServer + "\n"); 

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed...");
        String word2Translate = textField.getText();
        // 사용자가 입력한 단어를 서버로 전송한다. writer에 써주면 자동으로 전송된다.
        writer.println(word2Translate);

        // 서버가 보내주는 결과를 읽는다. 
        try {
            String wordTranslated = reader.readLine();
            textArea.append(wordTranslated + "\n");
        } catch(IOException err) {
            err.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        try {
            TranslationClient client = new TranslationClient();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
