package lk.example.backend.service.Impl;

import lk.example.backend.exception.UserNotFoundException;
import lk.example.backend.repository.UserRepository;
import lk.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepository.findByUsername(username)
                        .orElseThrow(()-> new UserNotFoundException("User Not found"));
    }
}
