package com.oe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StagingTable {

    private final ChillerInfos chillerInfos;
    private final List<StagingTableRow> rows;
    
    /*
    public int[][] getRecommendationTable() {

        int width = this.numberOfChillersInRecommendationTable + 2;
        int height = (int) Math.pow(2, this.numberOfChillersInRecommendationTable);

        int[][] recommendationTable = new int[height][width];

        Integer[] stageOrder = this.getStagingOrderArray();

        //create the unsorted staging order table (0,1,10,11,...,111111 ie, 0,1,2,3,...,63 )
        List<Integer> stagingTable = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, this.numberOfChillersInRecommendationTable); i++) {
            stagingTable.add(i);
        }

        //instatiate a comparer that uses the staging order to compare 2 rows in the table
        StageTableComparator orderer = new StageTableComparator(stageOrder);

        //sort the table by this staging order
        Collections.sort(stagingTable, orderer);

        //build the recommendation table by tacking on the stage and rank numbers
        int currentStage = 0;
        int currentRank = 0;
        for (int i = 0; i < Math.pow(2, this.numberOfChillersInRecommendationTable); i++) {

            int row = stagingTable.get(i);
            int stage = orderer.getStage(row);

            if (stage != currentStage) {
                currentRank = 0;
                currentStage = stage;
            }

            currentRank++;

            recommendationTable[i][0] = currentStage;
            recommendationTable[i][1] = currentRank;

            for (int j = 0; j < this.numberOfChillersInRecommendationTable; j++) {
                recommendationTable[i][j + 2] = ((row & 1 << (this.numberOfChillersInRecommendationTable - 1 - j)) > 0) ? 1 : 0;
            }
        }

        return recommendationTable;
    }
    */
    
    
    

    public StagingTable(ChillerInfos chillerInfos) {
        this.chillerInfos = chillerInfos;

        rows = new ArrayList<>();

        List<Integer> compressed = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, chillerInfos.getChillerCount()); i++) {
            compressed.add(i);
        }
        
        StagingTableComparator orderer = new StagingTableComparator(chillerInfos.getStagingOrder());

        Collections.sort(compressed, orderer);
        
        //build the recommendation table by tacking on the stage and rank numbers
        int currentStage = 0;
        int currentRank = 0;
        for (int comp : compressed) {

            int stage = orderer.getStage(comp);


            if (stage != currentStage) {
                currentRank = 0;
                currentStage = stage;
            }

            currentRank++;

            rows.add(new StagingTableRow(chillerInfos.getChillerCount(), currentStage, currentRank, comp));

        }

    }

    public List<ChillerInfo> getChillerInfos() {
        return chillerInfos.getChillerInfoList();
    }

    public List<StagingTableRow> getRows() {
        return rows;
    }

}
