package Products;



import java.util.Objects;



public class Part extends Product {
    private String  materials;
    private String  dimension;



    public Part(String name, String brand, String numb, String materials, String dimension) {
        super(name, brand, numb);

        if (    !this.valMaterials(materials)   ||
                !this.valDimension(dimension)
        ) {
            throw new IllegalArgumentException("Invalid Part Arguments!");
        }

        this.materials  =   materials;
        this.dimension  =   dimension;
    }



    public String   getMaterials()  { return this.materials;    }
    public String   getDimension()  { return this.dimension;    }



    public void setMaterials(String materials)  { if (!this.valMaterials(materials))    { throw new IllegalArgumentException("Invalid Materials Argument!"); }  this.materials = materials; }
    public void setDimension(String dimension)  { if (!this.valDimension(dimension))    { throw new IllegalArgumentException("Invalid Dimension Argument!"); }  this.dimension = dimension; }



    private Boolean valMaterials(String materials)  { return materials != null  && !materials.isEmpty();    }
    private Boolean valDimension(String dimension)  { return dimension != null  && !dimension.isEmpty();    }



    @Override
    public String toString() {
        return  "Part [ "       +
                this.name       +   " " +
                this.desc       +   " " +
                this.numb       +   " " +
                this.materials  +   " " +
                this.dimension          +
                "]";
    }



    @Override
    public int hashCode() {
        return Objects.hash(
                this.name, this.desc, this.numb,
                this.materials,
                this.dimension
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

        if (!(object instanceof Part other)) {
            return false;
        }

        return  other.name      .equals(this.name       )   &&
                other.desc      .equals(this.desc       )   &&
                other.numb      .equals(this.numb       )   &&
                other.materials .equals(this.materials  )   &&
                other.dimension .equals(this.dimension  );
    }
}
