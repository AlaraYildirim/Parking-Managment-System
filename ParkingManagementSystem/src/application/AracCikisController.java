package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * AracCikisController sınıfı araç çıkış işlemlerini yönetir.
 * Kullanıcı plakayı girer ve çıkış işlemi GUI üzerinden gerçekleştirilir.
 */
public class AracCikisController {

    // Plaka giriş alanı
    @FXML
    private TextField plakaField;

    // Bilgi veya hata mesajı gösterilecek Label
    @FXML
    private Label mesajLabel;

    /**
     * "Çıkış Yap" butonuna basıldığında çalışacak metod.
     * Kullanıcının girdiği plakaya göre araç çıkış işlemini yönetir.
     */
    @FXML
    private void handleCikisYap() {
        // Kullanıcının girdiği plakayı al ve boşlukları temizle
        String plaka = plakaField.getText().trim();

        // Plaka boş girilmişse kullanıcıyı uyar
        if (plaka.isEmpty()) {
            mesajLabel.setText("Lütfen plaka giriniz.");
            return;
        }

        // Girilen plaka sistemde kayıtlı değilse kullanıcıyı uyar
        if (!VehicleDAO.exists(plaka)) {
            mesajLabel.setText("Bu plaka sistemde kayıtlı değil.");
            return;
        }

        // Giriş saatini al ve çıkış işlemini başlat
        String exitTime = TimeUtil.now();
        
        // Araç çıkışı işlemi ve veritabanı güncellemesi
        VehicleDAO.exitVehicle(plaka, exitTime);

        // Başarılı çıkış mesajı göster
        mesajLabel.setText(plaka + " plakalı araç çıkış yaptı.");

        // Plaka giriş alanını temizle
        plakaField.clear();
    }
}
