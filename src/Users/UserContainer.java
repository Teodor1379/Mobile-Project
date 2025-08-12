package Users;



import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;



public class UserContainer implements UserRepository {
    private final Map<String, User> map;



    public UserContainer() {
        this.map = new HashMap<>();
    }



    @Override
    public void addUser(User user) {
        this.map.put(user.getUserName(), user);
    }



    @Override
    public void remUser(String userName) {
        this.map.remove(userName);
    }



    @Override
    public void updUser(User user) {
        this.map.put(user.getUserName(), user);
    }



    @Override
    public User fndUser(String userName) {
        return this.map.get(userName);
    }



    @Override
    public Map<String, User> getStorage() {
        return this.map;
    }
}
