/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.observers;

import miu.fncurvesdrawer.util.MIUConfigManager;
import miu.fncurvesdrawer.util.exception.MIUElementNotFoundException;


/**
 *
 * @author Ndadji Maxime
 */
public interface MiuFncdObservable {
    public void addObserver(MiuFncdObserver observer);
    public void removeObserver(MiuFncdObserver observer) throws MIUElementNotFoundException;
    public void notifyStartLoaded(int step);
    public void notifyStartUtilities(MIUConfigManager config);
    public void notifyThemeChanged();
    public void notifySuccess (String message);
    public void notifyError (String message);
    public void notifyTaskStarted(String t);
    public void notifyTaskEnded(String t);
}
