package application;

/**
 * MovementRecord sınıfı, bir aracın otoparka giriş ve çıkış bilgilerini temsil eder.
 * Geçmiş kayıtlarını (movement_history) tutmak için kullanılır.
 */
public class MovementRecord {

    // Araç plakası
    private String licensePlate;

    // Giriş zamanı
    private String entryTime;

    // Çıkış zamanı
    private String exitTime;

    /**
     * Constructor - Yeni bir MovementRecord nesnesi oluşturur.
     *
     * @param licensePlate Aracın plaka numarası
     * @param entryTime    Aracın otoparka giriş zamanı
     * @param exitTime     Aracın otoparktan çıkış zamanı
     */
    public MovementRecord(String licensePlate, String entryTime, String exitTime) {
        this.licensePlate = licensePlate;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    /**
     * Aracın plakasını döndürür.
     *
     * @return Plaka bilgisi
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Aracın giriş zamanını döndürür.
     *
     * @return Giriş zamanı
     */
    public String getEntryTime() {
        return entryTime;
    }

    /**
     * Aracın çıkış zamanını döndürür.
     *
     * @return Çıkış zamanı
     */
    public String getExitTime() {
        return exitTime;
    }

    /**
     * Aracın çıkış zamanını günceller.
     *
     * @param exitTime Yeni çıkış zamanı
     */
    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
}
