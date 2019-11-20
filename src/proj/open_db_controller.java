package proj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class open_db_controller {
	private ObservableList<Phone> phonesData = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button save_button;

    @FXML
    private Button edit_button;

    @FXML
    private Button delete_button;

    @FXML
    private TableView<Phone> table1;

    @FXML
    private Button find_button;

    @FXML
    private TableColumn<Phone, String> brand_column;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<Phone, Integer> price_column;

    @FXML
    private TableColumn<Phone, Integer> vendor_code_column;

    //@FXML
    //private TableColumn<?, ?> sensor_column;

    @FXML
    void initialize() {
       
        initData();
     // устанавливаем тип и значение которое должно хранится в колонке
        brand_column.setCellValueFactory(new PropertyValueFactory<Phone, String>("brand"));
        vendor_code_column.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("vendor code"));
        price_column.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("price"));
        
        // заполняем таблицу данными
        table1.setItems(phonesData);
    }
    private void initData() {
        phonesData.add(new Phone("hj",67,78));
        
    }
}

