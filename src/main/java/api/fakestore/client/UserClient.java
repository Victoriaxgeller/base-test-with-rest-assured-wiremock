package api.fakestore.client;

import api.common.BaseApiClient;
import api.fakestore.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserClient extends BaseApiClient {

    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    public User getUserById() {
        return new User();
    }

    public List<User> getLimitedUsers(int limit) {
        return new ArrayList<>();
    }

    public User addNewUser() {
        return new User();
    }

    public User updateUser() {
        return new User();
    }

    public User deleteUser() {
        return new User();
    }

}
