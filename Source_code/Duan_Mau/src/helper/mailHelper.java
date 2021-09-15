/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextField;

/**
 *
 * @author Tran Van Thanh
 */
public class mailHelper {
    private static int randumCode;
    public static int sendcode(JTextField txt){
        try {
            Random random = new Random();
            randumCode = random.nextInt(999999);//tạo 1 số ngẫu nhiên từ 0 đến 999999            
            String host = "smtp.gmail.com";
            String user = "vanthanh10012k@gmail.com";
            String pass = "thanhk52a2";
            String to = txt.getText();
            String subject = "Reseting Code";
            String message = "Your reset code is " + randumCode;
            boolean sessionDebug = false;
            //!.Tạo 1 dối tượng Properties
            Properties pros = new Properties();
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.host", "smtp.gmail.com");//2.Chỉ ra máy chủ mail của gg
            pros.put("mail.smtp.port", 587);//3.Chỉ ra port : 587 Cổng vào ra dữ liệu
            pros.put("mail.smtp.starttls.required", "true");
            pros.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Session mailSession = Session.getInstance(pros,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user,pass);//Tài khoản Gmail của bạn và pass
                }
            }
            );
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
//            Gán giá trị cho các thuộc tính đôi tượng msg
            msg.setFrom(new InternetAddress(user));//5.Từ địa chỉ Gmail nào gưởi đi
//            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));//Tù Gmail gưởi đến mai nào
            msg.setSubject(subject);//Tiêu đề thư
            msg.setText(message);//Nội dung thư
//            Transport.send(msg);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host,user,pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();            
        } catch (Exception e) {
            e.printStackTrace();
            dialogHelper.alert(null,"Tài khoản gmail không hoạt động");
        }
        return randumCode;
    }
}
