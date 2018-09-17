package miu.fncurvesdrawer.views.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import miu.fncurvesdrawer.controllers.util.MIUControllerModel;
import miu.fncurvesdrawer.observers.MiuFncdObserver;
import miu.fncurvesdrawer.util.MIUConfigManager;
import miu.fncurvesdrawer.util.exception.MIUElementNotFoundException;

/**
 *
 * @author Ndadji Maxime
 */
public abstract class MIUFrameModel extends JFrame implements MIUFrameAndPanelUtilities{
    protected List<MiuFncdObserver> updaterList;
    protected MIUControllerModel controller;
    protected static MIUConfigManager config;
    
    public MIUFrameModel(){
        updaterList = new ArrayList<MiuFncdObserver>();
    }
    
    public MIUFrameModel(MIUControllerModel controller){
        updaterList = new ArrayList<MiuFncdObserver>();
        this.controller = controller;
    }
    
    public MIUFrameModel(List<MiuFncdObserver> updaterList){
        this.updaterList = updaterList;
    }
    
    public MIUFrameModel(List<MiuFncdObserver> updaterList, MIUControllerModel controller){
        this.updaterList = updaterList;
        this.controller = controller;
    }
    
    @Override
    public void addUpdater(MiuFncdObserver observer) {
        if(!this.updaterList.contains(observer)){
            this.updaterList.add(observer);
            controller.getModel().addObserver(observer);
        }
    }

    @Override
    public void removeUpdater(MiuFncdObserver observer) throws MIUElementNotFoundException {
        try{
            this.updaterList.remove(observer);
            controller.getModel().removeObserver(observer);
        }
        catch(Exception e){
            throw new MIUElementNotFoundException(e.getMessage());
        }
    }
    
    protected abstract void initComponents();

    @Override
    public MIUControllerModel getController() {
        return controller;
    }

    @Override
    public void setController(MIUControllerModel controller) {
        this.controller = controller;
    }
    
    @Override
    public void dispose(){
        super.dispose();
    }
}
