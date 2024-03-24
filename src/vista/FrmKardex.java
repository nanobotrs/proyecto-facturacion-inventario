package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleTransaccion;
import modelo.Producto;
import utilidades.Controles;

public class FrmKardex extends IntFrm {

    private DefaultTableModel modelo;
    private ArrayList<DetalleTransaccion> lDetalle;

    public FrmKardex(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
    }

    public ArrayList<DetalleTransaccion> getlDetalle() {
        return this.lDetalle;
    }

    public void setlDetalle(ArrayList<DetalleTransaccion> lDetalle) {
        this.lDetalle = lDetalle;
    }

    public void generarTabla() {
        this.modelo = (DefaultTableModel) this.jtKardex.getModel();
        this.jtKardex.setModel(this.modelo);
        this.modelo.setRowCount(0);
    }

    public void cargarProductos() {
        this.almacen.setlProductos(this.mSQL.descargarProductos());
        this.cbProductos.removeAllItems();
        for (int i = 0; i < this.almacen.getlProductos().size(); i++) {
            this.cbProductos.addItem(this.almacen.getlProductos().get(i));
        }
        this.vaciarProducto();
    }

    private void vaciarProducto() {
        this.cbProductos.setSelectedItem(null);
        this.tfNombre.setText("");
        this.tfStock.setText("");
    }

    private void acbProd() {
        Producto p = (Producto) this.cbProductos.getSelectedItem();
        if (p != null) {
            this.tfNombre.setText(p.getNombre());
            this.tfStock.setText(String.valueOf(p.getStock()));
        }
    }

    public void llenarKardex() {
        Producto p = (Producto) this.cbProductos.getSelectedItem();
        if (p != null) {
            this.tfStock.setText(String.valueOf(p.getStock()));
            this.llenarLista(p);
            this.modelo.setRowCount(0);
            for (int i = 0; i < this.getlDetalle().size(); i++) {
                DetalleTransaccion d = this.getlDetalle().get(i);
                int tipo = d.getTipo();
                switch (tipo) {
                    case 0 ->
                        this.tipo0(p, d);
                    case 1 ->
                        this.tipo1(p, d, i);
                    case 2 ->
                        this.tipo2(p, d, i);
                    case 3 ->
                        this.tipo3(p, d, i);
                    case 4 ->
                        this.tipo4(p, d, i);
                }
            }
        }
    }

    public void llenarLista(Producto p) {
        ArrayList<DetalleTransaccion> dt = new ArrayList<>();
        for (int i = 0; i < this.getAlmacen().getlDetalle().size(); i++) {
            if (this.getAlmacen().getlDetalle().get(i).getCodigoProd().equals(p.getCodigo())) {
                dt.add(this.getAlmacen().getlDetalle().get(i));
            }
        }
        this.setlDetalle(dt);
    }

    public void tipo0(Producto p, DetalleTransaccion d) {
        String fecha, idTransaccion, descripcion, entrada, salida, stock;
        fecha = new Controles().formatFechaString(d.getFecha());
        idTransaccion = "";
        descripcion = "Inventario inicial";
        entrada = "";
        salida = "";
        stock = "0";

        String[] lista = new String[6];
        lista[0] = fecha;
        lista[1] = idTransaccion;
        lista[2] = descripcion;
        lista[3] = entrada;
        lista[4] = salida;
        lista[5] = stock;
        this.modelo.addRow(lista);
    }

    public void tipo1(Producto p, DetalleTransaccion d, int i) {
        String fecha, idTransaccion, descripcion, entrada, salida, stock;
        fecha = new Controles().formatFechaString(d.getFecha());
        idTransaccion = String.valueOf(d.getIdTransaccion());
        descripcion = "Compra";
        entrada = String.valueOf(d.getCantidad());
        salida = "";
        stock = String.valueOf(d.getCantidad() + Integer.parseInt(String.valueOf(this.jtKardex.getValueAt(i - 1, 5))));

        String[] lista = new String[6];
        lista[0] = fecha;
        lista[1] = idTransaccion;
        lista[2] = descripcion;
        lista[3] = entrada;
        lista[4] = salida;
        lista[5] = stock;
        this.modelo.addRow(lista);
    }

    public void tipo2(Producto p, DetalleTransaccion d, int i) {
        String fecha, idTransaccion, descripcion, entrada, salida, stock;
        fecha = new Controles().formatFechaString(d.getFecha());
        idTransaccion = String.valueOf(d.getIdTransaccion());
        descripcion = "Venta";
        entrada = "";
        salida = String.valueOf(d.getCantidad());
        stock = String.valueOf(Integer.parseInt(String.valueOf(this.jtKardex.getValueAt(i - 1, 5))) - d.getCantidad());

        String[] lista = new String[6];
        lista[0] = fecha;
        lista[1] = idTransaccion;
        lista[2] = descripcion;
        lista[3] = entrada;
        lista[4] = salida;
        lista[5] = stock;
        this.modelo.addRow(lista);
    }

    public void tipo3(Producto p, DetalleTransaccion d, int i) {
        String fecha, idTransaccion, descripcion, entrada, salida, stock;
        fecha = new Controles().formatFechaString(d.getFecha());
        idTransaccion = String.valueOf(d.getIdTransaccion());
        descripcion = "Eliminación de compra";
        entrada = "";
        salida = String.valueOf(d.getCantidad());
        stock = String.valueOf(Integer.parseInt(String.valueOf(this.jtKardex.getValueAt(i - 1, 5))) - d.getCantidad());

        String[] lista = new String[6];
        lista[0] = fecha;
        lista[1] = idTransaccion;
        lista[2] = descripcion;
        lista[3] = entrada;
        lista[4] = salida;
        lista[5] = stock;
        this.modelo.addRow(lista);
    }

    public void tipo4(Producto p, DetalleTransaccion d, int i) {
        String fecha, idTransaccion, descripcion, entrada, salida, stock;
        fecha = new Controles().formatFechaString(d.getFecha());
        idTransaccion = String.valueOf(d.getIdTransaccion());
        descripcion = "Eliminación de venta";
        entrada = String.valueOf(d.getCantidad());
        salida = "";
        stock = String.valueOf(d.getCantidad() + Integer.parseInt(String.valueOf(this.jtKardex.getValueAt(i - 1, 5))));

        String[] lista = new String[6];
        lista[0] = fecha;
        lista[1] = idTransaccion;
        lista[2] = descripcion;
        lista[3] = entrada;
        lista[4] = salida;
        lista[5] = stock;
        this.modelo.addRow(lista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtKardex = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        cbProductos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        btnCargar = new javax.swing.JButton();
        tfStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Kardex");

        jtKardex.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "idTransaccion", "Descripción", "Entrada", "Salida", "Stock"
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
        jScrollPane1.setViewportView(jtKardex);
        if (jtKardex.getColumnModel().getColumnCount() > 0) {
            jtKardex.getColumnModel().getColumn(1).setResizable(false);
        }

        btnActualizar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnActualizar.setText("Refrescar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        cbProductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbProductosMouseClicked(evt);
            }
        });
        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Producto");

        tfNombre.setEditable(false);
        tfNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        btnCargar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCargar.setText("Generar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        tfStock.setEditable(false);
        tfStock.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Stock");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnActualizar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17)
                        .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargar)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar)
                .addGap(15, 15, 15))
        );

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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.cargarProductos();
            this.generarTabla();
            this.almacen.setlDetalle(this.mSQL.descargarDetalle());
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed
        this.acbProd();
    }//GEN-LAST:event_cbProductosActionPerformed

    private void cbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbProductosMouseClicked

    }//GEN-LAST:event_cbProductosMouseClicked

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.llenarKardex();
        }
    }//GEN-LAST:event_btnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JComboBox<Producto> cbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtKardex;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfStock;
    // End of variables declaration//GEN-END:variables
}
