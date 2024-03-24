package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.Proveedores;
import utilidades.Jop;
import utilidades.Qr;

public final class FrmProductos extends IntFrm {

    private DefaultTableModel modelo;

    public FrmProductos(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.generarTabla();
        this.vaciarTxt();
    }

    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    public void generarTabla() {
        this.modelo = (DefaultTableModel) this.jtProductos.getModel();
        this.jtProductos.setModel(this.modelo);
    }

    public void cargarProductos() {
        this.tfCod.setEditable(true);
        this.modelo.setRowCount(0);
        this.almacen.setlProductos(this.mSQL.descargarProductos());
        for (int i = 0; i < this.almacen.getlProductos().size(); i++) {
            String codigo, nombre, codigoProv, stock;
            codigo = this.almacen.getlProductos().get(i).getCodigo();
            nombre = this.almacen.getlProductos().get(i).getNombre();
            codigoProv = this.almacen.getlProductos().get(i).getCodigoProv();
            stock = String.valueOf(this.almacen.getlProductos().get(i).getStock());
            
            String[] lista = new String[4];
            lista[0] = codigo;
            lista[1] = nombre;
            lista[2] = codigoProv;
            lista[3] = stock;
            this.modelo.addRow(lista);
        }
        this.vaciarTxt();
    }

    // Metodo para cargar proveedores al cb
    public void cargarProveedores() {
        this.cbProv.removeAllItems();
        this.almacen.setlProveedores(this.mSQL.descargarProveedores());
        for (int i = 0; i < this.almacen.getlProveedores().size(); i++) {
            this.cbProv.addItem(this.almacen.getlProveedores().get(i));
        }
        this.cbProv.setSelectedItem(null);
        this.tfRuc.setText("");
    }

    public void vaciarTxt() {
        this.tfNombre.setText("");
        this.tfCod.setText("");
        this.cbProv.setSelectedItem(null);
        this.tfRuc.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        btnQr = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfCod = new javax.swing.JTextField();
        tfRuc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbProv = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);
        setPreferredSize(new java.awt.Dimension(720, 461));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 110, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 98, 32));

        btnActualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Refrescar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, 32));

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código producto", "Nombre", "RUC Proveedor", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtProductos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 510, 310));

        btnQr.setBackground(new java.awt.Color(204, 204, 204));
        btnQr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnQr.setForeground(new java.awt.Color(0, 0, 0));
        btnQr.setText("QR");
        btnQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQrActionPerformed(evt);
            }
        });
        jPanel1.add(btnQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 98, 32));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(790, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfCod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodActionPerformed(evt);
            }
        });
        tfCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCodKeyTyped(evt);
            }
        });
        jPanel2.add(tfCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 60, 146, -1));

        tfRuc.setEditable(false);
        tfRuc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRucActionPerformed(evt);
            }
        });
        jPanel2.add(tfRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 264, 146, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("RUC proveedor");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 241, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Código");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 37, -1, -1));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 98, 32));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 105, -1, -1));

        tfNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
        });
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 128, 146, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Proveedor");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 173, -1, -1));

        cbProv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProvActionPerformed(evt);
            }
        });
        jPanel2.add(cbProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 196, 146, -1));

        btnAgregar.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 98, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (new Producto().crearProducto(this.almacen, this.mSQL, this.tfCod.getText().toUpperCase(), this.tfNombre.getText().toUpperCase(), (Proveedores) this.cbProv.getSelectedItem())) {
                this.cargarProductos();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtProductos.getSelectedRow();
            if (this.jtProductos.getSelectedRow() >= 0) {
                String cod = String.valueOf(this.jtProductos.getValueAt(fila, 0));
                int cont = 0;
                for (int i = 0; i < this.almacen.getlDetalle().size(); i++) {
                    if (this.almacen.getlDetalle().get(i).getCodigoProd().equals(cod)) {
                        cont++;
                    }
                }
                if (cont == 0) {
                    if (this.mSQL.delete("productos", "codigo", (String) this.jtProductos.getValueAt(fila, 0))) {
                        new Jop().mensaje("Producto eliminado");
                        this.getModelo().removeRow(fila);
                        this.almacen.setlProductos(this.mSQL.descargarProductos());
                        this.vaciarTxt();
                    }
                } else {
                    new Jop().mensaje("El producto está conectado a una factura, no se puede eliminar");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.cargarProductos();
            this.cargarProveedores();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtProductos.getSelectedRow();
            if (fila >= 0) {
                if (new Producto().modificarProductos(this.almacen, this.mSQL, this.tfCod.getText(), this.tfNombre.getText(),
                        (Proveedores) this.cbProv.getSelectedItem())) {
                    this.almacen.setlProductos(this.mSQL.descargarProductos());
                    this.cargarProductos();
                }
            } else {
                new Jop().mensaje("Seleccione un producto");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tfCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodActionPerformed

    private void tfRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRucActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked

    }//GEN-LAST:event_btnAgregarMouseClicked

    private void cbProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProvActionPerformed
        if (this.cbProv.getSelectedItem() != null) {
            Proveedores p = (Proveedores) this.cbProv.getSelectedItem();
            this.tfRuc.setText(p.getRuc());
        }
    }//GEN-LAST:event_cbProvActionPerformed

    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
        int fila = this.jtProductos.getSelectedRow();
        if (fila >= 0) {
            this.tfCod.setText((String) this.jtProductos.getValueAt(fila, 0));
            this.tfNombre.setText((String) this.jtProductos.getValueAt(fila, 1));

            String ruc = (String) this.jtProductos.getValueAt(fila, 2);
            for (int i = 0; i < this.almacen.getlProveedores().size(); i++) {
                if (ruc.equals(this.almacen.getlProveedores().get(i).getRuc())) {
                    this.cbProv.setSelectedItem(this.almacen.getlProveedores().get(i));
                }
            }
        }
    }//GEN-LAST:event_jtProductosMouseClicked

    private void btnQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQrActionPerformed
        int fila = this.jtProductos.getSelectedRow();
        if (fila >= 0) {
            String codi = (String) this.jtProductos.getValueAt(fila, 0);
            String nombre = (String) this.jtProductos.getValueAt(fila, 1);
            String rucp = (String) this.jtProductos.getValueAt(fila, 2);
            new Qr().generarQr_pro(codi, nombre, rucp);
        } else {
            new Jop().mensaje("Seleccione un producto");
        }
    }//GEN-LAST:event_btnQrActionPerformed

    private void tfCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodKeyTyped
        if (this.tfCod.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCodKeyTyped

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        if (this.tfNombre.getText().length() >= 22) {
            evt.consume();
        }
    }//GEN-LAST:event_tfNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQr;
    private javax.swing.JComboBox<Proveedores> cbProv;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfRuc;
    // End of variables declaration//GEN-END:variables
}
