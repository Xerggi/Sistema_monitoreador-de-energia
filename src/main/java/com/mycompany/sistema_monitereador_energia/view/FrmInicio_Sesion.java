
package com.mycompany.sistema_monitereador_energia.view;

import com.mycompany.sistema_monitereador_energia.factory.UsuarioRepositoryFactory;
import com.mycompany.sistema_monitereador_energia.model.DatabaseType;
import com.mycompany.sistema_monitereador_energia.model.Usuario;
import com.mycompany.sistema_monitereador_energia.repository.MySQLUsuarioRepository;
import com.mycompany.sistema_monitereador_energia.repository.PostgreSQLUsuarioRepository;
import com.mycompany.sistema_monitereador_energia.repository.TxtUsuarioRepository;
import com.mycompany.sistema_monitereador_energia.repository.UsuarioRepository;
import com.mycompany.sistema_monitereador_energia.repository.UsuarioRepositoryPostgre;
import com.mycompany.sistema_monitereador_energia.service.UsuarioService;
import com.mycompany.sistema_monitereador_energia.view.FrmRegistro_usuario;
import com.mycompany.sistema_monitereador_energia.view.FrmSistema_monitoreo;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;


public class FrmInicio_Sesion extends javax.swing.JFrame {

    private final UsuarioService usuarioService;
    
    public FrmInicio_Sesion() {
        initComponents();
        //CREO QUE FALTAN AGREGAR LAS OTRAS BASES DE DATOS
        
        DatabaseType tipoBaseDatos = DatabaseType.MYSQL;
        usuarioService = UsuarioService.getInstance(UsuarioRepositoryFactory.getRepository(tipoBaseDatos));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtcontrasena = new javax.swing.JPasswordField();
        btnregistrousuario = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btniniciarsesion1 = new javax.swing.JButton();
        cmbDatabaseType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(73, 181, 172));

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SISTEMA DE ENERGIA ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel2)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 500));

        jPanel2.setBackground(new java.awt.Color(33, 45, 62));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Iniciar Sesión");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 230, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE USUARIO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONTRASEÑA");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(33, 45, 62));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(null);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 270, 30));

        txtcontrasena.setBackground(new java.awt.Color(33, 45, 62));
        txtcontrasena.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtcontrasena.setForeground(new java.awt.Color(255, 255, 255));
        txtcontrasena.setBorder(null);
        txtcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontrasenaActionPerformed(evt);
            }
        });
        jPanel2.add(txtcontrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 270, 40));

        btnregistrousuario.setBackground(new java.awt.Color(73, 181, 172));
        btnregistrousuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnregistrousuario.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrousuario.setText("REGISTRARSE");
        btnregistrousuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnregistrousuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistrousuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrousuarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnregistrousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 110, 40));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 330, 20));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 320, 20));

        btniniciarsesion1.setBackground(new java.awt.Color(73, 181, 172));
        btniniciarsesion1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btniniciarsesion1.setForeground(new java.awt.Color(255, 255, 255));
        btniniciarsesion1.setText("INGRESAR");
        btniniciarsesion1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btniniciarsesion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btniniciarsesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarsesion1ActionPerformed(evt);
            }
        });
        jPanel2.add(btniniciarsesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, 40));

        cmbDatabaseType.setBackground(new java.awt.Color(73, 181, 172));
        cmbDatabaseType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MySQL", "PostgreSQL", "TextFile", " " }));
        cmbDatabaseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDatabaseTypeActionPerformed(evt);
            }
        });
        jPanel2.add(cmbDatabaseType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 430, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaActionPerformed

    private void btnregistrousuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrousuarioActionPerformed
        FrmRegistro_usuario frmregis = new FrmRegistro_usuario();
        frmregis.setVisible(true);
        frmregis.setLocationRelativeTo(this);
                
    }//GEN-LAST:event_btnregistrousuarioActionPerformed

    private void btniniciarsesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarsesion1ActionPerformed
        String nombre = txtUsuario.getText();
        String contrasena = new String(txtcontrasena.getPassword());
        
        
        if (nombre.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
        //(this, "Por favor, complete todos los campos.");
        return; 
    }   
        
        //eliminar en caso de error
 
         //Map<String, DatabaseType> dbTypeMap = Map.of(
        //"MySQL", DatabaseType.MYSQL,
        //"PostgreSQL", DatabaseType.POSTGRESQL,
        //"TextFile", DatabaseType.TEXTFILE
        //); 
        //String selectedDb = (String) cmbDatabaseType.getSelectedItem();
        //FUNCION LAMBDA
        //DatabaseType dbType;
        //switch (selectedDb) {
        //case "MySQL" -> dbType = DatabaseType.MYSQL;
        //case "PostgreSQL" -> dbType = DatabaseType.POSTGRESQL;
        //case "TextFile" -> dbType = DatabaseType.TEXTFILE;
        //default -> {
          //  JOptionPane.showMessageDialog(this, "Tipo de base de datos no válido.");
           // return;
        //}
    //}
        //ELIMINAR EN CASO DE ERROR
         //DatabaseType dbType = dbTypeMap.getOrDefault(selectedDb, null);
           // if (dbType == null) {
            //JOptionPane.showMessageDialog(this, "Tipo de base de datos no válido.");
            //return;
        //}
    
        //UsuarioRepository usuarioRepo = UsuarioRepositoryFactory.getRepository(dbType);
        //UsuarioService usuarioService = UsuarioService.getInstance(usuarioRepo);
        
        
        
        try {
            //********************************************************************//
        //boolean usuarioValido = usuarioService.validarUsuario(nombre, contrasena);
        boolean sesionIniciada = usuarioService.iniciarSesion(nombre, contrasena);
        
        if (sesionIniciada) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
            FrmSistema_monitoreo frmsis = new FrmSistema_monitoreo();
            frmsis.setNombreUsuario(nombre);
            frmsis.setVisible(true);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al validar usuario: " + e.getMessage());
    }  
    }//GEN-LAST:event_btniniciarsesion1ActionPerformed

    private void cmbDatabaseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDatabaseTypeActionPerformed
        
         //Map<String, DatabaseType> dbTypeMap = Map.of(
        //"MySQL", DatabaseType.MYSQL,
        //"PostgreSQL", DatabaseType.POSTGRESQL,
        //"TextFile", DatabaseType.TEXTFILE
        //);

        String selectedDb = (String) cmbDatabaseType.getSelectedItem();
        DatabaseType dbType;
        switch (selectedDb) {
            case "MySQL" -> dbType = DatabaseType.MYSQL;
            case "PostgreSQL" -> dbType = DatabaseType.POSTGRESQL;
            case "TextFile" -> dbType = DatabaseType.TEXTFILE;
            default -> throw new IllegalArgumentException("Tipo de base de datos no válido");
        }
            
        UsuarioRepository usuarioRepo = UsuarioRepositoryFactory.getRepository(dbType);
        UsuarioService usuarioService = UsuarioService.getInstance(usuarioRepo);
        
    }//GEN-LAST:event_cmbDatabaseTypeActionPerformed
    
    
    
    public void limpiar(){
        txtUsuario.setText("");
        txtcontrasena.setText("");
    }
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
            java.util.logging.Logger.getLogger(FrmInicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio_Sesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btniniciarsesion1;
    private javax.swing.JButton btnregistrousuario;
    private javax.swing.JComboBox<String> cmbDatabaseType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtcontrasena;
    // End of variables declaration//GEN-END:variables
}
