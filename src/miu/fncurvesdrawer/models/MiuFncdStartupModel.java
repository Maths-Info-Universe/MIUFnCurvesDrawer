/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.models;

import miu.fncurvesdrawer.models.util.MiuFncdModelModel;
import miu.fncurvesdrawer.util.MIUConfigManager;


/**
 *
 * @author Ndadji Maxime
 */
public class MiuFncdStartupModel extends MiuFncdModelModel{

    public MiuFncdStartupModel(MIUConfigManager config) {
        super(config);
    }

    public MiuFncdStartupModel() {
    }
    
    public void startupLoading(){
        try{
            
            notifyStartLoaded(0);
            notifyStartLoaded(1);
            if(config.isAskThemActivated())
                setTheme(config);
            notifyStartLoaded(2);
            notifyStartUtilities(config);
        }
        catch(Throwable ex){
            displayModalErrorDialog("Arrêt brusque"
                        + " de l'application", "L'application a rencontré un problème et va s'arrêter."
                        + "\nVeuillez contacter un développeur pour régler ce problème.");
            System.exit(0);
        }
    }
}
