package company.license.manager.application.data;

import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by wypychasia on 25.01.2017.
 */
public class AvalibleProducts {

    public String productName;
    public List<Double> avalibleVersions;
    public List<ProgramModule> avalibleModules;
    public String productInfo= "       Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis.\n" +
            "            Maecenas malesuada elit lectus felis, malesuada ultricies. Curabitur et ligula.\n" +
            "            Ut molestie a, ultricies porta urna. Vestibulum commodo volutpat a, convallis ac, laoreet enim.\n" +
            "            Phasellus fermentum in, dolor. Pellentesque facilisis. Nulla imperdiet sit amet magna.\n" +
            "            Vestibulum dapibus, mauris nec malesuada fames ac turpis velit, rhoncus eu, luctus et interdum adipiscing wisi.\n" +
            "            Aliquam erat ac ipsum. Integer aliquam purus.Quisque lorem tortor fringilla sed, vestibulum id,\n" +
            "            eleifend justo vel bibendum sapien massa ac turpis faucibus orci luctus non, consectetuer lobortis quis,\n" +
            "            varius in, purus. Integer ultrices posuere cubilia Curae, Nulla ipsum dolor lacus, suscipit adipiscing.";

    public AvalibleProducts(String productName, List<Double> avalibleVersions, List<ProgramModule> avalibleModules){
        this.productName = productName;
        this.avalibleModules = avalibleModules;
        this.avalibleVersions = avalibleVersions;
    }

}
