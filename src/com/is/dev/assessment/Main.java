package com.is.dev.assessment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;

public class Main {
	/* Parse csv file into java objects and stored into a List of Products
	 * @param String csvFiletoRead This is the passed .csv filename that will be parsed 
	 * @param List<Product> pList
	 * @return none
	 */
	public void csvToJava( String csvFileToRead, List<Product> pList )
	{
	
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		try
		{
			br = new BufferedReader(new FileReader(csvFileToRead));
			// read first line of csv to avoid storage in java obj
			if(( line = br.readLine()) != null )
			{
				String[] temp = line.split(splitBy);
			}
			while ((line = br.readLine()) != null) {
			    // parse csv 
				String[] item = line.split(splitBy);
			    // Convert into java object  
				Product productObj = new Product();
				// add values from csv to obj
				// title,upc,sku,price,condition,quantity
		     	// Make the title all caps
				productObj.setProduct( item[ 0 ], item[ 1 ], item[ 2 ], item[ 3 ], item[ 4 ], item[ 5 ]);
				pList.add(productObj);
			}
			System.out.println("Parsed csv to java objects");
		}
		catch (FileNotFoundException e) {
			   e.printStackTrace();
			}
			catch (IOException e) {
				   e.printStackTrace();
			} 
			finally {
				if (br != null) {
				   try {
					   br.close();
				    } 
				   	catch (IOException e) {
				   		e.printStackTrace();
				    }
				}
	    }
	}
	// cannot make a static reference to the non-static method
	/* iterate through List and print each Product object
	 * @param List<Product> productList provided List of Products
	 * @return none
	 */
	public static void printProductList( List<Product> pList )
	{
		// iterate through an ArrayList of objects
		for( Product p : pList  )
		{	
			System.out.print("ITEM[");
			System.out.print(" title = " + p.getTitle());
			System.out.print(", upc = " + p.getUpc());
			System.out.print(", sku = " + p.getSku());
			System.out.print(", price = " + p.getPrice());
			System.out.print(", sellPrice = " + p.getSellPrice());
			System.out.print(", condition = " + p.getCondition());
			System.out.print(", quantity = " + p.getQuantity());
			System.out.print(" ]");
			System.out.println();
		}
	}
	/* processing Java objects into xml formatted tree structure
	 * only "new" conditioned Products will be printed 
	 * sellPrice outputted will be 175& of the Product price
	 * @param String fileOutput filename to write xml out to
	 * @param List<Product> pList iterate through Products in provided List 
	 * @return none
	 */
	public void marshall(String fileOutput, List<Product> pList){
		try{
			Product product = new Product();
			// sellPrice must be 175% of the price
			BigDecimal sellPricePercent = new BigDecimal( 17.5 );
			Product tempProduct = new Product();
			
			JAXBContext jc = JAXBContext.newInstance(Product.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			
			FileWriter data = new FileWriter(fileOutput);
			BufferedWriter bw = new BufferedWriter(data);
			PrintWriter out = new PrintWriter(bw);
			
			// hardcode the xml header to the top of fileOutput
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			for( Product p : pList)
			{
				// Output XML File with the following rules :
	            // only "new" products
				if( p.getCondition().equals("new"))
				{

					tempProduct = p;
					tempProduct.setSellPrice( sellPricePercent );
					// Strip out the first 2 characters of the SKU
					tempProduct.setSku(p.getSku().substring(2, p.getSku().length()));
					ms.marshal(p, out);
				}
			}
			System.out.println("Printing out to " + fileOutput + " xml file");
		}
		catch(Exception e)
		{
		}
	}
	/* processing Java objects into xml formatted tree structure
	 * only "new" conditioned Products will be printed 
	 * sellPrice outputted will be 175& of the Product price
	 * @param String fileOutput filename to write xml out to
	 * @param List<Product> pList iterate through Products in provided List 
	 * @return none
	 */
	public void writeToJson( String fileOutput, List<Product> pList )
	{
		// Read CSV file into Product objects
    	// parse with comma separated file
		try(FileWriter data = new FileWriter(fileOutput);
				BufferedWriter bw = new BufferedWriter(data);
				PrintWriter out = new PrintWriter(bw);
				)
			{
				String jsonProduct = "";
				String tTitle, tUpc, tSku, tPrice, tSellPrice, tCondition, tQuantity;
				// iterate through productList
				out.print("[");
				for( Product p : pList )
				{
					// title must be all caps
					tTitle = p.getTitle().toUpperCase();
					tUpc = p.getUpc();
					tSku = p.getSku();
					tPrice = p.getPrice().toString();
					// sell price must be 140% of the price
			    	BigDecimal sellPricePercent = new BigDecimal( 14 );
			    	tSellPrice = ( p.getPrice().multiply(sellPricePercent).add( p.getPrice()).toString());
					tCondition = p.getCondition();
					tQuantity = p.getQuantity().toString();	
					// copy each product into json Formatted String
					jsonProduct = "{\"title\": " + tTitle + " \"upc\": " + tUpc + " \"sku\": " + tSku + " \"price\": " + tPrice 
							+ " \"sellPrice\": " + tSellPrice + " \"condition\": " + tCondition + " \"quantity\": " + tQuantity + " \"},";
					// write to file
					out.println(jsonProduct);
				}
				out.print("];");
			    System.out.println("Printed java objects to: " + fileOutput + " json file");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}
    public static void main(String[] args) throws IOException {
    	Main m = new Main();
    	String csvFileToRead =  "dev-assessment/input.csv";
    	String jsonOutputFile = "dev-assessment/output.json";
    	String xmlOutputFile = "dev-assessment/output.xml";
		List<Product> productList = new ArrayList<Product>();
		
		m.csvToJava(csvFileToRead, productList);
		// testing:
		// printProductList( productList );
		m.writeToJson( jsonOutputFile, productList );
        m.marshall( xmlOutputFile, productList );
    }
}
