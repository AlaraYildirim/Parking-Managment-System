package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * AppGUI sınıfı JavaFX uygulamasının başlangıç noktasıdır.
 * Ana sahneyi (Stage) başlatır ve main_view.fxml dosyasını yükler.
 */
public class AppGUI extends Application {

    /**
     * JavaFX uygulaması başlatıldığında çağrılır.
     * Burada sahne (Stage) ayarlanır ve ilk ekran yüklenir.
     *
     * @param stage Ana pencere (Stage)
     * @throws IOException FXML dosyası yüklenemezse fırlatılır
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Ana FXML dosyasını yükle (Ana Menü: main_view.fxml)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/main_view.fxml"));
        
        // FXML'den bir sahne (Scene) oluştur
        Scene scene = new Scene(loader.load());

        // Pencere başlığını ayarla
        stage.setTitle("Otopark Yönetim Sistemi");

        // Sahneyi pencereye yerleştir
        stage.setScene(scene);

        // Pencereyi göster
        stage.show();
    }
}
