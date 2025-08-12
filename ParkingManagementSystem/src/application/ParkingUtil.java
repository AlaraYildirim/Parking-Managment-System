package application;

import java.util.TreeMap;

/**
 * ParkingUtil sınıfı, otopark işlemleri için yardımcı (utility) metotlar içerir.
 * Slot arama gibi sık kullanılan fonksiyonlar burada toplanır.
 */
public class ParkingUtil {

    /**
     * Otopark yapısında ilk boş (dolu olmayan) slotu bulur.
     * Yapı: Floor -> Block -> SlotNumber -> ParkingSlot
     *
     * @param structure Kat, blok ve slot yapısında organize edilmiş TreeMap
     * @return Boş bir ParkingSlot nesnesi, eğer bulunamazsa null döner
     */
    public static ParkingSlot findFirstAvailableSlot(TreeMap<String, TreeMap<String, TreeMap<Integer, ParkingSlot>>> structure) {
        // Katlar arasında gez
        for (var floorEntry : structure.entrySet()) {
            // Her katta bloklar arasında gez
            for (var blockEntry : floorEntry.getValue().entrySet()) {
                // Her blokta slotlar arasında gez
                for (var slotEntry : blockEntry.getValue().entrySet()) {
                    ParkingSlot slot = slotEntry.getValue();
                    // Eğer slot boşsa (isOccupied = false)
                    if (!slot.isOccupied()) {
                        return slot; // İlk boş slotu döndür
                    }
                }
            }
        }
        // Eğer hiç boş slot bulunamadıysa
        return null;
    }
}
