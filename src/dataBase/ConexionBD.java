package dataBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Jop;

public class ConexionBD {

    protected final String jdbcUrl = "jdbc:sqlserver://nano-server.database.windows.net:1433;database=ProyectoFinal;user=CloudSAb6453eac@nano-server;password=Kona2019;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    protected static Connection connection = null;

    public ConexionBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        }
    }

    public boolean getConnection() {
        if (connection == null && ConexionBD.netIsAvailable()) {
            try {
                connection = DriverManager.getConnection(jdbcUrl);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            new Jop().mensaje("Error al conectar con el servidor, revise su conexion a internet e inténtelo de nuevo.");
            return false;
        }
    }
}
