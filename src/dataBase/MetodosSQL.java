package dataBase;

import static dataBase.ConexionBD.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.Compra;
import modelo.DetalleTransaccion;
import modelo.Producto;
import modelo.Proveedores;
import modelo.Provincia;
import modelo.Usuarios;
import modelo.Venta;
import utilidades.Alfabeto;
import utilidades.Controles;
import utilidades.Cripto;
import utilidades.Jop;

public class MetodosSQL extends ConexionBD {

    public boolean insertUsuario(String tabla, String tfNuevoUsuario, String tfNuevaClave) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, tfNuevoUsuario);
            ps.setString(2, new Cripto().encriptar(tfNuevaClave));
            ps.setInt(3, 0);
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.setInt(6, 1);
            ps.setInt(7, 1);
            ps.setInt(8, 1);
            ps.setInt(9, 1);
            ps.setInt(10, 1);
            ps.setInt(11, 1);
            ps.setInt(12, 1);
            ps.setInt(13, 1);
            ps.setInt(14, 1);
            ps.setInt(15, 1);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            new Jop().mensaje("El usuario ya existe");
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean insertProducto(String tabla, String cod, String nombre, String codProv) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO productos VALUES(?,?,?,?)");
            ps.setString(1, cod);
            ps.setString(2, new Alfabeto().cambio(nombre));
            ps.setString(3, codProv);
            ps.setString(4, "0");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean insertProveedor(String ruc, String nombre, String telefono, String direccion, String provincia, String ciudad) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO proveedores VALUES(?,?,?,?,?,?)");
            ps.setString(1, ruc);
            ps.setString(2, new Alfabeto().cambio(nombre));
            ps.setString(3, telefono);
            ps.setString(4, new Alfabeto().cambio(direccion));
            ps.setInt(5, Integer.parseInt(provincia));
            ps.setInt(6, Integer.parseInt(ciudad));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean insertCliente(String ci, String nombre, String direccion, String provincia, String ciudad) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?)");
            ps.setString(1, ci);
            ps.setString(2, new Alfabeto().cambio(nombre));
            ps.setString(3, new Alfabeto().cambio(direccion));
            ps.setInt(4, Integer.parseInt(provincia));
            ps.setInt(5, Integer.parseInt(ciudad));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean insertCompra(String ruc, String total, String fecha) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO compras VALUES(?,?,?,?)");
            ps.setString(1, ruc);
            ps.setDouble(2, Double.parseDouble(total));
            ps.setString(3, fecha);
            ps.setInt(4, 0);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean insertVenta(String ci, String total, String fecha) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO ventas VALUES(?,?,?,?)");
            ps.setString(1, ci);
            ps.setDouble(2, Double.parseDouble(total));
            ps.setString(3, fecha);
            ps.setInt(4, 0);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean insertDetalle(int id, String codProd, int cantidad, double precio, int tipo, String date) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO detalleTransaccion VALUES(?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, codProd);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precio);
            ps.setInt(5, tipo);
            ps.setString(6, date);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean insertProvincia(String nom) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO provincias VALUES(?)");
            System.out.println(new Alfabeto().cambio(nom));
            ps.setString(1, new Alfabeto().cambio(nom));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(new Alfabeto().cambio(nom));
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean insertCiudad(String nom, String codProv) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO ciudades VALUES(?,?)");
            ps.setString(1, new Alfabeto().cambio(nom));
            ps.setString(2, new Alfabeto().cambio(codProv));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void updateInt(String tabla, String columna, int cambio, String columKey, String key) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("UPDATE " + tabla + " set " + columna + "=? WHERE " + columKey + "=?");
            ps.setInt(1, cambio);
            ps.setString(2, key);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean updateString(String tabla, String columna, String cambio, String columKey, String key) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("UPDATE " + tabla + " set " + columna + "=? WHERE " + columKey + "=?");
            ps.setString(1, new Alfabeto().cambio(cambio));
            ps.setString(2, key);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete(String tabla, String columKey, String key) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("DELETE from " + tabla + " WHERE " + columKey + "=?");
            ps.setString(1, new Alfabeto().cambio(key));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            new Jop().mensaje("La propiedad seleccionada no se puede eliminar porque esta conectada a otra propiedad");
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Usuarios> descargarUsuarios() {
        ArrayList<Usuarios> lUsuario = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String usuario, clave;
        int productos, clientes, proveedores, facturas, compras,
                kardex, provincias, ciudades, listaVentas, listaCompras,
                gestionUsuarios, creacionUsuarios;
        int estado;
        try {
            ps = connection.prepareStatement("SELECT * FROM usuarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Alfabeto().devolver(rs.getString("usuario"));
                clave = new Alfabeto().devolver(rs.getString("clave"));
                estado = rs.getInt("estado");
                productos = rs.getInt("productos");
                clientes = rs.getInt("clientes");
                proveedores = rs.getInt("proveedores");
                facturas = rs.getInt("facturas");
                compras = rs.getInt("compras");
                kardex = rs.getInt("kardex");
                provincias = rs.getInt("provincias");
                ciudades = rs.getInt("ciudades");
                listaVentas = rs.getInt("listaVentas");
                listaCompras = rs.getInt("listaCompras");
                gestionUsuarios = rs.getInt("gestionUsuarios");
                creacionUsuarios = rs.getInt("creacionUsuarios");
                clave = new Cripto().desencriptar(clave);

                lUsuario.add(new Usuarios(usuario, clave, estado, productos, clientes, proveedores, facturas, compras, kardex, provincias,
                        ciudades, listaVentas, listaCompras, gestionUsuarios, creacionUsuarios));
            }
            return lUsuario;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Producto> descargarProductos() {
        ArrayList<Producto> lProductos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String codigo, nombre, codigoProv;
        int stock;
        try {
            ps = connection.prepareStatement("SELECT * FROM productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getString("codigo");
                nombre = new Alfabeto().devolver(rs.getString("nombre"));
                codigoProv = rs.getString("rucProveedor");
                stock = rs.getInt("stock");
                lProductos.add(new Producto(codigo, nombre, codigoProv, stock));
            }
            return lProductos;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Proveedores> descargarProveedores() {
        ArrayList<Proveedores> lProveedores = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String ruc, nombre, telf, direccion, provincia, ciudad;
        try {
            ps = connection.prepareStatement("SELECT * FROM proveedores");
            rs = ps.executeQuery();
            while (rs.next()) {
                ruc = rs.getString("ruc");
                nombre = new Alfabeto().devolver(rs.getString("nombre"));
                telf = rs.getString("telefono");
                direccion = new Alfabeto().devolver(rs.getString("direccion"));
                provincia = rs.getString("provincia");
                ciudad = rs.getString("ciudad");
                lProveedores.add(new Proveedores(ruc, nombre, telf, direccion, provincia, ciudad));
            }
            return lProveedores;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Compra> descargarCompras() {
        ArrayList<Compra> lCompras = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        int id, estado;
        String ruc;
        double total;
        String fechaString;
        try {
            ps = connection.prepareStatement("SELECT * FROM compras");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                ruc = rs.getString("codigoProveedor");
                fechaString = rs.getString("fecha");
                LocalDateTime fecha = new Controles().formatFecha(fechaString);
                total = rs.getDouble("total");
                estado = rs.getInt("estado");
                lCompras.add(new Compra(id, ruc, total, fecha, estado));
            }
            return lCompras;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Venta> descargarVentas() {
        ArrayList<Venta> lVentas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        int id, estado;
        String ci;
        double total;
        String fecha;
        try {
            ps = connection.prepareStatement("SELECT * FROM ventas");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                ci = rs.getString("codigoCliente");
                fecha = rs.getString("fecha");
                total = rs.getDouble("total");
                estado = rs.getInt("estado");
                lVentas.add(new Venta(id, ci, total, new Controles().formatFecha(fecha), estado));
            }
            return lVentas;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<DetalleTransaccion> descargarDetalle() {
        ArrayList<DetalleTransaccion> lDetalles = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String codigo;
        int idTransaccion, cantidad, tipo;
        double precio;
        try {
            ps = connection.prepareStatement("SELECT * FROM detalleTransaccion ORDER BY fecha ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                idTransaccion = rs.getInt("idTransaccion");
                codigo = rs.getString("codigoProducto");
                cantidad = rs.getInt("cantidad");
                precio = rs.getDouble("precio");
                tipo = rs.getInt("tipo");
                String fechaString = rs.getString("fecha");
                LocalDateTime fecha = new Controles().formatFecha(fechaString);
                lDetalles.add(new DetalleTransaccion(idTransaccion, codigo, cantidad, precio, tipo, fecha));
            }
            return lDetalles;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Cliente> descargarClientes() {
        ArrayList<Cliente> lClientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String ci, nombre, dir, prov, ciudad;
        try {
            ps = connection.prepareStatement("SELECT * FROM clientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                ci = rs.getString("ci");
                nombre = new Alfabeto().devolver(rs.getString("nombre"));
                dir = new Alfabeto().devolver(rs.getString("direccion"));
                prov = rs.getString("provincia");
                ciudad = rs.getString("ciudad");
                lClientes.add(new Cliente(ci, nombre, dir, prov, ciudad));
            }
            return lClientes;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Provincia> descargarProvincias() {
        ArrayList<Provincia> lProvincias = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String nom, cod;
        try {
            ps = connection.prepareStatement("SELECT * FROM provincias");
            rs = ps.executeQuery();
            while (rs.next()) {
                cod = rs.getString("codigoProvincia");
                nom = new Alfabeto().devolver(rs.getString("nombre"));
                lProvincias.add(new Provincia(cod, nom));
            }
            return lProvincias;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Ciudad> descargarCiudades() {
        ArrayList<Ciudad> lCiudades = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String nom, cod, codProv;
        try {
            ps = connection.prepareStatement("SELECT * FROM ciudades");
            rs = ps.executeQuery();
            while (rs.next()) {
                cod = rs.getString("codigoCiudad");
                nom = new Alfabeto().devolver(rs.getString("nombre"));
                codProv = rs.getString("codigoProvincia");
                lCiudades.add(new Ciudad(cod, nom, codProv));
            }
            return lCiudades;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int ultimoIdCompra() {
        PreparedStatement ps;
        ResultSet rs;
        int ultimoId = 0;
        try {
            ps = connection.prepareStatement("SELECT TOP 1 id FROM compras ORDER BY id DESC");
            rs = ps.executeQuery();
            while (rs.next()) {
                ultimoId = rs.getInt("id");
            }
            return ultimoId;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimoId;
    }

    public int ultimoIdVenta() {
        PreparedStatement ps;
        ResultSet rs;
        int ultimoId = 0;
        try {
            ps = connection.prepareStatement("SELECT TOP 1 id FROM ventas ORDER BY id DESC");
            rs = ps.executeQuery();
            while (rs.next()) {
                ultimoId = rs.getInt("id");
            }
            return ultimoId;
        } catch (SQLException ex) {
            new Jop().mensaje("La aplicacion se debe reiniciar, lo sentimos");
            System.exit(0);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimoId;
    }
}
