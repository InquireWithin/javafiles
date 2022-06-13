package javafx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Update implements EventHandler<ActionEvent> {
    private TextField tf;
    private Label l;
    public Update(Label l,TextField tf){this.tf=tf;this.l=l;}

    @Override
    public void handle(ActionEvent event) {
        l.setText(tf.getText());
        
    }
    
}
