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

    // �������������� ����� �������
    @FXML
    private void initialize() {
      showAll();
     // System.out.println(items);
      
//initData();
        // ������������� ��� � �������� ������� ������ �������� � �������
        //idColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("id"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("brand"));
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("vendor_code"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("price"));
         ObservableList<Phone> phonesData = FXCollections.observableArrayList(/*showAll()*/items);

        // ��������� ������� �������
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
	
    // �������������� ������ ��� �������
    // �� ������ �������� �� � ���� ������
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
        // ������� ��� ������ �����
        TableColumn<Phone, String> nameColumn = new TableColumn<Phone, String>("Brand");
        // ���������� ������� ��� ������� � ��������� � �������� name
        nameColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("Brand"));
        // ��������� �������
        table1.getColumns().add(nameColumn);
        
    
        // ������� ��� ������ �����
        TableColumn<Phone, Integer> vendor_codeColumn = new TableColumn<Phone, Integer>("Vendor code");
        // ���������� ������� ��� ������� � ��������� � �������� name
        vendor_codeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("Vendor code"));
        // ��������� �������
        table1.getColumns().add(vendor_codeColumn);
    
        // ������� ��� ������ �����
        TableColumn<Phone, Integer> priceColumn = new TableColumn<Phone, Integer>("Price");
        // ���������� ������� ��� ������� � ��������� � �������� name
        priceColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("Price"));
        // ��������� �������
        table1.getColumns().add(priceColumn);
    
        // ��������� ������� �������
        table1.setItems(phonesData);
    }
   
    private void initData() {
     //  phonesData.add(new Phone("��",67,78));
      // phonesData.add(new Phone("hj",67,78));
        
    }
}

*/