package com.damyan.TECHSOCI.service;

import com.damyan.TECHSOCI.dbo.UserDBO;
import com.damyan.TECHSOCI.repository.UserRepository;
import com.damyan.TECHSOCI.model.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserSecurityDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDBO user = userRepository.findByEmail(email);

        if(user != null) {
            return new SecurityUserDetails(user);
        }
        else {
            throw new UsernameNotFoundException("User with this email and password was not found");
        }
    }


}
