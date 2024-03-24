package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import java.sql.SQLException;
import utilidades.Controles;
import utilidades.Jop;

public class Cliente extends ModeloPadre {

    private String ci, nombre, dir, prov, ciudad;

    public Cliente() {
    }

    public Cliente(String ci, String nombre, String dir, String prov, String ciudad) {
        this.ci = ci;
        this.nombre = nombre;
        this.dir = dir;
        this.prov = prov;
        this.ciudad = ciudad;
    }

    public String getCi() {
        return ci;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public String getDir() {
        return dir;
    }

    public String getProv() {
        return prov;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    @Override
    public String toString() {
        return this.getNombre();
    }

    // Método para crear cliente
    public boolean crearCliente(Almacen almacen, MetodosSQL mSQL, String ci, String nom, String direccion, Provincia p, Ciudad ciu) {
        Controles c = new Controles();
        if (!c.vacio(ci) && !c.vacio(nom) && !c.vacio(direccion) && p != null && ciu != null) {
            if (c.validarCi(ci) && c.dosPalabras(nom) && c.tresPalabras(direccion)) {
                int cont = 0;
                if (!almacen.getlClientes().isEmpty()) {
                    for (int i = 0; i < almacen.getlClientes().size(); i++) {
                        cont = almacen.getlClientes().get(i).getCi().equals(ci) ? (cont + 1) : cont;
                    }
                }
                if (cont == 0) {
                    if (mSQL.insertCliente(ci, nom, direccion, p.getCod(), ciu.getCodigo())) {
                        new Jop().mensaje("Cliente creado");
                        almacen.setlClientes(mSQL.descargarClientes());
                        return true;
                    }
                } else {
                    new Jop().mensaje("El cliente ya existe");
                }
            }  else {
                    if (!c.validarCi(ci)) {
                        new Jop().mensaje("La cédula no es válida");
                    }
                    if (!c.dosPalabras(nom)) {
                        new Jop().mensaje("El nombre debe tener dos palabras");
                    }
                    if (!c.tresPalabras(direccion)) {
                        new Jop().mensaje("La dirección debe tener tres palabras");
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

    public boolean modificarCliente(Almacen a, MetodosSQL m, String ci, String nom, String direccion, Provincia p, Ciudad ciu) {
        Controles c = new Controles();
        if (!c.vacio(ci) && !c.vacio(nom) && !c.vacio(direccion) && p != null && ciu != null) {
            if ((c.dosPalabras(nom) && c.tresPalabras(direccion))) {
                int cont = 0;
                for (int i = 0; i < a.getlClientes().size(); i++) {
                    cont = a.getlClientes().get(i).getCi().equals(ci) ? (cont + 1) : cont;
                }

                if (cont != 0) {
                    if (m.updateString("clientes", "provincia", p.getCod(), "ci", ci) && m.updateString("clientes", "ciudad", ciu.getCodigo(), "ci", ci)) {
                        m.updateString("clientes", "nombre", nom.toUpperCase(), "ci", ci);
                        m.updateString("clientes", "direccion", direccion.toUpperCase(), "ci", ci);
                        new Jop().mensaje("Cliente modificado");
                        return true;
                    }
                } else {
                    new Jop().mensaje("-No se puede modificar un cliente que no existe\n- No se puede modificar la cedula");
                }
            } else {
                if (!c.dosPalabras(nom)) {
                    new Jop().mensaje("Ingrese solamente nombre y apellido");
                }
                if (!c.tresPalabras(direccion)) {
                    new Jop().mensaje("La dirección debe tener tres palabras");
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
}
