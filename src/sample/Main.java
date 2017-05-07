package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.canvas.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent fxmlroot = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Hello World");

        Group root = new Group();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(512,512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        /*Commenting following block out, because this belongs to another tutorial!!
        //First example begins here!
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.BOLD, 48));
        gc.fillText("Hello World!", 60, 50);
        gc.strokeText( "Hello World!", 60, 50);

        Image datImage = new Image("samples/Ship/f1.png");
        gc.drawImage(datImage, 180, 100);*/

        //Second example begins here!
        Image space = new Image("samples/Backgrounds/farback.gif");
        Image rocket = new Image("samples/Ship/f1.png");
        Image ufo = new Image("samples/Enemy/Example/e_f1.png");

        final long startNanoTimer = System.nanoTime();

        new AnimationTimer(){
            public void handle(long currentNanoTime){
                double t = (currentNanoTime - startNanoTimer) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                //Background image clears canvas
                gc.drawImage(space, 0, 0);
                gc.drawImage(rocket, x, y);
                gc.drawImage(ufo, 196, 196);
            }
        }.start();

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
