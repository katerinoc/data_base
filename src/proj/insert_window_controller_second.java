package proj;

import java.awt.event.ActionEvent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class insert_window_controller_second {
	    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField search_field_price;

    @FXML
    private Button search;
    @FXML
    private Button delete;

    @FXML
    private TextField search_field_vendor_code;

    @FXML
    private TextField search_field_brand;


    @FXML
    private void initialize() throws FileNotFoundException {

       
    	   
    	
    	 search.setOnAction(event->{try{
    		 

    		
    		
         	searchPhones();
         	
         	Parent root = FXMLLoader.load(getClass().getResource("/proj/main_second.fxml"));
         	try {
         	}catch(Exception e) {
         	    e.printStackTrace();
         	}

         	Stage stage = new Stage();
         	stage.setScene(new Scene(root));  
         	stage.show();
         	//search.getScene().getWindow().hide();}
    	 }
         	catch (Exception e) {
      	        e.printStackTrace();
      	    }
         	
         });
    	 delete.setOnAction(event->{try {
    		 deleteItem();
    		 //refreshTable();
    	 }
    	 catch(Exception e) {
    	 
    	 }
    	 });
    	
    }
    void searchPhones() {
        Phone find = new Phone();
        if (search_field_vendor_code.getText() != null && !search_field_vendor_code.getText().trim().isEmpty()) {
            Integer vendor_code = Integer.parseInt(search_field_vendor_code.getText());
            find.setVendor_code(vendor_code);
        }
        if (search_field_brand.getText() != null && !search_field_brand.getText().trim().isEmpty()) {
            find.setBrand(search_field_brand.getText());
        }
       
        
        if (search_field_price.getText() != null && !search_field_price.getText().trim().isEmpty()) {
            Integer price = Integer.parseInt(search_field_price.getText());
            find.setPrice(price);
        }
       
        
        

        selectPhones(find);
            }
    public void selectPhones(Phone find) {
        List<Phone> phones =showAll();
        if (find.getBrand() != null) {
            for (Phone currentItem : new ArrayList<>(phones)) {
                if (!currentItem.getBrand().equals(find.getBrand())) {
                    phones.remove(currentItem);
                }
            }
           saveToDB(phones);
           return;
        }
        if (find.getVendor_code() != null) {
            for (Phone currentItem : new ArrayList<>(phones)) {
                if (!currentItem.getVendor_code().equals(find.getVendor_code())) {
                    phones.remove(currentItem);
                }
            }
            saveToDB(phones);
            return;
        }
        
        if (find.getPrice() != null) {
            for (Phone currentItem : new ArrayList<>(phones)) {
                if (!currentItem.getPrice().equals(find.getPrice())) {
                    phones.remove(currentItem);
                }
            }
            saveToDB(phones);
            return;
        }
       
    
        saveToDB(phones);
    }
    public List<Phone> showAll() {
        try {
         
            BufferedReader reader = new BufferedReader(new FileReader("file.txt")); 
            
            List<Phone> phones = new ArrayList<>();
           
            String currentLine;
            
            while((currentLine = reader.readLine()) != null) {
                if (!currentLine.trim().isEmpty()) {
                
                    String[] field = currentLine.split("\\|");
                    //Integer id = Integer.parseInt(field[0]);
                    String brand = field[0];
                    Integer vendor_code=Integer.parseInt(field[1]);
                    Integer price=Integer.parseInt(field[2]);
                    
                   phones.add(new Phone(brand, vendor_code, price));
                   
                }
            } if (phones.isEmpty()) {
                return new ArrayList<>();
            } else {
                List<Phone> result = new ArrayList<>();
                for (Phone item : phones) {
                    result.add(item);
                   
                }
                return result;
            }
        } catch (FileNotFoundException e) {
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("База данных не существует");
            alert.showAndWait();
            
            
        } catch (IOException e) {
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("База данных не существует");
            alert.showAndWait();
            
        }
        return null;
       
    }
  
    private void saveToDB(List<Phone> phones) {
        try {
            BufferedWriter writer = new BufferedWriter(new PrintWriter(new FileOutputStream("copied_file.txt")));
            StringBuilder sb = new StringBuilder();
            for (Phone object : phones) {
                Phone phone = object;
                sb.append(convertItemToString(phone));
            }
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        } catch (Exception e) {
           
        }
    }
    private String convertItemToString(Phone phone) {
        StringBuilder sb = new StringBuilder();
        sb.append(phone.getBrand());
        sb.append("|");
        sb.append(phone.getVendor_code());
        sb.append("|");
        
        sb.append(phone.getPrice());
        
        sb.append("\n");
        return sb.toString();
    }
    private Phone getItem(Integer vendor_code) {
        List<Phone> items = showAll();
        for (Phone item : items) {
            if (item.getVendor_code().equals(vendor_code)) {
                return item;
            }
        }
        return null;
    }
   
    public void deleteItem() {
        try {Phone find = new Phone();
        	Integer vendor_code = Integer.parseInt(search_field_vendor_code.getText());
            
            File file = new File("file.txt");
            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !(String.valueOf(vendor_code).equals(line.substring(1, line.indexOf("|")))))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Запись была успешно удалена");
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        }
        refreshTable();
    }   
    private void refreshTable() {
        ObservableList<Phone> phoneData = FXCollections.observableArrayList(showAll());
       
    }
}
