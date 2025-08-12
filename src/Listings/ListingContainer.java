package Listings;



import java.util.Map    ;
import java.util.HashMap;

import java.util.List       ;
import java.util.ArrayList  ;



public class ListingContainer implements ListingRepository {
    private final Map<String, ListingOriginator>    mapO;
    private final Map<String, ListingCaretaker>     mapC;


    public ListingContainer() {
        this.mapO   = new HashMap<>();
        this.mapC   = new HashMap<>();
    }



    @Override
    public List<Listing> getHistory(String title) {
        return this.mapC.get(title).getHistory();
    }



    @Override
    public void addListing(Listing listing) {
        ListingOriginator   lO = new ListingOriginator  (listing);
        ListingCaretaker    lC = new ListingCaretaker   (       );

        lC.add(lO.saveMemento());

        this.mapO.put(listing.getTitle(), lO);
        this.mapC.put(listing.getTitle(), lC);
    }



    @Override
    public void remListing(String title) {
        this.mapO.remove(title);
        this.mapC.remove(title);
    }



    @Override
    public void updListing(Listing listing) {
        this.mapC.get(listing.getTitle()).add(this.mapO.get(listing.getTitle()).saveMemento());
    }



    @Override
    public Listing fndListing(String title) {
        if (this.mapO.get(title) == null) {
            return null;
        }

        return this.mapO.get(title).getListing();
    }



    @Override
    public Map<String, Listing> getStorage() {
        Map<String, Listing> result = new HashMap<>();

        for (ListingOriginator current : this.mapO.values()) {
            result.put(current.getListing().getTitle(), current.getListing());
        }

        return result;
    }
};
