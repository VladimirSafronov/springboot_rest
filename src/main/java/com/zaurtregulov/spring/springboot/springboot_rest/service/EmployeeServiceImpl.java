package com.zaurtregulov.spring.springboot.springboot_rest.service;


import com.zaurtregulov.spring.springboot.springboot_rest.dao.EmployeeDAO;
import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDAO employeeDAO;

  @Transactional
  public List<Employee> getAllEmployees() {
    return employeeDAO.getAllEmployees();
  }

  @Transactional
  public void saveEmployee(Employee employee) {
    employeeDAO.saveEmployee(employee);
  }

  @Transactional
  public Employee getEmployee(int id) {
    return employeeDAO.getEmployee(id);
  }

  @Transactional
  public void deleteEmployee(int id) {
    employeeDAO.deleteEmployee(id);
  }
}
