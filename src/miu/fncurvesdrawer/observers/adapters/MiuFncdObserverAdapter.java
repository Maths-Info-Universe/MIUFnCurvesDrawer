/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.observers.adapters;

import miu.fncurvesdrawer.models.util.MiuFncdModelModel;
import miu.fncurvesdrawer.observers.MiuFncdObserver;
import miu.fncurvesdrawer.util.MIUConfigManager;


/**
 *
 * @author Ndadji Maxime
 */
public abstract class MiuFncdObserverAdapter implements MiuFncdObserver{

    @Override
    public void updateStartLoaded(int step) {
        
    }

    @Override
    public void updateStartUtilities(MIUConfigManager config) {
        
    }

    @Override
    public void updateUserChanged() {
        
    }
    
    @Override
    public void updateThemeChanged() {
        
    }

    @Override
    public void updateSuccess(String message) {
        MiuFncdModelModel.displayMessageDialog(MiuFncdModelModel.config.getLangValue("success_notification"), message);
    }

    @Override
    public void updateError(String message) {
        MiuFncdModelModel.displayErrorDialog(MiuFncdModelModel.config.getLangValue("error_notification"), message);
    }
    
    @Override
    public void updateTaskStarted(String t){
        
    }
    
    @Override
    public void updateTaskEnded(String t){
        
    }
}
