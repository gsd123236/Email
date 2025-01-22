package education.email.send.Controller;

import education.email.send.Entity.Mail;
import education.email.send.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class MailController {

    @Autowired
    private MailService service;

    @PostMapping("/{mailsend}")
    public String sendMail(@PathVariable String mailsend, @RequestBody Mail mail) {
        service.sendMail(mailsend, mail);
        return "Mail Sent Successfully....";
    }
}
