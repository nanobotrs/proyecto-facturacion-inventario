package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import utilidades.Controles;
import utilidades.Jop;

public class Ciudad extends ModeloPadre {

    private String codigo, nombre, codProvincia;

    public Ciudad() {
    }

    public Ciudad(String codigo, String nombre, String codProvincia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codProvincia = codProvincia;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodProvincia() {
        return this.codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public boolean crearCiudad(Almacen almacen, MetodosSQL mSQL, String nom, Provincia p) {
        Controles c = new Controles();
        if (!c.vacio(nom) && p != null) {
            if (c.carateresEspeciales(nom)) {
                String codigoProvincia = p.getCod();
                if (mSQL.insertCiudad(nom, codigoProvincia)) {
                    almacen.setlCiudades(mSQL.descargarCiudades());
                    new Jop().mensaje("Ciudad creada");
                    return true;
                }
            } else {
                new Jop().mensaje("No se permiten caracteres especiales");
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }

    public boolean modificarCiudad(Almacen almacen, MetodosSQL mSQL, String cod, String nom, Provincia p) {
        Controles c = new Controles();
        if (!c.vacio(nom) && p != null) {
            if (c.carateresEspeciales(nom)) {
                int cont = 0;
                for (int i = 0; i < almacen.getlCiudades().size(); i++) {
                    cont = almacen.getlCiudades().get(i).getCodigo().equals(cod) ? (cont + 1) : cont;
                }

                if (cont != 0) {
                    if (c.letrasEsp(nom)) {
                        String nuevoCodigo = p.getCod();
                        mSQL.updateString("ciudades", "nombre", nom, "codigoCiudad", cod);
                        mSQL.updateString("ciudades", "codigoProvincia", nuevoCodigo, "codigoCiudad", cod);
                        almacen.setlCiudades(mSQL.descargarCiudades());
                        new Jop().mensaje("Ciudad modificada");
                        return true;
                    }
                } else {
                    new Jop().mensaje("-No se puede modificar una ciudad que no existe");
                }
            } else {
                new Jop().mensaje("No se permiten caracteres especiales");
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }
}
