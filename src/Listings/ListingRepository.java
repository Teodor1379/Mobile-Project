package Listings;



import java.util.Map    ;
import java.util.HashMap;
import java.util.TreeMap;

import java.util.List       ;
import java.util.ArrayList  ;



public interface ListingRepository {
    void    addListing(Listing  listing );  // Create
    void    remListing(String   title   );  // Delete
    void    updListing(Listing  listing );  // Update
    Listing fndListing(String   title   );  // Read


    List<Listing> getHistory(String title);

    Map<String, Listing> getStorage();
}
