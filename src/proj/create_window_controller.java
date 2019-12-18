package proj;

import java.net.URL;


import java.io.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class create_window_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton no;

    @FXML
    private TextField vendor_code;

    @FXML
    private TextField price;

    @FXML
    private RadioButton yes;

    @FXML
    private Button ready_button;

    @FXML
    private TextField brand;

    @FXML
    void initialize() {
        assert no != null : "fx:id=\"no\" was not injected: check your FXML file 'create_window.fxml'.";
        assert vendor_code != null : "fx:id=\"vendor_code\" was not injected: check your FXML file 'create_window.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'create_window.fxml'.";
        assert yes != null : "fx:id=\"yes\" was not injected: check your FXML file 'create_window.fxml'.";
        assert ready_button != null : "fx:id=\"ready_button\" was not injected: check your FXML file 'create_window.fxml'.";
        assert brand != null : "fx:id=\"brand\" was not injected: check your FXML file 'create_window.fxml'.";

        ready_button.setOnAction(event ->{try{
        add();
        
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        });
    }
    
    @FXML
    void add() {
    	Phone phone=new Phone();
		    
		    FileWriter fileWriter = null;
			try {
				File file = new File("file.txt");
				fileWriter = new FileWriter(file);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
			
			phone.setBrand(brand.getText());
			 int code = Integer.parseInt(vendor_code.getText());
			phone.setVendor_code(code);
			 int prices = Integer.parseInt(price.getText());
			phone.setPrice(prices);
			
			try {BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // соединяем FileWriter с BufferedWriter
		
				bufferedWriter.write(stringing(phone));
				 bufferedWriter.flush();
	                bufferedWriter.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		   
    
    }
    @FXML
    String stringing(Phone phone) {
	 StringBuilder sb = new StringBuilder();
    sb.append(phone.getBrand());
    sb.append("|");
    sb.append(phone.getVendor_code());
    sb.append("|");
    sb.append(phone.getPrice());
    sb.append("|");
   
  
    sb.append("\n");
    return sb.toString();
}
}

