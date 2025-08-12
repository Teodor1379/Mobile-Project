package Products;



import java.util.Objects;



public class Service extends Product {
    private String  dataInfo;
    private String  dataTime;
    private String  dataCond;



    public Service(String name, String desc, String numb, String dataInfo, String dataTime, String dataCond) {
        super(name, desc, numb);

        if (    !this.valDataInfo(dataInfo) ||
                !this.valDataTime(dataTime) ||
                !this.valDataCond(dataCond)
        ) {
            throw new IllegalArgumentException("Invalid Service Arguments!");
        }

        this.dataInfo   =   dataInfo;
        this.dataTime   =   dataTime;
        this.dataCond   =   dataCond;
    }



    public String   getDataInfo()   { return this.dataInfo  ;   }
    public String   getDataTime()   { return this.dataTime  ;   }
    public String   getDataCond()   { return this.dataCond  ;   }



    public void setDataInfo(String dataInfo)    { if (!this.valDataInfo(dataInfo)) { throw new IllegalArgumentException("Invalid DataInfo Argument!");  }   this.dataInfo = dataInfo; }
    public void setDataTime(String dataTime)    { if (!this.valDataTime(dataTime)) { throw new IllegalArgumentException("Invalid DataTime Argument!");  }   this.dataTime = dataTime; }
    public void setDataCond(String dataCond)    { if (!this.valDataCond(dataCond)) { throw new IllegalArgumentException("Invalid DataCond Argument!");  }   this.dataCond = dataCond; }



    private Boolean valDataInfo(String dataInfo)    { return dataInfo != null && !dataInfo.isEmpty();   }
    private Boolean valDataTime(String dataTime)    { return dataTime != null && !dataTime.isEmpty();   }
    private Boolean valDataCond(String dataCond)    { return dataCond != null && !dataCond.isEmpty();   }



    @Override
    public String toString() {
        return  "Service [ "    +
                this.name       +   " " +
                this.desc       +   " " +
                this.numb       +   " " +
                this.dataInfo   +   " " +
                this.dataTime   +   " " +
                this.dataCond           +
                "]";
    }



    @Override
    public int hashCode() {
        return Objects.hash(
                this.name       ,   this.desc       ,   this.numb       ,
                this.dataInfo   ,   this.dataTime   ,   this.dataCond
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

        if (!(object instanceof Service other)) {
            return false;
        }

        return  other.name      .equals(this.name       )   &&
                other.desc      .equals(this.desc       )   &&
                other.numb      .equals(this.numb       )   &&
                other.dataInfo  .equals(this.dataInfo   )   &&
                other.dataTime  .equals(this.dataTime   )   &&
                other.dataCond  .equals(this.dataCond   );
    }
}
