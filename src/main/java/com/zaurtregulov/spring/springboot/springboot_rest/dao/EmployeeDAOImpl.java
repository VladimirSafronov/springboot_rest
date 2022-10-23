package com.zaurtregulov.spring.springboot.springboot_rest.dao;


import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  //создание EntityManager происходит за кулисами (это SessionFactory из Hibernate)
  @Autowired
  private EntityManager entityManager;

  public List<Employee> getAllEmployees() {
    //получение hibernate сессии
    //EntityManager это обертка Session
    Session session = entityManager.unwrap(Session.class);

    Query<Employee> query = session.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }

  public void saveEmployee(Employee employee) {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(employee);
  }

  public Employee getEmployee(int id) {
    Session session = entityManager.unwrap(Session.class);
    return session.get(Employee.class, id);
  }

  public void deleteEmployee(int id) {
    Session session = entityManager.unwrap(Session.class);
    Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
    query.setParameter("employeeId", id);
    query.executeUpdate();
  }
}
