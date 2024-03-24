package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import java.time.LocalDateTime;
import utilidades.Controles;
import utilidades.Jop;

public class Venta {
    private int id, estado;
    private String ci;
    private double total;
    private LocalDateTime fecha;

    public Venta() {
    }

    public Venta(int id, String ci, double total, LocalDateTime fecha, int estado) {
        this.id = id;
        this.estado = estado;
        this.ci = ci;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId() {
        return this.id;
    }

    public int getEstado() {
        return this.estado;
    }

    public String getCi() {
        return this.ci;
    }

    public double getTotal() {
        return this.total;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }
    
    public boolean crearVenta(Almacen almacen, MetodosSQL mSQL, Cliente cliente, String total, String fecha) {
        Controles c = new Controles();
        if (cliente == null || c.vacio(fecha)){
            new Jop().mensaje("Campos VACÍOS");
        } else {
            if (c.validarFecha(fecha)) {
                if (mSQL.insertVenta(cliente.getCi(), total, fecha)) {
                    new Jop().mensaje("Venta validada");
                    return true;
                } else {
                    System.out.println("No vÁlida");
                }
            }
        }
        return false;
    }
}
