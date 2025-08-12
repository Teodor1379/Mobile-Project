package Notifications;



import Filters.Filter;

import Listings.Listing;
import Notifications.NotificationChannels.NotificationChannel;



public class NotificationRule {
    private final Filter<Listing>       filter  ;
    private final NotificationChannel channel ;



    public NotificationRule(Filter<Listing> filter, NotificationChannel channel) {
        this.filter     =   filter  ;
        this.channel    =   channel ;
    }



    public Filter<Listing>      getFilter   () { return this.filter ;   }
    public NotificationChannel  getChannel  () { return this.channel;   }
}
