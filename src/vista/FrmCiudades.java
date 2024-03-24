package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Ciudad;
import modelo.Provincia;
import utilidades.Jop;

public class FrmCiudades extends IntFrm {

    private DefaultTableModel modelo;

    public FrmCiudades(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.generarTabla();
        this.vaciarTxt();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCiudades = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tfCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCodigoProv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbProv = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ciudades");

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

        jtCiudades.setBackground(new java.awt.Color(255, 255, 255));
        jtCiudades.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtCiudades.setForeground(new java.awt.Color(0, 0, 0));
        jtCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Código Provincia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCiudades.getTableHeader().setReorderingAllowed(false);
        jtCiudades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCiudadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCiudades);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnActualizar))
                    .addComponent(jLabel1)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(790, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfCod.setEditable(false);
        tfCod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodActionPerformed(evt);
            }
        });
        jPanel2.add(tfCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 58, 150, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Código (no llenar)");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 35, 135, -1));

        btnModificar.setBackground(new java.awt.Color(204, 204, 204));
        btnModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 98, 32));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 97, -1, -1));

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
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 120, 150, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Código de provincia");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 219, -1, -1));

        tfCodigoProv.setEditable(false);
        tfCodigoProv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCodigoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoProvActionPerformed(evt);
            }
        });
        jPanel2.add(tfCodigoProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 242, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Provincia");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 159, -1, -1));

        cbProv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProvActionPerformed(evt);
            }
        });
        jPanel2.add(cbProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 180, 150, -1));

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
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 98, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarTabla() {
        this.modelo = (DefaultTableModel) this.jtCiudades.getModel();
        this.jtCiudades.setModel(this.modelo);
    }

    // Metodo para vaciar los text fields
    private void vaciarTxt() {
        this.tfCod.setText("");
        this.tfNombre.setText("");
    }

    // Metodo para cargar ciudades a la tabla
    public void cargarCiudades() {
        this.modelo.setRowCount(0);
        this.almacen.setlCiudades(this.mSQL.descargarCiudades());
        for (int i = 0; i < this.almacen.getlCiudades().size(); i++) {
            String cod, nombre, codP;
            cod = this.almacen.getlCiudades().get(i).getCodigo();
            nombre = this.almacen.getlCiudades().get(i).getNombre();
            codP = this.almacen.getlCiudades().get(i).getCodProvincia();
            String[] lista = new String[3];
            lista[0] = cod;
            lista[1] = nombre;
            lista[2] = codP;
            this.modelo.addRow(lista);
        }
        vaciarTxt();
    }

    // Metodo para cargar provincias al cb
    public void cargarProvincias() {
        this.cbProv.removeAllItems();
        this.almacen.setlProvincias(this.mSQL.descargarProvincias());
        for (int i = 0; i < this.almacen.getlProvincias().size(); i++) {
            this.cbProv.addItem(this.almacen.getlProvincias().get(i));
        }
        this.tfCodigoProv.setText("");
        this.cbProv.setSelectedIndex(-1);
    }

    // Actualizar proveedores y clientes
    public void actualizarPC(String codigoCiudad, Provincia p) throws SQLException {
        this.mSQL.updateString("proveedores", "provincia", p.getCod(), "ciudad", codigoCiudad);
        this.mSQL.updateString("clientes", "provincia", p.getCod(), "ciudad", codigoCiudad);
        this.almacen.setlProveedores(this.mSQL.descargarProveedores());
        this.almacen.setlClientes(this.mSQL.descargarClientes());
    }

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked

    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (new Ciudad().crearCiudad(this.almacen, this.mSQL, this.tfNombre.getText().toUpperCase(), (Provincia) this.cbProv.getSelectedItem())) {
                this.cargarCiudades();
                this.cargarProvincias();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtCiudades.getSelectedRow();
            if (fila >= 0) {
                if (this.mSQL.delete("ciudades", "codigoCiudad", (String) this.jtCiudades.getValueAt(fila, 0))) {
                    this.modelo.removeRow(fila);
                    this.almacen.setlCiudades(this.mSQL.descargarCiudades());
                    this.cargarCiudades();
                    this.cargarProvincias();
                }
            } else {
                new Jop().mensaje("Seleccione una ciudad");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.cargarCiudades();
            this.cargarProvincias();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jtCiudadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCiudadesMouseClicked
        int fila = this.jtCiudades.getSelectedRow();
        if (fila >= 0) {
            this.tfCod.setText((String) this.jtCiudades.getValueAt(fila, 0));
            this.tfNombre.setText((String) this.jtCiudades.getValueAt(fila, 1));
            String codProvincia = (String) this.jtCiudades.getValueAt(fila, 2);
            for (int i = 0; i < this.almacen.getlProvincias().size(); i++) {
                if (codProvincia.equals(this.almacen.getlProvincias().get(i).getCod())) {
                    this.cbProv.setSelectedItem(this.almacen.getlProvincias().get(i));
                }
            }
        }
    }//GEN-LAST:event_jtCiudadesMouseClicked

    private void tfCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            int fila = this.jtCiudades.getSelectedRow();
            if (fila >= 0) {
                try {
                    String codigo = this.tfCod.getText();
                    Provincia p = (Provincia) this.cbProv.getSelectedItem();
                    if (new Ciudad().modificarCiudad(this.almacen, this.mSQL, codigo, this.tfNombre.getText().toUpperCase(), p)) {
                        this.almacen.setlProvincias(this.mSQL.descargarProvincias());
                        this.actualizarPC(codigo, p);
                        this.cargarCiudades();
                        this.cargarProvincias();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCiudades.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                new Jop().mensaje("Seleccione una ciudad");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfCodigoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoProvActionPerformed

    private void cbProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProvActionPerformed
        if (this.cbProv.getSelectedItem() != null) {
            Provincia p = (Provincia) this.cbProv.getSelectedItem();
            this.tfCodigoProv.setText(p.getCod());
        }
    }//GEN-LAST:event_cbProvActionPerformed

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
    private javax.swing.JComboBox<Provincia> cbProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtCiudades;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfCodigoProv;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
