package modelo;

import almacen.Almacen;
import dataBase.MetodosSQL;
import javax.swing.JOptionPane;
import utilidades.Controles;
import utilidades.Jop;
import vista.FrmGestionUsuarios;

public class Usuarios {

    private String usuario, clave;
    private int estado;
    private int productos, clientes, proveedores, facturas, compras,
            kardex, provincias, ciudades, listaVentas, listaCompras,
            gestionUsuarios, creacionUsuarios;

    public Usuarios() {
    }

    public Usuarios(String usuario, String clave, int estado, int productos, int clientes, int proveedores, int facturas, int compras, int kardex, int provincias, int ciudades, int listaVentas, int listaCompras, int gestionUsuarios, int creacionUsuarios) {
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.productos = productos;
        this.clientes = clientes;
        this.proveedores = proveedores;
        this.facturas = facturas;
        this.compras = compras;
        this.kardex = kardex;
        this.provincias = provincias;
        this.ciudades = ciudades;
        this.listaVentas = listaVentas;
        this.listaCompras = listaCompras;
        this.gestionUsuarios = gestionUsuarios;
        this.creacionUsuarios = creacionUsuarios;
    }

    public Usuarios(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
        this.estado = 0;
        this.productos = 1;
        this.clientes = 1;
        this.proveedores = 1;
        this.facturas = 1;
        this.compras = 1;
        this.kardex = 1;
        this.provincias = 1;
        this.ciudades = 1;
        this.listaVentas = 1;
        this.listaCompras = 1;
        this.gestionUsuarios = 1;
        this.creacionUsuarios = 1;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getProductos() {
        return this.productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public int getClientes() {
        return this.clientes;
    }

    public void setClientes(int clientes) {
        this.clientes = clientes;
    }

    public int getProveedores() {
        return this.proveedores;
    }

    public void setProveedores(int proveedores) {
        this.proveedores = proveedores;
    }

    public int getFacturas() {
        return this.facturas;
    }

    public void setFacturas(int facturas) {
        this.facturas = facturas;
    }

    public int getCompras() {
        return this.compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public int getKardex() {
        return this.kardex;
    }

    public void setKardex(int kardex) {
        this.kardex = kardex;
    }

    public int getProvincias() {
        return this.provincias;
    }

    public void setProvincias(int provincias) {
        this.provincias = provincias;
    }

    public int getCiudades() {
        return this.ciudades;
    }

    public void setCiudades(int ciudades) {
        this.ciudades = ciudades;
    }

    public int getListaVentas() {
        return this.listaVentas;
    }

    public void setListaVentas(int listaVentas) {
        this.listaVentas = listaVentas;
    }

    public int getListaCompras() {
        return this.listaCompras;
    }

    public void setListaCompras(int listaCompras) {
        this.listaCompras = listaCompras;
    }

    public int getGestionUsuarios() {
        return this.gestionUsuarios;
    }

    public void setGestionUsuarios(int gestionUsuarios) {
        this.gestionUsuarios = gestionUsuarios;
    }

    public int getCreacionUsuarios() {
        return this.creacionUsuarios;
    }

    public void setCreacionUsuarios(int creacionUsuarios) {
        this.creacionUsuarios = creacionUsuarios;
    }

    public boolean crearUsuario(Almacen almacen, String tfNuevoUsuario, String tfNuevaContraseña, MetodosSQL mSQL) {
        Controles c = new Controles();
        if (c.letrasSinEsp(tfNuevoUsuario) && c.letrasSinEsp(tfNuevaContraseña)) {
            int cont = 0;
            for (int i = 0; i < almacen.getlUsuarios().size(); i++) {
                cont = almacen.getlUsuarios().get(i).getUsuario().equals(tfNuevoUsuario) ? (cont + 1) : cont;
            }
            if (cont == 0) {
                if (mSQL.insertUsuario("usuarios", tfNuevoUsuario, tfNuevaContraseña)) {
                    almacen.setlUsuarios(mSQL.descargarUsuarios());
                    JOptionPane.showMessageDialog(null, "Usuario creado");
                }
            } else {
                new Jop().mensaje("El usuario ya existe");
            }
        } else {
            new Jop().mensaje("No se pueden usar caracteres especiales");
        }
        return false;
    }

    public void eliminarUsuario(Almacen almacen, MetodosSQL mSQL, String usuario) {
        if (almacen.getlUsuarios().size() == 1) {
            new Jop().mensaje("No se puede eliminar todos los usuarios");
        } else {
            mSQL.delete("usuarios", "usuario", usuario);
            new Jop().mensaje("Usuario eliminado");
            almacen.setlUsuarios(mSQL.descargarUsuarios());
        }
    }

    public void actualizarPermisos(FrmGestionUsuarios g, MetodosSQL mSQL, String usuario, Almacen almacen) {
        if (g.checkProductos.isSelected()) {
            mSQL.updateInt("usuarios", "productos", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "productos", 1, "usuario", usuario);
        }
        if (g.checkClientes.isSelected()) {
            mSQL.updateInt("usuarios", "clientes", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "clientes", 1, "usuario", usuario);
        }
        if (g.checkProveedores.isSelected()) {
            mSQL.updateInt("usuarios", "proveedores", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "proveedores", 1, "usuario", usuario);
        }
        if (g.checkFacturas.isSelected()) {
            mSQL.updateInt("usuarios", "facturas", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "facturas", 1, "usuario", usuario);
        }
        if (g.checkCompras.isSelected()) {
            mSQL.updateInt("usuarios", "compras", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "compras", 1, "usuario", usuario);
        }
        if (g.checkKardex.isSelected()) {
            mSQL.updateInt("usuarios", "kardex", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "kardex", 1, "usuario", usuario);
        }
        if (g.checkProvincia.isSelected()) {
            mSQL.updateInt("usuarios", "provincias", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "provincias", 1, "usuario", usuario);
        }
        if (g.checkCiudad.isSelected()) {
            mSQL.updateInt("usuarios", "ciudades", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "ciudades", 1, "usuario", usuario);
        }
        if (g.checklVentas.isSelected()) {
            mSQL.updateInt("usuarios", "listaVentas", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "listaVentas", 1, "usuario", usuario);
        }
        if (g.checklCompras.isSelected()) {
            mSQL.updateInt("usuarios", "listaCompras", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "listaCompras", 1, "usuario", usuario);
        }
        if (g.checkGestion.isSelected()) {
            mSQL.updateInt("usuarios", "gestionUsuarios", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "gestionUsuarios", 1, "usuario", usuario);
        }
        if (g.checkCrear.isSelected()) {
            mSQL.updateInt("usuarios", "creacionUsuarios", 0, "usuario", usuario);
        } else {
            mSQL.updateInt("usuarios", "creacionUsuarios", 1, "usuario", usuario);
        }
        new Jop().mensaje("Permisos actualizados");
        almacen.setlUsuarios(mSQL.descargarUsuarios());
    }

    public void cargarPermisos(String u, Almacen almacen, FrmGestionUsuarios g) {
        for (int i = 0; i < almacen.getlUsuarios().size(); i++) {
            if (almacen.getlUsuarios().get(i).getUsuario().equals(u)) {
                if (almacen.getlUsuarios().get(i).getProductos() == 0) {
                    g.checkProductos.setSelected(true);
                } else {
                    g.checkProductos.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getClientes() == 0) {
                    g.checkClientes.setSelected(true);
                } else {
                    g.checkClientes.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getProveedores() == 0) {
                    g.checkProveedores.setSelected(true);
                } else {
                    g.checkProveedores.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getFacturas() == 0) {
                    g.checkFacturas.setSelected(true);
                } else {
                    g.checkFacturas.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getCompras() == 0) {
                    g.checkCompras.setSelected(true);
                } else {
                    g.checkCompras.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getKardex() == 0) {
                    g.checkKardex.setSelected(true);
                } else {
                    g.checkKardex.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getProvincias() == 0) {
                    g.checkProvincia.setSelected(true);
                } else {
                    g.checkProvincia.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getCiudades() == 0) {
                    g.checkCiudad.setSelected(true);
                } else {
                    g.checkCiudad.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getListaVentas() == 0) {
                    g.checklVentas.setSelected(true);
                } else {
                    g.checklVentas.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getListaCompras() == 0) {
                    g.checklCompras.setSelected(true);
                } else {
                    g.checklCompras.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getGestionUsuarios() == 0) {
                    g.checkGestion.setSelected(true);
                } else {
                    g.checkGestion.setSelected(false);
                }
                if (almacen.getlUsuarios().get(i).getCreacionUsuarios() == 0) {
                    g.checkCrear.setSelected(true);
                } else {
                    g.checkCrear.setSelected(false);
                }
            }
        }
    }
}
