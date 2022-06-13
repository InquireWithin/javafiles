package javafx; 

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
public class BorderPaneActivity extends Application{
    private Label makeLabel(String text, Color textColor,Color backgroundColor){
        Label label = new Label(text);
        
        label.setFont(new Font("Arial",36));
        label.setTextFill(textColor);
        label.setPadding(new Insets(30));
        
        

        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(8), Insets.EMPTY)));
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label top = makeLabel("Top",Color.DIMGRAY, Color.BISQUE);
        Label left = makeLabel("Top",Color.DIMGRAY, Color.SALMON);
        Label center = makeLabel("Top",Color.DIMGRAY, Color.LEMONCHIFFON);
        Label right = makeLabel("Top",Color.DIMGRAY, Color.HOTPINK);
        Label bottom = makeLabel("Top",Color.DIMGRAY, Color.HONEYDEW);
        BorderPane pane = new BorderPane();
        pane.setTop(top);
        pane.setLeft(left);pane.setRight(right);pane.setCenter(center);pane.setBottom(bottom);;
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
