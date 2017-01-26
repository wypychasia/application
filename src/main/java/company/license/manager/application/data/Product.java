package company.license.manager.application.data;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * Created by wypychasia on 21.01.2017.
 */
public class Product {
    public String productName;
    public double productVersion;
    public int productId;
    public List<ProgramModule> programModules;
    public List<Code> programCodes;
    public int stations;
    public int companyID;

    public Product(String productName, double productVersion, int productId, int stations)
    {
        this.productName = productName;
        this.productVersion = productVersion;
        this.productId =productId;
        this.stations = stations;
    }

    public Product(String productName){
        this.productName = productName;
    }
    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public double getProductVersion(){return productVersion;}

    public void setProductId(int productId){this.productId = productId;}

    public int getProductId(){return productId;}

    public List<ProgramModule> getProgramModules(){return programModules;}

    public void setProgramModules(List<ProgramModule> programModules){this.programModules=programModules;}

    public void setProgramModules(int productId){
        List<ProgramModule> programModules = new ArrayList<>();
        ProgramModule p = new ProgramModule("Nie ma modulow", productId);
        programModules.add(p);
        this.programModules = programModules;
    }

    public void setCode(List<Code> code){this.programCodes=code;}

    public List<Code> getCode(){return programCodes;}

    public void setProductVersion(double productVersion){this.productVersion=productVersion;}

    public void setStations(int stations){this.stations = stations;}

    public int getStations(){return stations;}

    public void setCompanyID(int companyID){this.companyID =companyID;}

    public int getCompanyID(){return companyID;}
}
