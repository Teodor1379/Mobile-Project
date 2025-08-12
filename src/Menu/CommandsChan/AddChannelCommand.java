package Menu.CommandsChan;



import Menu.Command;

import Notifications.Notifiers.*            ;
import Notifications.NotificationChannels.* ;

import Users.User       ;
import Users.UserService;



public class AddChannelCommand implements Command {
    private final UserService userServ;
    private final String      userName;
    private final String      chanName;



    public AddChannelCommand(UserService userServ, String userName, String chanName) {
        this.userServ   =   userServ;
        this.userName   =   userName;
        this.chanName   =   chanName;
    }



    @Override
    public Boolean execute() {
        User user = this.userServ.getUser(this.userName);

        NotificationChannel rule;

        switch (this.chanName) {
            case "email"    :   rule = new EmailNotificationChannel(new EmailNotifier(), user.getEmail   ());    break;
            case "pigeon"   :   rule = new PigeonNotificationChannel(new PigeonNotifier(), user.getPhone   ());    break;
            case "sms"      :   rule = new SMSNotificationChannel(new SMSNotifier(), user.getAddress ());    break;

            default         :   return false;
        }

        this.userServ.getUser(this.userName).addNotificationRule(rule);

        return true;
    }



    @Override
    public String help() {
        return "ADD_CHANNEL";
    }
}
