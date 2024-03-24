package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import utilidades.Controles;
import utilidades.Jop;

public class Proveedores extends ModeloPadre {

    private String ruc, nombre, telf, direccion, provincia, ciudad;

    // Constructor
    public Proveedores() {
    }

    // Constructor sobrecragado
    public Proveedores(String ruc, String nombre, String telf, String direccion, String provincia, String ciudad) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.telf = telf;
        this.direccion = direccion;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }

    // Getters
    public String getRuc() {
        return this.ruc;
    }

    // Metodo heredado de clase abstracta
    @Override
    public String getNombre() {
        return this.nombre;
    }

    public String getTelf() {
        return this.telf;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    // Metodo que controla crear proveedor
    public boolean crearProveedor(Almacen almacen, MetodosSQL mSQL, String ruc, String nom, String telf, String direccion, Provincia p, Ciudad ciu) {
        Controles c = new Controles();
        if (!c.vacio(ruc) && !c.vacio(nom) && !c.vacio(telf) && !c.vacio(direccion) && p != null && ciu != null) {
            if (c.validarRUC(ruc) && c.almenosDos(nom) && c.dosPalabras(direccion) && c.diezDigitos(telf)) {
                int cont = 0;
                if (!almacen.getlProveedores().isEmpty()) {
                    for (int i = 0; i < almacen.getlProveedores().size(); i++) {
                        cont = almacen.getlProveedores().get(i).getRuc().equals(ruc) ? (cont + 1) : cont;
                    }
                }
                if (cont == 0) {
                    String aProvincia = p.getCod();
                    String aCiudad = ciu.getCodigo();
                    if (mSQL.insertProveedor(ruc, nom, telf, direccion, aProvincia, aCiudad)) {
                        new Jop().mensaje("Proveedor creado");
                        almacen.setlProveedores(mSQL.descargarProveedores());
                        return true;
                    }
                }

                if (cont != 0) {
                    new Jop().mensaje("El proveedor ya existe");
                }
            } else {
                if (!c.diezDigitos(telf)) {
                    new Jop().mensaje("El número debe tener 10 dígitos");
                }
                if (!c.validarRUC(ruc)) {
                    new Jop().mensaje("El RUC no es válido");
                }
                if (!c.almenosDos(nom)) {
                    System.out.println(c.dosPalabras(nom));
                    System.out.println(nom);
                    new Jop().mensaje("El nombre debe tener al menos dos palabras");
                }
                if (!c.dosPalabras(direccion)) {
                    new Jop().mensaje("La dirección debe tener dos palabras");
                }
                if (!c.carateresEspeciales(nom) || !c.carateresEspeciales(direccion)) {
                    new Jop().mensaje("No se pueden usar caracteres especiales");
                }
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }

    // Metodo que controla modificar proveedor
    public boolean modificarProveedor(Almacen a, MetodosSQL m, String ruc, String nom, String telf, String direccion, Provincia p, Ciudad ciu) {
        Controles c = new Controles();
        if (!c.vacio(ruc) && !c.vacio(nom) && !c.vacio(telf) && !c.vacio(direccion) && p != null && ciu != null) {
            if ((c.almenosDos(nom) && c.dosPalabras(direccion)) && c.diezDigitos(telf)) {
                int cont = 0;
                for (int i = 0; i < a.getlProveedores().size(); i++) {
                    cont = a.getlProveedores().get(i).getRuc().equals(ruc) ? (cont + 1) : cont;
                }

                if (cont != 0) {
                    if (m.updateString("proveedores", "provincia", p.getCod(), "ruc", ruc) && m.updateString("proveedores", "ciudad", ciu.getCodigo(), "ruc", ruc)) {
                        m.updateString("proveedores", "nombre", nom.toUpperCase(), "ruc", ruc);
                        m.updateString("proveedores", "telefono", telf, "ruc", ruc);
                        m.updateString("proveedores", "direccion", direccion.toUpperCase(), "ruc", ruc);
                        new Jop().mensaje("Proveedor modificado");
                        return true;
                    }
                }
                if (cont == 0) {
                    new Jop().mensaje("-No se puede modificar un proveedor que no existe\n- No se puede modificar el RUC");
                }
            } else {
                if (!c.diezDigitos(telf)) {
                    new Jop().mensaje("El número debe tener 10 dígitos");
                }
                if (!c.almenosDos(nom)) {
                    new Jop().mensaje("El nombre debe tener al menos dos palabras");
                }
                if (!c.dosPalabras(direccion)) {
                    new Jop().mensaje("La dirección debe tener dos palabras");
                }
                if (!c.carateresEspeciales(nom) || !c.carateresEspeciales(direccion)) {
                    new Jop().mensaje("No se pueden usar caracteres especiales");
                }
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }

    // Metodo para eliminar proveedor
    public void eliminarProveedor(Almacen a, MetodosSQL m, String ruc) {
        if (verificarProducto(a, ruc)) {
            new Jop().mensaje("No se puede elimiar el proveedor porque uno o varios productos están conectados");
        } else {
            m.delete("proveedores", "ruc", ruc);
            new Jop().mensaje("Eliminado");
            a.setlProveedores(m.descargarProveedores());
        }
    }

    // Metodo para verficar si un proveedor tiene un proveedor conectado
    public boolean verificarProducto(Almacen a, String ruc) {
        boolean b = false;
        for (int i = 0; i < a.getlProductos().size(); i++) {
            if (a.getlProductos().get(i).getCodigoProv().equals(ruc)) {
                b = true;
            }
        }
        return b;
    }
}
