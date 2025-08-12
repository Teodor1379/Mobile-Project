package Menu.CommandsUser;



import Menu.Command;

import Users.User;
import Users.UserService;



import java.util.Map    ;
import java.util.HashMap;
import java.util.TreeMap;



public class ShwUserCommand implements Command {
    private final UserService userServ;

    public ShwUserCommand(UserService userServ) {
        this.userServ   =   userServ;
    }



    @Override
    public Boolean execute() {
        Map<String, User> persons = this.userServ.getUserRepository().getStorage();

        for (User user : persons.values()) {
            System.out.println(user.getUserName());
        }

        return true;
    }



    @Override
    public String help() {
        return "SHW_USER";
    }
}
