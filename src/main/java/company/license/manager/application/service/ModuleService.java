package company.license.manager.application.service;

import company.license.manager.application.data.ProgramModule;
import company.license.manager.application.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wypychasia on 22.01.2017.
 */
@Service
public class ModuleService {

    @Autowired
    public ModuleRepository moduleRepository;

    public List<ProgramModule> getModules(int productId) {
        List<ProgramModule> productsName = moduleRepository.getModuleData(productId);

        return productsName;
    }
}
