package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

/**
 * TumAraclarController sınıfı, otoparktaki mevcut tüm araçları listelemek için kullanılır.
 * Araç bilgileri bir TableView içinde görüntülenir.
 */
public class TumAraclarController {

    // Araçların listeleneceği tablo
    @FXML
    private TableView<Vehicle> vehicleTable;

    // Tablo sütunu: Plaka bilgisi
    @FXML
    private TableColumn<Vehicle, String> plateColumn;

    // Tablo sütunu: Model bilgisi
    @FXML
    private TableColumn<Vehicle, String> modelColumn;

    // Tablo sütunu: Giriş zamanı bilgisi
    @FXML
    private TableColumn<Vehicle, String> entryColumn;

    // Tablo sütunu: Konum bilgisi (Kat-Blok-Slot)
    @FXML
    private TableColumn<Vehicle, String> slotColumn;

    /**
     * Ekran açıldığında çalışır.
     * Tablonun sütunları araç nesnelerindeki verilerle eşleştirilir ve veriler tabloya yüklenir.
     */
    @FXML
    private void initialize() {
        // Sütunları Vehicle sınıfındaki ilgili verilere bağla
        plateColumn.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getLicensePlate()));
        modelColumn.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getModel()));
        entryColumn.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getEntryTime()));
        slotColumn.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(
                    data.getValue().getSlotFloor() + "-" +
                    data.getValue().getSlotBlock() + "-" +
                    data.getValue().getSlotNumber()
            ));

        // Veritabanından tüm mevcut araçları al
        List<Vehicle> araclar = VehicleDAO.getAllVehicles();

        // Listeyi ObservableList'e çevir (JavaFX ile uyumlu hale getir)
        ObservableList<Vehicle> observableList = FXCollections.observableArrayList(araclar);

        // Tabloya verileri yükle
        vehicleTable.setItems(observableList);
    }
}
