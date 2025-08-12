package Menu.CommandsList;



import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;



public class RemListingCommand implements Command {
    private final ListingService    listingServ;

    private final String    identificationList;
    private final String    identificationUser;



    public RemListingCommand(ListingService listingServ, String identificationList, String identificationUser) {
        this.listingServ    =   listingServ ;

        this.identificationList =   identificationList;
        this.identificationUser =   identificationUser;
    }



    @Override
    public Boolean execute() {
        Listing listing = listingServ.getListing(identificationList);

        if (listing == null || !listing.getOwner().equals(identificationUser)) {
            return false;
        }

        this.listingServ.remListing(this.identificationList);

        return true;
    }



    @Override
    public String help() {
        return "REM_LISTING";
    }
}
