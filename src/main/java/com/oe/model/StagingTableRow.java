
package com.oe.model;

import java.util.List;


public class StagingTableRow {
    
    int stage;
    int rank;
    List<Boolean> flags;
    
    StagingTableRow(List<Boolean> flags){
        
        this.flags = flags;
        
    }
    
    public int getStage(){
        return this.stage;
    }
    
    public int getRank(){
        return this.rank;
    }
    
    public List<Boolean> getFlags(){
        return flags;
    }
    
}
