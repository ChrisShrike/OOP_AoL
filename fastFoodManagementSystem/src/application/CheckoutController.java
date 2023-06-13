package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckoutController implements Initializable {

	 	@FXML
	    private Text OrderText;

	    @FXML
	    private Text OrderText1;

	    @FXML
	    private TextField cardNum;

	    @FXML
	    private Text food;

	    @FXML
	    private Text food1;

	    @FXML
	    private Text food2;

	    @FXML
	    private Text food3;

	    @FXML
	    private Text food4;

	    @FXML
	    private Text food5;

	    @FXML
	    private Text food6;

	    @FXML
	    private Text food7;

	    @FXML
	    private Text food8;

	    @FXML
	    private Text food9;

	    @FXML
	    private GridPane foodGrid;

	    @FXML
	    private Text pax;

	    @FXML
	    private Text pax1;

	    @FXML
	    private Text pax2;

	    @FXML
	    private Text pax3;

	    @FXML
	    private Text pax4;

	    @FXML
	    private Text pax5;

	    @FXML
	    private Text pax6;

	    @FXML
	    private Text pax7;

	    @FXML
	    private Text pax8;

	    @FXML
	    private Text pax9;

	    @FXML
	    private PasswordField pin;

	    @FXML
	    private Text price;

	    @FXML
	    private Text price1;

	    @FXML
	    private Text price2;

	    @FXML
	    private Text price3;

	    @FXML
	    private Text price4;

	    @FXML
	    private Text price5;

	    @FXML
	    private Text price6;

	    @FXML
	    private Text price7;

	    @FXML
	    private Text price8;

	    @FXML
	    private Text price9;
	    
	    @FXML
	    private Text totalPrice;
    private List<Food> foods;

    public void next(ActionEvent event) throws IOException {
    	String num1 = cardNum.getText();
    	String num2 = pin.getText();
    	String cleanedNum1 = num1.replaceAll("\\D", "");
    	String cleanedNum2 = num2.replaceAll("\\D", "");
    	
    	if(cleanedNum1.isEmpty() && cleanedNum2.isEmpty()) {
            showAlert("Card invalid");
    	}
    	else if(cleanedNum2.length() != 3) {
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
    
    public void setFoods(List<Food> foods) {
        this.foods = foods;
        printFoodDetailsWithMoreThanZeroPax();
    }
    
    @FXML
    private void printFoodDetailsWithMoreThanZeroPax() {
    	double curr = 0;
    	double tot = 0;
//        int row = 0;
        int i = 0;
        
    	for (Food food : foods) {
            if (food.getPax() > 0) {
            	String temp1 = food.getName();
                double temp2 = food.getPax();
                double temp3 = food.getPrice();
                curr = temp2 * temp3;
                tot += curr;
                
                System.out.println("success");
            	System.out.println("Food Name: " + temp1);
                System.out.println("Pax: " + temp2);
                System.out.println("Price: " + curr);
                System.out.println("---------------------");   
                
                if(i == 0) {
                	food1.setText(temp1);
                	pax1.setText(String.valueOf(temp2));
                	price1.setText(String.valueOf(curr));
                	food1.setOpacity(1);
                	pax1.setOpacity(1);
                	price1.setOpacity(1);
                } else if(i == 1) {
                	food2.setText(temp1);
                	pax2.setText(String.valueOf(temp2));
                	price2.setText(String.valueOf(curr));
                	food2.setOpacity(1);
                	pax2.setOpacity(1);
                	price2.setOpacity(1);
                } else if(i == 2) {
                	food3.setText(temp1);
                	pax3.setText(String.valueOf(temp2));
                	price3.setText(String.valueOf(curr));
                	food3.setOpacity(1);
                	pax3.setOpacity(1);
                	price3.setOpacity(1);
                } else if(i == 3) {
                	food4.setText(temp1);
                	pax4.setText(String.valueOf(temp2));
                	price4.setText(String.valueOf(curr));
                	food4.setOpacity(1);
                	pax4.setOpacity(1);
                	price4.setOpacity(1);
                } else if(i == 4) {
                	food5.setText(temp1);
                	pax5.setText(String.valueOf(temp2));
                	price5.setText(String.valueOf(curr));
                	food5.setOpacity(1);
                	pax5.setOpacity(1);
                	price5.setOpacity(1);
                } else if(i == 5) {
                	food6.setText(temp1);
                	pax6.setText(String.valueOf(temp2));
                	price6.setText(String.valueOf(curr));
                	food6.setOpacity(1);
                	pax6.setOpacity(1);
                	price6.setOpacity(1);
                } else if(i == 6) {
                	food7.setText(temp1);
                	pax7.setText(String.valueOf(temp2));
                	price7.setText(String.valueOf(curr));
                	food7.setOpacity(1);
                	pax7.setOpacity(1);
                	price7.setOpacity(1);
                } else if(i == 7) {
                	food8.setText(temp1);
                	pax8.setText(String.valueOf(temp2));
                	price8.setText(String.valueOf(curr));
                	food8.setOpacity(1);
                	pax8.setOpacity(1);
                	price8.setOpacity(1);
                } else if(i == 8) {
                	food9.setText(temp1);
                	pax9.setText(String.valueOf(temp2));
                	price9.setText(String.valueOf(curr));
                	food9.setOpacity(1);
                	pax9.setOpacity(1);
                	price9.setOpacity(1);
                }
                
//                foodLabel = new Label(temp1);
//                paxLabel= new Label(String.valueOf(temp2));
//                priceLabel= new Label(String.valueOf(curr));
//                
//                foodLabel.setFont(new Font("Cambria", 24));
//                paxLabel.setFont(new Font("Cambria", 24));
//                priceLabel.setFont(new Font("Cambria", 24));
//                
//                foodLabel.setText(temp1);
//                paxLabel.setText(String.valueOf(temp2));
//                priceLabel.setText(String.valueOf(curr));
//                
//                foodGrid.add(foodLabel, 0, row);
//	            foodGrid.add(paxLabel, 1, row);
//	            foodGrid.add(priceLabel, 2, row);
//	            
//	            GridPane.setConstraints(foodLabel, 0, row);
//	            GridPane.setConstraints(paxLabel, 1, row);
//	            GridPane.setConstraints(priceLabel, 2, row);
//
//	            foodGrid.getChildren().addAll(foodLabel, paxLabel, priceLabel);
	            
//                row++;
                
//                System.out.println("recheck success");
//            	System.out.println("Food Name: " + foodLabel.getText());
//                System.out.println("Pax: " + paxLabel.getText());
//                System.out.println("Price: " + priceLabel.getText());
//                System.out.println("---------------------");
                
                i++;
            }
            System.out.println("inside for no");
        }
    	totalPrice.setText("Rp. " + String.valueOf(tot));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	foods = new ArrayList<>();
    	setFoods(foods);
    }
}