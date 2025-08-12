package Users;



import java.util.Map    ;
import java.util.HashMap;
import java.util.TreeMap;



public interface UserRepository {
    void    addUser(User    user    );  // Create
    void    remUser(String  userName);  // Delete
    void    updUser(User    user    );  // Update
    User    fndUser(String  userName);  // Read


    Map<String, User> getStorage();
}
