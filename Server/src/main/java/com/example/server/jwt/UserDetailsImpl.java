package com.example.server.jwt;

import com.example.server.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * A class that implements the UserDetails interface.
 * This class is used to get the user details from the token.
 * We need this class because jwt expects a UserDetails object. Consider this as a wrapper class.
 */
public class UserDetailsImpl implements UserDetails {

    private UserDTO userDTO;

    public UserDetailsImpl(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDetailsImpl() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDTO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getRole() {
        return userDTO.getRole();
    }
}
