package javafx;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PacManWav extends Application{
    //event handler for buttons used during the start method
    private class PlayMedia implements EventHandler<ActionEvent> {
        private String URI;
    
        public PlayMedia(String fileName){
            URI = new File(fileName).toURI().toString();

        }

        @Override
        public void handle(ActionEvent arg0) {
            Media media = new Media(URI);
            MediaPlayer player = new MediaPlayer(media);
            player.play(); 
        }
    }
    @Override
    public void start(Stage arg0) throws Exception {
        //new MediaPlayer(new Media("media/sounds/start.wav")
        MediaPlayer mp = new MediaPlayer(new Media(new File("media/sounds/start.wav").toURI().toString()));
        Button startSound = new Button("Start");
        startSound.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //mp = new MediaPlayer(new Media("media/sounds/start.wav"));
        startSound.setOnAction((e)->{mp.stop();mp.play();});
        Button chomp = new Button("Chomp");
        chomp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        MediaPlayer chompPlayer= new MediaPlayer(new Media(new File("media/sounds/chomp.wav").toURI().toString()));
        chomp.setOnAction((e)->{chompPlayer.stop();chompPlayer.play();});
        Button eat = new Button("eat");
        eat.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        MediaPlayer eatPlayer = new MediaPlayer(new Media(new File("media/sounds/eat.wav").toURI().toString()));
        eat.setOnAction((e)->{eatPlayer.stop();eatPlayer.play();});
        Button end = new Button("end");
        end.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        MediaPlayer endPlayer =new MediaPlayer(new Media(new File("media/sounds/end.wav").toURI().toString()));
        end.setOnAction((e)->{endPlayer.stop();endPlayer.play();});
        VBox box= new VBox();
        box.getChildren().addAll(startSound,chomp,eat,end);
        ImageView image = new ImageView("file:media/images/smb.gif");
        VBox.setVgrow(startSound, Priority.ALWAYS);
        VBox.setVgrow(end, Priority.ALWAYS);
        VBox.setVgrow(chomp, Priority.ALWAYS);
        VBox.setVgrow(eat, Priority.ALWAYS);
        HBox hbox =new HBox();
        hbox.getChildren().addAll(image,box);
        Scene scene  = new Scene(hbox);
        arg0.setScene(scene);
        arg0.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
