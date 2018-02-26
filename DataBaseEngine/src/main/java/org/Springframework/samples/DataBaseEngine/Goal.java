package org.Springframework.samples.DataBaseEngine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Goal {
	String first = null;
	String last = null;
	static int index1;
	static String operate = null;
	static String selected;
	ArrayList<String> con = new ArrayList<String>();
	ArrayList<String> token = new ArrayList<String>();
	// To tokenise entered query and adding into arraylist
	public ArrayList<String> token1(String query) {
		String words = null;
		StringTokenizer st = new StringTokenizer(query, " ");
		while (st.hasMoreTokens()) {
			words = st.nextToken();
			token.add(words);
			System.out.println(words);
		}
		return token;
	}
	// To get .csv file name from the entered query
	public String fname(String query) {
		String code = "";
		System.out.print("File Name: ");
		Pattern p = Pattern.compile("[\\w]+\\.(csv)");
		Matcher m = p.matcher(query);
		while (m.find())
			code = m.group();
		System.out.println(code);
		return code;
	}
	// To get string before 'where' from the query
	public String basefilter(String query) {
		index1 = query.indexOf("where");
		System.out.print("Query before where: ");
		first = query.substring(0, index1);
		System.out.println(first);
		return first;
	}
	// To get string after 'where' from the query
	public String endfilter(String query) {
		System.out.print("Query after where: ");
		int index2 = index1 + ("where ".length());
		last = query.substring(index2, query.length());
		return last;
	}
	// To get conditions to select particular valued rows
	public ArrayList<String> conditions(String last) {
		ArrayList<String> condition= new ArrayList<String>();
		System.out.println("Conditions: ");
		Pattern p2 = Pattern.compile("([\\w]+[ ]?)((<=)|(>=)|(<>)|=|<|>)([ ]?[']?[\\w]+[ ]?[\\w]*[']?)");
		Matcher m2 = p2.matcher(last);
		while (m2.find())
			condition.add(m2.group());
		return condition;
	}
	// To get operators like and,or and not from the entered string
	public String operator(ArrayList<String> token) {
		for (String operatorCollection : token) {
			if ((operatorCollection.equalsIgnoreCase("and")) || (operatorCollection.equalsIgnoreCase("or"))
					|| (operatorCollection.equalsIgnoreCase("not")))
				System.out.println("Logical operators in statement: " + operatorCollection);
		}
		return "error";
	}
	// To get selected fields/information from the entered query
	public ArrayList<String> selectInfo(String query) {
		System.out.println("selected fields/information from the given query");
		int index3 = token.indexOf("from");
		con.addAll(token.subList(1, index3));
		Iterator<String> iterator = con.iterator();
		while (iterator.hasNext()) {
			String itrstr = iterator.next();
			selected = itrstr.replace(",", " ");
			System.out.println(selected);
		}
		return con;
	}
	// To get string after 'order by'
	public String order(String query) {
		String afterOrderBy = null;
		if (query.contains("order")) {
			int index4 = query.indexOf("order by") + ("order by ".length());
			afterOrderBy = query.substring(index4, query.length());
			System.out.println("After order by:");
		} else
			System.out.println("doesn't contain any order by clause");
		return afterOrderBy;
	}
	// To get string after 'group by'
	public String group(String query) {
		String afterGroupBy = null;
		if (query.contains("group")) {
			int index5 = query.indexOf("group by") + ("group by ".length());
			afterGroupBy = query.substring(index5, query.length());
			System.out.println("After group by:");
		} else
			System.out.println("doesn't contain any group by clause");
		return afterGroupBy;
	}
	// To get aggregate function from entered query
	public String aggregate(String query) {
		System.out.println("aggregate functions");
		Pattern p = Pattern.compile("[a-zA-Z]+[(][\\w]+[)]");
		Matcher m = p.matcher(query);
		while (m.find())
			System.out.println(m.group());
		return "in function aggregate";
	}
	// To fulfill goal 5 of retrieving data fron ipl.csv file according to query entered
	public String goal5(ArrayList<String> selectResult, ArrayList<String> conditionResult) {
		String csvFile = "ipl.csv";
		BufferedReader br = null;
		String csvSplit = ",";
		String line = "";
		String heading = null;
		String[] data = null;
		ArrayList<Integer> conditionHeadingMatch = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader(csvFile)); 
			//To get heading elements from ipl.csv file
			heading = br.readLine();
			String strArray[] = heading.split(csvSplit);
			List<String> headingList = Arrays.asList(strArray);
			//To add heading elements from a string into arraylist
			ArrayList<String> headingArray = new ArrayList<String>(headingList);
			System.out.println(headingArray);
			String condition=conditionResult.toString().replace("[", "").replace("]", "").replace("'", "").replace(",", "");
			String strArray1[] = condition.split(" ");
			List<String> conditionList = Arrays.asList(strArray1);
			ArrayList<String> conditionArray = new ArrayList<String>(conditionList);
			System.out.println(conditionArray);
			//comparing elements of heading and elements of condition field from the queue
				for (int i = 0; i < conditionArray.size(); i++) {
				for (int j = 0; j < headingArray.size(); j++) {	
					if ((conditionArray.get(i)).equals(headingArray.get(j))) 
						conditionHeadingMatch.add(j);	
					}
				}
					System.out.print(conditionHeadingMatch);
					
					for(int y=0;y<conditionHeadingMatch.size();y++) {
						System.out.println();
						for (int i = 0; i < conditionArray.size(); i++) {
						while ((line = br.readLine()) != null) {
							data = line.split(csvSplit);
							if(i<(conditionArray.size()-2)) {
							if((data[conditionHeadingMatch.get(y)]).startsWith(conditionArray.get(i+2))) 
							{
								for (int k = 0; k < selectResult.size(); k++) {
									for (int l = 0; l < headingArray.size(); l++) {		                              
										if ((selectResult.get(k)).equals(headingArray.get(l)))
							System.out.print(data[l]+" ");									
									}
								}
							}
						}
						}
						
						
						br=new BufferedReader(new FileReader(csvFile)); 
						br.readLine();
					}
					}
				
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}catch (NumberFormatException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		finally {
			//To close bufferReader after completion of tasks
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "in goal5";
	}
}
