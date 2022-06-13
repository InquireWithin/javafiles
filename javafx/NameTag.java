package javafx;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.beans.EventHandler;

import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
public class NameTag extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Label hello= new Label("Hello my name is");
        Label name = new Label("Your name");
        TextField text = new TextField("Enter your name");
        Button update = new Button("Update Name Tag");
        update.setOnAction(new Update(name, text));
        Button clear = new Button("Clear");
        clear.setOnAction((e)->name.setText(""));
        VBox box = new VBox();
        box.getChildren().addAll(hello,name,text,update, clear);
        Scene scene = new Scene(box);
        
        stage.setScene(scene);
        stage.show();
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
