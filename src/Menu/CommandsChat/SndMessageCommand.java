package Menu.CommandsChat;



import Menu.Command;

import Users.User       ;
import Users.UserService;



public class SndMessageCommand implements Command {
    private final UserService   userServ;

    private final   String    userS;
    private final   String    userR;
    private final   String    messg;



    public SndMessageCommand(UserService userServ, String userS, String userR, String messg) {
        this.userServ   =   userServ;

        this.userS  =   userS;
        this.userR  =   userR;
        this.messg  =   messg;
    }



    @Override
    public Boolean execute() {
        User userSend = this.userServ.getUser(userS);
        User userRecv = this.userServ.getUser(userR);

        if (userSend == null || userRecv == null) {
            return false;
        }

        if (userSend.getUserName().equals(userRecv.getUserName())) {
            return false;
        }

        userSend.sendMessage(userRecv, messg);

        return true;
    }



    @Override
    public String help() {
        return "SND_MESS";
    }
}
