package com.test;

import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import antlr.collections.List;

import com.entity.Employee;
import com.service.IEmployeeSvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context.xml")
public class SpringAppTests {
@Autowired
IEmployeeSvc employeeSvc;
@Test
public void testCRUD() {
	Employee[] empList={new Employee(1,"tamajit"),new Employee(2,"alex")};
	employeeSvc.save(empList[0]);
Assert.assertEquals("tamajit",employeeSvc.findById(1).getEname());
Assert.assertEquals(new Integer(1),new Integer(employeeSvc.findAll().size()));
employeeSvc.save(empList[1]);
Assert.assertEquals(new Integer(2),new Integer(employeeSvc.findAll().size()));
employeeSvc.delete(1);
Assert.assertEquals(new Integer(1),new Integer(employeeSvc.findAll().size()));
employeeSvc.delete(2);
Assert.assertEquals(new Integer(0),new Integer(employeeSvc.findAll().size()));

}
@Test(expected=EntityNotFoundException.class)
public void testEmployeeNotFoundException() {

employeeSvc.delete(100000);


}
}