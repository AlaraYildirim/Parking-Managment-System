package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.LinkedList;

/**
 * GecmisController sınıfı araçların geçmiş giriş-çıkış kayıtlarını gösterir.
 * Kullanıcı, hareket geçmişini bir tablo (TableView) üzerinden görüntüleyebilir.
 */
public class GecmisController {

    // Araç geçmişi verilerinin gösterileceği tablo
    @FXML
    private TableView<MovementRecord> historyTable;

    // Tablo sütunu: Plaka
    @FXML
    private TableColumn<MovementRecord, String> plateColumn;

    // Tablo sütunu: Giriş zamanı
    @FXML
    private TableColumn<MovementRecord, String> entryColumn;

    // Tablo sütunu: Çıkış zamanı
    @FXML
    private TableColumn<MovementRecord, String> exitColumn;

    /**
     * Ekran ilk açıldığında çalışır.
     * Sütunlarla verileri eşleştirir ve geçmiş kayıtları tabloya yükler.
     */
    @FXML
    private void initialize() {
        // Her sütunu ilgili MovementRecord verisiyle eşleştir
        plateColumn.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getLicensePlate()));
        entryColumn.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getEntryTime()));
        exitColumn.setCellValueFactory(data -> 
            new javafx.beans.property.SimpleStringProperty(data.getValue().getExitTime()));

        // Veritabanından tüm hareket geçmişini getir
        LinkedList<MovementRecord> history = MovementHistoryDAO.getAllHistory();

        // LinkedList'i ObservableList'e çevir (JavaFX için)
        ObservableList<MovementRecord> observableList = FXCollections.observableArrayList(history);

        // Tabloya verileri yükle
        historyTable.setItems(observableList);
    }
}
