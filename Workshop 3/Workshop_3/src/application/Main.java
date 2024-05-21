/**********************************************
Workshop 3
Course:APD545 - 5th Semester
Last Name: Aman 
First Name:Aanand 
ID: 166125211 
Section: ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Aanand Aman
Date: 2024/3/5 
**********************************************/

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("VehicleLoan.fxml"));
			Scene scene = new Scene(root,720,705);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
