package Menu.CommandsList;




import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;



import java.util.List       ;
import java.util.ArrayList  ;



public class EdtListingCommand implements Command {
    private final ListingService    listingServ ;
    private final Double            price       ;
    private final String            title       ;
    private final String            descrip     ;
    private final String            category    ;



    public EdtListingCommand(ListingService listingServ, Double price, String title, String descrip, String category) {
        this.listingServ    =   listingServ;

        this.price      =   price   ;
        this.title      =   title   ;
        this.descrip    =   descrip ;
        this.category   =   category;
    }



    @Override
    public Boolean execute() {
        Listing listing = this.listingServ.getListing(title);

        if (listing == null) {
            return false;
        }

        List<Listing> history = this.listingServ.getListingHistory(this.title);

        for (Listing current : history) {
            System.out.println(current);
        }

        listing.setPrice    (price  );
        listing.setDescript (descrip);
        listing.setCategory (category);

        this.listingServ.updListing(listing);

        return true;
    }



    @Override
    public String help() {
        return "EDT_LISTING";
    }
}
