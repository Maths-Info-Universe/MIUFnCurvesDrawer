/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import miu.fncurvesdrawer.controllers.MiuFncdStartupController;
import miu.fncurvesdrawer.observers.adapters.MiuFncdObserverAdapter;
import miu.fncurvesdrawer.util.MIUConfigManager;
import miu.fncurvesdrawer.util.exception.MIUApplException;
import miu.fncurvesdrawer.util.exception.MIUElementNotFoundException;
import miu.fncurvesdrawer.views.util.MIUFrameModel;

/**
 *
 * @author Ndadji Maxime
 */
public class MiuFncdStartupView extends MIUFrameModel{

    private MiuFncdStartupPanel mainPanel;
    private Updater updater;
    
    public MiuFncdStartupView(MiuFncdStartupController controller, MIUConfigManager config) {
        super(controller);
        MIUFrameModel.config = config;
        try {
            this.setTitle(config.getSoftwareInfos().get("shortname") + "-" + config.getSoftwareInfos().get("instance") + " : " + config.getLangValue("startup_title"));
        } catch (MIUApplException ex) {
            this.setTitle(config.getLangValue("startup_title"));
        }
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/miu/fncurvesdrawer/resources/images/logo.png"));
        this.setIconImage(icon.getImage());
        updater = new Updater();
        this.addUpdater(updater);
        
        this.initComponents();
        
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //break;
                }
            }
        } catch (ClassNotFoundException ex) {
            //java.util.logging.Logger.getLogger(Eqn2DCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //java.util.logging.Logger.getLogger(Eqn2DCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //java.util.logging.Logger.getLogger(Eqn2DCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(Eqn2DCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        
        this.setVisible(true);
        
        controller.startupLoading();
    }
    
    @Override
    protected final void initComponents() {
        mainPanel = new MiuFncdStartupPanel(config);
        this.setContentPane(mainPanel);
    }
    
    private void constructMainView(MIUConfigManager config) {
        MiuFncdMainView view = new MiuFncdMainView(config);
        this.dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        try {
            this.removeUpdater(updater);
        } catch (MIUElementNotFoundException ex) {
            
        }
    }
    
    
    
    public class Updater extends MiuFncdObserverAdapter{

        @Override
        public void updateStartLoaded(int step) {
            if(step >= 0 && step < 4)
                mainPanel.check(step);
            else{
                
            }
        }

        @Override
        public void updateStartUtilities(MIUConfigManager config) {
            constructMainView(config);
        }
    }
}
