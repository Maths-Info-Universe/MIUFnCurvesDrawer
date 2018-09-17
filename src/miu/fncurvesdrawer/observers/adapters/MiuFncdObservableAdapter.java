/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.fncurvesdrawer.observers.adapters;

import java.util.ArrayList;
import java.util.List;
import miu.fncurvesdrawer.observers.MiuFncdObservable;
import miu.fncurvesdrawer.observers.MiuFncdObserver;
import miu.fncurvesdrawer.util.MIUConfigManager;
import miu.fncurvesdrawer.util.exception.MIUElementNotFoundException;

/**
 *
 * @author Ndadji Maxime
 */
public abstract class MiuFncdObservableAdapter implements MiuFncdObservable{

    protected List<MiuFncdObserver> observerList;
    
    public MiuFncdObservableAdapter(){
        observerList = new ArrayList<MiuFncdObserver>();
    }
    
    public MiuFncdObservableAdapter(List<MiuFncdObserver> observerList){
        this.observerList = observerList;
    }
    
    @Override
    public synchronized void addObserver(MiuFncdObserver observer) {
        if(!this.observerList.contains(observer))
            this.observerList.add(observer);
    }

    @Override
    public synchronized void removeObserver(MiuFncdObserver observer) throws MIUElementNotFoundException {
        try{
            this.observerList.remove(observer);
        }
        catch(Exception e){
            throw new MIUElementNotFoundException(e.getMessage());
        }
    }

    @Override
    public void notifyStartLoaded(final int step) {
        ArrayList<MiuFncdObserver> observers = (ArrayList<MiuFncdObserver>)((ArrayList<MiuFncdObserver>)this.observerList).clone();
        for(final MiuFncdObserver observer : observers){
            Thread t = new Thread(){
                @Override
                public void run() {
                    observer.updateStartLoaded(step);
                }
            };
            t.start();
        }
    }

    @Override
    public void notifyStartUtilities(final MIUConfigManager config) {
        ArrayList<MiuFncdObserver> observers = (ArrayList<MiuFncdObserver>)((ArrayList<MiuFncdObserver>)this.observerList).clone();
        for(final MiuFncdObserver observer : observers){
            Thread t = new Thread(){
                @Override
                public void run() {
                    observer.updateStartUtilities(config);
                }
            };
            t.start();
        }
    }
    
    @Override
    public void notifyThemeChanged() {
        ArrayList<MiuFncdObserver> observers = (ArrayList<MiuFncdObserver>)((ArrayList<MiuFncdObserver>)this.observerList).clone();
        for(final MiuFncdObserver observer : observers){
            Thread t = new Thread(){
                @Override
                public void run() {
                    observer.updateThemeChanged();
                }
            };
            t.start();
        }
    }
    
    @Override
    public void notifySuccess(final String message) {
        ArrayList<MiuFncdObserver> observers = (ArrayList<MiuFncdObserver>)((ArrayList<MiuFncdObserver>)this.observerList).clone();
         for(final MiuFncdObserver observer : observers){
            Thread t = new Thread(){
                @Override
                public void run() {
                    observer.updateSuccess(message);
                }
            };
            t.start();
        }
    }

    @Override
    public void notifyError(final String message) {
        ArrayList<MiuFncdObserver> observers = (ArrayList<MiuFncdObserver>)((ArrayList<MiuFncdObserver>)this.observerList).clone();
        for(final MiuFncdObserver observer : observers){
            Thread t = new Thread(){
                @Override
                public void run() {
                    observer.updateError(message);
                }
            };
            t.start();
        }
    }
    
    @Override
    public void notifyTaskStarted(final String task){
        ArrayList<MiuFncdObserver> observers = (ArrayList<MiuFncdObserver>)((ArrayList<MiuFncdObserver>)this.observerList).clone();
        for(final MiuFncdObserver observer : observers){
            Thread t = new Thread(){
                @Override
                public void run() {
                    observer.updateTaskStarted(task);
                }
            };
            t.start();
        }
    }
    
    @Override
    public void notifyTaskEnded(final String task){
        ArrayList<MiuFncdObserver> observers = (ArrayList<MiuFncdObserver>)((ArrayList<MiuFncdObserver>)this.observerList).clone();
        for(final MiuFncdObserver observer : observers){
            Thread t = new Thread(){
                @Override
                public void run() {
                    observer.updateTaskEnded(task);
                }
            };
            t.start();
        }
    }
}
