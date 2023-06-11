package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
	
	private double x = 0;
	private double y = 0;
	public static final String CURRENCY = "Rp. ";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RegLog.fxml"));
			
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("loginDesign.css").toExternalForm());
			
			root.setOnMousePressed((MouseEvent event) ->{
				x = event.getSceneX();
				y = event.getSceneY();
			});
			
			root.setOnMouseDragged((MouseEvent event) -> {
				primaryStage.setX(event.getScreenX() - x);
				primaryStage.setY(event.getScreenY() - y);
				
				primaryStage.setOpacity(.8);
			});
			
			root.setOnMouseReleased((MouseEvent event) -> {
				primaryStage.setOpacity(1);
			});
			
			Image img = new Image(getClass().getResourceAsStream("/application/icon.png"));
			primaryStage.getIcons().add(img);
			primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.centerOnScreen();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}