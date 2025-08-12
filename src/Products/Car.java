package Products;



import java.util.Objects;



public class Car extends Product {
    protected String    brand   ;
    protected String    model   ;
    protected String    color   ;
    protected Integer   power   ;
    protected Integer   year    ;
    protected Boolean   manual  ;



    public Car(String name, String desc, String numb, String brand, String model, String color, Integer power, Integer year, Boolean manual) {
        super(name, desc, numb);

        if (    !this.valBrand(brand)   ||
                !this.valModel(model)   ||
                !this.valColor(color)   ||

                !this.valPower  (power  )   ||
                !this.valYear   (year   )
        ) {
            throw new IllegalArgumentException("Invalid Car Arguments!");
        }

        this.brand  =   brand   ;
        this.model  =   model   ;
        this.color  =   color   ;
        this.power  =   power   ;
        this.year   =   year    ;
        this.manual =   manual  ;
    }



    public String   getBrand    ()  { return this.brand ;   }
    public String   getModel    ()  { return this.model ;   }
    public String   getColor    ()  { return this.color ;   }
    public Integer  getPower    ()  { return this.power ;   }
    public Integer  getYear     ()  { return this.year  ;   }
    public Boolean  getManual   ()  { return this.manual;   }



    public void setBrand    (String brand)      { if (!this.valBrand(brand  ))  { throw new IllegalArgumentException("Invalid Brand Argument!");    }   this.brand    = brand ;   }
    public void setModel    (String model)      { if (!this.valModel(model  ))  { throw new IllegalArgumentException("Invalid Model Argument!");    }   this.model    = model ;   }
    public void setColor    (String color)      { if (!this.valColor(color  ))  { throw new IllegalArgumentException("Invalid Color Argument!");    }   this.color    = color ;   }
    public void setPower    (Integer power)     { if (!this.valPower(power  ))  { throw new IllegalArgumentException("Invalid Power Argument!");    }   this.power    = power ;   }
    public void setYear     (Integer year)      { if (!this.valYear (year   ))  { throw new IllegalArgumentException("Invalid Year  Argument!");    }   this.year     = year  ;   }
    public void setManual   (Boolean manual)    {                                                                                                       this.manual   = manual;   }



    private Boolean valBrand    (String brand)  { return brand != null  && !brand.isEmpty();    }
    private Boolean valModel    (String model)  { return model != null  && !model.isEmpty();    }
    private Boolean valColor    (String color)  { return color != null  && !color.isEmpty();    }

    private Boolean valPower    (Integer power  )   { return power  != null && power    > 0 ;   }
    private Boolean valYear     (Integer year   )   { return year   != null && year     > 0 ;   }



    @Override
    public String toString() {
        return  "Car ["     +
                this.name   +   " " +
                this.desc   +   " " +
                this.numb   +   " " +
                this.brand  +   " " +
                this.model  +   " " +
                this.color  +   " " +
                this.power  +   " " +
                this.year   +   " " +
                this.manual         +
                "]";
    }



    @Override
    public int hashCode() {
        return Objects.hash(
                this.name   , this.desc , this.numb ,
                this.brand  , this.model, this.color,
                this.power  , this.year , this.manual
        );
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (!(object instanceof Car other)) {
            return false;
        }

        return  other.name  .equals (this.name  )   &&
                other.desc  .equals (this.desc  )   &&
                other.numb  .equals (this.numb  )   &&
                other.brand .equals (this.brand )   &&
                other.model .equals (this.model )   &&
                other.color .equals (this.color )   &&
                other.power .equals (this.power )   &&
                other.year  .equals (this.year  )   &&
                other.manual.equals (this.manual);
    }
}
