package application;

/**
 * ParkingSlot sınıfı, otoparktaki bir park alanını temsil eder.
 * Her slot kat, blok ve slot numarası ile tanımlanır ve dolu/boş durumu saklanır.
 */
public class ParkingSlot {

    // Slotun bulunduğu kat (örnek: A, B, C)
    private String floor;

    // Slotun bulunduğu blok (örnek: A, B, C)
    private String block;

    // Slot numarası (örnek: 1, 2, 3)
    private int slotNumber;

    // Slotun dolu mu boş mu olduğunu belirten bayrak
    private boolean isOccupied;

    /**
     * Constructor - Yeni bir ParkingSlot nesnesi oluşturur.
     * Başlangıçta slot boş kabul edilir (isOccupied = false).
     *
     * @param floor Kat bilgisi
     * @param block Blok bilgisi
     * @param slotNumber Slot numarası
     */
    public ParkingSlot(String floor, String block, int slotNumber) {
        this.floor = floor;
        this.block = block;
        this.slotNumber = slotNumber;
        this.isOccupied = false; // Başlangıçta slot boş kabul edilir
    }

    // --- Getters ---

    /**
     * Slotun bulunduğu katı döndürür.
     *
     * @return Kat bilgisi
     */
    public String getFloor() { return floor; }

    /**
     * Slotun bulunduğu bloğu döndürür.
     *
     * @return Blok bilgisi
     */
    public String getBlock() { return block; }

    /**
     * Slotun numarasını döndürür.
     *
     * @return Slot numarası
     */
    public int getSlotNumber() { return slotNumber; }

    /**
     * Slotun dolu mu boş mu olduğunu döndürür.
     *
     * @return true → dolu, false → boş
     */
    public boolean isOccupied() { return isOccupied; }

    // --- Setters ---

    /**
     * Slotun doluluk durumunu günceller.
     *
     * @param occupied true → dolu, false → boş
     */
    public void setOccupied(boolean occupied) { isOccupied = occupied; }
}
