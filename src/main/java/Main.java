import email.EmailServiceImpl;
import email.decorator.EmailLogDecorator;
import employee.Employee;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        EmailServiceImpl emailServiceImpl= new EmailServiceImpl();
        EmailLogDecorator emailLogDecorator = new EmailLogDecorator(emailServiceImpl);

        Employee manager = new Employee("Janusz Kowalski");

        Employee workerOne = new Employee("Piotr Kozik");
        Employee workerTwo = new Employee("Adam Nowacki");

        emailLogDecorator.send(manager, Arrays.asList(workerOne,workerTwo),"titleOne","contentOne");

    }
}
