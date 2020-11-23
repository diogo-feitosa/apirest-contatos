package com.contatos.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private PasswordEncoder enconder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(!username.equals("diogo")){
            throw new UsernameNotFoundException("Usuário não encontrado na base.");
        }
		
		return User
				.builder()
				.username("diogo")
				.password(enconder.encode("123"))
			    .roles("ADMIN","USER")
				.build();
	}

}
