package edu.secourse.patientportal.pmbackend.service;

import edu.secourse.patientportal.pmbackend.model.User;
import edu.secourse.patientportal.pmbackend.repository.UserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String role = user.getRole();

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_" + role)
        );
    }
}