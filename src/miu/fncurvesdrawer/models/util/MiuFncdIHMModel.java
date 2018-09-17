package miu.fncurvesdrawer.models.util;

import miu.fncurvesdrawer.views.MiuFncdSettingGUIDialog;

/**
 *
 * @author garrik brel
 */
public class MiuFncdIHMModel extends MiuFncdModelModel{
    
    public MiuFncdIHMModel (){
        
    }

    public void editDesign() {
        MiuFncdSettingGUIDialog dialog = new MiuFncdSettingGUIDialog(config, true, null);
        dialog.showDialog();
        if(dialog.changed){
            notifyThemeChanged();
        }
    }
    
    public void startTask(String task){
        notifyTaskStarted(task);
    }
    
    public void stopTask(String task){
        notifyTaskEnded(task);
    }
}
