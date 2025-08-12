package Menu.CommandsUser;


import Menu.Command;



public class ExitCommand implements Command {

    @Override
    public Boolean execute() {
        return true;
    }


    @Override
    public String help() {
        return "EXT_USER";
    }
}
