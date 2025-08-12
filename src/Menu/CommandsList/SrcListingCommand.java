package Menu.CommandsList;



import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;

import Parser.QuerySearcher;


import java.util.List       ;
import java.util.ArrayList  ;



public class SrcListingCommand implements Command {
    private final ListingService        listingServ;
    private final String                queryListng;



    public SrcListingCommand(ListingService listingServ, String queryListng) {
        this.listingServ    =   listingServ;
        this.queryListng    =   queryListng;
    }



    @Override
    public Boolean execute() {
        QuerySearcher querySearcher = new QuerySearcher();

        List<Listing> listings = querySearcher.search(listingServ.getListingsAll(), queryListng);

        for (Listing listing : listings) {
            System.out.println(listing);
        }

        return true;
    }



    @Override
    public String help() {
        return "SRC_LISTING";
    }
}
