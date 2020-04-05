import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiTest extends Application{
	
	School school;

	public static void main(String[] schoolApp) {
		// launch app
		launch(schoolApp);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// display border to scene
		BorderPane root = new BorderPane();
		
		GridPane pane = new GridPane();
		
		// display load data
		TextArea schoolData = new TextArea();
		root.setTop(pane);
		root.setBottom(schoolData);
		
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setVgap(5);
		pane.setHgap(5);
		
		schoolData.setPrefRowCount(10);
		schoolData.setPrefColumnCount(20);
		// create label to school
		Label schoolNameL = new Label("School Name");;
		Label schoolFloorsL = new Label("School Floors");
		// create label to room
		Label roomNumberL = new Label("Room Number");;
		Label roomCapacityL = new Label("Room Capacity");
		// create label to class
		Label classSizeL = new Label("Class Size");;
		Label classLevelL = new Label("Class Level");
		Label classTeacherL = new Label("Teacher Name");;
		
		// create text field for school
		TextField schoolNameTf = new TextField();
		TextField schoolFloorsTf = new TextField();
		// create text field for room
		TextField roomNumberTf = new TextField();
		TextField roomCapacityTf = new TextField();
		// create text field for class
		TextField classSizeTf = new TextField();
		TextField classLevelTf = new TextField();
		TextField classTeacherTf = new TextField();
		// create buttons
		Button addSchool = new Button("Add School");
		Button addRoom = new Button("Add Room");
		Button addClass = new Button("Assign Class To Right Room");
		Button save = new Button("Save School Data");
		Button load = new Button("Load School");
		// create new school
		addSchool.setOnAction(e -> {
			school = new School(schoolNameTf.getText(), Integer.parseInt(schoolFloorsTf.getText()));
			
		});
		// add room to school
		addRoom.setOnAction(e -> {
			school.addRoom(new Room(roomNumberTf.getText(), Integer.parseInt(roomCapacityTf.getText())));
			
		});
		// assign class to to the right room
		addClass.setOnAction(e -> {
			
			try {
				school.assignclassToRightRoom(new Class(Integer.parseInt(classSizeTf.getText()), classLevelTf.getText(), classTeacherTf.getText()));
			} catch (Exception e1) {
								
			}
		
		});
		// save data
		save.setOnAction(e -> {
			school.saveSchool();
			
		});
		// load data
		load.setOnAction(e -> {
			
			schoolData.setText(school.loadSchool());
		});
		
		// add school attribute
		pane.add(schoolNameL, 0, 0);
		pane.add(schoolNameTf, 1, 0);
		pane.add(schoolFloorsL, 0, 1);
		pane.add(schoolFloorsTf, 1, 1);
		pane.add(addSchool, 0, 2);
		// add room atribute
		pane.add(roomNumberL, 0, 3);
		pane.add(roomNumberTf, 1, 3);
		pane.add(roomCapacityL, 0, 4);
		pane.add(roomCapacityTf, 1, 4);
		pane.add(addRoom, 0, 5);
		// add class attribute
		pane.add(classSizeL, 0, 6);
		pane.add(classSizeTf, 1, 6);
		pane.add(classLevelL, 0, 7);
		pane.add(classLevelTf, 1, 7);
		pane.add(classTeacherL, 0, 8);
		pane.add(classTeacherTf, 1, 8);
		pane.add(addClass, 0, 9);
		pane.add(save, 0, 10); 
		pane.add(load, 1, 10);
		
		
		
		// frame of screen
		Scene scene = new Scene(root, 400, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("M251 - TMA 2020");
		primaryStage.show();
		
	}

}
