package application;

/**
 * Vehicle sınıfı, otoparka giriş yapan araçların bilgilerini temsil eder.
 * Her araç plaka, model, giriş zamanı ve bulunduğu konum bilgileri ile tanımlanır.
 */
public class Vehicle {

    // Araç plakası
    private String licensePlate;

    // Araç modeli
    private String model;

    // Araç otoparka giriş zamanı
    private String entryTime;

    // Aracın bulunduğu kat
    private String slotFloor;

    // Aracın bulunduğu blok
    private String slotBlock;

    // Aracın bulunduğu slot numarası
    private int slotNumber;

    /**
     * Constructor - Yeni bir Vehicle nesnesi oluşturur.
     *
     * @param licensePlate Araç plakası
     * @param model Araç modeli
     * @param entryTime Giriş zamanı
     * @param slotFloor Kat bilgisi
     * @param slotBlock Blok bilgisi
     * @param slotNumber Slot numarası
     */
    public Vehicle(String licensePlate, String model, String entryTime, String slotFloor, String slotBlock, int slotNumber) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.entryTime = entryTime;
        this.slotFloor = slotFloor;
        this.slotBlock = slotBlock;
        this.slotNumber = slotNumber;
    }

    // --- Getters ---

    /**
     * Aracın plakasını döndürür.
     *
     * @return Plaka bilgisi
     */
    public String getLicensePlate() { return licensePlate; }

    /**
     * Aracın modelini döndürür.
     *
     * @return Model bilgisi
     */
    public String getModel() { return model; }

    /**
     * Aracın giriş zamanını döndürür.
     *
     * @return Giriş zamanı
     */
    public String getEntryTime() { return entryTime; }

    /**
     * Aracın bulunduğu kat bilgisini döndürür.
     *
     * @return Kat bilgisi
     */
    public String getSlotFloor() { return slotFloor; }

    /**
     * Aracın bulunduğu blok bilgisini döndürür.
     *
     * @return Blok bilgisi
     */
    public String getSlotBlock() { return slotBlock; }

    /**
     * Aracın bulunduğu slot numarasını döndürür.
     *
     * @return Slot numarası
     */
    public int getSlotNumber() { return slotNumber; }

    // --- Setters ---

    /**
     * Aracın plakasını günceller.
     *
     * @param licensePlate Yeni plaka bilgisi
     */
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    /**
     * Aracın modelini günceller.
     *
     * @param model Yeni model bilgisi
     */
    public void setModel(String model) { this.model = model; }

    /**
     * Aracın giriş zamanını günceller.
     *
     * @param entryTime Yeni giriş zamanı
     */
    public void setEntryTime(String entryTime) { this.entryTime = entryTime; }

    /**
     * Aracın bulunduğu kat bilgisini günceller.
     *
     * @param slotFloor Yeni kat bilgisi
     */
    public void setSlotFloor(String slotFloor) { this.slotFloor = slotFloor; }

    /**
     * Aracın bulunduğu blok bilgisini günceller.
     *
     * @param slotBlock Yeni blok bilgisi
     */
    public void setSlotBlock(String slotBlock) { this.slotBlock = slotBlock; }

    /**
     * Aracın bulunduğu slot numarasını günceller.
     *
     * @param slotNumber Yeni slot numarası
     */
    public void setSlotNumber(int slotNumber) { this.slotNumber = slotNumber; }
}
