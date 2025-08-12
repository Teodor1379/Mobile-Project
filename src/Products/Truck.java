package Products;



// Sample vehicle, which is different from car.
// If we want further extension of the vehicles,
// we should create an abstract class Vehicle,
// which inherits the Product class. Every one
// of the vehicles should inherit Vehicle class.



public class Truck extends Product {
    private String  brand       ;
    private String  model       ;
    private Integer capacityTons;



    public Truck(String name, String desc, String idnt, String brand, String model, Integer capacityTons) {
        super(name, desc, idnt);


        this.brand          =   brand       ;
        this.model          =   model       ;
        this.capacityTons   =   capacityTons;
    }



    public String   getBrand        ()  { return this.brand         ;   }
    public String   getModel        ()  { return this.model         ;   }
    public Integer  getCapacityTones()  { return this.capacityTons  ;   }



    public void setBrand        (String brand           )   { this.brand        =   brand           ;   }
    public void setModel        (String model           )   { this.model        =   model           ;   }
    public void setCapacityTons (Integer capacityTons   )   { this.capacityTons =   capacityTons    ;   }
}
