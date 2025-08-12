package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ParkingDatabase sınıfı, veritabanı bağlantısını yönetir.
 * MySQL veritabanına bağlanmak için gerekli bağlantı ayarlarını içerir.
 */
public class ParkingDatabase {

    // Veritabanı bağlantı URL'si (localhost üzerinde parking_system veritabanı)
    private static final String URL = "jdbc:mysql://localhost:3306/parking_system";

    // Veritabanı kullanıcı adı
    private static final String USER = "root";

    // Veritabanı kullanıcı şifresi
    private static final String PASSWORD = "a7E9n7oVr0u7^WP";

    /**
     * Veritabanı bağlantısı sağlar.
     *
     * @return Connection Veritabanı bağlantı nesnesi
     * @throws SQLException Bağlantı sırasında bir hata oluşursa fırlatılır
     */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
