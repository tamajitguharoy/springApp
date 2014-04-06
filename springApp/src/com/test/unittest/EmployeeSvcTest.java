package com.test.unittest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import com.dao.IEmployeeDao;
import com.entity.Employee;
import com.service.EmployeeSvc;
@RunWith(MockitoJUnitRunner.class)
public class EmployeeSvcTest {
	@InjectMocks
	EmployeeSvc employeeSvc;
	@Mock 
	IEmployeeDao mock ;
	@Test
	public void testFindById(){
		//IEmployeeDao mock=mock(IEmployeeDao.class);
		doReturn(new Employee(1, "tamajit")).when(mock).findById(1);
		
		Employee employee = employeeSvc.findById(1);
		
		Assert.assertEquals("tamajit", employee.getEname());
		verify(mock).findById(anyInt());
		
	}
	
	@Test
	public void testSave(){
		employeeSvc.save(new Employee(1, "tamajit"));
		ArgumentCaptor<Employee> argumentCaptor = ArgumentCaptor.forClass(Employee.class);
	//	verify(mock).save(any(Employee.class));
		verify(mock).save(argumentCaptor.capture());
		Assert.assertEquals(new Integer(1), argumentCaptor.getValue().getEid());
		Assert.assertEquals("tamajit", argumentCaptor.getValue().getEname());
	}
	@Test
	public void testDelete(){
		employeeSvc.delete(1);

		verify(mock).delete(anyInt());

	}
	
	
}
