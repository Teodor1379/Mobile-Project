package Listings;


import Products.Product ;
import Products.Service ;
import Products.Car     ;
import Products.Part    ;



import java.util.Objects;

import java.time.LocalDateTime;



public class Listing {
    private final Product   product ;

    private Double          price   ;
    private String          title   ;
    private String          descript;
    private String          category;

    private String          owner   ;
    private String          buyer   ;

    private LocalDateTime   created;
    private LocalDateTime   updated;



    public Listing(Product product, Double price, String title, String descript, String category) {
        this.product    =   product             ;

        this.price      =   price               ;
        this.title      =   title               ;
        this.descript   =   descript            ;
        this.category   =   category            ;

        this.owner      =   null                ;
        this.buyer      =   null                ;

        this.created    =   LocalDateTime.now() ;
        this.updated    =   LocalDateTime.now() ;
    }



    public Product  getProduct  ()  { return this.product   ;   }
    public Double   getPrice    ()  { return this.price     ;   }
    public String   getTitle    ()  { return this.title     ;   }
    public String   getDescript ()  { return this.descript  ;   }
    public String   getCategory ()  { return this.category  ;   }

    public String   getOwner    ()  { return this.owner     ;   }
    public String   getBuyer    ()  { return this.buyer     ;   }

    public LocalDateTime    getCreated()    { return this.created;  }
    public LocalDateTime    getUpdated()    { return this.updated;  }



    public void setPrice    (Double price   )   { this.price    =   price   ;   this.updated = LocalDateTime.now()  ;   }
    public void setTitle    (String title   )   { this.title    =   title   ;   this.updated = LocalDateTime.now()  ;   }
    public void setDescript (String descript)   { this.descript =   descript;   this.updated = LocalDateTime.now()  ;   }
    public void setCategory (String category)   { this.category =   category;   this.updated = LocalDateTime.now()  ;   }



    public Integer getYear()    {
        Car car = (Car) this.product;

        return car.getYear();
    }



    public Boolean  hasOwner()  { return this.owner != null; }
    public Boolean  hasBuyer()  { return this.buyer != null; }



    public void ownProduct(String user) {
        if (this.hasOwner()) {
            return;
        }

        this.owner      =   user                ;
        this.updated    =   LocalDateTime.now() ;
    }


    public void buyProduct(String user) {
        if (this.hasBuyer()) {
            return;
        }

        this.buyer      =   user                ;
        this.updated    =   LocalDateTime.now() ;
    }



    public Listing clone() {
        Listing result = new Listing(this.product, this.price, this.title, this.descript, this.category);

        if (this.owner != null) { result.ownProduct(this.owner);    }
        if (this.buyer != null) { result.buyProduct(this.buyer);    }

        return result;
    }



    @Override
    public String toString() {
        return  this.updated            +   " " +
                "Listing ["             +
                this.product.toString() +   " " +
                this.price              +   " " +
                this.title              +   " " +
                this.descript           +   " " +
                this.category                   +
                "]";
    }



    // Helper Methods for Consistency...
    // If there are other products in the
    // application, the cast won't be here.

    public Service  getServ () { if (this.product instanceof Service) { return (Service ) this.product; } return null; }
    public Car      getCar  () { if (this.product instanceof Car    ) { return (Car     ) this.product; } return null; }
    public Part     getPart () { if (this.product instanceof Part   ) { return (Part    ) this.product; } return null; }
};
