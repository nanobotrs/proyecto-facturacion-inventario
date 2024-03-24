package vista;

import almacen.Almacen;
import dataBase.ConexionBD;
import dataBase.MetodosSQL;
import java.awt.event.KeyEvent;
import utilidades.Controles;

public class FrmLogin extends Frm {

    public FrmLogin(Almacen almacen, MetodosSQL mSQL) {
        super(almacen, mSQL);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getRootPane().setDefaultButton(btnIniciar);
        this.ocultar.setVisible(false);
    }

    private FrmLogin() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ocultar = new javax.swing.JLabel();
        ver = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pwdClave = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesión");
        setBackground(new java.awt.Color(51, 51, 51));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2KeyReleased(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-ocultar-25.png"))); // NOI18N
        ocultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocultarMouseClicked(evt);
            }
        });
        jPanel2.add(ocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, -1));

        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-ver-25 (1).png"))); // NOI18N
        ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMouseClicked(evt);
            }
        });
        jPanel2.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuario.setBorder(null);
        txtUsuario.setCaretColor(new java.awt.Color(0, 0, 0));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 200, 30));

        pwdClave.setBackground(new java.awt.Color(255, 255, 255));
        pwdClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pwdClave.setForeground(new java.awt.Color(0, 0, 0));
        pwdClave.setBorder(null);
        pwdClave.setCaretColor(new java.awt.Color(0, 0, 0));
        pwdClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdClaveActionPerformed(evt);
            }
        });
        pwdClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pwdClaveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwdClaveKeyTyped(evt);
            }
        });
        jPanel2.add(pwdClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 200, 30));

        btnIniciar.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciar.setText("Login");
        btnIniciar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnIniciarFocusGained(evt);
            }
        });
        btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarMouseEntered(evt);
            }
        });
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        btnIniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIniciarKeyPressed(evt);
            }
        });
        jPanel2.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 156, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-llave-40.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-usuario-masculino-en-círculo-40.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoFinal.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && btnIniciar.hasFocus()) {
            btnIniciar.doClick();
        }
    }//GEN-LAST:event_jPanel2KeyReleased

    private void btnIniciarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIniciarKeyPressed

    }//GEN-LAST:event_btnIniciarKeyPressed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if (ConexionBD.netIsAvailable()) {
            this.almacen.setlUsuarios(mSQL.descargarUsuarios());
            new Controles().controlarLogin(super.getmSQL(), super.getAlmacen(), txtUsuario.getText(), pwdClave.getText(), this);
            this.almacen.setlUsuarios(mSQL.descargarUsuarios());
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarMouseEntered

    private void btnIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseClicked

    }//GEN-LAST:event_btnIniciarMouseClicked

    private void btnIniciarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnIniciarFocusGained

    }//GEN-LAST:event_btnIniciarFocusGained

    private void pwdClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdClaveKeyTyped
        if (this.pwdClave.getText().length() >= 25) {
            evt.consume();
        }
    }//GEN-LAST:event_pwdClaveKeyTyped

    private void pwdClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdClaveKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (ConexionBD.netIsAvailable()) {
                this.almacen.setlUsuarios(mSQL.descargarUsuarios());
                new Controles().controlarLogin(super.getmSQL(), super.getAlmacen(), txtUsuario.getText(), pwdClave.getText(), this);
                this.almacen.setlUsuarios(mSQL.descargarUsuarios());
            }
        }
    }//GEN-LAST:event_pwdClaveKeyReleased

    private void pwdClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdClaveActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        if (this.txtUsuario.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (ConexionBD.netIsAvailable()) {
                this.almacen.setlUsuarios(mSQL.descargarUsuarios());
                new Controles().controlarLogin(super.getmSQL(), super.getAlmacen(), txtUsuario.getText(), pwdClave.getText(), this);
                this.almacen.setlUsuarios(mSQL.descargarUsuarios());
            }
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void verMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMouseClicked
        this.ver.setVisible(false);
        this.ocultar.setVisible(true);
        this.pwdClave.setEchoChar((char) 0);
    }//GEN-LAST:event_verMouseClicked

    private void ocultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocultarMouseClicked
        this.ver.setVisible(true);
        this.ocultar.setVisible(false);
        this.pwdClave.setEchoChar('●');
    }//GEN-LAST:event_ocultarMouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped


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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel ocultar;
    private javax.swing.JPasswordField pwdClave;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel ver;
    // End of variables declaration//GEN-END:variables
}
