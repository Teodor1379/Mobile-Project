package Listings;



public class ListingOriginator {
    private Listing listing;



    public ListingOriginator(Listing listing) {
        this.listing = listing;
    }



    public Listing getListing() {
        return this.listing;
    }


    public void setListing(Listing listing) {
        this.listing = listing;
    }



    public ListingMemento saveMemento() {
        return new ListingMemento(this.listing.clone());
    }

    public void revcMemento(ListingMemento memento) {
        this.listing = memento.getSnapshot();
    }
}
