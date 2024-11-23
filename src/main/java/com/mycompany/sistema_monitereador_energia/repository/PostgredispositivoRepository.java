
package com.mycompany.sistema_monitereador_energia.repository;

import com.mycompany.sistema_monitereador_energia.factory.DatabaseConnection;
import com.mycompany.sistema_monitereador_energia.model.DatabaseType;
import java.sql.Connection;
import java.sql.SQLException;


public class PostgredispositivoRepository extends DispositivoRepositoryPostgre{

    @Override
    protected Connection getConnection() throws SQLException {
         return DatabaseConnection.getConnection(DatabaseType.POSTGRESQL);
    }
    
}
