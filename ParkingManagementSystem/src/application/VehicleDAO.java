package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * VehicleDAO sınıfı, araç verileri üzerinde veritabanı işlemlerini yönetir.
 * Araç ekleme, silme, kontrol etme ve listeleme gibi işlevleri içerir.
 */
public class VehicleDAO {

    /**
     * Veritabanına yeni bir araç kaydeder ve slotu dolu olarak işaretler.
     *
     * @param vehicle Eklenecek Vehicle nesnesi
     */
    public static void reserveSlotAndInsertVehicle(Vehicle vehicle) {
        String insertVehicleSql = "INSERT INTO vehicle (license_plate, model, entry_time, slot_floor, slot_block, slot_number) VALUES (?, ?, ?, ?, ?, ?)";
        String updateSlotSql = "UPDATE parking_slot SET is_occupied = TRUE WHERE floor = ? AND block = ? AND slot_number = ?";

        try (Connection conn = ParkingDatabase.connect();
             PreparedStatement insertStmt = conn.prepareStatement(insertVehicleSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSlotSql)) {

            // Aracı ekle
            insertStmt.setString(1, vehicle.getLicensePlate());
            insertStmt.setString(2, vehicle.getModel());
            insertStmt.setString(3, vehicle.getEntryTime());
            insertStmt.setString(4, vehicle.getSlotFloor());
            insertStmt.setString(5, vehicle.getSlotBlock());
            insertStmt.setInt(6, vehicle.getSlotNumber());
            insertStmt.executeUpdate();

            // Slot'u dolu yap
            updateStmt.setString(1, vehicle.getSlotFloor());
            updateStmt.setString(2, vehicle.getSlotBlock());
            updateStmt.setInt(3, vehicle.getSlotNumber());
            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Veritabanından bir aracı siler, geçmişe kaydeder ve slotu boşaltır.
     *
     * @param licensePlate Çıkış yapacak aracın plakası
     * @param exitTime Çıkış zamanı
     */
    public static void exitVehicle(String licensePlate, String exitTime) {
        String selectSql = "SELECT * FROM vehicle WHERE license_plate = ?";
        String insertHistorySql = "INSERT INTO movement_history (license_plate, entry_time, exit_time) VALUES (?, ?, ?)";
        String deleteSql = "DELETE FROM vehicle WHERE license_plate = ?";
        String updateSlotSql = "UPDATE parking_slot SET is_occupied = FALSE WHERE floor = ? AND block = ? AND slot_number = ?";

        try (Connection conn = ParkingDatabase.connect();
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement insertStmt = conn.prepareStatement(insertHistorySql);
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
             PreparedStatement updateSlotStmt = conn.prepareStatement(updateSlotSql)) {

            // Araç bilgilerini veritabanından çek
            selectStmt.setString(1, licensePlate);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                String entryTime = rs.getString("entry_time");
                String floor = rs.getString("slot_floor");
                String block = rs.getString("slot_block");
                int slotNumber = rs.getInt("slot_number");

                // Geçmiş tablosuna giriş-çıkış kaydını ekle
                insertStmt.setString(1, licensePlate);
                insertStmt.setString(2, entryTime);
                insertStmt.setString(3, exitTime);
                insertStmt.executeUpdate();

                // Aracı vehicle tablosundan sil
                deleteStmt.setString(1, licensePlate);
                deleteStmt.executeUpdate();

                // Slotu boşalt (is_occupied = FALSE)
                updateSlotStmt.setString(1, floor);
                updateSlotStmt.setString(2, block);
                updateSlotStmt.setInt(3, slotNumber);
                updateSlotStmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verilen plakaya sahip bir araç veritabanında var mı diye kontrol eder.
     *
     * @param plate Kontrol edilecek plaka
     * @return true → araç var, false → araç yok
     */
    public static boolean exists(String plate) {
        String sql = "SELECT 1 FROM vehicle WHERE license_plate = ?";
        try (Connection conn = ParkingDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plate);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // kayıt varsa true döner
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Veritabanındaki tüm araçları liste olarak döndürür.
     *
     * @return List<Vehicle> mevcut tüm araçlar
     */
    public static List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicle";

        try (Connection conn = ParkingDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Tüm araç kayıtlarını listeye ekle
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("license_plate"),
                        rs.getString("model"),
                        rs.getString("entry_time"),
                        rs.getString("slot_floor"),
                        rs.getString("slot_block"),
                        rs.getInt("slot_number")
                );
                vehicles.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }
}
