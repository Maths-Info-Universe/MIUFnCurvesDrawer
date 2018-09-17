/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer;

import miu.fncurvesdrawer.controllers.MiuFncdStartupController;
import miu.fncurvesdrawer.models.MiuFncdStartupModel;
import miu.fncurvesdrawer.models.util.MiuFncdModelModel;
import miu.fncurvesdrawer.util.MIUConfigManager;
import miu.fncurvesdrawer.util.exception.MIUApplException;
import miu.fncurvesdrawer.views.MiuFncdStartupView;

/**
 *
 * @author Ndadji Maxime
 */
public class MIUFnCurvesDrawer {
    public static void main(String[] args){
        MIUConfigManager config = null;
        try{
            config = new MIUConfigManager();
        }catch(MIUApplException e){
            MiuFncdModelModel.displayModalErrorDialog("Arrêt brusque"
                    + " de l'application", "L'application a rencontré un problème et va s'arrêter."
                    + "\nVeuillez contacter un développeur pour régler ce problème.");
            System.exit(0);
        }
        MiuFncdStartupModel model = new MiuFncdStartupModel(config);
        MiuFncdStartupController controller = new MiuFncdStartupController(model);
        MiuFncdStartupView view = new MiuFncdStartupView(controller, config);
    }
}
