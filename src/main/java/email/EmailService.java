package email;

import employee.Employee;

import java.io.FileNotFoundException;
import java.util.List;

public interface EmailService {
    boolean send(Employee from, List<Employee> recipient, String title, String content) throws FileNotFoundException;
}
