package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import utilidades.Controles;
import utilidades.Jop;

public class Provincia extends ModeloPadre {

    private String cod, nombre;

    public Provincia() {
    }

    public Provincia(String cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public String getCod() {
        return this.cod;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public boolean crearProvincia(Almacen almacen, MetodosSQL mSQL, String nom) {
        Controles c = new Controles();
        if (!c.vacio(nom)) {
            if (c.carateresEspeciales(nom)) {
                if (mSQL.insertProvincia(nom)) {
                    almacen.setlProvincias(mSQL.descargarProvincias());
                    new Jop().mensaje("Provincia creada");
                    return true;
                }

            } else {
                new Jop().mensaje("Solo ingrese letras");
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }

    public boolean modificarProvincia(Almacen almacen, MetodosSQL mSQL, String cod, String nom) {
        Controles c = new Controles();
        if (!c.vacio(nom)) {
            if (c.carateresEspeciales(nom)) {
                int cont = 0;
                for (int i = 0; i < almacen.getlProvincias().size(); i++) {
                    cont = almacen.getlProvincias().get(i).getCod().equals(cod) ? (cont + 1) : cont;
                }

                if (cont != 0) {
                    if (c.letrasEsp(nom)) {
                        mSQL.updateString("provincias", "nombre", nom, "codigoProvincia", cod);
                        almacen.setlProvincias(mSQL.descargarProvincias());
                        new Jop().mensaje("Provincia modificado");
                        return true;
                    }
                } else {
                    new Jop().mensaje("La provincia no existe");
                }
            } else {
                new Jop().mensaje("No ingrese caracteres especiales");
            }
        } else {
            new Jop().mensaje("Campos vaciós");
        }
        return false;
    }

}
