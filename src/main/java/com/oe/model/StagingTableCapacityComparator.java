package com.oe.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StagingTableCapacityComparator implements Comparator<Integer> {

    List<ChillerInfo> chillerInfos;
    Map<Integer, ChillerInfo> chillerNumToInfoMap;

    private final int AWINS = -1;
    private final int BWINS = 1;
    private final int TIE = 0;

    public StagingTableCapacityComparator(List<ChillerInfo> chillerInfos, Map<Integer, ChillerInfo> chillerNumToInfoMap) {
        this.chillerInfos = chillerInfos;
        this.chillerNumToInfoMap = chillerNumToInfoMap;
    }

    //the stages are
    //count the number of chillers that are ON; this is the stage.
    public int getRowCap(int A) {

        int capacity = 0;
        //for (int i = 1; i <= Math.pow(2, this.chillerInfos.size()); i = i << 1) {
        for (int i = 0; i < chillerInfos.size(); i++) {
            Integer maskValue = (new Double(Math.pow(2, i))).intValue();
            int chillerIsOn = A & maskValue;
            if (chillerIsOn > 0) {
                int chillerNumber = i + 1;
                if (!chillerNumToInfoMap.containsKey(chillerNumber)) {
                    System.out.println("opps");
                }
                capacity += chillerNumToInfoMap.get(chillerNumber).getSize();
            }
        }
        return capacity;
    }

    public int getStage(int A) {

        int countOfChillersOn = 0;
        for (int i = 1; i <= Math.pow(2, this.chillerInfos.size()); i = i << 1) {
            countOfChillersOn += (A & i) > 0 ? 1 : 0;
        }
        return countOfChillersOn;
    }

    @Override
    public int compare(Integer A, Integer B) {
        if (getRowCap(A) < getRowCap(B)) {
            return AWINS; //A should be higher in the list since it has smaller stage
        }
        if (getRowCap(A) > getRowCap(B)) {
            return BWINS;  //B wins
        }
        /*
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
         */

        return TIE;
    }

}
