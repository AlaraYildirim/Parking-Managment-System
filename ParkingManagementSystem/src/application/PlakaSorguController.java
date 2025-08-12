package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * PlakaSorguController sınıfı, kullanıcıların plaka numarası ile araç sorgulaması yapmasını sağlar.
 * Araç bilgileri hızlı erişim için önceden cache'e (VehicleCache) yüklenir.
 */
public class PlakaSorguController {

    // Kullanıcının sorgulamak için plaka girdiği alan
    @FXML
    private TextField plakaField;

    // Sorgu sonucunun gösterileceği label
    @FXML
    private Label sonucLabel;

    // Bellek içinde hızlı sorgulama için araç önbelleği
    private VehicleCache cache = new VehicleCache();

    /**
     * Ekran açıldığında çalışır. Araç verileri önbelleğe yüklenir.
     */
    @FXML
    private void initialize() {
        cache.loadVehiclesFromDatabase(); // Form açıldığında cache hazırlanır
    }

    /**
     * "Sorgula" butonuna basıldığında çalışır.
     * Kullanıcının girdiği plakaya göre araç bilgisi aranır ve sonuç gösterilir.
     */
    @FXML
    private void handleSorgula() {
        // Kullanıcının girdiği plakayı oku ve boşlukları temizle
        String plaka = plakaField.getText().trim();

        // Eğer plaka boşsa kullanıcıyı uyar
        if (plaka.isEmpty()) {
            sonucLabel.setText("Lütfen plaka giriniz.");
            return;
        }

        // Cache üzerinden aracı bul
        Vehicle v = cache.findByPlate(plaka);

        // Araç bulunduysa bilgileri ekrana yazdır
        if (v != null) {
            sonucLabel.setText(
                    "Plaka: " + v.getLicensePlate() +
                    "\nModel: " + v.getModel() +
                    "\nGiriş: " + v.getEntryTime() +
                    "\nSlot: " + v.getSlotFloor() + "-" + v.getSlotBlock() + "-" + v.getSlotNumber()
            );
        } 
        // Araç bulunamadıysa kullanıcıyı bilgilendir
        else {
            sonucLabel.setText("Araç bulunamadı.");
        }
    }
}
