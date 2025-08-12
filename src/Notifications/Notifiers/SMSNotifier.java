package Notifications.Notifiers;



public class SMSNotifier {
    public void sendSMS(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + " with message: " + message);
    }
}
