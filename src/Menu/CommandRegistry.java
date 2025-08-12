package Menu;



public class CommandRegistry {
    private Command command;



    public CommandRegistry setCommand(Command command) {
        this.command = command;

        return this;
    }

    public Boolean executeCommand() {
        return this.command.execute();
    }

    public Command getCommand() {
        return this.command;
    }
}
