/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.views.util;

import miu.fncurvesdrawer.controllers.util.MIUControllerModel;
import miu.fncurvesdrawer.observers.MiuFncdObserver;
import miu.fncurvesdrawer.util.exception.MIUElementNotFoundException;

/**
 *
 * @author Ndadji Maxime
 */
public interface MIUFrameAndPanelUtilities {
    public void dispose();
    public void addUpdater(MiuFncdObserver observer);
    public void removeUpdater(MiuFncdObserver observer) throws MIUElementNotFoundException;
    public MIUControllerModel getController();
    public void setController(MIUControllerModel controller);
}
