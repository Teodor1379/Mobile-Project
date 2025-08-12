package Users;



public class UserService {
    private final UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public UserRepository getUserRepository() {
        return this.userRepository;
    }



    public void addUser(User user) {
        if (this.userRepository.fndUser(user.getUserName()) == null) {
            this.userRepository.addUser(user);
        }
    }

    public void remUser(String userName) {
        if (this.userRepository.fndUser(userName) != null) {
            this.userRepository.remUser(userName);
        }
    }

    public void updUser(User user) {
        if (this.userRepository.fndUser(user.getUserName()) == null) {
            this.userRepository.addUser(user);
        }

        this.userRepository.updUser(user);
    }

    public User getUser(String userName) {
        return this.userRepository.fndUser(userName);
    }
}
