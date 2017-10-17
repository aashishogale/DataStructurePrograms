package com.bridgelabz.Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.Programs.Queue;

public class Util {
	static Scanner sc =new Scanner(System.in);
	static Random random;
	static  int array[]=new int[52];
	static String addressbooks="/home/bridgeit/Desktop/addressbook.json";

	public static String[] readFile(String filePath) {
		String words[] = {};
		ArrayList<String> lines = new ArrayList<String>();
		String line, temp[] = {};
		BufferedReader bufferedReader;
		FileReader file;
		int index = 0;
		try {
			file = new FileReader(filePath);
			bufferedReader = new BufferedReader(file);
			while ((line = bufferedReader.readLine()) != null) {
				temp = line.split(",|\\s");
				for (int i = 0; i < temp.length; i++) {
					lines.add(temp[i]);

				}
			}
			words = lines.toArray(new String[lines.size()]);
			bufferedReader.close();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return words;
	}

	/** This method appends word on filePath
	 * @param word
	 * @param filePath
	 *           
	 */
	public static void appendFile(String word, String filePath) {

		try {
			FileWriter writer = new FileWriter(filePath, false);
			PrintWriter out = new PrintWriter(writer);
			out.println(word);
			out.close();
			writer.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**This method write given string on given filePath
	 * @param word     -Array of String to write
	 * @param filePath -File path with file name
	 */
	public static void writeFile(String word[], String filePath) {

		try {
			FileWriter writer = new FileWriter(filePath, false);
			PrintWriter out = new PrintWriter(writer);
			for (int i = 0; i < word.length; i++) {
				out.write(word[i] + " ");
			}
			out.close();
			writer.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	static {
		random = new Random();
	}

	public static int generateRandom(int number) {
		int randomnum;
		randomnum = random.nextInt(number);
		return randomnum;
	}
	public static int generateIndex()
	{
		
		int index=Util.generateRandom(52);
		for(int i=0;i<52;i++) {
			if(array[i]==index) {
				return(generateIndex());
			}
		}
			
				
			
				return index;
					
		
	
	
		
		
	}
	public static void shuffle(String suits[],String rank[]) {
		Queue<Queue<String>> allplayers=new Queue<Queue<String>>();
		Queue<String> queue;
		String player[][]=new String[4][9];
		String randomCard="";
		String deck[]=new String[52];
		int suitSelect=0;
		int rankSelect=0;
		int flag=0;
	int k=0;
	int m=0;
			int index=0;
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				deck[k++]=suits[i]+"-"+rank[j];
			}
			
		}
	
		for(int i=0;i<4;i++) {
			queue=new Queue<String>();
			
	 for(int j=0;j<9;j++)	{
				
				
				index=Util.generateIndex();
				array[m++]=index;
			player[i][j]=deck[index];
			queue.enqueueSort(deck[index]);
				
			
			
		}
	 allplayers.enqueue(queue);
		}
		for(int i=0;i<4;i++) {
			System.out.print((i+1)+"   player  ");
			queue=allplayers.dequeue();
			for (int j=0;j<9;j++) {
		
		System.out.println(queue.dequeue());
			}
			System.out.println("");
		
	}
	}
	public static void addAddressBook() {
		JSONObject jsonobject=new JSONObject();
		JSONObject jsonobject1=new JSONObject();
	   JSONParser parser =new JSONParser();
	   JSONArray array1=new JSONArray();
	   try {
		   JSONObject jobj = (JSONObject) parser.parse(new FileReader(addressbooks));

			JSONArray jarray = (JSONArray) jobj.get("addressbook");
			System.out.println("enter the number of  names  to add");
			int number = sc.nextInt();
			for (int i = 0; i < number; i++) {
				JSONObject temp = new JSONObject();
				System.out.println("enter first name");

				temp.put("firstname", sc.next());
				System.out.println("enter last name");

				temp.put("lastname", sc.next());
				System.out.println("enter address");

				temp.put("address", sc.next());
				System.out.println("enter city");

				temp.put("city", sc.next());
				System.out.println("enter state");

				temp.put("state", sc.next());
				
				System.out.println("enter zipcode");
				temp.put("zip", sc.nextInt());
				System.out.println("enter phone number");
				temp.put("phno", sc.nextInt());
			array1.add(temp);
			}
		
			jsonobject.put("addressbook", array1);
			Util.appendFile(jsonobject1.toJSONString(), addressbooks);
			
		   
	   } catch (ParseException ie1) {
	        ie1.printStackTrace();
	    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public static void createAddressBook() {
		JSONObject jsonobject=new JSONObject();
		JSONObject jsonobject1=new JSONObject();
		 JSONParser parser = new JSONParser();
		JSONArray array1=new JSONArray();
		JSONArray objectarray=new JSONArray();
		JSONArray array=new JSONArray();
		    
		try {
			BufferedReader br = new BufferedReader(new FileReader(addressbooks)); 
			if (br.readLine() != null ) {
			   Util.addAddressBook();
			   return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("enter the number of  names  to add");
		int number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			JSONObject temp = new JSONObject();
			System.out.println("enter first name");

			temp.put("firstname", sc.next());
			System.out.println("enter last name");

			temp.put("lastname", sc.next());
			System.out.println("enter address");

			temp.put("address", sc.next());
			System.out.println("enter city");

			temp.put("city", sc.next());
			System.out.println("enter state");

			temp.put("state", sc.next());
			
			System.out.println("enter zipcode");
			temp.put("zip", sc.nextInt());
			System.out.println("enter phone number");
			temp.put("phno", sc.nextInt());
		array1.add(temp);
		}
		
		jsonobject1.put("addressbook", array1);
		Util.appendFile(jsonobject1.toJSONString(), addressbooks); 
	}
		
	public static void editAddressBook(String name) {

	int number;
	String []valuelist={"address","city","state","zip","phno"};
	System.out.println("1.address,2 city,3 state,4 zip,5 phno");
	JSONArray addressArray=new JSONArray();
	number=sc.nextInt();
	System.out.println("enter value");
	String cde=sc.next();
		JSONParser parser = new JSONParser();
		try {
			  JSONObject arrayobject = (JSONObject) parser.parse(new FileReader(addressbooks));

				JSONArray jarray = (JSONArray) arrayobject.get("addressbook");
				for (Object name1 : jarray) {
					JSONObject nameselect= (JSONObject) name1;
					
						if(nameselect.get("firstname").equals(name)) {
							nameselect.replace(valuelist[number-1], cde);
							System.out.println(nameselect.get(valuelist[number-1]));
						}
						
					}

				arrayobject.put("addressbook", jarray);
				Util.appendFile(arrayobject.toJSONString(), addressbooks);
			
		 } catch (ParseException ie1) {
	        ie1.printStackTrace();
	    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	/*
	public static void sortByName() {
		JSONParser parser = new JSONParser();
		int i=0;
		
		try {
			  JSONObject arrayobject = (JSONObject) parser.parse(new FileReader(addressbooks));
	
				JSONArray jarray = (JSONArray) arrayobject.get("addressbook");
				for (Object name1 : jarray) {
					while(i<jarray.size()) {
					Object temp;
					JSONObject nameselect= (JSONObject) name1;
					
						if(((String) nameselect.get(i)).compareTo(nameselect.get(i+1))) {
							nameselect.replace(valuelist[number-1], cde);
							System.out.println(nameselect.get(valuelist[number-1]));
						}
						
					}

				arrayobject.put("addressbook", jarray);
				Util.appendFile(arrayobject.toJSONString(), addressbooks);
			
		 } catch (ParseException ie1) {
	        ie1.printStackTrace();
	    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}*/
}
