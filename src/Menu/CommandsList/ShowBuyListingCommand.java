package Menu.CommandsList;



import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;



import java.util.List       ;
import java.util.ArrayList  ;



public class ShowBuyListingCommand implements Command {
    private final ListingService    listServ;
    private final String            userName;



    public ShowBuyListingCommand(ListingService listServ, String userName) {
        this.listServ   =   listServ;
        this.userName   =   userName;
    }



    @Override
    public Boolean execute() {
        List<Listing> listings = this.listServ.getListingsBuyer(userName);

        for (Listing listing : listings) {
            System.out.println(listing);
        }

        return true;
    }



    @Override
    public String help() {
        return "SHB_LISTING";
    }
}
