import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

// cred: https://code.makery.ch/library/javafx-tutorial/part1/

public class MainApp extends Application {
    private Stage primaryStage;
    private VBox rootLayout;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Game of Life");

        initRootLayout();

    }

    public void initRootLayout() {
        try {
            rootLayout = FXMLLoader.load(getClass().getClassLoader().getResource("view.fxml"));

            // show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
