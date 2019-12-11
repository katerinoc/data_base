package proj;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class insert_window_controller_first {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button search_price;

    @FXML
    private Button search_vendor_code;

    @FXML
    private Button search_brand;

    @FXML
    void initialize() {
        assert search_price != null : "fx:id=\"serach_price\" was not injected: check your FXML file 'insert_window.fxml'.";
        assert search_vendor_code != null : "fx:id=\"serach_vendor_code\" was not injected: check your FXML file 'insert_window.fxml'.";
        assert search_brand != null : "fx:id=\"search_brand\" was not injected: check your FXML file 'insert_window.fxml'.";
 
        search_price.setOnAction(event->{try{Parent root = FXMLLoader.load(getClass().getResource("/proj/insert_window_second.fxml"));
try {
}catch(Exception e) {
    e.printStackTrace();
}

Stage stage = new Stage();
stage.setScene(new Scene(root));  
stage.show();
search_price.getScene().getWindow().hide();}

        
        catch(Exception e) {
        	e.printStackTrace();
        }
        });
    }
}
