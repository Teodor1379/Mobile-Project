package Listings;



public class ListingMemento {
    private final Listing snapshot;



    public ListingMemento(Listing listing) {
        this.snapshot = listing;
    }



    public Listing getSnapshot() {
        return this.snapshot;
    }
}
