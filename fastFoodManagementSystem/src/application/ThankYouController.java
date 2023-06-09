package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ThankYouController {
 	private Stage stage;
   	private Scene scene;
   	private Parent root;
	
	@FXML
    private Button returnMain;

    @FXML
    public void retrunMain(ActionEvent event) throws IOException{
    	
    	root = FXMLLoader.load(getClass().getResource("RegLog.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
}
