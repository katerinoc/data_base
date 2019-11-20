package proj;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class first_window_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button open_bd;

    @FXML
    private Button create_bd;
    
    @FXML
    void initialize() {
        assert open_bd != null : "fx:id=\"open_bd\" was not injected: check your FXML file 'main_window.fxml'.";
        assert create_bd != null : "fx:id=\"create_bd\" was not injected: check your FXML file 'main_window.fxml'.";
 
        create_bd.setOnAction(event ->{try{
        	
        	openNewWindow("create_window.fxml"); }
        	 catch (Exception e) {
     	        e.printStackTrace();
     	    }
        });
        open_bd.setOnAction(event ->{try{
        	openNewWindow("open_db.fxml");}
        catch(Exception e) {
        	e.printStackTrace();
        }
        });
      
    }
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
}
