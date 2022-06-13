package javafx;
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
import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
public class LabelActivity extends Application {
    @Override
    public void start(Stage stage)throws Exception{
        Label label = new Label("Hello JavaFX!");
        
        label.setFont(new Font("Lucidia",36));
        label.setTextFill(Color.ALICEBLUE);
        label.setPadding(new Insets(30));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, new CornerRadii(8), Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5),BorderStroke.THIN)));
        Label label2 = new Label("Goodbye JavaFX!");
        
        label2.setFont(new Font("Lucidia",36));
        label2.setTextFill(Color.ALICEBLUE);
        label2.setPadding(new Insets(30));
        label2.setMaxWidth(Double.MAX_VALUE);
        label2.setBackground(new Background(new BackgroundFill(Color.CHARTREUSE, new CornerRadii(8), Insets.EMPTY)));
        label2.setBorder(new Border(new BorderStroke(Color.LIMEGREEN, BorderStrokeStyle.DASHED, new CornerRadii(5),BorderStroke.THICK)));
        Label label3 = new Label("With Style");
        
        label3.setFont(new Font("Lucidia",36));
        label3.setTextFill(Color.ANTIQUEWHITE);
        label3.setMaxWidth(Double.MAX_VALUE);
        label3.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.NONE, new CornerRadii(3),BorderStroke.THIN)));
        label3.setPadding(new Insets(30));
        label3.setStyle("-fx-background-color: Dodger Blue");
        label3.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, new CornerRadii(8), Insets.EMPTY)));
        
        VBox box = new VBox();
        box.getChildren().addAll(label,label3,label2);
        
        Scene scene = new Scene(box);
        stage.setTitle("Label Activity");
        stage.setScene(scene);
        stage.show();

    }
    private Label makeLabel(String text, Color textColor,Color backgroundColor){
        Label label = new Label(text);
        
        label.setFont(new Font("Arial",36));
        label.setTextFill(textColor);
        label.setPadding(new Insets(30));
        
        

        label.setMaxWidth(Double.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(8), Insets.EMPTY)));
        return label;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
