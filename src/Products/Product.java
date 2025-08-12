package Products;



public abstract class Product {
    protected String    name;
    protected String    desc;
    protected String    numb;


    public Product(String name, String desc, String numb) {
        if (    !this.valName(name) ||
                !this.valDesc(desc) ||
                !this.valNumb(numb)
        ) {
            throw new IllegalArgumentException("Invalid Product Arguments!");
        }

        this.name   =   name;
        this.desc   =   desc;
        this.numb   =   numb;
    }



    public String   getName()   { return this.name; }
    public String   getDesc()   { return this.desc; }
    public String   getNumb()   { return this.numb; }



    public void setName(String  name)   { if (!valName(name)) { throw new IllegalArgumentException("Invalid Name Argument!");   }   this.name = name; }
    public void setDesc(String  desc)   { if (!valDesc(desc)) { throw new IllegalArgumentException("Invalid Desc Argument!");   }   this.desc = desc; }
    public void setNumb(String  numb)   { if (!valNumb(numb)) { throw new IllegalArgumentException("Invalid Numb Argument!");   }   this.numb = numb; }



    private Boolean valName(String name )   { return name != null && !name.isEmpty();   }
    private Boolean valDesc(String desc )   { return desc != null && !desc.isEmpty();   }
    private Boolean valNumb(String numb )   { return numb != null && !numb.isEmpty();   }
}
