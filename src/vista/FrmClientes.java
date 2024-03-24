package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import javax.swing.table.DefaultTableModel;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.Provincia;
import utilidades.Jop;

public class FrmClientes extends IntFrm {

    private DefaultTableModel modelo;

    public FrmClientes(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.generarTabla();
        this.tfCi.setEditable(true);
        this.vaciarTxt();
    }

    // Metodo para generar la tabla de clientes
    private void generarTabla() {
        this.modelo = (DefaultTableModel) this.jtClientes.getModel();
        this.jtClientes.setModel(this.modelo);
    }

    // Metodo para cargar clientes a la tabla
    public void cargarClientes() {
        this.modelo.setRowCount(0);
        this.almacen.setlClientes(mSQL.descargarClientes());
        for (int i = 0; i < this.almacen.getlClientes().size(); i++) {
            String ci, nombre, direccion, provincia, ciudad;
            ci = this.almacen.getlClientes().get(i).getCi();
            nombre = this.almacen.getlClientes().get(i).getNombre();
            direccion = this.almacen.getlClientes().get(i).getDir();
            provincia = this.almacen.getlClientes().get(i).getProv();
            ciudad = this.almacen.getlClientes().get(i).getCiudad();

            String[] lista = new String[5];
            lista[0] = ci;
            lista[1] = nombre;
            lista[2] = direccion;
            lista[3] = provincia;
            lista[4] = ciudad;
            this.modelo.addRow(lista);
        }
        this.vaciarTxt();
    }

    // Metodo para vaciar los text fields
    private void vaciarTxt() {
        this.tfCi.setText("");
        this.tfNombre.setText("");
        this.tfDir.setText("");
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

    public void cargarCiudades() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfCi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDir = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbProvincia = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfCodigoProvincia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfCodigoCiudad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1050, 445));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(764, 449));

        jtClientes.setBackground(new java.awt.Color(255, 255, 255));
        jtClientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Dirección", "Código Provincia", "Código Ciudad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtClientes);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnActualizar)
                        .addGap(272, 272, 272))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(337, 337, 337))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cédula");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 15, -1, -1));

        tfCi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCiActionPerformed(evt);
            }
        });
        tfCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCiKeyTyped(evt);
            }
        });
        jPanel2.add(tfCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 38, 150, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre y apellido");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 67, -1, -1));

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
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 90, 150, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Dirección");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 119, -1, -1));

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
        jPanel2.add(tfDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 142, 150, -1));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 98, 32));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Provincia");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        cbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProvinciaActionPerformed(evt);
            }
        });
        jPanel2.add(cbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 203, 135, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ciudad");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 242, -1, -1));

        cbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCiudadActionPerformed(evt);
            }
        });
        jPanel2.add(cbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 265, 135, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Código");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 180, 64, -1));

        tfCodigoProvincia.setEditable(false);
        tfCodigoProvincia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCodigoProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoProvinciaActionPerformed(evt);
            }
        });
        jPanel2.add(tfCodigoProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 205, 60, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Código");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 241, 64, -1));

        tfCodigoCiudad.setEditable(false);
        tfCodigoCiudad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCodigoCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoCiudadActionPerformed(evt);
            }
        });
        jPanel2.add(tfCodigoCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 265, 60, -1));

        btnAgregar.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 306, 98, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.tfCi.setEditable(true);
            if (new Cliente().crearCliente(this.almacen, this.mSQL, this.tfCi.getText(), this.tfNombre.getText().toUpperCase(), this.tfDir.getText().toUpperCase(), (Provincia) this.cbProvincia.getSelectedItem(), (Ciudad) this.cbCiudad.getSelectedItem())) {
                this.cargarClientes();
                this.cargarProvincias();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtClientes.getSelectedRow();
            if (fila >= 0) {
                String ci = (String) this.jtClientes.getValueAt(fila, 0);
                if (this.mSQL.delete("clientes", "ci", ci)) {
                    new Jop().mensaje("Cliente eliminado");
                    this.almacen.setlClientes(mSQL.descargarClientes());
                    this.modelo.removeRow(fila);
                    this.cargarClientes();
                    this.cargarProvincias();
                    this.tfCi.setEditable(true);
                }
            } else {
                new Jop().mensaje("Seleccione un cliente");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.tfCi.setEditable(true);
            this.cargarClientes();
            this.cargarProvincias();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tfCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCiActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtClientes.getSelectedRow();
            if (fila >= 0) {
                if (new Cliente().modificarCliente(this.almacen, this.mSQL, this.tfCi.getText(), this.tfNombre.getText().toUpperCase(), this.tfDir.getText().toUpperCase(), (Provincia) this.cbProvincia.getSelectedItem(), (Ciudad) this.cbCiudad.getSelectedItem())) {
                    this.almacen.setlClientes(mSQL.descargarClientes());
                    this.tfCi.setEditable(true);
                    this.cargarClientes();
                }
            } else {
                new Jop().mensaje("Seleccione un cliente");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
        this.tfCi.setEditable(false);
        int fila = this.jtClientes.getSelectedRow();
        if (fila >= 0) {
            this.tfCi.setText((String) this.jtClientes.getValueAt(fila, 0));
            this.tfNombre.setText((String) this.jtClientes.getValueAt(fila, 1));
            this.tfDir.setText((String) this.jtClientes.getValueAt(fila, 2));
            String provinciaSelect = (String) this.jtClientes.getValueAt(fila, 3);
            String ciudadSelect = (String) this.jtClientes.getValueAt(fila, 4);
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
    }//GEN-LAST:event_jtClientesMouseClicked

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

    private void tfCodigoProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoProvinciaActionPerformed

    private void tfCodigoCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoCiudadActionPerformed

    private void tfCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCiKeyTyped
        if (this.tfCi.getText().length() >= 10) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCiKeyTyped

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        if (this.tfNombre.getText().length() >= 22) {
            evt.consume();
        }
    }//GEN-LAST:event_tfNombreKeyTyped

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField tfCi;
    private javax.swing.JTextField tfCodigoCiudad;
    private javax.swing.JTextField tfCodigoProvincia;
    private javax.swing.JTextField tfDir;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
