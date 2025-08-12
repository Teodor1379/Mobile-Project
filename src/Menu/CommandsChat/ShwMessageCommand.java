package Menu.CommandsChat;



import Menu.Command;

import Users.User       ;
import Users.UserService;



import java.util.List       ;


public class ShwMessageCommand implements Command {
    private final UserService   userServ;
    private final String        userCurr;
    private final String        userOthr;



    public ShwMessageCommand(UserService userServ, String userCurr, String userOthr) {
        this.userServ   =   userServ;
        this.userCurr   =   userCurr;
        this.userOthr   =   userOthr;
    }



    @Override
    public Boolean execute() {
        User userCurr = this.userServ.getUser(this.userCurr);
        User userOthr = this.userServ.getUser(this.userOthr);

        if (userCurr == null || userOthr == null) {
            return false;
        }

        if (userCurr.getUserName().equals(userOthr.getUserName())) {
            return false;
        }

        List<String> chat = userCurr.viewMessages(this.userOthr);

        for (String message : chat) {
            System.out.println(message);
        }

        return true;
    }



    @Override
    public String help() {
        return "SHW_MESS";
    }
}
