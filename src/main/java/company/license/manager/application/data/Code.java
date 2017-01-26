package company.license.manager.application.data;

/**
 * Created by wypychasia on 24.01.2017.
 */
public class Code {

    public String codeContent;
    public int productID;
    public int stationID;

    public Code(String codeContent){
        this.codeContent =codeContent;
    }
    public Code(String codeContent, int productID, int stationID){
        this.codeContent = codeContent;
        this.productID = productID;
        this.stationID= stationID;
    }

    public void setCode(String codeContent){this.codeContent=codeContent;}

    public String getCode(){return codeContent;}

    public void setProductID(int productID){this.productID = productID;}

    public int getProductID(){return productID;}

    public void setStationID(int stationID){this.stationID= stationID;}

    public int getStationID(){return stationID;}
}
