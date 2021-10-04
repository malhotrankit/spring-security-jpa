package com.ankit.springsecurity.springsecurityjpa.security;

import com.ankit.springsecurity.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));
        System.out.println("abc   " + user.map(MyUserDetails::new).get().getUsername() + " " + user.map(MyUserDetails::new).get().getPassword());
        return user.map(MyUserDetails::new).get();
    }
}
