package application;

import java.util.HashMap;
import java.util.Map;

/**
 * VehicleCache sınıfı, araç bilgilerini bellek içi bir HashMap yapısında saklar.
 * Bu sayede araçlara plaka ile hızlı erişim sağlanır.
 */
public class VehicleCache {

    // Plakaya göre araçları tutan HashMap (Anahtar: Plaka, Değer: Vehicle nesnesi)
    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    /**
     * Veritabanındaki tüm araçları çekip HashMap'e yükler.
     * Böylece plaka ile hızlı arama yapılabilir.
     */
    public void loadVehiclesFromDatabase() {
        for (Vehicle v : VehicleDAO.getAllVehicles()) {
            vehicleMap.put(v.getLicensePlate(), v);
        }
        System.out.println("Tüm araçlar HashMap'e yüklendi.");
    }

    /**
     * Verilen plakaya göre aracı bulur.
     *
     * @param licensePlate Sorgulanacak plaka
     * @return Bulunan Vehicle nesnesi, yoksa null döner
     */
    public Vehicle findByPlate(String licensePlate) {
        return vehicleMap.get(licensePlate);
    }

    /**
     * Plakaya göre aracı bulur ve konsola bilgilerini yazdırır.
     *
     * @param licensePlate Yazdırılacak aracın plakası
     */
    public void printVehicle(String licensePlate) {
        Vehicle v = findByPlate(licensePlate);
        if (v != null) {
            System.out.println("Araç bulundu: " + v.getLicensePlate() + " - " + v.getModel() +
                               " - Slot: " + v.getSlotFloor() + "-" + v.getSlotBlock() + "-" + v.getSlotNumber());
        } else {
            System.out.println("Araç bulunamadı.");
        }
    }
}
