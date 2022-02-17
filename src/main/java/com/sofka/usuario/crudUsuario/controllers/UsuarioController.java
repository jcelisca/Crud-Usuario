package com.sofka.usuario.crudUsuario.controllers;

import java.util.ArrayList;
import java.util.Optional;


import com.sofka.usuario.crudUsuario.models.UsuarioModel;
import com.sofka.usuario.crudUsuario.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorid(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/buscaNombre/{nombre}")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@PathVariable("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }

    @GetMapping(path = "/buscaPrioridad")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @GetMapping(path = "/buscaEmail")
    public ArrayList<UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("email") String email){
        return this.usuarioService.obtenerPorEmail(email);
    }

    @DeleteMapping(path = "/delete/{nombre}")
    public String eliminarUsuarioPorNombre(@PathVariable("nombre") String nombre){
        return usuarioService.eliminarUsuario(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con Id: "+ id;
        }else{
            return "No se pudo eliminar el usuario con Id: "+ id;
        }
    }
}
