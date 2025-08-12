package Notifications;



import Listings.Listing;

import Products.Car;



import java.util.List       ;
import java.util.ArrayList  ;


public class NotificationService {
    private final List<NotificationRule> rules;



    public NotificationService() {
        this.rules = new ArrayList<>();
    }



    public void subscribe(NotificationRule rule) {
        this.rules.add(rule);
    }



    public void onNewListingAdded(Listing listing) {
        for (NotificationRule rule : this.rules) {
            if (rule.getFilter().matches(listing)) {
                Car car = (Car) listing.getProduct();

                String message =    car.getBrand()
                        + " "   +   car.getModel()
                        + " "   +   listing.getPrice();

                rule.getChannel().update("New car found for you!", message);
            }
        }
    }
}
