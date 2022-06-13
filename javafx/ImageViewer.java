package javafx;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;
public class ImageViewer extends Application{

    @Override
    public void start(Stage stage) throws Exception {
       ImageView img = new ImageView(new Image("https://cdn.discordapp.com/attachments/526562967186178048/834392958396530688/Screenshot_2021-04-20-22-34-51.png"));
        VBox box = new VBox();
        box.getChildren().add(img);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
