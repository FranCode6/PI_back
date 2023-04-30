package com.proyecto.ap.services;

import com.proyecto.ap.exception.UserNotFoundException;
import com.proyecto.ap.models.Usuario;
import com.proyecto.ap.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    public final UsuarioRepo usuarioRepo;

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Usuario addUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> buscarUsuario(){
        return usuarioRepo.findAll();
    }

    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public Usuario findUsuarioById(Long id){
        return usuarioRepo.findById(id).orElseThrow(()->new UserNotFoundException("Usuario no encontrado"));
    }
}
