package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.DetalleTransaccion;
import modelo.Producto;
import modelo.Venta;
import utilidades.Controles;
import utilidades.Jop;
import utilidades.Qr;

public class FrmVenta extends IntFrm {

    private DefaultTableModel modelo;

    public FrmVenta(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.generarTabla();
        this.vaciarTodo();
    }

    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    public void setId() {
        this.id.setText(String.valueOf(this.mSQL.ultimoIdVenta() + 1));
    }

    public void setFecha() {
        this.tfFecha.setText(new Controles().formatFechaString(LocalDateTime.now()));
    }

    private void generarTabla() {
        this.modelo = (DefaultTableModel) this.jtVenta.getModel();
        this.jtVenta.setModel(this.modelo);
    }

    // Metodo para vaciar los text fields relacionados con producto
    private void vaciarProducto() {
        this.cbProductos.setSelectedItem(null);
        this.tfPrecio.setText("");
        this.tfCantidad.setText("");
        this.tfNombreProd.setText("");
        this.tfStock.setText("");
    }

    private void vaciarTodo() {
        this.vaciarProducto();
        this.cbClientes.setSelectedItem(null);
        this.tfNombre.setText("");
    }

    public void cargarProductos() {
        this.cbProductos.removeAllItems();
        for (int i = 0; i < this.almacen.getlProductos().size(); i++) {
            this.cbProductos.addItem(this.almacen.getlProductos().get(i));
        }
        this.vaciarProducto();
    }

    public void cargarClientes() {
        this.cbClientes.removeAllItems();
        for (int i = 0; i < this.almacen.getlClientes().size(); i++) {
            this.cbClientes.addItem(this.almacen.getlClientes().get(i).getCi());
        }
        this.vaciarTodo();
    }

    private void cargarTotal() {
        int filas = this.jtVenta.getRowCount();
        double total = 0;
        for (int i = 0; i < filas; i++) {
            total = Double.parseDouble(String.valueOf(this.jtVenta.getValueAt(i, 2)))
                    * Double.parseDouble(String.valueOf(this.jtVenta.getValueAt(i, 3))) + total;
        }
        this.tfTotal.setText(String.valueOf(total));
    }

    private void eliminarP() {
        int fila = this.jtVenta.getSelectedRow();
        if (fila >= 0) {
            this.getModelo().removeRow(fila);
            this.cargarTotal();
        }
    }

    private boolean generarVenta() {
        Controles c = new Controles();
        int fila = this.jtVenta.getRowCount();
        if (!c.vacio(this.tfFecha.getText()) && this.cbClientes.getSelectedItem() != null) {
            if (fila > 0) {
                Cliente p = null;
                for (int i = 0; i < this.almacen.getlClientes().size(); i++) {
                    if (this.cbClientes.getSelectedItem().equals(this.almacen.getlClientes().get(i).getCi())) {
                        p = this.almacen.getlClientes().get(i);
                    }
                }

                if (new Venta().crearVenta(this.almacen, this.mSQL, p, this.tfTotal.getText(),
                        this.tfFecha.getText())) {
                    return true;
                }
            } else {
                new Jop().mensaje("Debe ingresar al menos un producto");
            }
        } else {
            new Jop().mensaje("Campos vacíos");
        }
        return false;
    }

    private void generarDetalleCompra(int idCompra) {
        int filas = this.jtVenta.getRowCount();
        int restock = 0;
        String codigoProducto = "";
        for (int i = 0; i < filas; i++) {
            String codProd = String.valueOf(this.jtVenta.getValueAt(i, 0));
            int cantidad = Integer.parseInt(String.valueOf(this.jtVenta.getValueAt(i, 2)));
            for (int j = 0; j < this.almacen.getlProductos().size(); j++) {
                if (codProd.equals(this.almacen.getlProductos().get(j).getCodigo())) {
                    Producto producto = this.almacen.getlProductos().get(j);
                    codigoProducto = producto.getCodigo();
                    restock = producto.getStock() - cantidad;
                }
            }
            Double precio = Double.valueOf(String.valueOf(this.jtVenta.getValueAt(i, 3)));
            if (new DetalleTransaccion().crearDetalle(this.almacen, this.mSQL, idCompra, codProd, cantidad,
                    precio, 2, this.tfFecha.getText())) {
                this.mSQL.updateInt("productos", "stock", restock, "codigo", codigoProducto);
                
                System.out.println("Se creo");
            } else {
                System.out.println("No se creo");
            }
        }
    }

    public boolean controlarStock(String cantidad, int stock) {
        return Integer.parseInt(cantidad) <= stock;
    }

    // Metodo para agregar producto a la tabla
    public void agregarProducto() {
        Controles c = new Controles();
        String cod, nombre, cantidad, precio;
        Double subtotal;
        nombre = (String) this.tfNombreProd.getText();
        cantidad = (String) this.tfCantidad.getText();
        precio = (String) this.tfPrecio.getText();
        if (c.vacio(cantidad) || c.vacio(precio) || this.cbProductos.getSelectedItem() == null) {
            new Jop().mensaje("Campos de producto vacíos");
        } else if (c.numerosM(cantidad) && c.decimal(precio)) {
            double precioF = Double.parseDouble(precio);
            int filas = this.jtVenta.getRowCount();
            Producto p = (Producto) this.cbProductos.getSelectedItem();
            int stock = p.getStock();
            if (this.controlarStock(cantidad, stock)) {
                cod = p.getCodigo();
                int cont = 0;
                int posicion = 0;
                for (int i = 0; i < filas; i++) {
                    if (cod.equals(String.valueOf(this.jtVenta.getValueAt(i, 0)))) {
                        int cantidadTabla = Integer.parseInt(String.valueOf(this.jtVenta.getValueAt(i, 2)));
                        if (precio.equals(String.valueOf(this.jtVenta.getValueAt(i, 3)))
                                && (cantidadTabla + Integer.parseInt(cantidad)) <= stock && precioF < 1000000) {
                            int cantidadv = Integer.parseInt(String.valueOf(this.jtVenta.getValueAt(posicion, 2)));
                            cantidad = (Integer.parseInt(cantidad) + cantidadv) + "";
                            subtotal = (precioF * Double.parseDouble(cantidad));
                            this.modelo.setValueAt(cantidad, posicion, 2);
                            this.modelo.setValueAt(subtotal, posicion, 4);
                            this.cargarTotal();
                            this.vaciarProducto();
                        } 
                        if (!precio.equals(String.valueOf(this.jtVenta.getValueAt(i, 3)))) {
                            new Jop().mensaje("El producto ya esta agregado y debe tener el mismo precio");
                        } 
                        if ((cantidadTabla + Integer.parseInt(cantidad)) <= stock) {
                            new Jop().mensaje("La cantidad a vender supera el stock");
                        }
                        if (precioF >= 1000000) {
                            new Jop().mensaje("El precio no puede ser mayor o igual al millón");
                        }
                        cont++;
                    }
                }
                if (cont == 0) {
                    if (precioF < 1000000) {
                        subtotal = Double.valueOf(precio) * Double.valueOf(cantidad);
                        String[] lista = new String[5];
                        lista[0] = cod;
                        lista[1] = nombre;
                        lista[2] = cantidad;
                        lista[3] = precio;
                        lista[4] = String.valueOf(subtotal);
                        this.modelo.addRow(lista);
                        this.cargarTotal();
                        this.vaciarProducto();
                    } else {
                        new Jop().mensaje("El precio no puede ser mayor o igual al millón");
                    }
                }
            } else {
                new Jop().mensaje("La cantidad a vender supera el stock");
            }
        } else {
            new Jop().mensaje("La cantidad debe ser entero mayor que cero y el precio decimal con punto");
        }
    }

    private void acbCliente() {
        if (this.cbClientes.getSelectedItem() != null) {
            String nombre = "";
            for (int i = 0; i < this.almacen.getlClientes().size(); i++) {
                if (this.cbClientes.getSelectedItem().equals(this.almacen.getlClientes().get(i).getCi())) {
                    nombre = this.almacen.getlClientes().get(i).toString();
                }
            }
            this.tfNombre.setText(nombre);
        }
    }

    private void acbProd() {
        Producto p = (Producto) this.cbProductos.getSelectedItem();
        if (p != null) {
            this.tfNombreProd.setText(p.getNombre());
            this.tfStock.setText(String.valueOf(p.getStock()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbClientes = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfFecha = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbProductos = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfPrecio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        tfCantidad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVenta = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfNombreProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfStock = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 0));
        id.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 60, 40));

        btnGenerar.setBackground(new java.awt.Color(153, 153, 153));
        btnGenerar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerar.setText("Generar venta");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 140, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cliente:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        cbClientes.setBackground(new java.awt.Color(255, 255, 255));
        cbClientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbClientes.setForeground(new java.awt.Color(0, 0, 0));
        cbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientesActionPerformed(evt);
            }
        });
        jPanel1.add(cbClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Fecha:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, -1));

        tfFecha.setBackground(new java.awt.Color(255, 255, 255));
        tfFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfFecha.setForeground(new java.awt.Color(0, 0, 0));
        tfFecha.setCaretColor(new java.awt.Color(0, 0, 0));
        tfFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFechaActionPerformed(evt);
            }
        });
        tfFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFechaKeyTyped(evt);
            }
        });
        jPanel1.add(tfFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 160, -1));

        tfTotal.setEditable(false);
        tfTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTotal.setForeground(new java.awt.Color(0, 0, 0));
        tfTotal.setCaretColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(tfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 134, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(153, 153, 153));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar producto");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("AGREGAR PRODUCTO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Código:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        cbProductos.setBackground(new java.awt.Color(255, 255, 255));
        cbProductos.setForeground(new java.awt.Color(0, 0, 0));
        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });
        jPanel1.add(cbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 92, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cantidad:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Precio:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        tfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        tfPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        tfPrecio.setCaretColor(new java.awt.Color(0, 0, 0));
        tfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecioActionPerformed(evt);
            }
        });
        tfPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(tfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 120, -1));

        btnAgregar.setBackground(new java.awt.Color(153, 153, 153));
        btnAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 97, 20));

        tfCantidad.setBackground(new java.awt.Color(255, 255, 255));
        tfCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCantidad.setForeground(new java.awt.Color(0, 0, 0));
        tfCantidad.setCaretColor(new java.awt.Color(0, 0, 0));
        tfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCantidadActionPerformed(evt);
            }
        });
        tfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(tfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 90, -1));

        jtVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtVenta.setForeground(new java.awt.Color(0, 0, 0));
        jtVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codProducto", "Nombre", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVenta.setOpaque(false);
        jScrollPane2.setViewportView(jtVenta);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 750, 193));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Stock:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        tfNombre.setEditable(false);
        tfNombre.setBackground(new java.awt.Color(255, 255, 255));
        tfNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNombre.setForeground(new java.awt.Color(0, 0, 0));
        tfNombre.setCaretColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 210, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("TOTAL:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));

        tfNombreProd.setEditable(false);
        tfNombreProd.setBackground(new java.awt.Color(255, 255, 255));
        tfNombreProd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNombreProd.setForeground(new java.awt.Color(0, 0, 0));
        tfNombreProd.setCaretColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(tfNombreProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 134, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("VENTA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("#");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 20, 40));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nombre:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        tfStock.setEditable(false);
        tfStock.setBackground(new java.awt.Color(255, 255, 255));
        tfStock.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfStock.setForeground(new java.awt.Color(0, 0, 0));
        tfStock.setCaretColor(new java.awt.Color(0, 0, 0));
        tfStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStockActionPerformed(evt);
            }
        });
        jPanel1.add(tfStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            if (this.generarVenta()) {
                int ultimoId = this.mSQL.ultimoIdVenta();
                this.generarDetalleCompra(ultimoId);
                this.vaciarTodo();
                this.modelo.setRowCount(0);
                this.almacen.setlCompras(this.mSQL.descargarCompras());
                this.almacen.setlDetalle(this.mSQL.descargarDetalle());
                this.almacen.setlProductos(this.mSQL.descargarProductos());
                this.cargarProductos();
                this.setId();
                this.setFecha();
            }
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void cbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientesActionPerformed
        this.acbCliente();
    }//GEN-LAST:event_cbClientesActionPerformed

    private void tfFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFechaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminarP();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed
        this.acbProd();
    }//GEN-LAST:event_cbProductosActionPerformed

    private void tfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecioActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.agregarProducto();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCantidadActionPerformed

    private void tfStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStockActionPerformed

    private void tfFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFechaKeyTyped
        if (this.tfFecha.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_tfFechaKeyTyped

    private void tfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCantidadKeyTyped
        if (this.tfCantidad.getText().length() >= 6) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCantidadKeyTyped

    private void tfPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecioKeyTyped
        if (this.tfPrecio.getText().length() >= 9) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_tfPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGenerar;
    public javax.swing.JComboBox<String> cbClientes;
    public javax.swing.JComboBox<modelo.Producto> cbProductos;
    public javax.swing.JLabel id;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jtVenta;
    public javax.swing.JTextField tfCantidad;
    public javax.swing.JTextField tfFecha;
    public javax.swing.JTextField tfNombre;
    public javax.swing.JTextField tfNombreProd;
    public javax.swing.JTextField tfPrecio;
    public javax.swing.JTextField tfStock;
    public javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
