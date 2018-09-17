package miu.fncurvesdrawer.controllers;

import miu.fncurvesdrawer.controllers.util.MIUControllerModel;
import miu.fncurvesdrawer.models.util.MiuFncdIHMModel;

/**
 *
 * @author garrik brel
 */
public class MiuFncdIHMController extends MIUControllerModel {
    
    public MiuFncdIHMController(MiuFncdIHMModel model) {
        super(model);
    }

    public void editDesign() {
        ((MiuFncdIHMModel)model).editDesign();
    }
    
    public void startTask(String task){
        ((MiuFncdIHMModel)model).startTask(task);
    }
    
    public void stopTask(String task){
        ((MiuFncdIHMModel)model).stopTask(task);
    }
}
