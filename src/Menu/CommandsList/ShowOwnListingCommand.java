package Menu.CommandsList;



import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;



import java.util.List       ;
import java.util.ArrayList  ;



public class ShowOwnListingCommand implements Command {
    private final ListingService    listServ;
    private final String            userName;



    public ShowOwnListingCommand(ListingService listServ, String userName) {
        this.listServ   =   listServ;
        this.userName   =   userName;
    }



    @Override
    public Boolean execute() {
        List<Listing> listings = this.listServ.getListingsOwner(this.userName);

        for (Listing listing : listings) {
            System.out.println(listing);
        }

        return true;
    }



    @Override
    public String help() {
        return "SHO_Listing";
    }
}
