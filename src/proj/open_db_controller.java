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
   
    @FXML
    private TableView<Phone> tableUsers;

   // @FXML
   // private TableColumn<Phone, Integer> idColumn;

    @FXML
    private TableColumn<Phone, String> brandColumn;

    @FXML
    private TableColumn<Phone, Integer> vendor_codeColumn;

    @FXML
    private TableColumn<Phone, Integer> priceColumn;

    // инициализируем форму данными
    @FXML
    private void initialize() {
      showAll();
     // System.out.println(items);
      
//initData();
        // устанавливаем тип и значение которое должно хранится в колонке
        //idColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("id"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("brand"));
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("vendor_code"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("price"));
         ObservableList<Phone> phonesData = FXCollections.observableArrayList(/*showAll()*/items);

        // заполняем таблицу данными
        tableUsers.setItems(phonesData);
    }
    private static final String PATH = "src/file.txt";
	   
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
	        return items;
	    }
	
    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
 //private void initData() {
   //    phonesData.add(new Phone("Alex", 3,5));
        //phonesData.add(new Phone(2, "Bob", "dsfsdfw", "bob@mail.com"));
        //phonesData.add(new Phone(3, "Jeck", "dsfdsfwe", "Jeck@mail.com"));
        //phonesData.add(new Phone(4, "Mike", "iueern", "mike@mail.com"));
        //phonesData.add(new Phone(5, "colin", "woeirn", "colin@mail.com"));
  // }

}
/*
public class open_db_controller {
	//private ObservableList<Phone> phonesData = FXCollections.observableArrayList(/*proj.DBManipulator.showAll());

	


	
	    @FXML
	    private TableView<Phone> table1;
	    

	   

    @FXML
    public void initialize() {
    	
    	ObservableList<Phone> phonesData = FXCollections.observableArrayList(
     			new Phone("df",12,12),
     			new Phone("df",12,12)
     			
     			);
    	 //initData();
    	 
    	
        System.out.println(phonesData.get(0));
        // столбец для вывода имени
        TableColumn<Phone, String> nameColumn = new TableColumn<Phone, String>("Brand");
        // определяем фабрику для столбца с привязкой к свойству name
        nameColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("Brand"));
        // добавляем столбец
        table1.getColumns().add(nameColumn);
        
    
        // столбец для вывода имени
        TableColumn<Phone, Integer> vendor_codeColumn = new TableColumn<Phone, Integer>("Vendor code");
        // определяем фабрику для столбца с привязкой к свойству name
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("Vendor code"));
        // добавляем столбец
        table1.getColumns().add(vendor_codeColumn);
    
        // столбец для вывода имени
        TableColumn<Phone, Integer> priceColumn = new TableColumn<Phone, Integer>("Price");
        // определяем фабрику для столбца с привязкой к свойству name
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("Price"));
        // добавляем столбец
        table1.getColumns().add(priceColumn);
    
        // заполняем таблицу данными
        table1.setItems(phonesData);
    }
   
    private void initData() {
     //  phonesData.add(new Phone("ка",67,78));
      // phonesData.add(new Phone("hj",67,78));
        
    }
}

*/