package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TimeUtil sınıfı, tarih ve saat işlemleri için yardımcı fonksiyonlar sağlar.
 * Şu anki zamanı belirli bir formatta String olarak döndürür.
 */
public class TimeUtil {

    // Tarih ve saat biçimlendiricisi (yyyy-MM-dd HH:mm:ss)
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Şu anki tarih ve saati belirlenen formatta String olarak döndürür.
     *
     * @return Şu anki zaman (örnek: "2025-04-27 22:15:30")
     */
    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
