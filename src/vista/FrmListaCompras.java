package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.DetalleTransaccion;
import utilidades.Controles;
import utilidades.Jop;

public class FrmListaCompras extends IntFrm {

    private DefaultTableModel modelo;

    public FrmListaCompras(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.generarTabla();
    }

    private void generarTabla() {
        this.modelo = (DefaultTableModel) this.jtFactura.getModel();
        this.jtFactura.setModel(this.modelo);
    }

    public void llenarfCompras() {
        this.modelo.setRowCount(0);
        for (int i = 0; i < this.almacen.getlCompras().size(); i++) {
            String fecha, id, proveedor, total;
            proveedor = "";
            if (this.almacen.getlCompras().get(i).getEstado() == 0) {
                Compra compra = this.almacen.getlCompras().get(i);
                fecha = String.valueOf(new Controles().formatFechaString(compra.getFecha()));
                id = String.valueOf(compra.getId());
                for (int j = 0; j < this.almacen.getlProveedores().size(); j++) {
                    if (compra.getRucProveedor().equals(this.almacen.getlProveedores().get(j).getRuc())) {
                        proveedor = this.almacen.getlProveedores().get(j).getNombre();
                    }
                }
                total = String.valueOf(compra.getTotal());

                String[] lista = new String[4];
                lista[0] = fecha;
                lista[1] = id;
                lista[2] = proveedor;
                lista[3] = total;
                this.modelo.addRow(lista);
            }
        }
    }

    public void eliminarCompra() {
        int fila = this.jtFactura.getSelectedRow();
        if (fila >= 0) {
            int idCompra = Integer.parseInt(String.valueOf(this.jtFactura.getValueAt(fila, 1)));
            for (int i = 0; i < this.almacen.getlCompras().size(); i++) {
                if (idCompra == this.almacen.getlCompras().get(i).getId()) {
                    this.mSQL.updateInt("compras", "estado", 1, "id", String.valueOf(idCompra));
                    this.restock(this.almacen.getlCompras().get(i));
                    this.modelo.removeRow(fila);
                }
            }
        } else {
            new Jop().mensaje("Seleccione una venta");
        }
    }

    public void restock(Compra compra) {
        for (int i = 0; i < this.almacen.getlDetalle().size(); i++) {
            if (this.almacen.getlDetalle().get(i).getTipo() == 1
                    && this.almacen.getlDetalle().get(i).getIdTransaccion() == compra.getId()) {
                String codProducto = this.almacen.getlDetalle().get(i).getCodigoProd();
                for (int j = 0; j < this.almacen.getlProductos().size(); j++) {
                    if (codProducto.equals(this.almacen.getlProductos().get(j).getCodigo())) {
                        int restock = this.almacen.getlProductos().get(j).getStock() - this.almacen.getlDetalle().get(i).getCantidad();
                        this.mSQL.updateInt("productos", "stock", restock, "codigo", codProducto);
                        this.crearDetalle(this.almacen.getlDetalle().get(i), codProducto,
                                this.almacen.getlDetalle().get(i).getCantidad(), this.almacen.getlDetalle().get(i).getPrecio());
                    }
                }
            }
        }
    }

    public boolean crearDetalle(DetalleTransaccion d, String codigoProducto, int cantidad, Double precio) {
        return this.mSQL.insertDetalle(d.getIdTransaccion(), codigoProducto, cantidad, precio, 3, new Controles().formatFechaString(LocalDateTime.now()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFactura = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("LISTADO DE COMPRAS");

        jtFactura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Número de factura", "Proveedor", "Precio total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtFactura);

        btnActualizar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnActualizar.setText("Refrescar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(47, 47, 47)
                        .addComponent(btnActualizar)
                        .addGap(215, 215, 215)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.almacen.setlCompras(this.mSQL.descargarCompras());
            this.llenarfCompras();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.eliminarCompra();
            this.almacen.setlDetalle(mSQL.descargarDetalle());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtFactura;
    // End of variables declaration//GEN-END:variables
}
