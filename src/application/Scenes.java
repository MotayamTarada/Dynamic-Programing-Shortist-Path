package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scenes {

	Button res = new Button("Path");
	Button alt = new Button("alt");
	Button dp = new Button("DP");

	TextArea text = new TextArea();
	TextArea text1 = new TextArea();
	TextArea text2 = new TextArea();

	public GridPane GridP() {
		GridPane pane = new GridPane();
		VBox vbox = new VBox(20);
		DatePicker datePicker = new DatePicker();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);
		pane.add( text,0, 0);
		pane.add(res,0, 1);
		text.setMaxWidth(400);
		text.setMaxHeight(200);
		
		Text err =new Text("Fiald Input Is null !!!");
		Text mass = new Text("Add Is Successfully");
		// Design text font
	
		err.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		mass.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		

		 res.setOnAction(e -> {
				try {
					
					massegeBox(mass);
				} catch (Exception e1) {
					massegeBox(err);
				}
			});

	        // Create a background image


		return pane;
	}
	public GridPane GridP2() {
		GridPane pane = new GridPane();
		VBox vbox = new VBox(20);
		DatePicker datePicker = new DatePicker();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);
		pane.add( text1,0, 0);
		pane.add(alt,0, 1);
		text1.setMaxWidth(400);
		text1.setMaxHeight(200);
		
		Text err =new Text("Fiald Input Is null !!!");
		Text mass = new Text("Add Is Successfully");
		// Design text font
	
		err.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		mass.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		

		 alt.setOnAction(e -> {
				try {
					
					massegeBox(mass);
				} catch (Exception e1) {
					massegeBox(err);
				}
			});
		 

	        // Create a background image


		return pane;
	}
	
	public GridPane GridP3() {
		GridPane pane = new GridPane();
		VBox vbox = new VBox(20);
		DatePicker datePicker = new DatePicker();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);
		pane.add( text2,0, 0);
		pane.add(dp,0, 1);
		text2.setMaxWidth(400);
		text2.setMaxHeight(400);
		
		Text err =new Text("Fiald Input Is null !!!");
		Text mass = new Text("Add Is Successfully");
		// Design text font
	
		err.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		mass.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		

		 dp.setOnAction(e -> {
				try {
					
					massegeBox(mass);
				} catch (Exception e1) {
					massegeBox(err);
				}
			});


		return pane;
	}
	

	public static Stage massegeBox(Text text) {
		GridPane pane = new GridPane();
		Button ok = new Button("OK");
		Stage stage = new Stage();
		stage.setScene(new Scene(pane, 280, 130));
		pane.add(text, 0, 0);
		pane.add(ok, 0, 2);
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);
		stage.show();
		ok.setOnAction(e -> {
			stage.close();
		});
		stage.setTitle("Message");
		return stage;
	}
}
