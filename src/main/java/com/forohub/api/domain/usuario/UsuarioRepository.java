package com.forohub.api.domain.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    UserDetails findByEmail(String username);
}
