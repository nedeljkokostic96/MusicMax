package com.musicmax.demo.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicmax.demo.repository.ClientRepository;

import model.Client;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
   	private ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    	
        Client client = clientRepository.findByEmail(email)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + email)
        );

        return UserPrinciple.build(client);
    }
}