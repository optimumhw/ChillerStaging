package com.oe.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Model extends java.util.Observable {

    final private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    static Logger logger = LoggerFactory.getLogger(Model.class.getName());
    
    private ChillerInfos chillerInfos;

    

    StagingTable stagingTable;


    public Model() {
        
        List<ChillerInfo> chillerInfoList = new ArrayList<>();
        
        //CH	RankA		CH	RankB
        //CH1	1		CH1	3
        //CH2	3		CH2	1
        //CH3	9		CH3	9
        //CH4	10		CH4	10
        //CH5	7		CH5	7
        //CH6	8		CH6	8
        //CH7	2		CH7	2
        //CH8	6		CH8	6
        //CH9	4		CH9	5
        //CH10	5		CH10	4
//
//        chillerInfoList.add(new ChillerInfo("CH1", 1, 1));
//        chillerInfoList.add(new ChillerInfo("CH2", 2, 3));
//        chillerInfoList.add(new ChillerInfo("CH3", 3, 9));
//        chillerInfoList.add(new ChillerInfo("CH4", 4, 10));
//        chillerInfoList.add(new ChillerInfo("CH5", 5, 7));
//        chillerInfoList.add(new ChillerInfo("CH6", 6, 8));
//        chillerInfoList.add(new ChillerInfo("CH7", 7, 2));
//        chillerInfoList.add(new ChillerInfo("CH8", 8, 6));
//        chillerInfoList.add(new ChillerInfo("CH9", 9, 4));
//        chillerInfoList.add(new ChillerInfo("CH10", 10, 5));
//           
        chillerInfoList.add(new ChillerInfo("CH1", 1, 3));
        chillerInfoList.add(new ChillerInfo("CH2", 2, 1));
        chillerInfoList.add(new ChillerInfo("CH3", 3, 9));
        chillerInfoList.add(new ChillerInfo("CH4", 4, 10));
        chillerInfoList.add(new ChillerInfo("CH5", 5, 7));
        chillerInfoList.add(new ChillerInfo("CH6", 6, 8));
        chillerInfoList.add(new ChillerInfo("CH7", 7, 2));
        chillerInfoList.add(new ChillerInfo("CH8", 8, 6));
        chillerInfoList.add(new ChillerInfo("CH9", 9, 5));
        chillerInfoList.add(new ChillerInfo("CH10", 10, 4));
////        


//        chillerInfoList.add(new ChillerInfo("A", 1, 2));
//        chillerInfoList.add(new ChillerInfo("B", 2, 3));
//        chillerInfoList.add(new ChillerInfo("C", 3, 1));



        chillerInfos = new ChillerInfos(chillerInfoList);
        
        
        stagingTable = new StagingTable(chillerInfos);
    }

    public void addPropChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public void initModel() {

    }

    public List<ChillerInfo> getChillerInfos() {
        return chillerInfos.getChillerInfoList();
    }
    
    public Integer[] getStageOrder(){
        return chillerInfos.getStagingOrder();
    }

    public StagingTable getStagingTable() {
        return stagingTable;
    }


}
