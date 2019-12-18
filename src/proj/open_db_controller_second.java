package proj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class open_db_controller_second {
	public  List<Phone> item = new ArrayList<>();

	   @FXML
	    private TableView<Phone> tableUsers;

	    @FXML
	    private TableColumn<Phone, String> brandColumn;

	    @FXML
	    private TableColumn<Phone, Integer> vendor_codeColumn;

	    @FXML
	    private TableColumn<Phone, Integer> priceColumn;
	    @FXML
	    private Button delete;
	    
	    
	    @FXML
	    private void initialize() {
	    brandColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("brand"));
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("vendor_code"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("price"));
       
         ObservableList<Phone> phonesData = FXCollections.observableArrayList(showAll());
       // delete.setOnAction(event->{try{
        	//deleteItem(phone.getVendor_code());
      //  });

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
        private Phone getItem(Integer vendor_code) {
            List<Phone> items = showAll();
            for (Phone item : items) {
                if (item.getVendor_code().equals(vendor_code)) {
                    return item;
                }
            }
            return null;
        }
       
        public void deleteItem(Integer itemId) {
            try {
                File file = new File("file.txt");
                List<String> out = Files.lines(file.toPath())
                        .filter(line -> !(String.valueOf(itemId).equals(line.substring(1, line.indexOf("|")))))
                        .collect(Collectors.toList());
                Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Запись была успешно удалена");
            } catch (FileNotFoundException e) {
                
            } catch (IOException e) {
                
            }
        }   
        

}
