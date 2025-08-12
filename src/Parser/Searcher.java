package Parser;



import Listings.Listing;


import java.util.List       ;
import java.util.ArrayList  ;



public interface Searcher {
    List<Listing> search(List<Listing> listings, String query);
}
