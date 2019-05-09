package com.oe.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Model extends java.util.Observable {

    final private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    static Logger logger = LoggerFactory.getLogger(Model.class.getName());

    private final List<ChillerInfo> chillerInfos;

    public Model() {
        this.chillerInfos = new ArrayList<>();

        chillerInfos.add(new ChillerInfo("A", 2500, 1.0));
        chillerInfos.add(new ChillerInfo("B", 2500, 2.0));
        chillerInfos.add(new ChillerInfo("C", 1200, 1.0));
        chillerInfos.add(new ChillerInfo("D", 1200, 2.0));
        chillerInfos.add(new ChillerInfo("E", 1200, 3.0));

    }

    public void addPropChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
    
    public void initModel() {

    }
    
    public List<ChillerInfo> getChillerInfos(){
        return chillerInfos;
    }
    
    
   

    /*
    public void doSomething() {

        SwingWorker worker = new SwingWorker< OEResponse, Void>() {

            @Override
            public OEResponse doInBackground() throws IOException {
                OEResponse results = stationClient.getStations();
                return results;
            }

            @Override
            public void done() {
                try {
                    OEResponse resp = get();

                    if (resp.responseCode == 200) {
                        List<StationInfo> stations = (List<StationInfo>) resp.responseObject;

                        pcs.firePropertyChange(PropertyChangeNames.StationsListReturned.getName(), null, stations);
                    } else {
                        pcs.firePropertyChange(PropertyChangeNames.ErrorResponse.getName(), null, resp);
                    }
                    pcs.firePropertyChange(PropertyChangeNames.RequestResponseChanged.getName(), null, getRRS());

                } catch (Exception ex) {
                    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
                    logger.error(this.getClass().getName(), ex);
                }
            }
        };
        worker.execute();
    }

     */
}
