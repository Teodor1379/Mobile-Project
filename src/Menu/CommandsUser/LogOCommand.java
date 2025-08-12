package Menu.CommandsUser;



import Menu.Command;



public class LogOCommand implements Command {
    private final String userName   ;



    public LogOCommand(String userName) {
        this.userName = userName;
    }



    @Override
    public Boolean execute() {
        System.out.println("Logging out " + this.userName + "...");

        return true;
    }



    @Override
    public String help() {
        return "LGO_USER";
    }
}
