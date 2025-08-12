package Menu.CommandsUser;



import Menu.Command;

import Users.User;
import Users.UserService;



public class AddUserCommand implements Command {
    private final UserService   userServ;
    private final User          userInst;



    public AddUserCommand(UserService userServ, User userInst) {
        this.userServ   =   userServ;
        this.userInst   =   userInst;
    }



    @Override
    public Boolean execute() {
        if (this.userServ.getUser(userInst.getUserName()) != null) {
            return false;
        }

        this.userServ.addUser(userInst);

        return true;
    }



    @Override
    public String help() {
        return "ADD_USER";
    }
}
