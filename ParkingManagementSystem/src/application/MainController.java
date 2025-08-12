package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * MainController sınıfı, ana menüdeki butonların işlevlerini yönetir.
 * Her buton farklı bir alt ekranı (FXML dosyasını) açar.
 */
public class MainController {

    /**
     * "Araç Girişi" butonuna basıldığında araç giriş ekranını açar.
     */
    @FXML
    private void handleAracGirisi(ActionEvent event) {
        try {
            // arac_giris_view.fxml dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/arac_giris_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Araç Girişi");
            stage.setScene(new Scene(loader.load()));
            stage.setResizable(false); // Kullanıcı pencere boyutunu değiştiremesin
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * "Araç Çıkışı" butonuna basıldığında araç çıkış ekranını açar.
     */
    @FXML
    private void handleAracCikisi(ActionEvent event) {
        try {
            // arac_cikis_view.fxml dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/arac_cikis_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Araç Çıkışı");
            stage.setScene(new Scene(loader.load()));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * "Plaka ile Sorgula" butonuna basıldığında plaka sorgulama ekranını açar.
     */
    @FXML
    private void handleSorgula(ActionEvent event) {
        try {
            // plaka_sorgu_view.fxml dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/plaka_sorgu_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Plaka Sorgulama");
            Scene scene = new Scene(loader.load(), 400, 300); // GENİŞLİK, YÜKSEKLİK
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * "Geçmişi Görüntüle" butonuna basıldığında hareket geçmişi ekranını açar.
     */
    @FXML
    private void handleGecmis(ActionEvent event) {
        try {
            // gecmis_view.fxml dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/gecmis_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Hareket Geçmişi");
            stage.setScene(new Scene(loader.load()));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * "Tüm Araçları Görüntüle" butonuna basıldığında otoparktaki tüm araçları listeler.
     */
    @FXML
    private void handleTumAraclar(ActionEvent event) {
        try {
            // tum_araclar_view.fxml dosyasını yükle
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/tum_araclar_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Tüm Araçlar");
            stage.setScene(new Scene(loader.load()));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleSlotDurum(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/slot_durum_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Slot Durumu");
            stage.setScene(new Scene(loader.load()));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleRezervasyon(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/reservation_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Rezervasyon Paneli");
            stage.setScene(new Scene(loader.load()));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
