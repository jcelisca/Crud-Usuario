package com.sofka.usuario.crudUsuario.services;

import java.util.ArrayList;
import java.util.Optional;


import com.sofka.usuario.crudUsuario.models.UsuarioModel;
import com.sofka.usuario.crudUsuario.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    public ArrayList<UsuarioModel> obtenerPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public String eliminarUsuario(String nombre){
        try{
            ArrayList<UsuarioModel> user = usuarioRepository.findByNombre(nombre);
            usuarioRepository.deleteAll(user);
            return "Se elimino el usuario: " + nombre;
        }catch(Exception err){
            return "El nombre de usuario no existe";
        }
    }

    public String eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return "Se elimino el usuario con Id: "+ id;
        }catch(Exception err){
            return "No se pudo eliminar el usuario con Id: "+ id;
        }
    }
}
