/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import miu.fncurvesdrawer.controllers.util.MIUControllerModel;
import miu.fncurvesdrawer.observers.adapters.MiuFncdObserverAdapter;
import miu.fncurvesdrawer.views.util.MIUPanelModel;

/**
 *
 * @author Ndadji Maxime
 */
public class MiuFncdStatePanel extends MIUPanelModel{
    private Updater updater;
    private ActionListener listener;
    private JLabel version, expired, task, loading;
    private ArrayList<String> tasks;
    private boolean askedStock;
    private ImageIcon icon;
    private JToolBar toolBar;

    public MiuFncdStatePanel(MIUControllerModel controller) {
        super(controller);
        
        tasks = new ArrayList<String>();
        
        Thread t = new Thread(){

            @Override
            public void run() {
                initComponents();
                updater = new Updater();
                addUpdater(updater);
                
                validate();
                repaint();
                updateUI();
            }
            
        };
        t.start();
        
        /*this.initComponents();
        
        updater = new Updater();
        controller.getModel().addObserver(updater);
        pController.getModel().addObserver(updater);
        
        updateLicense();
        getExpiredProduct();*/
    }
    
    @Override
    protected final void initComponents() {
        listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if(command.equalsIgnoreCase("clear")){
                    
                    return;
                }
                
                if(command.equalsIgnoreCase("print")){
                    return;
                }
                
                if(command.equalsIgnoreCase("add")){
                    
                    return;
                }
            }
        };
        
        setLayout(new BorderLayout());
        
        //setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        
        toolBar = new JToolBar(JToolBar.HORIZONTAL);
        toolBar.setPreferredSize(new Dimension(20, 20));
        toolBar.setFloatable(false);
        toolBar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY.brighter()));
        
        
        version = new JLabel("");
        version.setFont(new Font("Cambria", Font.PLAIN, 13));
        version.setPreferredSize(new Dimension(320, 15));
        //version.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
        toolBar.add(version);
        
        toolBar.addSeparator(new Dimension(40, 9));
        
        expired = new JLabel("");
        expired.setFont(new Font("Cambria", Font.PLAIN, 13));
        expired.setPreferredSize(new Dimension(400, 15));
        expired.setForeground(Color.red);
        toolBar.add(expired);
        
        toolBar.addSeparator(new Dimension(40, 9));
        
        task = new JLabel("");
        task.setFont(new Font("Cambria", Font.PLAIN, 13));
        task.setPreferredSize(new Dimension(550, 15));
        task.setHorizontalAlignment(JLabel.RIGHT);
        toolBar.add(task);
        
        toolBar.addSeparator(new Dimension(9, 9));
        
        loading = new JLabel("");
        loading.setFont(new Font("Cambria", Font.PLAIN, 13));
        loading.setPreferredSize(new Dimension(10, 10));
        icon = new ImageIcon(getClass().getResource("/miu/fncurvesdrawer/resources/images/loading.gif"));
        toolBar.add(loading);
        
        add(toolBar);
    }
    
    public synchronized void addTask(String t){
        tasks.add(0, t);
        updateTasks();
    }
    
    public synchronized void removeTask(String t){
        tasks.remove(t);
        updateTasks();
    }
    
    public synchronized void updateTasks(){
        int size = tasks.size();
        if(size > 0){
            task.setText(tasks.get(0)+(size > 1 ? " (+"+ (size - 1) + " " + config.getLangValue("more") + ")" : ""));
            loading.setIcon(icon);
        }else{
            loading.setIcon(null);
            task.setText("");
        }
        validate();
        updateUI();
    }
    
    public class Updater extends MiuFncdObserverAdapter{
        @Override
        public void updateTaskStarted(String t){
            addTask(t);
        }
        
        @Override
        public void updateTaskEnded(String t){
            removeTask(t);
        }
    }
}
