package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import java.time.LocalDateTime;

public class DetalleTransaccion {

    private int idTransaccion;
    private String codigoProd;
    private int cantidad;
    private double precio;
    private int tipo;
    private LocalDateTime fecha;

    public DetalleTransaccion() {
    }

    public DetalleTransaccion(int idTransaccion, String cod, int cantidad, double precio, 
            int tipo, LocalDateTime fecha) {
        this.idTransaccion = idTransaccion;
        this.codigoProd = cod;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public int getIdTransaccion() {
        return this.idTransaccion;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getTipo() {
        return this.tipo;
    }

    public String getCodigoProd() {
        return this.codigoProd;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public boolean crearDetalle(Almacen a, MetodosSQL mSQL, int id, String cod, int cantidad, double precio, int tipo, String fecha) {
        return mSQL.insertDetalle(id, cod, cantidad, precio, tipo, fecha);
    }
}
