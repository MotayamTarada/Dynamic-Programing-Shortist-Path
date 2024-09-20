package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Main extends Application {
	static int count;
	Button select = new Button("Load File");
	Text messge3 = new Text("No file selected.");
	Text messge = new Text("Save Is Successfully");
	Button login = new Button("LOGIN");
	public static TheThingToManageTheMap node;

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			TabPane pane = new TabPane(); // Mangement screen

			root.add(select, 0, 0);
			root.add(login, 0, 1);
			root.setVgap(10);
			select.setMaxWidth(100);
			login.setMinWidth(100);

			root.setAlignment(Pos.CENTER);

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Select a File");

			// Create a background image

			select.setOnAction(e -> {
				File selectedFile = fileChooser.showOpenDialog(primaryStage);
				if (selectedFile != null) {
					selectedFile.getAbsolutePath();
					try {
						BufferedReader br = new BufferedReader(new FileReader(selectedFile));
						node = new TheThingToManageTheMap();
						readFile(selectedFile);

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				} else {
					massegeBox(messge3);
				}
			});

			login.setOnAction(e -> {
				Stage stage = new Stage();
				Scene scene = new Scene(pane, 700, 600);
				stage.setScene(scene);
				stage.setTitle("Result");
				stage.show();
			});

			Scenes sec = new Scenes();
			Tab tab1 = new Tab("Expected_Resul");
			tab1.setContent(sec.GridP());
			Tab tab2 = new Tab("Alternatives_Result ");
			tab2.setContent(sec.GridP2());
			Tab tab3 = new Tab("DP_Table");
			tab3.setContent(sec.GridP3());

			pane.getTabs().addAll(tab1, tab2, tab3);

			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Main");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void readFile(File file) {
	    try {
	        Scanner in = new Scanner(file);

	        int numCities = Integer.parseInt(in.nextLine());

	        // Skip the Start and End cities
	        in.nextLine();

	        TheThingToManageTheMap map = new TheThingToManageTheMap();

	        while (in.hasNextLine()) {
	            map.addCity(in.nextLine());
	        }
			System.out.println( map.start.toString());
			
	        // Once all cities are added, find shortest paths and print results
			map.findShortestPathAndPrintResults(0,13);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
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

	public static void main(String[] args) {
		launch(args);
	}
}
