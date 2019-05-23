package com.oe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StagingTable {

    private final List<ChillerInfo> chillerInfos;
    private final List<StagingTableRow> rows;

    public StagingTable(List<ChillerInfo> chillerInfos) {
        this.chillerInfos = chillerInfos;
        rows = new ArrayList<>();
        
        List<Integer> compressed = new ArrayList<>();
        
        for( int i=0; i< Math.pow(2, chillerInfos.size()); i++){
            compressed.add(i);
        }
        
       //instatiate a comparer that uses the staging order to compare 2 rows in the table
        //StagingTableComparator orderer = new StagingTableComparator(stageOrder);

        //sort the table by this staging order
        //Collections.sort(compressed, orderer);

    }

    public List<ChillerInfo> getChillerInfos() {
        return chillerInfos;
    }

    public List<StagingTableRow> getRows() {
        return rows;
    }

}
