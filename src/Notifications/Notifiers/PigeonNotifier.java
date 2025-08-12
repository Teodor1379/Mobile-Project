package Notifications.Notifiers;



public class PigeonNotifier {
    public void sendPigeon(String address, Integer pigeonID, String message) {
        System.out.println("Sending pigeon to " + address + " with number " + pigeonID + " with message: " + message);
    }
}
