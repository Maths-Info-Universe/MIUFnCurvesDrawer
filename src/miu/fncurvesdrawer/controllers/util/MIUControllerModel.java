/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.controllers.util;

import miu.fncurvesdrawer.observers.MiuFncdObservable;
import miu.fncurvesdrawer.util.MIUConfigManager;


/**
 *
 * @author Ndadji Maxime
 */
public abstract class MIUControllerModel {
    
    protected MiuFncdObservable model;
    protected static MIUConfigManager config;
    
    public MIUControllerModel(){
        
    }
    
    public MIUControllerModel(MiuFncdObservable model){
        this.model = model;
    }

    public MiuFncdObservable getModel() {
        return model;
    }

    public void setModel(MiuFncdObservable model) {
        this.model = model;
    }
}
