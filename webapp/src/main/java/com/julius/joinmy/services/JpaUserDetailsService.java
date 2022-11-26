package com.julius.joinmy.services;

import com.julius.joinmy.models.dao.IUsuarioDao;
import com.julius.joinmy.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class JpaUserDetailsService implements UserDetailsService {

    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        UserDetails user = User.builder().username(usuario.getUsername()).password(usuario.getPassword())
                .disabled(!usuario.getEnabled()).authorities(usuario.getAuthority()).build();


        return user;
    }

    @Autowired
    public void setUsuarioDao(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
