package com.oe.controller;

import com.oe.model.ChillerInfo;
import com.oe.model.Model;
import com.oe.model.PropertyChangeNames;
import com.oe.view.MainFrame;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;


public class Controller implements java.awt.event.ActionListener, PropertyChangeListener {

    private Model model = null;
    private MainFrame view = null;

    public Controller() {

    }

    public void tellControllerAboutTheModel(Model model) {
        this.model = model;
        model.addPropChangeListener(this);
    }

    public void addModelListener(PropertyChangeListener listener) {
        model.addPropChangeListener(listener);
    }

    public void removePropChangeListener(PropertyChangeListener listener) {
        model.removePropChangeListener(listener);
    }

    public Model getModel() {
        return model;
    }

    public void tellTheControllerAboutTheView(MainFrame view) {
        this.view = view;
    }

    public void initModel(){
        model.initModel();
        
        view.fillChillerTable( getChillerInfos() );
        view.fillStagingTable( model.getStagingTable() );
    }
    
    public List<ChillerInfo> getChillerInfos(){
        return model.getChillerInfos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Object obj = e.getSource();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String propName = evt.getPropertyName();

        if (propName.equals(PropertyChangeNames.StageTableMade.getName())) {
            //view.showError((OEResponse) evt.getNewValue());
        }


    }
}
