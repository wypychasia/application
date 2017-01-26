package company.license.manager.application.service;

import company.license.manager.application.data.AvalibleProducts;
import company.license.manager.application.data.Code;
import company.license.manager.application.data.Product;
import company.license.manager.application.data.ProgramModule;
import company.license.manager.application.repository.CodeRepository;
import company.license.manager.application.repository.ModuleRepository;
import company.license.manager.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wypychasia on 21.01.2017.
 */
@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public ModuleRepository moduleRepository;
    @Autowired
    public CodeRepository codeRepository;

    public List<Product> checkProductsOwnership(String userName) {
        List<Product> productsName = productRepository.getProductData(userName);
        for (Product p: productsName) {
            List<ProgramModule> list = moduleRepository.getModuleData(p.getProductId());
            p.setProgramModules(list);
            List<Code> codeList = codeRepository.getCodeContent(p.getProductId());
            p.setCode(codeList);
        }
        return productsName;
    }
    public void updateStations(String userName)
    {
        productRepository.updateStations(userName);
    }
    public void updateProductData(Product product, String userName)
    {
        productRepository.updateProductData(product, userName);
    }
    public List<AvalibleProducts> generate(){
        List<Double> productVersions = new ArrayList<>();
        List<AvalibleProducts> productList = new ArrayList<>();
        List<ProgramModule> mikromapModules = new ArrayList<>();
        List<ProgramModule> winkalkModules = new ArrayList<>();
        List<ProgramModule> operatModules = new ArrayList<>();

        productVersions.add(1.0);
        productVersions.add(1.5);
        productVersions.add(2.0);
        productVersions.add(3.0);
        productVersions.add(4.5);
        productVersions.add(4.0);

        mikromapModules.add(new ProgramModule("MikromapM1"));
        mikromapModules.add(new ProgramModule("MikromapM2"));
        mikromapModules.add(new ProgramModule("MikromapM3"));
        mikromapModules.add(new ProgramModule("MikromapM4"));
        mikromapModules.add(new ProgramModule("MikromapM5"));

        winkalkModules.add(new ProgramModule("WinkalkM1"));
        winkalkModules.add(new ProgramModule("WinkalkM2"));
        winkalkModules.add(new ProgramModule("WinkalkM3"));
        winkalkModules.add(new ProgramModule("WinkalkM4"));
        AvalibleProducts mikromap = new AvalibleProducts("Mikromap", productVersions, mikromapModules);
        AvalibleProducts winkalk = new AvalibleProducts("Winkalk", productVersions,winkalkModules);
        AvalibleProducts operat = new AvalibleProducts("Operat", productVersions,operatModules);

        productList.add(mikromap);
        productList.add(winkalk);
        productList.add(operat);
        return productList;
    }
}
