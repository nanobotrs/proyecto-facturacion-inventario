package almacen;

import java.util.ArrayList;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.Compra;
import modelo.DetalleTransaccion;
import modelo.Producto;
import modelo.Proveedores;
import modelo.Provincia;
import modelo.Usuarios;
import modelo.Venta;

public class Almacen {

    private ArrayList<Usuarios> lUsuarios = new ArrayList<>();
    private ArrayList<Producto> lProductos = new ArrayList<>();
    private ArrayList<Proveedores> lProveedores = new ArrayList<>();
    private ArrayList<Provincia> lProvincias = new ArrayList<>();
    private ArrayList<Ciudad> lCiudades = new ArrayList<>();
    private ArrayList<Cliente> lClientes = new ArrayList<>();
    private ArrayList<Compra> lCompras = new ArrayList<>();
    private ArrayList<Venta> lVentas = new ArrayList<>();
    private ArrayList<DetalleTransaccion> lDetalle = new ArrayList<>();
    
    public ArrayList<Usuarios> getlUsuarios() {
        return this.lUsuarios;
    }

    public void setlUsuarios(ArrayList<Usuarios> lUsuarios) {
        this.lUsuarios = lUsuarios;
    }

    public void agregarUsuario(Usuarios u) {
        this.getlUsuarios().add(u);
    }

    public ArrayList<Producto> getlProductos() {
        return this.lProductos;
    }

    public void setlProductos(ArrayList<Producto> lProductos) {
        this.lProductos = lProductos;
    }

    public void agregarProducto(Producto p) {
        this.getlProductos().add(p);
    }

    public ArrayList<Proveedores> getlProveedores() {
        return this.lProveedores;
    }

    public void setlProveedores(ArrayList<Proveedores> lProveedores) {
        this.lProveedores = lProveedores;
    }

    public void agregarProveedor(Proveedores p) {
        this.getlProveedores().add(p);
    }

    public ArrayList<Provincia> getlProvincias() {
        return this.lProvincias;
    }

    public void setlProvincias(ArrayList<Provincia> lProvincias) {
        this.lProvincias = lProvincias;
    }

    public void agregarProvincia(Provincia p) {
        this.getlProvincias().add(p);
    }

    public ArrayList<Ciudad> getlCiudades() {
        return this.lCiudades;
    }

    public void setlCiudades(ArrayList<Ciudad> lCiudades) {
        this.lCiudades = lCiudades;
    }
    
    public void agregarCiudad(Ciudad p) {
        this.getlCiudades().add(p);
    }

    public ArrayList<Cliente> getlClientes() {
        return this.lClientes;
    }

    public void setlClientes(ArrayList<Cliente> lCliente) {
        this.lClientes = lCliente;
    }
    
    public void agregarCliente(Cliente c) {
        this.getlClientes().add(c);
    }

    public ArrayList<Compra> getlCompras() {
        return this.lCompras;
    }

    public void setlCompras(ArrayList<Compra> lCompras) {
        this.lCompras = lCompras;
    }
    
    public void agregarCompras(Compra c) {
        this.getlCompras().add(c);
    }

    public ArrayList<DetalleTransaccion> getlDetalle() {
        return this.lDetalle;
    }

    public void setlDetalle(ArrayList<DetalleTransaccion> lDetalle) {
        this.lDetalle = lDetalle;
    }
    
    public void agregarDetalle(DetalleTransaccion c) {
        this.getlDetalle().add(c);
    }

    public ArrayList<Venta> getlVentas() {
        return this.lVentas;
    }

    public void setlVentas(ArrayList<Venta> lVentas) {
        this.lVentas = lVentas;
    }
    
    public void agregarVenta(Venta c) {
        this.getlVentas().add(c);
    }
    
}
