package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

	@FXML
    private VBox chosenFoodCard;

    @FXML
    private VBox chosenFoodCard1;

    @FXML
    private Label foodChosenDesc;
    
    @FXML
    private Label valueLabel;

    @FXML
    private ImageView foodImg;

    @FXML
    private Label foodNameLabel;

    @FXML
    private Label foodPriceLabel;

    @FXML
    private Spinner<Integer> foodSpinner;

    @FXML
    private GridPane grid;

    @FXML
    private GridPane grid1;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label userDisplay;

    
    private List<Food> foods = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    
    User user;
    
    public int foodset = 0;
    
    public List<Food> getData(){
    	List<Food> foods = new ArrayList<>();
    	Food food;
    	
    	if(foodset == 0) {
	    	food = new Food();
	    	food.setName("Combo 1");
	   		food.setPrice(25000);
	    	food.setImgSrc("/img/cb1.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("1x fries, 1x chicken, 1x soft drink");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Combo 2");
	   		food.setPrice(35000);
	    	food.setImgSrc("/img/cb2.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("1x fries, 2x chicken, 1x soft drink");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Combo 3");
	   		food.setPrice(20000);
	    	food.setImgSrc("/img/cb3.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("1x fries, 1x hamburger, 1x soft drink");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Combo 4");
	   		food.setPrice(25000);
	    	food.setImgSrc("/img/cb4.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("1x fries, 1x cheeseburger, 1x soft drink");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Chicken");
	   		food.setPrice(10000);
	    	food.setImgSrc("/img/Chicken.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("-");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Soft drink");
	   		food.setPrice(5000);
	    	food.setImgSrc("/img/Pepsi.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("-");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Fries");
	   		food.setPrice(7500);
	    	food.setImgSrc("/img/Fries.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("-");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Hamburger");
	   		food.setPrice(13000);
	    	food.setImgSrc("/img/Hamburger.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("-");
	    	food.setPax(0);
	    	
	    	food = new Food();
	    	food.setName("Cheeseburger");
	   		food.setPrice(18000);
	    	food.setImgSrc("/img/Cheeseburger.png");
	    	food.setColor("ff8601");
	    	foods.add(food);
	    	food.setDesc("-");
	    	food.setPax(0);
	    	foodset++;
    	}
    	
    	return foods;
    }
    
    private void setChosenFood(Food food) {
        foodNameLabel.setText(food.getName());
        foodPriceLabel.setText(Main.CURRENCY + food.getPrice());
        image = new Image(getClass().getResourceAsStream(food.getImgSrc()));
        foodImg.setImage(image);
        foodChosenDesc.setText(food.getDesc());;
        chosenFoodCard.setStyle("-fx-background-color: #" + food.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
        valueLabel.setText(Integer.toString(food.getPax()));
    }
    
    public void cartClick(MouseEvent mouseEvent) {
        try {
        	String foodName = foodNameLabel.getText();

            List<Food> itemsToRemove = new ArrayList<>();
            for (Food food : foods) {
                if (food.getName().equals(foodName)) {
                    food.setPax(Integer.parseInt(valueLabel.getText()));
                    initializeSmallIcon();
                    itemsToRemove.add(food);
                }
            }

            foods.removeAll(itemsToRemove);
        } catch (ConcurrentModificationException e) {
        	
        }
    }
    public double total;
    public String[] name = new String[foods.size() + 1];
    public double[] pax = new double[foods.size() + 1];
    public double[] price = new double[foods.size() + 1];
    
    public void checkOut(ActionEvent event) throws IOException {
    	double temp;
    	total = 0;
    	
    	for (int i = 0; i < foods.size(); i++) {
    	    Food food = foods.get(i);
    	    if (food.getPax() > 0) {
    	        temp = food.getPax() * food.getPrice();
    	        total += temp;
    	        name[i] = food.getName();
    	        pax[i] = food.getPax();
    	        price[i] = food.getPrice();
    	    }
//            System.out.println(food);
//            System.out.println(food.getName());
//            System.out.println(food.getPax());
//            System.out.println(food.getPrice());
//            System.out.println("-=-=-=-=-=-=-=-=-");
        }
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkout.fxml"));
        Parent root = loader.load();
        CheckoutController checkoutController = loader.getController();
//        checkoutController.setFoodData(name, pax, price, foods.size());
//    	root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
//        System.out.println("---");
//        System.out.println(total);
//        System.out.println(foods.size());
    }
    
    private Stage stage;
   	private Scene scene;
   	private Parent root;
    int curr;
    private static MenuController instance;
    
    public static MenuController getInstance() {
        return instance;
    }

    public List<Food> getFoods() {
        return foods;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	instance = this;
    	initializeSmallIcon();
    } 
    
    public void initializeSmallIcon() {
    	SpinnerValueFactory<Integer> valueFactory =
    		    new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
    	
    	valueFactory.setValue(0);
    	
    	foodSpinner.setValueFactory(valueFactory);
    	
    	valueLabel.setText(Integer.toString(foodSpinner.getValue()));
    	
    	foodSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				// TODO Auto-generated method stub
		    	valueLabel.setText(Integer.toString(foodSpinner.getValue()));
		    	curr = foodSpinner.getValue();
			}
    	});
    	
    	foods.addAll(getData());
    	
    	if (foods.size() > 0) {
    		setChosenFood(foods.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Food food) {
                	setChosenFood(food);
                	valueFactory.setValue(food.getPax());
                }
            };
            valueFactory.setValue(Integer.parseInt(valueLabel.getText()));
        }
    	
    	int column = 0;
    	int row = 0;
    	
    	try {
    		for(int i = 0; i < 4; i++) {
	    		FXMLLoader fxmlLoader = new FXMLLoader();
	    		fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
				AnchorPane anchorPane = fxmlLoader.load();
				
	    		ItemController itemController = fxmlLoader.getController();
	    		
	    		itemController.setData(foods.get(i), myListener);
	    		
	    		grid.add(anchorPane, column, row);
	    		
	    		grid.setMinWidth(Region.USE_COMPUTED_SIZE);
	            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
	            grid.setMaxWidth(Region.USE_PREF_SIZE);
	            
	            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
	            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
	            grid.setMaxHeight(Region.USE_PREF_SIZE);
	            
	            if(column == 1) {
	            	GridPane.setMargin(anchorPane, new Insets(10,10,10,155));
	            }else {
	            	GridPane.setMargin(anchorPane, new Insets(10,10,10,10));
	            }
	            
	            column++;
	            if(column > 2) {
	    			column = 0;
	    			row++;
	    		}
	    	}
    		column = 0;
    		row = 0;
    		for(int i = 4; i < 9; i++) {
	    		FXMLLoader fxmlLoader = new FXMLLoader();
	    		fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
				AnchorPane anchorPane = fxmlLoader.load();
				
	    		ItemController itemController = fxmlLoader.getController();
	    		itemController.setData(foods.get(i), myListener);
	    		
	    		grid1.add(anchorPane, column, row);
	    		
	    		grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
	            grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
	            grid1.setMaxWidth(Region.USE_PREF_SIZE);
	            
	            grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
	            grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
	            grid1.setMaxHeight(Region.USE_PREF_SIZE);
	            
	            if(column == 1) {
	            	GridPane.setMargin(anchorPane, new Insets(10,10,10,155));
	            }else {
	            	GridPane.setMargin(anchorPane, new Insets(10,10,10,10));
	            }
	            
	            column++;
	            if(column > 2) {
	    			column = 0;
	    			row++;
	    		}
	    	}
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}