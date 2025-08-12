package application;

import java.sql.*;
import java.util.TreeMap;

/**
 * ParkingSlotDAO sınıfı, veritabanındaki parking_slot tablosundan verileri çeker.
 * Otoparkın yapısını (kat, blok, slot) hiyerarşik şekilde TreeMap yapısında organize eder.
 */
public class ParkingSlotDAO {

    /**
     * Veritabanından tüm slot bilgilerini yükler ve TreeMap yapısında organize eder.
     * Yapı: Floor -> Block -> SlotNumber -> ParkingSlot
     *
     * @return Otopark yapısını temsil eden TreeMap
     */
    public static TreeMap<String, TreeMap<String, TreeMap<Integer, ParkingSlot>>> loadParkingStructure() {
        // Kat, blok ve slot bazlı hiyerarşik yapı oluşturuluyor
        TreeMap<String, TreeMap<String, TreeMap<Integer, ParkingSlot>>> structure = new TreeMap<>();

        // SQL sorgusu: Tüm slot kayıtlarını getir
        String sql = "SELECT * FROM parking_slot";

        // Veritabanı bağlantısı ve veri çekme işlemleri
        try (Connection conn = ParkingDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Sonuç kümesindeki her slot için
            while (rs.next()) {
                // Slot bilgilerini oku
                String floor = rs.getString("floor");     // Kat bilgisi
                String block = rs.getString("block");     // Blok bilgisi
                int slotNumber = rs.getInt("slot_number"); // Slot numarası
                boolean isOccupied = rs.getBoolean("is_occupied"); // Doluluk durumu

                // ParkingSlot nesnesi oluştur
                ParkingSlot slot = new ParkingSlot(floor, block, slotNumber);
                slot.setOccupied(isOccupied);

                // Kat (floor) düzeyinde TreeMap oluştur veya var olanı kullan
                TreeMap<String, TreeMap<Integer, ParkingSlot>> floorMap =
                        structure.computeIfAbsent(floor, unused -> new TreeMap<>());

                // Blok (block) düzeyinde TreeMap oluştur veya var olanı kullan
                TreeMap<Integer, ParkingSlot> blockMap =
                        floorMap.computeIfAbsent(block, unused -> new TreeMap<>());

                // Slot'u ilgili blok altına ekle
                blockMap.put(slotNumber, slot);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Hata olursa logla
        }

        // Yapıyı geri döndür
        return structure;
    }
}
