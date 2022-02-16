package com.sofka.usuario.crudUsuario.repositories;

import java.util.ArrayList;

import com.sofka.usuario.crudUsuario.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}