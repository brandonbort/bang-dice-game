/*
 * AUTHOR: Brandon Bort
 */
package User_Interface_Components;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Brandon
 */
public class StartScreenUI extends Application implements EventHandler<ActionEvent> {
    
    Button startButton;
    ChoiceBox playerNum;
    Label playerLabel;
    HBox playerBox;
    HBox bottomPane;
    
    public void launchGame(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Bang! Dice Game");
        primaryStage.setResizable(false);
        FileInputStream iconStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/bang icon.jpg");
        Image icon = new Image(iconStream);
        primaryStage.getIcons().add(icon);
        //button won't be selectable until the everything is correctly populated
        startButton = new Button("Start!");
        startButton.setDisable(true);
        startButton.setOnAction(this);
        
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        
        playerLabel = new Label("Number of Players: ");
        //array that populates the choice box
        String nums[] = {"3", "4", "5", "6", "7", "8"};
        playerNum = new ChoiceBox(FXCollections.observableArrayList(nums));
        playerNum.setOnAction(this);
        
        BorderPane layout = new BorderPane();

        playerBox = newHbox();
        playerBox.getChildren().addAll(playerLabel, playerNum);
        playerBox.setBackground(background);
        

        FileInputStream logoStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/bang logo.jpg");
        Image logo = new Image(logoStream);
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(100);
        logoView.setFitWidth(325);

        layout.setTop(logoView);
        layout.setCenter(playerBox);
        
        bottomPane = newHbox();
        bottomPane.getChildren().add(startButton);
        bottomPane.setBackground(background);
        
        layout.setBottom(bottomPane);
        Scene scene = new Scene(layout, 300, 200);
    
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==startButton){
            System.out.println("User_Interface_Components.StartScreenUI.handle()");
            //launchGameBoard(playerNum.getValue());
        }
        if(event.getSource()==playerNum){
            //enables the start button once the choices are correctly filled out
            startButton.setDisable(false);
        }
    }
    //standardized spacing for all hbox layouts throughout the UI
    public HBox newHbox(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }
    
    public VBox newVbox(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        
        return vbox;
    }
}
