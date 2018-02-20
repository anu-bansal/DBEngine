package org.Springframework.samples.SpringJDBCMaven;

import java.util.Scanner;


public class Index {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		 Goal g1=new Goal();
		 System.out.println("Enter the query:");
		 String  query= sc.nextLine();
		 g1.token1(query);		 
		 //task1
		 g1.fname(query);
		 //task2 and task 3 
		 g1.basefilter(query);
		 //task4
		 g1.conditions(query);
		 //task5
		 g1.operator(query);
		 //task6
		 g1.selectInfo(query);
		 //task7
		 g1.order(query);	
		 //task 8
		 g1.group(query);
		 //task 9
		 g1.aggregate(query);
		 // goal 3
		 Goal3 obj3=new Goal3();
		 obj3.goalHead();
		 //goal 5
		 g1.goal5(query);

	}

}
