package sample;

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

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.BOLD, 48));
        gc.fillText("Hello World!", 60, 50);
        gc.strokeText( "Hello World!", 60, 50);

        Image datImage = new Image("samples/Ship/f1.png");
        gc.drawImage(datImage, 180, 100);

        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
