package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import java.time.LocalDateTime;
import utilidades.Controles;
import utilidades.Jop;

public class Compra {

    private int id, estado;
    private String rucProveedor;
    private double total;
    private LocalDateTime fecha;

    public Compra() {
    }

    public Compra(int id, String rucProveedor, double total, LocalDateTime fecha, int estado) {
        this.id = id;
        this.rucProveedor = rucProveedor;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return this.id;
    }

    public String getRucProveedor() {
        return this.rucProveedor;
    }

    public double getTotal() {
        return this.total;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean crearCompra(Almacen almacen, MetodosSQL mSQL, Proveedores proveedor, String total, String fecha){
        Controles c = new Controles();
        if (proveedor == null || c.vacio(fecha)) {
            new Jop().mensaje("Campos vacíos");
        } else {
            if (c.validarFecha(fecha)) {
                if (mSQL.insertCompra(proveedor.getRuc(), total, fecha)) {
                    new Jop().mensaje("Compra validada");
                    return true;
                }
            }
        }
        return false;
    }
}
