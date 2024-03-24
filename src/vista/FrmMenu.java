package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;

public class FrmMenu extends Frm {
    
    private final FrmGestionUsuarios frmGestionUsuarios = new FrmGestionUsuarios(this.almacen, this.mSQL);
    private final FrmNuevoUsuario frmNuevoUsuario = new FrmNuevoUsuario(this.almacen, this.mSQL);
    private final FrmProductos frmProductos = new FrmProductos(this.almacen, this.mSQL);
    private final FrmProveedores frmProveedores = new FrmProveedores(this.almacen, this.mSQL);
    private final FrmProvincias frmProvincias = new FrmProvincias(this.almacen, this.mSQL);
    private final FrmCiudades frmCiudades = new FrmCiudades(this.almacen, this.mSQL);
    private final FrmClientes frmClientes = new FrmClientes(this.almacen, this.mSQL);
    private final FrmCompra frmCompra = new FrmCompra(this.almacen, this.mSQL);
    private final FrmVenta frmVenta = new FrmVenta(this.almacen, this.mSQL);
    private final FrmListaCompras frmlFacturasC = new FrmListaCompras(this.almacen, this.mSQL);
    private final FrmListaVentas frmlFacturasV = new FrmListaVentas(this.almacen, this.mSQL);
    private final FrmKardex frmKardex = new FrmKardex(this.almacen, this.mSQL);

    /**
     * Creates new form FrmMenu
     *
     * @param almacen
     * @param mSQL
     */
    public FrmMenu(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    private FrmMenu() {
    }
    
    public FrmGestionUsuarios getFrmGestionUsuarios() {
        return this.frmGestionUsuarios;
    }
    
    public FrmNuevoUsuario getFrmNuevoUsuario() {
        return this.frmNuevoUsuario;
    }
    
    public FrmProductos getFrmProductos() {
        return this.frmProductos;
    }
    
    public FrmProveedores getFrmProveedores() {
        return this.frmProveedores;
    }
    
    public FrmProvincias getFrmProvincias() {
        return this.frmProvincias;
    }
    
    public FrmCiudades getFrmCiudades() {
        return this.frmCiudades;
    }
    
    public FrmClientes getFrmClientes() {
        return this.frmClientes;
    }
    
    public FrmCompra getFrmCompra() {
        return this.frmCompra;
    }
    
    public FrmListaCompras getFrmlFacturas() {
        return this.frmlFacturasC;
    }
    
    public FrmVenta getFrmVenta() {
        return this.frmVenta;
    }
    
    public FrmListaVentas getFrmlFacturasV() {
        return this.frmlFacturasV;
    }
    
    public FrmKardex getFrmKardex() {
        return this.frmKardex;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dpMenu = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        opProductos = new javax.swing.JMenuItem();
        opClientes = new javax.swing.JMenuItem();
        opProveedores = new javax.swing.JMenuItem();
        opCompras = new javax.swing.JMenuItem();
        oplCompras = new javax.swing.JMenuItem();
        opFacturas = new javax.swing.JMenuItem();
        oplVentas = new javax.swing.JMenuItem();
        opKardex = new javax.swing.JMenuItem();
        opProvincias = new javax.swing.JMenuItem();
        opCiudades = new javax.swing.JMenuItem();
        opGestionU = new javax.swing.JMenuItem();
        opNuevoUsuario = new javax.swing.JMenuItem();
        opSalir = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        dpMenu.setBackground(new java.awt.Color(51, 51, 51));
        dpMenu.setPreferredSize(new java.awt.Dimension(1290, 726));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/toyoMenu.jpg"))); // NOI18N

        dpMenu.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpMenuLayout = new javax.swing.GroupLayout(dpMenu);
        dpMenu.setLayout(dpMenuLayout);
        dpMenuLayout.setHorizontalGroup(
            dpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dpMenuLayout.setVerticalGroup(
            dpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-lista-38.png"))); // NOI18N
        jMenu.setText("Opciones");
        jMenu.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        opProductos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-producto-38.png"))); // NOI18N
        opProductos.setText("Productos");
        opProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opProductosActionPerformed(evt);
            }
        });
        jMenu.add(opProductos);

        opClientes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-clientes-38.png"))); // NOI18N
        opClientes.setText("Clientes");
        opClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opClientesActionPerformed(evt);
            }
        });
        jMenu.add(opClientes);

        opProveedores.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-proveedor-38.png"))); // NOI18N
        opProveedores.setText("Proveedores");
        opProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opProveedoresActionPerformed(evt);
            }
        });
        jMenu.add(opProveedores);

        opCompras.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-compra-38.png"))); // NOI18N
        opCompras.setText("Factura de compra");
        opCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opComprasActionPerformed(evt);
            }
        });
        jMenu.add(opCompras);

        oplCompras.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        oplCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-carpeta-38.png"))); // NOI18N
        oplCompras.setText("Listado de compras");
        oplCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oplComprasActionPerformed(evt);
            }
        });
        jMenu.add(oplCompras);

        opFacturas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opFacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-compra-38 (1).png"))); // NOI18N
        opFacturas.setText("Factura de venta");
        opFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opFacturasActionPerformed(evt);
            }
        });
        jMenu.add(opFacturas);

        oplVentas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        oplVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-carpeta-38.png"))); // NOI18N
        oplVentas.setText("Listado de ventas ");
        oplVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oplVentasActionPerformed(evt);
            }
        });
        jMenu.add(oplVentas);

        opKardex.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opKardex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-inventario-38.png"))); // NOI18N
        opKardex.setText("Kardex");
        opKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opKardexActionPerformed(evt);
            }
        });
        jMenu.add(opKardex);

        opProvincias.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opProvincias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-ubicación-38.png"))); // NOI18N
        opProvincias.setText("Provincias");
        opProvincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opProvinciasActionPerformed(evt);
            }
        });
        jMenu.add(opProvincias);

        opCiudades.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opCiudades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-marcador-38.png"))); // NOI18N
        opCiudades.setText("Ciudades");
        opCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opCiudadesActionPerformed(evt);
            }
        });
        jMenu.add(opCiudades);

        opGestionU.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opGestionU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-administración-38.png"))); // NOI18N
        opGestionU.setText("Gestión de usuarios");
        opGestionU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opGestionUActionPerformed(evt);
            }
        });
        jMenu.add(opGestionU);

        opNuevoUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-añadir-usuario-masculino-38.png"))); // NOI18N
        opNuevoUsuario.setText("Creación de usuarios");
        opNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opNuevoUsuarioActionPerformed(evt);
            }
        });
        jMenu.add(opNuevoUsuario);

        opSalir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        opSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-salida-38.png"))); // NOI18N
        opSalir.setText("Cerrar sesión");
        opSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opSalirActionPerformed(evt);
            }
        });
        jMenu.add(opSalir);

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-38.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem1);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opProductosActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmProductos().isVisible()) {
                this.almacen.setlProductos(this.mSQL.descargarProductos());
                this.getFrmProductos().setTitle("Productos");
                dpMenu.add(this.getFrmProductos());
                this.getFrmProductos().cargarProductos();
                this.getFrmProductos().cargarProveedores();
                this.getFrmProductos().setVisible(true);
            }
        }
    }//GEN-LAST:event_opProductosActionPerformed

    private void opClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opClientesActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmClientes().isVisible()) {
                this.almacen.setlClientes(this.mSQL.descargarClientes());
                this.getFrmClientes().setTitle("Clientes");
                dpMenu.add(this.getFrmClientes());
                this.getFrmClientes().cargarClientes();
                this.getFrmClientes().cargarProvincias();
                this.getFrmClientes().setVisible(true);
            }
        }
    }//GEN-LAST:event_opClientesActionPerformed

    private void opProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opProveedoresActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmProveedores().isVisible()) {
                this.almacen.setlProveedores(this.mSQL.descargarProveedores());
                this.getFrmProveedores().setTitle("Proveedores");
                dpMenu.add(this.getFrmProveedores());
                this.getFrmProveedores().cargarProveedores();
                this.getFrmProveedores().cargarProvincias();
                this.getFrmProveedores().setVisible(true);
            }
        }
    }//GEN-LAST:event_opProveedoresActionPerformed

    private void opFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opFacturasActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmVenta().isVisible()) {
                this.almacen.setlVentas(this.mSQL.descargarVentas());
                this.almacen.setlProductos(this.mSQL.descargarProductos());
                this.getFrmVenta().setTitle("Ventas");
                dpMenu.add(this.getFrmVenta());
                this.getFrmVenta().cargarClientes();
                this.getFrmVenta().cargarProductos();
                this.getFrmVenta().setFecha();
                this.getFrmVenta().setId();
                this.getFrmVenta().setVisible(true);
            }
        }
    }//GEN-LAST:event_opFacturasActionPerformed

    private void opComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opComprasActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmCompra().isVisible()) {
                this.almacen.setlCompras(this.mSQL.descargarCompras());
                this.almacen.setlProductos(this.mSQL.descargarProductos());
                this.getFrmCompra().setTitle("Compra");
                dpMenu.add(this.getFrmCompra());
                this.getFrmCompra().cargarProveedores();
                this.getFrmCompra().setFecha();
                this.getFrmCompra().setId();
                this.getFrmCompra().setVisible(true);
            }
        }
    }//GEN-LAST:event_opComprasActionPerformed

    private void opGestionUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opGestionUActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmGestionUsuarios().isVisible()) {
                this.getFrmGestionUsuarios().cargarUsuarios();
                this.getFrmGestionUsuarios().setTitle("Gestión de usuarios");
                dpMenu.add(this.getFrmGestionUsuarios());
                this.getFrmGestionUsuarios().setVisible(true);
            }
        }
    }//GEN-LAST:event_opGestionUActionPerformed

    private void opNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opNuevoUsuarioActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmNuevoUsuario().isVisible()) {
                this.getFrmNuevoUsuario().setTitle("Creacion de usuarios");
                dpMenu.add(this.getFrmNuevoUsuario());
                this.getFrmNuevoUsuario().setVisible(true);
            }
        }
    }//GEN-LAST:event_opNuevoUsuarioActionPerformed

    private void opSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opSalirActionPerformed
        this.dispose();
        FrmLogin frmLogin = new FrmLogin(this.almacen, this.mSQL);
        frmLogin.setVisible(true);
    }//GEN-LAST:event_opSalirActionPerformed

    private void opProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opProvinciasActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmProvincias().isVisible()) {
                this.almacen.setlProvincias(this.mSQL.descargarProvincias());
                this.getFrmProvincias().setTitle("Provincias");
                dpMenu.add(this.getFrmProvincias());
                this.getFrmProvincias().cargarProvincias();
                this.getFrmProvincias().setVisible(true);
            }
        }
    }//GEN-LAST:event_opProvinciasActionPerformed

    private void opCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opCiudadesActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmCiudades().isVisible()) {
                this.almacen.setlCiudades(this.mSQL.descargarCiudades());
                this.getFrmCiudades().setTitle("Ciudades");
                dpMenu.add(this.getFrmCiudades());
                this.getFrmCiudades().cargarCiudades();
                this.getFrmCiudades().cargarProvincias();
                this.getFrmCiudades().setVisible(true);
            }
        }
    }//GEN-LAST:event_opCiudadesActionPerformed

    private void oplComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oplComprasActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmlFacturas().isVisible()) {
                this.almacen.setlCompras(this.mSQL.descargarCompras());
                this.getFrmlFacturas().setTitle("Facturas");
                dpMenu.add(this.getFrmlFacturas());
                this.getFrmlFacturas().llenarfCompras();
                this.getFrmlFacturas().setVisible(true);
            }
        }
    }//GEN-LAST:event_oplComprasActionPerformed

    private void oplVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oplVentasActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmlFacturasV().isVisible()) {
                this.almacen.setlVentas(this.mSQL.descargarVentas());
                this.getFrmlFacturasV().setTitle("Facturas");
                dpMenu.add(this.getFrmlFacturasV());
                this.getFrmlFacturasV().llenarfVentas();
                this.getFrmlFacturasV().setVisible(true);
            }
        }
    }//GEN-LAST:event_oplVentasActionPerformed

    private void opKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opKardexActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (!this.getFrmKardex().isVisible()) {
                this.almacen.setlDetalle(this.mSQL.descargarDetalle());
                this.almacen.setlProductos(this.mSQL.descargarProductos());
                this.getFrmKardex().setTitle("Kardex");
                dpMenu.add(this.getFrmKardex());
                this.getFrmKardex().cargarProductos();
                this.getFrmKardex().generarTabla();
                this.getFrmKardex().setVisible(true);
            }
        }
    }//GEN-LAST:event_opKardexActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JMenuItem opCiudades;
    public javax.swing.JMenuItem opClientes;
    public javax.swing.JMenuItem opCompras;
    public javax.swing.JMenuItem opFacturas;
    public javax.swing.JMenuItem opGestionU;
    public javax.swing.JMenuItem opKardex;
    public javax.swing.JMenuItem opNuevoUsuario;
    public javax.swing.JMenuItem opProductos;
    public javax.swing.JMenuItem opProveedores;
    public javax.swing.JMenuItem opProvincias;
    private javax.swing.JMenuItem opSalir;
    public javax.swing.JMenuItem oplCompras;
    public javax.swing.JMenuItem oplVentas;
    // End of variables declaration//GEN-END:variables
}
