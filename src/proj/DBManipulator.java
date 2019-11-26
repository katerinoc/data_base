package proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBManipulator {
	private static final String PATH = "src/db.txt";
	   
	 public List<Phone> showAll() {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(PATH));
	            List<Phone> items = new ArrayList<>();
	            String currentLine;
	            while((currentLine = reader.readLine()) != null) {
	                if (!currentLine.trim().isEmpty()) {
	                
	                    String[] field = currentLine.split("\\|");
	                  //  Integer id = Integer.parseInt(field[0]);
	                    String brand = field[1];
	                    Integer vendor_code=Integer.parseInt(field[2]);
	                    Integer price=Integer.parseInt(field[3]);
	                    
	                   items.add(new Phone(brand, vendor_code, price));
	                    
	                }
	            } if (items.isEmpty()) {
	                return new ArrayList<>();
	            } else {
	                List<Phone> result = new ArrayList<>();
	                for (Phone item : items) {
	                    result.add(item);
	                }
	                return result;
	            }
	        } catch (FileNotFoundException e) {
	            
	        } catch (IOException e) {
	            
	        }
	        return null;
	    }
	 
	
}
