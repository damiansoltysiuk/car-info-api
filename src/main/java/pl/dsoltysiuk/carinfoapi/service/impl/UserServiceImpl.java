package pl.dsoltysiuk.carinfoapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dsoltysiuk.carinfoapi.model.User;
import pl.dsoltysiuk.carinfoapi.repository.UserRepository;
import pl.dsoltysiuk.carinfoapi.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
