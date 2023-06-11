package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckoutController implements Initializable {

    @FXML
    private Text OrderText;

    @FXML
    private TextField cardNum;

    @FXML
    private GridPane foodGrid;

    @FXML
    private Label foodLabel;

    @FXML
    private Label paxLabel;

    @FXML
    private PasswordField pin;

    @FXML
    private Label priceLabel;
    
    private MenuController menuController;
    private String[] foodNames = new String[menuController.name.length];
    private double[] pax = new double[menuController.pax.length];
    private double[] prices = new double[menuController.price.length];
    private int foodSize;

    public void next(ActionEvent event) throws IOException {
    	String num = cardNum.getText();
    	String cleanedNum = num.replaceAll("\\D", "");
    	
    	if (cleanedNum.isEmpty()) {
            showAlert("Card invalid");
    	}
    	else{
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("ThankYou.fxml"));
	        Parent root = loader.load();
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        Scene scene = new Scene(root);
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
    
//    public void setFoodData(String[] foodNames, double[] pax, double[] prices, int foodSize) {
//        this.foodNames = foodNames;
//        this.pax = pax;
//        this.prices = prices;
//        this.foodSize = foodSize;
//    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayFoodNames();
    }

    private void displayFoodNames() {
        int row = 0;
        for (int i = 0; i < foodSize; i++) {
        	if(pax[i] > 0) {
//        		Label foodLabel = new Label(foodNames[i]);
//	            Label paxLabel = new Label(String.valueOf(pax[i]));
//	            Label priceLabel = new Label(String.valueOf(prices[i]));
//	            
//	            foodGrid.add(foodLabel, 0, row);
//	            foodGrid.add(paxLabel, 1, row);
//	            foodGrid.add(priceLabel, 2, row);
//	            
//	            System.out.println(foodNames[i]);
//	            System.out.println(pax[i]);
//	            System.out.println(prices[i]);
	            
	            row++;
        	}
        }
    }
}