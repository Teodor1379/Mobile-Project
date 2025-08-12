package Menu.CommandsList;



import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;



public class AddListingCommand implements Command {
    private final Listing               listing         ;
    private final ListingService        listingServ     ;
    private final String                identification  ;



    public AddListingCommand(Listing listing, ListingService listingServ, String identification) {
        this.listing        =   listing         ;
        this.listingServ    =   listingServ     ;
        this.identification =   identification  ;
    }



    @Override
    public Boolean execute() {
        this.listing.ownProduct(this.identification);

        this.listingServ.addListing(this.listing);

        return true;
    }



    @Override
    public String help() {
        return "ADD_LISTING";
    }
}
