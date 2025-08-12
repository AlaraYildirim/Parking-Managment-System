package application;

import java.sql.*;
import java.util.LinkedList;

/**
 * MovementHistoryDAO sınıfı, hareket geçmişi (movement_history tablosu) üzerinde işlemler yapar.
 * Geçmişe ait araç giriş-çıkış kayıtlarını veritabanından çeker.
 */
public class MovementHistoryDAO {

    /**
     * Tüm hareket geçmişini veritabanından çeker ve LinkedList olarak döndürür.
     * Kayıtlar giriş zamanına (entry_time) göre artan sırayla listelenir (FIFO mantığı).
     *
     * @return LinkedList<MovementRecord> geçmiş kayıtların listesi
     */
    public static LinkedList<MovementRecord> getAllHistory() {
        // Geçmiş kayıtları tutacak liste
        LinkedList<MovementRecord> historyList = new LinkedList<>();

        // SQL sorgusu: tüm kayıtları giriş zamanına göre sırala
        String sql = "SELECT * FROM movement_history ORDER BY entry_time ASC";

        // Veritabanı bağlantısı ve sorgu işlemleri
        try (Connection conn = ParkingDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Sonuç kümesindeki her kayıt için
            while (rs.next()) {
                String plate = rs.getString("license_plate"); // Plaka bilgisi
                String entry = rs.getString("entry_time");    // Giriş zamanı
                String exit = rs.getString("exit_time");      // Çıkış zamanı

                // Yeni bir hareket kaydı oluştur
                MovementRecord record = new MovementRecord(plate, entry, exit);

                // Listeye ekle (FIFO sırası korunur)
                historyList.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Hata durumunda konsola yaz
        }

        // Hazırlanan geçmiş listesini döndür
        return historyList;
    }
}
