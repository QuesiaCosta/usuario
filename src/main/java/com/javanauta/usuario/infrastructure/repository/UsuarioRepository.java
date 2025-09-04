package com.javanauta.usuario.infrastructure.repository;


import com.javanauta.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);



    @Service
    public class CustomUserDetailsService implements UserDetailsService {

        private final UsuarioRepository usuarioRepository;

        public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
            this.usuarioRepository = usuarioRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return usuarioRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        }
    }

    @Transactional
    void deleteByEmail(String email);


}


