package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main sınıfı JavaFX uygulamasının başlangıç noktasıdır.
 * Ana menüyü (main_view.fxml) yükler ve başlatır.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/main_view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Otopark Yönetim Sistemi");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // JavaFX uygulamasını başlatır
    }
}
