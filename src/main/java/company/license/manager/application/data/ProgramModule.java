package company.license.manager.application.data;

/**
 * Created by wypychasia on 22.01.2017.
 */
public class ProgramModule {

    public String moduleName;
    public boolean moduleStatus;
    public int programID;

    public ProgramModule(String moduleName, int programID){
        this.moduleName = moduleName;
        this.programID =programID;
    }
    public ProgramModule(String moduleName){
        this.moduleName = moduleName;
    }

    public String getModuleNameName(){return moduleName;}

    public void setModuleName(String moduleName){this.moduleName = moduleName;}

    public boolean getModuleStatus(){return moduleStatus;}

    public void setModuleStatus(boolean moduleStatus){this.moduleStatus=moduleStatus;}
}
