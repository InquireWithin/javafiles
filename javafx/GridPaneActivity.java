package javafx;

import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
public class GridPaneActivity  extends Application{
    public GridPane calculator() {
        GridPane gp = new GridPane();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    
    public void start(Stage arg0) throws Exception {
        Label result = makeLabel("0",Color.    BLACK, java.awt.Color.white);
        result.setBorder(new Border(new BorderStroke(Color.LIMEGREEN, BorderStrokeStyle.DASHED, new CornerRadii(5),BorderStroke.THICK)));
        Label zero = makeLabel("0",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label one = makeLabel("1",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label two = makeLabel("2",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label three = makeLabel("3",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label four = makeLabel("4",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label five = makeLabel("5",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label six = makeLabel("6",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label seven = makeLabel("7",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label eight= makeLabel("8",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label nine = makeLabel("9",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label plus= makeLabel("+",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label minus = makeLabel("-",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label divide = makeLabel("/",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label modulo = makeLabel("%",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        Label equals = makeLabel("=",Color.DIMGRAY,java.awt.Color.LIGHT_GRAY);
        GridPane pane = new GridPane();
        pane.add(result,0,0,4,1);
        pane.add(one,0,1);
        pane.add(two,1,1);
        pane.add(three,2,1);
        pane.add(plus,3,1);
        
        /*Label left = makeLabel("Top",Color.DIMGRAY, Color.SALMON);
        Label center = makeLabel("Top",Color.DIMGRAY, Color.LEMONCHIFFON);
        Label right = makeLabel("Top",Color.DIMGRAY, Color.HOTPINK);
        Label bottom = makeLabel("Top",Color.DIMGRAY, Color.HONEYDEW);*/
        //BorderPane pane = new BorderPane();
        //pane.setTop(top);
        //pane.setLeft(left);pane.setRight(right);pane.setCenter(center);pane.setBottom(bottom);;
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
    }

    private Label makeLabel(String text, Color textColor,java.awt.Color backgroundColor){
        Label label = new Label(text);
        
        label.setFont(new Font("Arial",36));
        label.setTextFill(textColor);
        label.setPadding(new Insets(30));
        
        

        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setBackground(new Background(new BackgroundFill(backgroundColor, new CornerRadii(8), Insets.EMPTY)));
        return label;
    }

}
