package com.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employee;
import com.exceptions.EmployeeNotFoundException;
@Repository
@Transactional
public class EmployeeDao extends BaseDao implements IEmployeeDao {

	@Override
	public void save(Employee employee) {
		getEntityManager().merge(employee);
		
	}

	@Override
	public Employee findById(Integer id) {
		return getEntityManager().find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		return getEntityManager().createQuery("from Employee").getResultList();
	}

	
	@Override 
	public void delete(Integer id) {
		
		Employee employee = getEntityManager().getReference(Employee.class, id);
	
	//	try{
		getEntityManager().remove(employee);
//		}catch(Exception e){
//			new EmployeeNotFoundException();
//		}
		
	}
	
	
	
	

}
