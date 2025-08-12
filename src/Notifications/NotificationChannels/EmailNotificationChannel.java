package Notifications.NotificationChannels;


import Notifications.Notifiers.EmailNotifier;

public class EmailNotificationChannel implements NotificationChannel {
    private final EmailNotifier emailNotifier   ;
    private final String        email           ;



    public EmailNotificationChannel(EmailNotifier emailNotifier, String email) {
        this.emailNotifier  =   emailNotifier   ;
        this.email          =   email           ;
    }



    @Override
    public void update(String title, String message) {
        this.emailNotifier.sendEmail(this.email, title, message);
    }
}
