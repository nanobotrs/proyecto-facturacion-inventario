package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import javax.swing.table.DefaultTableModel;
import modelo.Ciudad;
import modelo.Proveedores;
import modelo.Provincia;
import utilidades.Jop;

public class FrmProveedores extends IntFrm {

    private DefaultTableModel modelo;

    public FrmProveedores(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.generarTabla();
        this.tfRuc.setEditable(true);
        this.vaciarTxt();
    }

    // Metodo para generar la tabla de proveedores
    private void generarTabla() {
        this.modelo = (DefaultTableModel) this.jtProv.getModel();
        this.jtProv.setModel(this.modelo);
    }

    // Metodo para cargar proveedores a la tabla
    public void cargarProveedores() {
        this.modelo.setRowCount(0);
        this.almacen.setlProveedores(this.mSQL.descargarProveedores());
        for (int i = 0; i < this.almacen.getlProveedores().size(); i++) {
            String ruc, nombre, telf, direccion, provincia, ciudad;
            ruc = this.almacen.getlProveedores().get(i).getRuc();
            nombre = this.almacen.getlProveedores().get(i).getNombre();
            telf = this.almacen.getlProveedores().get(i).getTelf();
            direccion = this.almacen.getlProveedores().get(i).getDireccion();
            provincia = this.almacen.getlProveedores().get(i).getProvincia();
            ciudad = this.almacen.getlProveedores().get(i).getCiudad();

            String[] lista = new String[6];
            lista[0] = ruc;
            lista[1] = nombre;
            lista[2] = telf;
            lista[3] = direccion;
            lista[4] = provincia;
            lista[5] = ciudad;
            this.modelo.addRow(lista);
        }
        vaciarTxt();
    }

    // Metodo para vaciar los text fields
    private void vaciarTxt() {
        this.tfRuc.setText("");
        this.tfTelf.setText("");
        this.tfDir.setText("");
        this.tfNombre.setText("");
        this.cbProvincia.setSelectedItem(null);
        this.cbCiudad.setSelectedItem(null);
        this.tfCodigoCiudad.setText("");
        this.tfCodigoProvincia.setText("");
    }

    public void cargarProvincias() {
        this.cbProvincia.removeAllItems();
        for (int i = 0; i < this.almacen.getlProvincias().size(); i++) {
            this.cbProvincia.addItem(this.almacen.getlProvincias().get(i));
        }
        this.cbProvincia.setSelectedItem(null);
        this.tfCodigoProvincia.setText("");
        this.cbCiudad.removeAllItems();
    }

    private void cargarCiudades() {
        this.cbCiudad.removeAllItems();
        Provincia p = (Provincia) this.cbProvincia.getSelectedItem();
        for (int i = 0; i < this.almacen.getlCiudades().size(); i++) {
            if (p.getCod().equals(this.almacen.getlCiudades().get(i).getCodProvincia())) {
                this.cbCiudad.addItem(this.almacen.getlCiudades().get(i));
            }
        }
        this.cbCiudad.setSelectedItem(null);
        this.tfCodigoCiudad.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProv = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tfRuc = new javax.swing.JTextField();
        tfTelf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCodigoProvincia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbProvincia = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox<>();
        tfDir = new javax.swing.JTextField();
        tfCodigoCiudad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proveedores");

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Refrescar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jtProv.setBackground(new java.awt.Color(255, 255, 255));
        jtProv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtProv.setForeground(new java.awt.Color(0, 0, 0));
        jtProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC", "Nombre", "Teléfono", "Dirección", "Provincia", "Ciudad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProv.getTableHeader().setReorderingAllowed(false);
        jtProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProv);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(790, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfRuc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRucActionPerformed(evt);
            }
        });
        tfRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfRucKeyTyped(evt);
            }
        });
        jPanel2.add(tfRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 150, -1));

        tfTelf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelfActionPerformed(evt);
            }
        });
        tfTelf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelfKeyTyped(evt);
            }
        });
        jPanel2.add(tfTelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 150, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Teléfono");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("RUC");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

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
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 150, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Dirección");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        tfCodigoProvincia.setEditable(false);
        tfCodigoProvincia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCodigoProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoProvinciaActionPerformed(evt);
            }
        });
        jPanel2.add(tfCodigoProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 60, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Código");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 64, -1));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 98, 32));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Provincia");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        cbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProvinciaActionPerformed(evt);
            }
        });
        jPanel2.add(cbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 135, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Código");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 64, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ciudad");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        cbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCiudadActionPerformed(evt);
            }
        });
        jPanel2.add(cbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 135, -1));

        tfDir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDirActionPerformed(evt);
            }
        });
        tfDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDirKeyTyped(evt);
            }
        });
        jPanel2.add(tfDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 150, -1));

        tfCodigoCiudad.setEditable(false);
        tfCodigoCiudad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCodigoCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoCiudadActionPerformed(evt);
            }
        });
        jPanel2.add(tfCodigoCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 60, -1));

        btnAgregar.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 98, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.tfRuc.setEditable(true);
            if (new Proveedores().crearProveedor(this.almacen, this.mSQL, this.tfRuc.getText(), this.tfNombre.getText().toUpperCase(), this.tfTelf.getText(), this.tfDir.getText().toUpperCase(), (Provincia) this.cbProvincia.getSelectedItem(), (Ciudad) this.cbCiudad.getSelectedItem())) {
                this.cargarProveedores();
                this.cargarProvincias();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtProv.getSelectedRow();
            if (fila >= 0) {
                String ruc = (String) this.jtProv.getValueAt(fila, 0);
                if (this.mSQL.delete("proveedores", "ruc", ruc)) {
                    new Jop().mensaje("Proveedor eliminado");
                    this.almacen.setlProveedores(mSQL.descargarProveedores());
                    this.modelo.removeRow(fila);
                    this.tfRuc.setEditable(true);
                    this.cargarProveedores();
                    this.cargarProvincias();
                }
            } else {
                new Jop().mensaje("Seleccione un proveedor");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.tfRuc.setEditable(true);
            this.cargarProveedores();
            this.cargarProvincias();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtProv.getSelectedRow();
            if (fila >= 0) {
                if (new Proveedores().modificarProveedor(this.almacen, this.mSQL, this.tfRuc.getText(), this.tfNombre.getText().toUpperCase(), this.tfTelf.getText(), this.tfDir.getText().toUpperCase(), (Provincia) this.cbProvincia.getSelectedItem(), (Ciudad) this.cbCiudad.getSelectedItem())) {
                    this.almacen.setlProveedores(this.mSQL.descargarProveedores());
                    this.tfRuc.setEditable(true);
                    this.cargarProveedores();
                    this.cargarCiudades();
                }
            } else {
                new Jop().mensaje("Seleccione un proveedor");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tfRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRucActionPerformed

    private void tfTelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelfActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfCodigoProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoProvinciaActionPerformed

    private void jtProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProvMouseClicked
        this.tfRuc.setEditable(false);
        int fila = this.jtProv.getSelectedRow();
        if (fila >= 0) {
            this.tfRuc.setText((String) this.jtProv.getValueAt(fila, 0));
            this.tfNombre.setText((String) this.jtProv.getValueAt(fila, 1));
            this.tfTelf.setText((String) this.jtProv.getValueAt(fila, 2));
            this.tfDir.setText((String) this.jtProv.getValueAt(fila, 3));
            String provinciaSelect = (String) this.jtProv.getValueAt(fila, 4);
            String ciudadSelect = (String) this.jtProv.getValueAt(fila, 5);
            for (int i = 0; i < this.almacen.getlProvincias().size(); i++) {
                if (provinciaSelect.equals(this.almacen.getlProvincias().get(i).getCod())) {
                    this.cbProvincia.setSelectedItem(this.almacen.getlProvincias().get(i));
                    this.tfCodigoProvincia.setText(provinciaSelect);
                }
            }
            for (int i = 0; i < this.almacen.getlCiudades().size(); i++) {
                if (ciudadSelect.equals(this.almacen.getlCiudades().get(i).getCodigo())) {
                    this.cbCiudad.setSelectedItem(this.almacen.getlCiudades().get(i));
                    this.tfCodigoCiudad.setText(ciudadSelect);
                }
            }
        }
    }//GEN-LAST:event_jtProvMouseClicked

    private void tfDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDirActionPerformed

    private void tfCodigoCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoCiudadActionPerformed

    private void cbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProvinciaActionPerformed
        if (this.cbProvincia.getSelectedItem() != null) {
            Provincia p = (Provincia) this.cbProvincia.getSelectedItem();
            this.tfCodigoProvincia.setText(p.getCod());
            this.cargarCiudades();
        }
    }//GEN-LAST:event_cbProvinciaActionPerformed

    private void cbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCiudadActionPerformed
        if (this.cbCiudad.getSelectedItem() != null) {
            Ciudad c = (Ciudad) this.cbCiudad.getSelectedItem();
            this.tfCodigoCiudad.setText(c.getCodigo());
        }
    }//GEN-LAST:event_cbCiudadActionPerformed

    private void tfRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRucKeyTyped
        if (this.tfRuc.getText().length() >= 13) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tfRucKeyTyped

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        if (this.tfNombre.getText().length() >= 22) {
            evt.consume();
        }
    }//GEN-LAST:event_tfNombreKeyTyped

    private void tfTelfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelfKeyTyped
        if (this.tfTelf.getText().length() >= 10) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tfTelfKeyTyped

    private void tfDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDirKeyTyped
        if (this.tfDir.getText().length() >= 22) {
            evt.consume();
        }
    }//GEN-LAST:event_tfDirKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<Ciudad> cbCiudad;
    private javax.swing.JComboBox<Provincia> cbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProv;
    private javax.swing.JTextField tfCodigoCiudad;
    private javax.swing.JTextField tfCodigoProvincia;
    private javax.swing.JTextField tfDir;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfRuc;
    private javax.swing.JTextField tfTelf;
    // End of variables declaration//GEN-END:variables
}
