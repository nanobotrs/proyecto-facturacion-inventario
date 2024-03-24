package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import java.time.LocalDateTime;
import utilidades.Controles;
import utilidades.Jop;

public class Producto extends ModeloPadre {

    private String codigo;
    private String nombre;
    private String codigoProv;
    private int stock;

    public Producto(String codigo, String nombre, String codigoProv, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoProv = codigoProv;
        this.stock = stock;
    }

    public Producto() {
    }

    public int getStock() {
        return this.stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoProv() {
        return codigoProv;
    }

    public void setCodigoProv(String codigoProv) {
        this.codigoProv = codigoProv;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return this.getCodigo();
    }

    public boolean crearProducto(Almacen almacen, MetodosSQL mSQL, String cod, String nom, Proveedores p) {
        Controles c = new Controles();
        if (!c.vacio(nom) && !c.vacio(cod) && p != null) {
            if (c.carateresEspeciales(cod) && c.carateresEspeciales(nom)) {
                int cont = 0;
                if (!almacen.getlProductos().isEmpty()) {
                    for (int i = 0; i < almacen.getlProductos().size(); i++) {
                        cont = almacen.getlProductos().get(i).getCodigo().equals(cod) ? (cont + 1) : cont;
                    }
                }
                if (cont == 0) {
                    String ruc = p.getRuc();
                    if (mSQL.insertProducto("productos", cod.toUpperCase(), nom.toUpperCase(), ruc)) {
                        String fecha = new Controles().formatFechaString(LocalDateTime.now());
                        mSQL.insertDetalle(0, cod, 0, 0, 0, fecha);
                        almacen.setlProductos(mSQL.descargarProductos());
                        new Jop().mensaje("Producto creado");
                        return true;
                    }
                } else {
                    new Jop().mensaje("El producto ya existe");
                }
            } else {
                new Jop().mensaje("No se pueden usar caracteres especiales");
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }

    public boolean modificarProductos(Almacen a, MetodosSQL m, String cod, String nombre, Proveedores p) {
        Controles c = new Controles();
        if (!c.vacio(nombre) && !c.vacio(cod)) {
            if (c.carateresEspeciales(cod) && c.carateresEspeciales(nombre)) {
                int cont = 0;
                for (int i = 0; i < a.getlProductos().size(); i++) {
                    cont = a.getlProductos().get(i).getCodigo().equals(cod) ? (cont + 1) : cont;
                }

                if (cont == 0) {
                    new Jop().mensaje("-No se puede modificar un producto que no existe\n-No se puede modificar el código");
                }

                if (cont != 0) {
                    String ruc = p.getRuc();
                    m.updateString("productos", "nombre", nombre.toUpperCase(), "codigo", cod);
                    m.updateString("productos", "rucProveedor", ruc, "codigo", cod);
                    new Jop().mensaje("Producto modificado");
                    return true;
                }
            } else {
                new Jop().mensaje("No se pueden usar caracteres especiales");
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }

}
