package org.Springframework.samples.SpringJDBCMaven;
import java.util.ArrayList;
import java.util.Scanner;
public class Index {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		 Goal g1=new Goal();
		 System.out.println("Enter the query:");
		 String  query= sc.nextLine();
		 ArrayList<String> token=g1.token1(query);		 
		 //task1
		 g1.fname(query);
		 //task2  
		 g1.basefilter(query);
		 //task 3
		 String lastResult=g1.endfilter(query);
		 System.out.println(lastResult);
		 //task4
		 ArrayList<String> conditionResult=g1.conditions(lastResult);
		 System.out.println(conditionResult);
		 //task5
		 g1.operator(token);
		 //task6
		 ArrayList<String> selectResult=g1.selectInfo(query);
		 System.out.println(selectResult);
		 //task7
		 String orderResult=g1.order(query);	
		 System.out.println(orderResult);
		 //task 8
		 String groupResult= g1.group(query);
		 System.out.println(groupResult);
		 //task 9
		 String aggregateResult=g1.aggregate(query);
		 System.out.println(aggregateResult);
		 // goal 3
		 Goal3 obj3=new Goal3();
		 obj3.goalHead();
		 //goal 5
		 g1.goal5(selectResult,conditionResult);
	}
}
