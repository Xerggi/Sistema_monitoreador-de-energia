
package com.mycompany.sistema_monitereador_energia.repository;

import com.mycompany.sistema_monitereador_energia.model.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TxtUsuarioRepository implements UsuarioRepository{
    
    private final String fileName = "usuarios.txt";
    private int currentId = 1;

    public TxtUsuarioRepository() {
        ensureFileExists(); 
        initializeIdCounter();
    }
    
    private void ensureFileExists() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void initializeIdCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    currentId = Math.max(currentId, id + 1); // Incrementa el ID automáticamente
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuario.setId(currentId++); 

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(usuario.getId() + "," + usuario.getNombre()+ "," + usuario.getContrasena()+ "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerUsuario(int id) {
         try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int usuarioId = Integer.parseInt(data[0]);
                if (usuarioId == id) {
                    return new Usuario(usuarioId, data[1], data[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public Usuario obtenerUsuarioNombre(String nombre) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(nombre)) {
                    int usuarioId = Integer.parseInt(data[0]);
                    return new Usuario(usuarioId, data[1], data[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no encuentra el usuario
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int usuarioId = Integer.parseInt(data[0]);
                usuarios.add(new Usuario(usuarioId, data[1], data[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        List<Usuario> usuarios = obtenerTodosLosUsuarios();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Usuario u : usuarios) {
                if (u.getId() == usuario.getId()) {
                    writer.write(usuario.getId() + "," + usuario.getNombre() + "," + usuario.getContrasena() + "\n");
                } else {
                    writer.write(u.getId() + "," + u.getNombre() + "," + u.getContrasena() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        List<Usuario> usuarios = obtenerTodosLosUsuarios();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Usuario u : usuarios) {
                if (u.getId() != id) {
                    writer.write(u.getId() + "," + u.getNombre() + "," + u.getContrasena() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   

    @Override
    public boolean validarUsuario(String nombre, String contrasena) {
         try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(nombre) && data[2].equals(contrasena)) {
                return true; // Usuario válido
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
    }

}
