package Notifications.NotificationChannels;


import Notifications.Notifiers.PigeonNotifier;

public class PigeonNotificationChannel implements NotificationChannel {
    private final PigeonNotifier notifier;
    private final String            address ;



    public PigeonNotificationChannel(PigeonNotifier notifier, String address) {
        this.notifier   =   notifier;
        this.address    =   address ;
    }



    @Override
    public void update(String title, String message) {
        this.notifier.sendPigeon(this.address, 666, title + '\n' + message);
    }
}
