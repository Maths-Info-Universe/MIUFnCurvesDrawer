/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.models.util;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import miu.fncurvesdrawer.controllers.MiuFncdIHMController;
import miu.fncurvesdrawer.controllers.util.MIUControllerModel;
import miu.fncurvesdrawer.observers.adapters.MiuFncdObservableAdapter;
import miu.fncurvesdrawer.util.MIUConfigManager;
import miu.fncurvesdrawer.views.MiuFncdLoadingDialog;
import miu.fncurvesdrawer.views.MiuFncdSettingGUIDialog;
import org.joda.time.DateTime;

/**
 *
 * @author Ndadji Maxime
 */
public abstract class MiuFncdModelModel extends MiuFncdObservableAdapter{
    public static MIUConfigManager config;
    protected static Timestamp lastRequestTime;
    public static final double sessionTime = 3;
    public static boolean display = true;
    protected static Desktop desktop = null;
    private static MiuFncdLoadingDialog loadingDialog;
    protected static MiuFncdIHMController ihmController;

    public static MIUControllerModel getIHMController() {
        return ihmController;
    }

    public MiuFncdModelModel(MIUConfigManager config) {
        MiuFncdModelModel.config = config;
        if(Desktop.isDesktopSupported())
            desktop = Desktop.getDesktop();
        ihmController = new MiuFncdIHMController(new MiuFncdIHMModel());
        loadingDialog = new MiuFncdLoadingDialog(config, false, null, ihmController);
    }

    public MiuFncdModelModel() {
        if(Desktop.isDesktopSupported())
            desktop = Desktop.getDesktop();
    }
    
    public static boolean verifySession(Timestamp time){
        Long diff = time.getTime() - lastRequestTime.getTime();
        double seconds = (diff / 1000);
        return (seconds <= sessionTime);
    }
    
    public static void displayErrorDialog(final String title, final String message){
        Thread t = new Thread(){

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
            }
        };
        t.start();
    }
    
    public static void displayMessageDialog(final String title, final String message) {
        Thread t = new Thread(){

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE); 
            }
        };
        t.start();
    }
    
    public static void displayModalErrorDialog(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void displayModalMessageDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE); 
    }
    
    public static boolean setTheme(MIUConfigManager config){
        MiuFncdSettingGUIDialog dialog = new MiuFncdSettingGUIDialog(config, true, null);
        dialog.showDialog();
        return dialog.changed;
    }
    
    public static void addProcess(String lab){
        if(loadingDialog != null)
            loadingDialog.addProcess(lab);
    }

    public static void removeProcess(String lab){
        if(loadingDialog != null)
            loadingDialog.removeProcess(lab);
    }
}
