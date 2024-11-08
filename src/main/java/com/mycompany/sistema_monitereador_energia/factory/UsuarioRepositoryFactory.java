
package com.mycompany.sistema_monitereador_energia.factory;

import com.mycompany.sistema_monitereador_energia.model.DatabaseType;
import com.mycompany.sistema_monitereador_energia.repository.MySQLUsuarioRepository;
import com.mycompany.sistema_monitereador_energia.repository.PostgreSQLUsuarioRepository;
import com.mycompany.sistema_monitereador_energia.repository.TxtUsuarioRepository;
import com.mycompany.sistema_monitereador_energia.repository.UsuarioRepository;


public class UsuarioRepositoryFactory {
    public static UsuarioRepository getRepository(DatabaseType dbType) {
        return switch (dbType) {
            case MYSQL -> new MySQLUsuarioRepository();
            case POSTGRESQL -> new PostgreSQLUsuarioRepository();
            case TEXTFILE -> new TxtUsuarioRepository();
        };
    }
}
