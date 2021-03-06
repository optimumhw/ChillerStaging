package com.oe.model;

import java.util.ArrayList;
import java.util.List;

public class StagingTableRow {

    int stage;
    int rank;
    List<Integer> flags;

    StagingTableRow(int numChillers, int stage, int rank, int compressed) {


        this.stage = stage;
        this.rank = rank;

        flags = new ArrayList<>();
        for (int j = 0; j < numChillers; j++) {
            int flag = 1 << (numChillers - 1 - j);
            int onOrOff = ((compressed & flag) > 0) ? 1 : 0;
            flags.add(onOrOff);
        }

    }
    

    public int getStage() {
        return this.stage;
    }
    
    public int getRank() {
        return this.rank;
    }

    public List<Integer> getFlags() {
        return flags;
    }

}
