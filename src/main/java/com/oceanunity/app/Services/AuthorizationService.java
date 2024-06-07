package com.oceanunity.app.Services;

import com.oceanunity.app.Exceptions.ObjectNotFoundException;
import com.oceanunity.app.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = usuarioRepository.findByEmail(username);
        if(user != null){
            return user;
        }
        throw new ObjectNotFoundException("Usuario");
    }
}
