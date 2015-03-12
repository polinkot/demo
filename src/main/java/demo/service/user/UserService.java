package demo.service.user;

import demo.domain.User;
import demo.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    User create(UserCreateForm form);

}
