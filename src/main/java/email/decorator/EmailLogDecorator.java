package email.decorator;

import email.EmailService;
import email.EmailServiceImpl;
import employee.Employee;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EmailLogDecorator implements EmailService {
    private EmailServiceImpl emailServiceImpl;

    public EmailLogDecorator(EmailServiceImpl emailServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
    }

    @Override
    public boolean send(Employee from, List<Employee> recipient, String title, String content) throws FileNotFoundException {
           final Path exampleFile = Paths.get("C:", "Users", "okams", "Desktop", "wzorce", "design-pattern-exercise-7", "examplefile.txt");
       PrintWriter out = new PrintWriter("examplefile.txt");
        recipient.forEach(o -> out.println("Date: "+LocalDateTime.now() + " From: " +from+ " To: "+ o + " Title: " + title + " Content: " + content ));
        out.close();
        boolean email = emailServiceImpl.send(from, recipient, title, content);
        return email;
    }

}
