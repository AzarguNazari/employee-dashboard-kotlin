package services;

import models.JPA.Employee;
import models.JPA.EmployeeDto;
import models.JPA.Title;
import exceptions.InvalidInput;
import com.dashboard.repositories.EmployeeRepository;
import interfaces.serviceInterfaces.DashboardServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DashboardService implements DashboardServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createAccount(EmployeeDto employeeDto) throws InvalidInput {

        if(!employeeDto.getPassword1().equalsIgnoreCase(employeeDto.getPassword2())){
            throw new InvalidInput("Passwords do not match");
        }

        Employee employee = new Employee(employeeDto.getUsername(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getPassword1(), employeeDto.getSalary(), Title.valueOf(employeeDto.getPosition()));
        employeeRepository.save(employee);
        log.debug("New employee is saved {}", employee);
    }

}
