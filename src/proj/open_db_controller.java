package proj;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import proj.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    
    @FXML
    private Button delete;
    @FXML
    private Button add;
    
    @FXML
    private Button delete_info;
    @FXML
    private Button search;
    @FXML
    private Button delete_phone;


    // инициализируем форму данными
    @FXML
    private void initialize() throws IOException  {
     
        // устанавливаем тип и значение которое должно хранится в колонке
        //idColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("id"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("brand"));
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("vendor_code"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("price"));
        
         ObservableList<Phone> phonesData = FXCollections.observableArrayList(showAll());
       

        // заполняем таблицу данными
        tableUsers.setItems(phonesData);
           delete_phone.setOnAction(event->{try{
        	   Phone selectedPhone = tableUsers.getSelectionModel().getSelectedItem();
               if (selectedPhone == null) {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Ошибка");
                   alert.setHeaderText("Ошибка");
                   alert.setContentText("Не выбран элемент для удаления");
                   alert.showAndWait();
               } else {
            	   tableUsers.getItems().remove(selectedPhone);
            	   deleteItem(selectedPhone.getVendor_code());
                   //refreshTable();
               }
        	}
        	catch (Exception e) {
     	        e.printStackTrace();
     	    }
          
        	
        });
        
        delete.setOnAction(event->{try{
        	
        	deleteDB();
        	delete.getScene().getWindow().hide();}
        	catch (Exception e) {
     	        e.printStackTrace();
     	    }
        	
        });
        delete_info.setOnAction(event->{try{
        
        	deleteFileinfo();
        	delete_info.getScene().getWindow().hide();}
    	catch (Exception e) {
 	        e.printStackTrace();
 	    }
    	
        });
        
        add.setOnAction(event->{try{
        	add_new_item();

        	Parent root = FXMLLoader.load(getClass().getResource("/proj/add_window.fxml"));
try {
}catch(Exception e) {
    e.printStackTrace();
}

Stage stage = new Stage();
stage.setScene(new Scene(root));  
stage.show();
add.getScene().getWindow().hide();}

        
        catch(Exception e) {
        	e.printStackTrace();
        }
        });
        search.setOnAction(event->{try
        {Parent root2 = FXMLLoader.load(getClass().getResource("/proj/insert_window_second.fxml"));
        try {
        }catch(Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(root2));  
        stage.show();
        search.getScene().getWindow().hide();
        
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        });
    
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
	 
	
	 public void deleteDB() {
	        try {
	            if (Files.exists(Paths.get(PATH))) {
	                Files.delete(Paths.get(PATH));
	                
	                
	                Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Success");
	                alert.setHeaderText("Success");
	                alert.setContentText("База данных удалена");
	                alert.showAndWait();
	            } else {
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Error");
	                alert.setHeaderText("Error");
	                alert.setContentText("Невозможно произвести операцию удаления");
	                alert.showAndWait();
	            }
	        } catch (IOException e) {
	           
	        }
	    }
	 
	 public void deleteFileinfo() {
		 try {
		        FileWriter fstream1 = new FileWriter(PATH);// конструктор с одним параметром - для перезаписи
		        BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
		        out1.write(""); // очищаем, перезаписав поверх пустую строку
		         out1.close(); // закрываем
		         Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Success");
	                alert.setHeaderText("Success");
	                alert.setContentText("База данных удалена");
	                alert.showAndWait();
		         } catch (Exception e) 
		            {System.err.println("Error in file cleaning: " + e.getMessage());}
		 
		 
	 }
	 
	 private void add_new_item() {
		 
	  ObservableList<Phone> phonesData = FXCollections.observableArrayList(showAll());

     // заполняем таблицу данными
     tableUsers.setItems(phonesData);}
     
	 public void openNewWindow(String window) throws IOException {
     	
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(window));
         try {
         }catch(Exception e) {
             e.printStackTrace();
         }
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));  
         stage.show();
     }
	 
	 public void deleteItem(Integer vendor_code) {
	        try {
	            File file = new File(PATH);
	            List<String> out = Files.lines(file.toPath())
	                    .filter(line -> !(String.valueOf(vendor_code).equals(line.substring(0, line.indexOf("|")))))
	                    .collect(Collectors.toList());
	            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	            System.out.println("Запись была успешно удалена");
	        } catch (FileNotFoundException e) {
	           
	        } catch (IOException e) {
	            
	        }
	    }
	 private void refreshTable() {
	        ObservableList<Phone> phoneData = FXCollections.observableArrayList(showAll());
	        tableUsers.setItems(phoneData);
	    }
 
}
