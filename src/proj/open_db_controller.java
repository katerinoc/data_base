package proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import proj.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class open_db_controller {
public  List<Phone> items = new ArrayList<>();
private static final String PATH = "file.txt";
    @FXML
    private TableView<Phone> tableUsers;

    @FXML
    private TableColumn<Phone, String> brandColumn;

    @FXML
    private TableColumn<Phone, Integer> vendor_codeColumn;

    @FXML
    private TableColumn<Phone, Integer> priceColumn;

    // инициализируем форму данными
    @FXML
    private void initialize()  {
     
        // устанавливаем тип и значение которое должно хранится в колонке
        //idColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("id"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("brand"));
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("vendor_code"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("price"));
         ObservableList<Phone> phonesData = FXCollections.observableArrayList(showAll());

        // заполняем таблицу данными
        tableUsers.setItems(phonesData);
    }
   
	 public List<Phone> showAll() {
	        try {
	         
	            BufferedReader reader = new BufferedReader(new FileReader(PATH)); 
	            
	            List<Phone> items = new ArrayList<>();
	           
	            String currentLine;
	            
	            while((currentLine = reader.readLine()) != null) {
	                if (!currentLine.trim().isEmpty()) {
	                
	                    String[] field = currentLine.split("\\|");
	                    //Integer id = Integer.parseInt(field[0]);
	                    String brand = field[0];
	                    Integer vendor_code=Integer.parseInt(field[1]);
	                    Integer price=Integer.parseInt(field[2]);
	                    
	                   items.add(new Phone(brand, vendor_code, price));
	                   System.out.println(items);
	                }
	            } if (items.isEmpty()) {
	                return new ArrayList<>();
	            } else {
	                List<Phone> result = new ArrayList<>();
	                for (Phone item : items) {
	                    result.add(item);
	                    System.out.println(result);
	                }
	                return result;
	            }
	        } catch (FileNotFoundException e) {
	            
	        } catch (IOException e) {
	            
	        }
	        return null;
	       
	    }
	
    

}
