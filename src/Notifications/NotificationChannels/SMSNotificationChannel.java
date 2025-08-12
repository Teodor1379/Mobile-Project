package Notifications.NotificationChannels;


import Notifications.Notifiers.SMSNotifier;

public class SMSNotificationChannel implements NotificationChannel {
    private final SMSNotifier notifier;
    private final String        phoneNum;



    public SMSNotificationChannel(SMSNotifier notifier, String phoneNum) {
        this.notifier   =   notifier;
        this.phoneNum   =   phoneNum;
    }



    @Override
    public void update(String title, String message) {
        this.notifier.sendSMS(this.phoneNum, title + '\n' + message);
    }
}
