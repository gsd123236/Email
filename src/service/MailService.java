package education.email.send.Services;

import education.email.send.Entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

        @Autowired
        private JavaMailSender javaMailSender;



    @Value("${spring.mail.username}")
    private String fromMail;
    public void sendMail(String mailsend, Mail mail ){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getMessage());

        simpleMailMessage.setTo(mailsend);

        javaMailSender.send(simpleMailMessage);
    }
}
