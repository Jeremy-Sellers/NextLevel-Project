package com.personal.nextlevel.services;

import com.personal.nextlevel.models.User;
import com.personal.nextlevel.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
   private UserRepository userRepository;

   public UserPrincipalDetailsService(UserRepository userRepository){
       this.userRepository = userRepository;
   }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        UserPrincipal userPrincipal= new UserPrincipal(user);

        return userPrincipal;
    }
}
