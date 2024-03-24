package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import modelo.Usuarios;
import utilidades.Jop;

public class FrmGestionUsuarios extends IntFrm {

    public FrmGestionUsuarios(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.vaciarC();
    }

    public void cargarUsuarios() {
        this.comboUsuarios.removeAllItems();
        for (int i = 0; i < this.almacen.getlUsuarios().size(); i++) {
            this.comboUsuarios.addItem(this.almacen.getlUsuarios().get(i).getUsuario());
        }
        this.comboUsuarios.setSelectedIndex(-1);
        this.vaciarC();
    }

    public void vaciarC() {
        this.checkCiudad.setSelected(false);
        this.checkClientes.setSelected(false);
        this.checkCompras.setSelected(false);
        this.checkCrear.setSelected(false);
        this.checkFacturas.setSelected(false);
        this.checkGestion.setSelected(false);
        this.checkKardex.setSelected(false);
        this.checkProductos.setSelected(false);
        this.checkProveedores.setSelected(false);
        this.checkProvincia.setSelected(false);
        this.checklCompras.setSelected(false);
        this.checklVentas.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        checkProductos = new javax.swing.JCheckBox();
        checkClientes = new javax.swing.JCheckBox();
        checkProveedores = new javax.swing.JCheckBox();
        checkFacturas = new javax.swing.JCheckBox();
        checkKardex = new javax.swing.JCheckBox();
        checkProvincia = new javax.swing.JCheckBox();
        checkCiudad = new javax.swing.JCheckBox();
        checklVentas = new javax.swing.JCheckBox();
        checklCompras = new javax.swing.JCheckBox();
        checkGestion = new javax.swing.JCheckBox();
        checkCrear = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        checkCompras = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        comboUsuarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(null);
        setClosable(true);
        setTitle("Gestión de usuarios");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(800, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Permisos");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Productos");

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Clientes");

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Proveedores");

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ventas");

        jLabel8.setBackground(new java.awt.Color(0, 51, 51));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Kardex");

        jLabel9.setBackground(new java.awt.Color(0, 51, 51));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Provincias");

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ciudades");

        jLabel11.setBackground(new java.awt.Color(0, 51, 51));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Listado de ventas generadas");

        jLabel12.setBackground(new java.awt.Color(0, 51, 51));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Listado de compras generadas");

        jLabel13.setBackground(new java.awt.Color(0, 51, 51));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Gestión de usuarios");

        jLabel14.setBackground(new java.awt.Color(0, 51, 51));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Creación de usuarios");

        checkProductos.setBackground(new java.awt.Color(153, 153, 153));
        checkProductos.setForeground(new java.awt.Color(0, 204, 0));
        checkProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkProductosActionPerformed(evt);
            }
        });

        checkClientes.setBackground(new java.awt.Color(153, 153, 153));
        checkClientes.setForeground(new java.awt.Color(0, 204, 0));
        checkClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkClientesActionPerformed(evt);
            }
        });

        checkProveedores.setBackground(new java.awt.Color(153, 153, 153));
        checkProveedores.setForeground(new java.awt.Color(0, 204, 0));
        checkProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkProveedoresActionPerformed(evt);
            }
        });

        checkFacturas.setBackground(new java.awt.Color(153, 153, 153));
        checkFacturas.setForeground(new java.awt.Color(0, 204, 0));
        checkFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFacturasActionPerformed(evt);
            }
        });

        checkKardex.setBackground(new java.awt.Color(153, 153, 153));
        checkKardex.setForeground(new java.awt.Color(0, 204, 0));
        checkKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkKardexActionPerformed(evt);
            }
        });

        checkProvincia.setBackground(new java.awt.Color(153, 153, 153));
        checkProvincia.setForeground(new java.awt.Color(0, 204, 0));
        checkProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkProvinciaActionPerformed(evt);
            }
        });

        checkCiudad.setBackground(new java.awt.Color(153, 153, 153));
        checkCiudad.setForeground(new java.awt.Color(0, 204, 0));
        checkCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCiudadActionPerformed(evt);
            }
        });

        checklVentas.setBackground(new java.awt.Color(153, 153, 153));
        checklVentas.setForeground(new java.awt.Color(0, 204, 0));
        checklVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checklVentasActionPerformed(evt);
            }
        });

        checklCompras.setBackground(new java.awt.Color(153, 153, 153));
        checklCompras.setForeground(new java.awt.Color(0, 204, 0));
        checklCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checklComprasActionPerformed(evt);
            }
        });

        checkGestion.setBackground(new java.awt.Color(153, 153, 153));
        checkGestion.setForeground(new java.awt.Color(0, 204, 0));
        checkGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGestionActionPerformed(evt);
            }
        });

        checkCrear.setBackground(new java.awt.Color(153, 153, 153));
        checkCrear.setForeground(new java.awt.Color(0, 204, 0));
        checkCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCrearActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 51, 51));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Compras");

        checkCompras.setBackground(new java.awt.Color(153, 153, 153));
        checkCompras.setForeground(new java.awt.Color(0, 204, 0));
        checkCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkComprasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkProductos)
                    .addComponent(checkClientes)
                    .addComponent(checkProveedores)
                    .addComponent(checkFacturas)
                    .addComponent(checkKardex)
                    .addComponent(checkProvincia)
                    .addComponent(checkCiudad)
                    .addComponent(checklVentas)
                    .addComponent(checklCompras)
                    .addComponent(checkGestion)
                    .addComponent(checkCrear)
                    .addComponent(checkCompras))
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(checkProductos))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addComponent(checkClientes))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(checkProveedores))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(checkFacturas))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(checkCompras))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(checkCiudad)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel8)
                                                                    .addComponent(checkKardex))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel9))
                                                            .addComponent(checkProvincia, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addGap(18, 18, Short.MAX_VALUE)
                                                        .addComponent(jLabel10)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11))
                                            .addComponent(checklVentas))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12))
                                    .addComponent(checklCompras))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addComponent(checkGestion))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14))
                    .addComponent(checkCrear))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        comboUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        comboUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        comboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUsuariosActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(114, 114, 114))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUsuariosActionPerformed
        if (this.comboUsuarios.getSelectedItem() != null) {
            new Usuarios().cargarPermisos(this.comboUsuarios.getSelectedItem().toString(), almacen, this);
        }
    }//GEN-LAST:event_comboUsuariosActionPerformed

    private void checkProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkProductosActionPerformed

    private void checkClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkClientesActionPerformed

    private void checkProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkProveedoresActionPerformed

    private void checkFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFacturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkFacturasActionPerformed

    private void checkKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkKardexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkKardexActionPerformed

    private void checkProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkProvinciaActionPerformed

    private void checkCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkCiudadActionPerformed

    private void checklVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checklVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checklVentasActionPerformed

    private void checklComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checklComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checklComprasActionPerformed

    private void checkGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkGestionActionPerformed

    private void checkCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (this.comboUsuarios.getSelectedItem() != null) {
                new Usuarios().actualizarPermisos(this, this.mSQL, this.comboUsuarios.getSelectedItem().toString(), this.almacen);
            } else {
                new Jop().mensaje("Seleccione un usuario");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (this.comboUsuarios.getSelectedItem() != null) {
                new Usuarios().eliminarUsuario(this.almacen, this.mSQL, this.comboUsuarios.getSelectedItem().toString());
                this.cargarUsuarios();
            } else {
                new Jop().mensaje("Seleccione un usuario");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void checkComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkComprasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    public javax.swing.JCheckBox checkCiudad;
    public javax.swing.JCheckBox checkClientes;
    public javax.swing.JCheckBox checkCompras;
    public javax.swing.JCheckBox checkCrear;
    public javax.swing.JCheckBox checkFacturas;
    public javax.swing.JCheckBox checkGestion;
    public javax.swing.JCheckBox checkKardex;
    public javax.swing.JCheckBox checkProductos;
    public javax.swing.JCheckBox checkProveedores;
    public javax.swing.JCheckBox checkProvincia;
    public javax.swing.JCheckBox checklCompras;
    public javax.swing.JCheckBox checklVentas;
    private javax.swing.JComboBox<String> comboUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
