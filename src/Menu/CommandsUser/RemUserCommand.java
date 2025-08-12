package Menu.CommandsUser;



import Menu.Command;

import Users.UserService;



public class RemUserCommand implements Command {
    private final UserService   userServ;
    private final String        userName;



    public RemUserCommand(UserService userServ, String userName) {
        this.userServ   =   userServ;
        this.userName   =   userName;
    }



    @Override
    public Boolean execute() {
        this.userServ.remUser(userName);

        return true;
    }


    @Override
    public String help() {
        return "REM_USER";
    }
}
