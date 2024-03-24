package main;

import almacen.Almacen;
import dataBase.MetodosSQL;
import vista.FrmLogin;

public class Main {

    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        MetodosSQL mSQL = new MetodosSQL();
        if (mSQL.getConnection()) {
            almacen.setlUsuarios(mSQL.descargarUsuarios());
            FrmLogin frmLogin = new FrmLogin(almacen, mSQL);
            almacen.setlProductos(mSQL.descargarProductos());
            almacen.setlProveedores(mSQL.descargarProveedores());
            almacen.setlProvincias(mSQL.descargarProvincias());
            almacen.setlCiudades(mSQL.descargarCiudades());
            almacen.setlClientes(mSQL.descargarClientes());
            almacen.setlCompras(mSQL.descargarCompras());
            almacen.setlDetalle(mSQL.descargarDetalle());
        }
    }
}
