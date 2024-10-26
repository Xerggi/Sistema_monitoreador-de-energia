
package com.mycompany.sistema_monitereador_energia;

import com.mycompany.sistema_monitereador_energia.util.DatabaseConnection;
import com.mycompany.sistema_monitereador_energia.view.FrmInicio_Sesion;
 // import com.mycompany.sistema_monitereador_energia.view.FrmSistema_monitoreo;
import java.sql.Connection;
import java.sql.SQLException;


public class Sistema_monitereador_energia {

    public static void main(String[] args) {
 
        
        FrmInicio_Sesion frmini = new FrmInicio_Sesion();
        frmini.setVisible(true);
        frmini.setLocationRelativeTo(null);
        
        
        
    }
}
