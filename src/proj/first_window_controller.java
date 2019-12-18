package proj;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
    private Button recover_back_up;
    
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
                	Parent root = FXMLLoader.load(getClass().getResource("/proj/main.fxml"));
                	
        try {
        }catch(Exception e) {
            e.printStackTrace();
        }
       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();}


         catch(Exception e) {
        	e.printStackTrace();
        }
        });
        recover_back_up.setOnAction(event->{try{
        	recoverBackup();
        	recover_back_up.getScene().getWindow().hide();}
        catch(Exception e) {
        	e.printStackTrace();
        	
        }
        });
    
      
    }
    public void recoverBackup() throws FileNotFoundException {
		 FileInputStream fileIn = null;
		 FileOutputStream fileOut = null;

		 try {
		    fileIn = new FileInputStream("back_file.txt");
		    fileOut = new FileOutputStream("file.txt");
		    
		    int a;
		 // Копирование содержимого файла file.txt
		    try {
		 	while ((a = fileIn.read()) != -1) {
		 	      fileOut.write(a); // Чтение содержимого файла file.txt и запись в файл copied_file.txt
		 	     
		 	}
		 } catch (IOException e) {
		 	// TODO Auto-generated catch block
		 	e.printStackTrace();
		 }
		 }finally {
		    if (fileIn != null) {
		       try {
		    	   Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Success");
	                alert.setHeaderText("Success");
	                alert.setContentText("File recovered !");
	                alert.showAndWait();  
		 		fileIn.close();
		 	} catch (IOException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
		    }
		    if (fileOut != null) {
		       try {
		 		fileOut.close();
		 	} catch (IOException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
		    }
		 }
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
