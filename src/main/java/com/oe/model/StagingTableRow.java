
package com.oe.model;

import java.util.List;


public class StagingTableRow {
    
    int stage;
    int rank;
    List<Boolean> flags;
    
    StagingTableRow(List<Boolean> flags){
        
        this.flags = flags;
        
    }
    
    
    
}
