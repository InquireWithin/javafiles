package javafx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClickCounter extends Application {
    private int count;
    @Override
    public void start(Stage arg0) throws Exception {
        count=0;
        
        VBox vbox = new VBox();
        Label l = new Label();
        l.setFont(new Font("Arial", 24));
        l.setPadding(new Insets(10));
        l.setText("number of respects paid: "); //+((Integer)count).toString());
        Label clicks= new Label(" "+count);
        Button button = new Button("f to pay respects, rip meg");
        button.setOnAction((e)->{count+=1;clicks.setText((""+count));});
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        clicks.setFont(new Font("Arial", 64));
        clicks.setPadding(new Insets(20));
        clicks.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(button,l,clicks);
        
        Scene scene =new Scene(vbox);
        arg0.setScene(scene);
        arg0.show();;
    }
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
