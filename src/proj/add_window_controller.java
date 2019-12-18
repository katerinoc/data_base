package proj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class add_window_controller {

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
    private Button add_button;

    @FXML
    private RadioButton yes;

    @FXML
    private TextField brand;

    @FXML
    void initialize() {
        assert no != null : "fx:id=\"no\" was not injected: check your FXML file 'create_window Ч копи€.fxml'.";
        assert vendor_code != null : "fx:id=\"vendor_code\" was not injected: check your FXML file 'create_window Ч копи€.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'create_window Ч копи€.fxml'.";
        assert add_button != null : "fx:id=\"add_button\" was not injected: check your FXML file 'create_window Ч копи€.fxml'.";
        assert yes != null : "fx:id=\"yes\" was not injected: check your FXML file 'create_window Ч копи€.fxml'.";
        assert brand != null : "fx:id=\"brand\" was not injected: check your FXML file 'create_window Ч копи€.fxml'.";

        
        add_button.setOnAction(event ->{try{
        add();
        add_button.getScene().getWindow().hide();
        
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        });
    }
    @FXML
    void add() {
    	Phone phone=new Phone();
		    
		   
			
			phone.setBrand(brand.getText());
			 int code = Integer.parseInt(vendor_code.getText());
			phone.setVendor_code(code);
			 int prices = Integer.parseInt(price.getText());
			phone.setPrice(prices);
			
			try {FileWriter writer = new FileWriter("file.txt", true);
		            BufferedWriter bufferWriter = new BufferedWriter(writer);
		            bufferWriter.write(stringing(phone));
		            bufferWriter.close();
				
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
