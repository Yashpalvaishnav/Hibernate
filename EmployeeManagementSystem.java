package com.te.employee.operations;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
//import java.util.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.jpawithHibernate.bean.Employee;

import antlr.collections.List;

public class EmployeeManagementSystem 
{
public static void main(String[] args) throws ParseException, IdnotpresentException {
	Scanner scanner=new Scanner(System.in);
	
	System.out.println("press 1 for see all the data");
	System.out.println("press 2 for see any perticular Data");
	System.out.println("press 3 for Update any perticular Data");
	System.out.println("press 4 for delete data");
	int Option=scanner.nextInt();
	switch(Option)
	{
	case(1):
	{
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		factory=Persistence.createEntityManagerFactory("employeedata");
		manager=factory.createEntityManager();
	String readall ="from Employee";
	Query query=manager.createQuery(readall);
java.util.List list=	query.getResultList();
System.out.println("data whicch is present");
for (Object object : list) {
	System.out.println(object);
}
break;
	}
	case(2):
	{
		System.out.println("enter the id which you want to see the data");
		int id=scanner.nextInt();
		
		EntityManagerFactory factory1=null;
		EntityManager manager1=null;
		EntityTransaction transaction1=null;
		
			factory1=Persistence.createEntityManagerFactory("employeedata");
			manager1 =factory1.createEntityManager();
			transaction1=manager1.getTransaction();
			transaction1.begin();
			String select1="select id from Employee";
			Query query1=manager1.createQuery(select1);
		java.util.List list1=query1.getResultList();
	   // System.out.println(list);
		System.out.println("id present are");
		for (Object object1 : list1) {
			System.out.println(object1);
		}
		
		if(list1.contains(id))
		{
		
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
	EntityTransaction transaction=null;
		
			factory=Persistence.createEntityManagerFactory("employeedata");
			manager =factory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			String select="from Employee where id = : id";
			
			Query query=manager.createQuery(select);
			query.setParameter("id", id);
		java.util.List<Employee> list=query.getResultList();
	   // System.out.println(list);
		System.out.println("the perticular data ");
		for (Object object : list) {
			System.out.println(object);
		}
			//System.out.println(result+"data updateds sucessfully");
		 
	}else
	{
	try {
		IdnotpresentException exception=new IdnotpresentException("id not present");
		System.out.println(exception.getMessage());
		
		throw new IdnotpresentException("id not present");
	} catch (IdnotpresentException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}
	}
		break;
	}
	case(3):
	{
		System.out.println("press 1 edit name");
	System.out.println("press 2 edit phone");
	System.out.println("press 3 edit doj");
	
	int Option1=scanner.nextInt();
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	factory=Persistence.createEntityManagerFactory("employeedata");
	manager =factory.createEntityManager();
	transaction=manager.getTransaction();
	transaction.begin();
	
	
	
	switch(Option1)
	{
	case(1):
	{
		
		System.out.println("enter the id you want to update");
		int id=scanner.nextInt();
		System.out.println("do you want update name");
		String name=scanner.next();
		
		String query="update Employee set name = : name where id = : id";
		
		Query query2=manager.createQuery(query);
		query2.setParameter("name", name);
		query2.setParameter("id", id);
		int result=query2.executeUpdate();
		System.out.println(result+"rows afftected");
		transaction.commit();
		break;
		
	}
	case(2):
	{
		System.out.println("enter the id you want to update");
		int id=scanner.nextInt();
		System.out.println("enter the phonenumber to update");
		int phonenumber=scanner.nextInt();
String query="update Employee set phonenumber = : phonenumber where id = : id";
		
		Query query2=manager.createQuery(query);
		query2.setParameter("phonenumber", phonenumber);
		query2.setParameter("id", id);
		int result=query2.executeUpdate();
		System.out.println(result+"rows afftected");
		transaction.commit();
		break;
	}
	case(3):
	{
		System.out.println("enter the id you want to update");
		int id=scanner.nextInt();
		
		System.out.println("enter the date");
		String strdate=scanner.next();
	
		
		
			java.util.Date date=new SimpleDateFormat("dd.MM.yyyy").parse(strdate);
			java.sql.Date sqldate=new java.sql.Date(date.getTime());
			System.out.println(sqldate);
			date=sqldate;
String query="update Employee set date = : date  where id = : id";

		
		Query query2=manager.createQuery(query);
		query2.setParameter("date", date);
		query2.setParameter("id", id);
		int result=query2.executeUpdate();
		System.out.println(result+"rows afftected");
		transaction.commit();
		
		
		
		
	}
	
	}
	
	break;
	}
	case(4):
	{
		System.out.println("enter the id which you want to delete");
		int id=scanner.nextInt();
		
		EntityManagerFactory factory1=null;
		EntityManager manager1=null;
		EntityTransaction transaction1=null;
		
			factory1=Persistence.createEntityManagerFactory("employeedata");
			manager1 =factory1.createEntityManager();
			transaction1=manager1.getTransaction();
			transaction1.begin();
			String select1="select id from Employee";
			Query query1=manager1.createQuery(select1);
		java.util.List list1=query1.getResultList();
	   // System.out.println(list);
		System.out.println("id present are");
		for (Object object1 : list1) {
			System.out.println(object1);
		}
		if(list1.contains(id))
		{
		
		
		
		
		
		
		
		
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		factory=Persistence.createEntityManagerFactory("employeedata");
		manager =factory.createEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
		System.out.println("enter the id you want to delete");
		int id1=scanner.nextInt();
		//System.out.println("enter the data to update");
		//int phonenumber=scanner.nextInt();
String query="delete from Employee where id = :id";

		
		Query query2=manager.createQuery(query);
		
		query2.setParameter("id", id1);
		int result=query2.executeUpdate();
		System.out.println(result+"rows afftected");
		transaction.commit();
		break;
		}
		else
		{
			throw new IdnotpresentException("id not present");
			
		}
	}
	}
	
}
}