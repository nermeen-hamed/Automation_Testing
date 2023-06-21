package testSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

public class Utils {
    public static String URL="http://live.techpanda.org/index.php/";
    public static WebDriver driver;
    public static void setupCredintials(String URL) {
       /* WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();*/
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void readCSVFile(String path) throws FileNotFoundException {
        Scanner sc=new Scanner (new File(path));
         sc.useDelimiter(",");
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
        sc.close();

    }
    public static void sendEmail(String to,String pass,String from,String filepath){
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);

        props.put("mail.smtp.password", pass);

        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("Username", "password");
                    }
                });


        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            System.out.println("Set To ");
            // Set Subject: header field
            message.setSubject("Testing Subject");


            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();


            // Now set the actual message
            messageBodyPart.setText("This is message body");



            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = filepath;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));

            messageBodyPart.setFileName(filename);

            multipart.addBodyPart(messageBodyPart);


            // Send the complete message parts
            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");

            transport.connect(host, from, pass);

            transport.send(message);

            transport.close();


            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
}

