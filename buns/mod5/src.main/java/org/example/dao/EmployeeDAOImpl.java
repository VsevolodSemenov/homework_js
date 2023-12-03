package java.org.example.dao;

import java.org.example.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Employee", Employee.class).getResultList();
	}

	@Override
	public void save(Employee employee) {
		sessionFactory.getCurrentSession()
				.saveOrUpdate(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Employee where id =:empId")
				.setParameter("empId", id)
				.executeUpdate();
	}
}
