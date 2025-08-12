package Menu.CommandsList;



import Menu.Command;

import Listings.Listing         ;
import Listings.ListingService  ;



import java.util.List       ;
import java.util.ArrayList  ;

import java.util.Map    ;
import java.util.HashMap;

import java.util.stream.Collectors;



public class StatsListingCommand implements Command {
    private final ListingService    listingService;



    public StatsListingCommand(ListingService listingService) {
        this.listingService =   listingService;
    }



    @Override
    public Boolean execute() {
        List<Listing> listings = this.listingService.getListingsAll();

        Map<Integer, Double> averageMap = listings.stream()
                .collect(Collectors.groupingBy(
                        Listing::getYear,
                        Collectors.averagingDouble(Listing::getPrice)
                ));

        averageMap.forEach((year, price) ->
                System.out.println("From year" + year + " the price is: " + price)
        );

        return true;
    }



    @Override
    public String help() {
        return "STS_LISTING";
    }
}
