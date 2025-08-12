package Listings;



import Notifications.NotificationService;



import java.util.List       ;
import java.util.ArrayList  ;


public class ListingService {
    private final ListingRepository     listingRepository   ;
    private final NotificationService   notificationService ;



    public ListingService(ListingRepository listingRepository, NotificationService notificationService) {
        this.listingRepository      =   listingRepository   ;
        this.notificationService    =   notificationService ;
    }



    public ListingRepository getListingRepository() {
        return this.listingRepository;
    }



    public void addListing(Listing listing) {
        if (this.listingRepository.fndListing(listing.getTitle()) == null) {
            System.out.println("Hello World 1");
            this.listingRepository  .addListing         (listing);
            this.notificationService.onNewListingAdded  (listing);
        }
    }

    public void remListing(String title) {
        if (this.listingRepository.fndListing(title) != null) {
            this.listingRepository.remListing(title);
        }
    }

    public Listing getListing(String title) {
        return this.listingRepository.fndListing(title);
    }

    public void updListing(Listing listing) {
        if (this.listingRepository.fndListing(listing.getTitle()) == null) {
            this.listingRepository.addListing(listing);
        }

        this.listingRepository.updListing(listing);
    }


    public List<Listing> getListingsAll() {
        return this.listingRepository.getStorage().values().stream().toList();
    }



    public List<Listing> getListingsOwner(String owner) {
        return this.listingRepository.getStorage().values().stream().filter(listing -> listing.hasOwner() && listing.getOwner().equals(owner)).toList();
    }

    public List<Listing> getListingsBuyer(String buyer) {
        return this.listingRepository.getStorage().values().stream().filter(listing -> listing.hasBuyer() && listing.getBuyer().equals(buyer)).toList();
    }



    public List<Listing> getListingHistory(String title) {
        return this.listingRepository.getHistory(title);
    }
};
