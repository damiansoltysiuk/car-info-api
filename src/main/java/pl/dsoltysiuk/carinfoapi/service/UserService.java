package pl.dsoltysiuk.carinfoapi.service;

import pl.dsoltysiuk.carinfoapi.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getSingleUserById(Long id);
}
