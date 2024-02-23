package lessons.module_5.lesson_5_1;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class MailSending {
    public static void main(String[] args) throws MessagingException {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter code: ");
        String code=sc.nextLine();

        System.out.print("Enter address: ");
        String address=sc.nextLine();

        sendMail("email verification", code, address);
    }

    public static void sendMail(String subject, String text, String recipient) throws MessagingException {
        String from = "utkirbekqutfiddinov@gmail.com";
        String token = "lylxrfextvqlfcso";

        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.auth","true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, token);
            }
        };

        Session session = Session.getInstance(props, auth);


        Message message = new MimeMessage(session);

        message.setSubject(subject);
        message.setText(text);
        message.setSentDate(new Date());
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, new Address[]{new InternetAddress(recipient)});

        BodyPart music=new MimeBodyPart();
        music.setFileName("jaloliddin.mp3");
        music.setDataHandler(new DataHandler(new FileDataSource(new File("music.mp3"))));


        Multipart multipart=new MimeMultipart();

        multipart.addBodyPart(music);

//        message.setContent(multipart);

        Transport.send(message);
        System.out.println("Mail sent successfully");
    }
}
