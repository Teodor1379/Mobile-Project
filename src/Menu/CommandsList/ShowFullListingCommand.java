package Menu.CommandsList;



import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;



import java.util.List       ;
import java.util.ArrayList  ;



public class ShowFullListingCommand implements Command {
    private final ListingService    listingService;



    public ShowFullListingCommand(ListingService listingService) {
        this.listingService = listingService;
    }



    @Override
    public Boolean execute() {
        List<Listing> listings = this.listingService.getListingsAll();

        for (Listing listing : listings) {
            System.out.println(listing);
        }

        return true;
    }


    @Override
    public String help() {
        return "SWF_LISTING";
    }
}
