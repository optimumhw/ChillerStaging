
package com.oe.model;

import java.util.Comparator;
import java.util.List;


public class StagingTableComparator implements Comparator<Integer> {

    List<ChillerInfo> chillerInfos;
    
    private final int AWINS = -1;
    private final int BWINS = 1;
    private final int TIE = 0;

   
    public StagingTableComparator(List<ChillerInfo> chillerInfos) {
        this.chillerInfos = chillerInfos;
    }

    //count the number of chillers that are ON; this is the stage.
    public int getStage(int A) {

        int countOfChillersOn = 0;
        for (int i = 1; i <= Math.pow(2, this.chillerInfos.size()); i = i << 1) {
            countOfChillersOn += (A & i) > 0 ? 1 : 0;
        }
        return countOfChillersOn;
    }

    
    @Override
    public int compare(Integer A, Integer B) {
        if( getStage(A) < getStage(B) ) return AWINS; //A should be higher in the list since it has smaller stage
        if( getStage(A) > getStage(B) ) return BWINS;  //B wins
        
        Integer stagingOrder[] = new Integer[]{1};
        
        //when both are of the same stage, look at which chillers are on.
        //the guy with the first more efficient chiller should be higher in the table.
        for( int i=0; i< stagingOrder.length; i++ ){
            
            int nextBestChiller = 1 << (stagingOrder.length - stagingOrder[i]);
            
            if( (A & B & nextBestChiller) > 0 ) continue; //they both have this chiller
            
            if( (A & nextBestChiller) > 0  ) return AWINS; //A wins
            if( (B & nextBestChiller) > 0  ) return BWINS; //B wins
            
            //continue - neither have this chiller turned on
            
        }
       
        return TIE;
    }

}
