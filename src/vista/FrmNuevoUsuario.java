package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import modelo.Usuarios;

public class FrmNuevoUsuario extends IntFrm {

    public FrmNuevoUsuario(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCrearUsuario = new javax.swing.JButton();
        tfNuevaClave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNuevoUsuario = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Creación de usuario");
        setPreferredSize(new java.awt.Dimension(335, 343));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrearUsuario.setBackground(new java.awt.Color(102, 102, 102));
        btnCrearUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setText("Crear usuario");
        btnCrearUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 238, 125, 33));

        tfNuevaClave.setBackground(new java.awt.Color(255, 255, 255));
        tfNuevaClave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNuevaClave.setForeground(new java.awt.Color(0, 0, 0));
        tfNuevaClave.setBorder(null);
        tfNuevaClave.setCaretColor(new java.awt.Color(0, 0, 0));
        tfNuevaClave.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfNuevaClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNuevaClaveKeyTyped(evt);
            }
        });
        jPanel1.add(tfNuevaClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 166, 202, 36));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nueva contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 137, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nuevo usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 36, -1, -1));

        tfNuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        tfNuevoUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNuevoUsuario.setForeground(new java.awt.Color(0, 0, 0));
        tfNuevoUsuario.setBorder(null);
        tfNuevoUsuario.setCaretColor(new java.awt.Color(0, 0, 0));
        tfNuevoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNuevoUsuarioActionPerformed(evt);
            }
        });
        tfNuevoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNuevoUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(tfNuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 65, 202, 36));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        if (ConexionBD.netIsAvailable()) {
            new Usuarios().crearUsuario(this.almacen, tfNuevoUsuario.getText(), tfNuevaClave.getText(), this.mSQL);
            tfNuevoUsuario.setText("");
            tfNuevaClave.setText("");
        }
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void tfNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNuevoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNuevoUsuarioActionPerformed

    private void tfNuevoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNuevoUsuarioKeyTyped
        if (this.tfNuevoUsuario.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_tfNuevoUsuarioKeyTyped

    private void tfNuevaClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNuevaClaveKeyTyped
        if (this.tfNuevaClave.getText().length() >= 22) {
            evt.consume();
        }
    }//GEN-LAST:event_tfNuevaClaveKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfNuevaClave;
    private javax.swing.JTextField tfNuevoUsuario;
    // End of variables declaration//GEN-END:variables
}
