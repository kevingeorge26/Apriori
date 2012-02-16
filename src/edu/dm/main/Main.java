package edu.dm.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import edu.dm.apriori.Logic;
import edu.dm.object.Item;
import edu.dm.object.ItemSet;
import edu.dm.object.Transaction;

public class Main 
{

	private static List<Transaction> transaction = new ArrayList<Transaction>();
	private static List<Item> itemList = new ArrayList<Item>();
	private static float SDC;

	public static void main(String[] args)
	{

		BasicConfigurator.configure();

		//		List<Transaction> transaction = new ArrayList<Transaction>();
		//		
		//		Transaction one = new Transaction("beef,bread");
		//		transaction.add(one);
		//		
		//		Transaction two = new Transaction("bread,clothes");
		//		transaction.add(two);
		//		
		//		Transaction three = new Transaction("bread,clothes,milk");
		//		transaction.add(three);
		//		
		//		Transaction four = new Transaction("cheese,boots");
		//		transaction.add(four);
		//		
		//		Transaction five = new Transaction("beef,bread,cheese,shoes");
		//		transaction.add(five);
		//		
		//		Transaction six = new Transaction("beef,bread,cheese,milk");
		//		transaction.add(six);
		//		
		//		Transaction seven = new Transaction("bread,milk,clothes");
		//		transaction.add(seven);
		//		
		//		List<Item> itemList = new ArrayList<Item>();
		//		
		//		Item onei = new Item("beef", 3, 0.25f);
		//		Item twoi = new Item("bread", 6, 0.7f);
		//		Item threei = new Item("clothes", 3, 0.25f);
		//		Item fouri = new Item("milk",3,0.5f);
		//		Item fivei = new Item("boots", 1, .25f);
		//		Item sixi = new Item("cheese", 3, .25f);
		//		Item sevi = new Item("shoes", 1,.25f);
		//		
		//		itemList.add(onei);
		//		itemList.add(twoi);
		//		itemList.add(threei);
		//		itemList.add(fouri);
		//		itemList.add(fivei);
		//		itemList.add(sixi);
		//		itemList.add(sevi);
		
		getTransaction();
		readMIS();
		
		Logger logger = Logger.getLogger(Main.class);
		
//		logger.debug(transaction);
//		logger.debug(itemList);
//		logger.debug("" + SDC);
		
		new Logic(itemList, SDC, transaction);


	}

	private static void getTransaction()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("data-1.txt")));
			String line;
			System.out.println("Transactions:");
			
			while((line = br.readLine()) != null)
			{
				String[] inputchars = line.split(",");
				ArrayList<String> arr = new ArrayList<String>();
				for(int i = 0; i < inputchars.length; i++){
				arr.add(inputchars[i].trim());
				}
				Transaction trans = new Transaction(arr);
				transaction.add(trans);

			}

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	private static void readMIS()
	{
		try 
		{
			BufferedReader br = new BufferedReader(
					new FileReader(new File("para-1.txt")));
			String line;
			String itemName;
			float mis;
			// System.out.println("\nItem MIS values:");
			while((line = br.readLine()) != null)
			{
				if(!line.equals(" ") && !line.equals(""))
				{
					String[] input = line.split(" ");

					if(input[0].equals("SDC"))
					{
						SDC = Float.valueOf(input[2]);
						continue;
					}
					
					itemName = input[0].substring(input[0].indexOf('(')+1, input[0].indexOf(')'));
					mis = Float.parseFloat(input[2]);
					
					createNewItemSet(itemName,mis);

					
				}
			}
		} 
		
		catch (FileNotFoundException e) 
		{			
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	private static void createNewItemSet(String newItem,float mis)
	{
		Item item = null;
		int count = 0 ;

		for(Transaction trans : transaction)
		{
			if (trans.containsItemSet(newItem))
				count++;
		}

		item = new Item(newItem, count, mis);

		itemList.add(item);
	}

}
