package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.TreeMap;

/**
 * AracGirisController sınıfı araç giriş işlemlerini yönetir.
 * Kullanıcı araç plakasını ve modelini girerek sisteme yeni bir araç kaydı yapabilir.
 */
public class AracGirisController {

    // Plaka giriş alanı
    @FXML
    private TextField plakaField;

    // Model giriş alanı
    @FXML
    private TextField modelField;

    // Bilgi veya hata mesajı gösterilecek Label
    @FXML
    private Label mesajLabel;

    /**
     * "Giriş Yap" butonuna basıldığında çalışacak metod.
     * Araç bilgilerini alır, uygun bir slot bulur ve aracı sisteme kaydeder.
     */
    @FXML
    private void handleGirisYap() {
        // Kullanıcının girdiği plaka ve modeli al, boşlukları temizle
        String plaka = plakaField.getText().trim();
        String model = modelField.getText().trim();

        // Eğer plaka veya model boşsa kullanıcıyı uyar
        if (plaka.isEmpty() || model.isEmpty()) {
            mesajLabel.setText("Lütfen plaka ve model giriniz.");
            return;
        }

        // Eğer plaka zaten sistemde kayıtlıysa kullanıcıyı uyar
        if (VehicleDAO.exists(plaka)) {
            mesajLabel.setText("Bu plaka zaten sisteme kayıtlı!");
            return;
        }

        // Tüm otopark yapısını yükle (kat > blok > slot)
        TreeMap<String, TreeMap<String, TreeMap<Integer, ParkingSlot>>> structure =
                ParkingSlotDAO.loadParkingStructure();

        // Boş bir slot bul
        ParkingSlot slot = ParkingUtil.findFirstAvailableSlot(structure);

        // Eğer boş slot bulunamadıysa kullanıcıyı uyar
        if (slot == null) {
            mesajLabel.setText("Boş slot bulunamadı.");
            return;
        }

        // Araç nesnesi oluştur ve giriş zamanını ayarla
        Vehicle vehicle = new Vehicle(
                plaka,
                model,
                TimeUtil.now(),
                slot.getFloor(),
                slot.getBlock(),
                slot.getSlotNumber()
        );

        // Aracı veritabanına ekle ve slotu dolu olarak işaretle
        VehicleDAO.reserveSlotAndInsertVehicle(vehicle);

        // Başarılı kayıt mesajı göster
        mesajLabel.setText("Araç başarıyla kaydedildi. Slot: " +
                slot.getFloor() + "-" + slot.getBlock() + "-" + slot.getSlotNumber());

        // Giriş alanlarını temizle
        plakaField.clear();
        modelField.clear();
    }
}
