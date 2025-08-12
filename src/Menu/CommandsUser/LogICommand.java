package Menu.CommandsUser;



import Menu.Command;

import Users.User       ;
import Users.UserService;



public class LogICommand implements Command {
    private final UserService   userServ;
    private final String        username;
    private final String        password;



    public LogICommand(UserService userServ, String username, String password) {
        this.userServ   =   userServ;
        this.username   =   username;
        this.password   =   password;
    }



    public String   getUsername ()  { return this.username  ;   }
    public String   getPassword ()  { return this.password  ;   }



    @Override
    public Boolean execute() {
        User user = this.userServ.getUser(username);

        if (user == null) {
            return false;
        }

        return user.valPasswd(this.password);
    }



    @Override
    public String help() {
        return "LGI_USER";
    }
}
