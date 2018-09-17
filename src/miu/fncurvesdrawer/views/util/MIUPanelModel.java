package miu.fncurvesdrawer.views.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import miu.fncurvesdrawer.controllers.util.MIUControllerModel;
import miu.fncurvesdrawer.observers.MiuFncdObserver;
import miu.fncurvesdrawer.util.MIUConfigManager;
import miu.fncurvesdrawer.util.exception.MIUElementNotFoundException;
/**
 *
 * @author Ndadji Maxime
 */
public abstract class MIUPanelModel extends JPanel implements MIUFrameAndPanelUtilities{
    protected List<MiuFncdObserver> updaterList;
    protected MIUControllerModel controller;
    public static MIUConfigManager config;
    
    public MIUPanelModel(){
        updaterList = new ArrayList<MiuFncdObserver>();
        MIUStyledPanel p = new MIUStyledPanel(config);
    }
    
    public MIUPanelModel(MIUControllerModel controller){
        updaterList = new ArrayList<MiuFncdObserver>();
        this.controller = controller;
    }
    
    public MIUPanelModel(List<MiuFncdObserver> observerList){
        this.updaterList = observerList;
    }
    
    public MIUPanelModel(List<MiuFncdObserver> observerList, MIUControllerModel controller){
        this.updaterList = observerList;
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
    public void dispose() {
        
    }
}
