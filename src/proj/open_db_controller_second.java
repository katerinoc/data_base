package proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class open_db_controller_second {
	   @FXML
	    private TableView<Phone> tableUsers;

	    @FXML
	    private TableColumn<Phone, String> brandColumn;

	    @FXML
	    private TableColumn<Phone, Integer> vendor_codeColumn;

	    @FXML
	    private TableColumn<Phone, Integer> priceColumn;
	    @FXML
	    private void initialize() {
	    brandColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("brand"));
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("vendor_code"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("price"));
       
         ObservableList<Phone> phonesData = FXCollections.observableArrayList(showAll());
        

        // заполняем таблицу данными
        tableUsers.setItems(phonesData);}
        
        public List<Phone> showAll() {
            try {
             
                BufferedReader reader = new BufferedReader(new FileReader("copied_file.txt")); 
                
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
       
	    

}
