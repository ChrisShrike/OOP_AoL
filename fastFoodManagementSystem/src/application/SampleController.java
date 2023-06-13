package application;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SampleController implements Initializable {
    
    @FXML
    private Button alr_btn;

    @FXML
    private Button crt_btn;

    @FXML
    private Button ext_btn;

    @FXML
    private Button lgn_btn;

    @FXML
    private AnchorPane lgn_form;

    @FXML
    private PasswordField lgn_pass;

    @FXML
    private TextField lgn_user;

    @FXML
    private Button reg_btn;

    @FXML
    private AnchorPane reg_form;

    @FXML
    private PasswordField reg_pass;

    @FXML
    private PasswordField reg_repass;

    @FXML
    private TextField reg_user;

    @FXML
    private StackPane scenePane;

    @FXML
    private AnchorPane side_form;
    
    User user;
    private Stage stage;
	private Scene scene;
	private Parent root;
	
    public void regClicked() {
        String username = reg_user.getText();
        String password = reg_pass.getText();
        String rePassword = reg_repass.getText();
        
        if (username.isEmpty()) {
            showAlert("Username is required.");
        } else if (password.length() < 8) {
            showAlert("Password must have at least 8 characters.");
        } else if (!password.equals(rePassword)) {
            showAlert("Passwords don't match.");
        } else {
            user = new User(username, password);
            
            TranslateTransition slider = new TranslateTransition();
            slider.setNode(side_form);
    		slider.setToX(0);
    		slider.setDuration(Duration.millis(500));
    		slider.setOnFinished((ActionEvent e)->{
    			alr_btn.setVisible(false);
    			crt_btn.setVisible(true);
    		});
    		
    		slider.play();
        }
    }
    
    public void logClicked(ActionEvent event) throws IOException {
    	String username = lgn_user.getText();
        String password = lgn_pass.getText();

        if (username.isEmpty()) {
            showAlert("Username is required.");
        } else if (!username.equals(user.getUsername())) {
            showAlert("Invalid username.");
        } else if (password.isEmpty()) {
            showAlert("Password is required.");
        } else if (!password.equals(user.getPass())) {
            showAlert("Invalid password.");
        } else {
            showAlert("Login successful!");
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	scene = new Scene(root);
        	stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }
    
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void switchForm(ActionEvent event) {
    	TranslateTransition slider = new TranslateTransition();
    	
    	if(event.getSource() == crt_btn) {
    		slider.setNode(side_form);
    		slider.setToX(300);
    		slider.setDuration(Duration.millis(500));
    		slider.setOnFinished((ActionEvent e)->{
    			alr_btn.setVisible(true);
    			crt_btn.setVisible(false);
    		});
    		
    		slider.play();
    	}else if(event.getSource() == alr_btn) {
    		slider.setNode(side_form);
    		slider.setToX(0);
    		slider.setDuration(Duration.millis(500));
    		slider.setOnFinished((ActionEvent e)->{
    			alr_btn.setVisible(false);
    			crt_btn.setVisible(true);
    		});
    		
    		slider.play();
    	}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	user = new User("username", "password");
    }    
}