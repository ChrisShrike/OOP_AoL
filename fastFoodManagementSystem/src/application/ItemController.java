package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemController {

	@FXML
    private Label FoodPax;

    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;
    
    @FXML
    private void click(MouseEvent mouseEvent) {
    	myListener.onClickListener(food);
    }
    
    private Food food;
    private MyListener myListener;
    
    public void setData(Food food, MyListener myListener) {
    	this.food = food;
    	this.myListener = myListener;
    	nameLabel.setText(food.getName());
    	priceLabel.setText(Main.CURRENCY + food.getPrice());
    	FoodPax.setText(String.valueOf(food.getPax()));
    	Image image = new Image(getClass().getResourceAsStream(food.getImgSrc()));
    	img.setImage(image);
    }
}
