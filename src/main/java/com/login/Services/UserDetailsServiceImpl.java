package com.login.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.Model.Admin;
import com.login.Repositry.AdminRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.getUserByEmail(username);
        if (admin == null) {
            throw new UsernameNotFoundException("Oho! User not found!");
        }
        return new CustomeUserDetails(admin);
    }
}
