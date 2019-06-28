package com.oe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StagingTable {

    private final List<ChillerInfo> chillerInfos;
    private final Map<Integer, ChillerInfo> chillerNumToInfoMap;
    private final List<StagingTableRow> rows;

    public StagingTable(List<ChillerInfo> chillerInfos, Map<Integer, ChillerInfo> chillerNumToInfoMap) {
        this.chillerInfos = chillerInfos;
        this.chillerNumToInfoMap = chillerNumToInfoMap;
        rows = new ArrayList<>();

        List<Integer> compressed = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, chillerInfos.size()); i++) {
            compressed.add(i);
        }

        StagingTableCapacityComparator orderer = new StagingTableCapacityComparator(chillerInfos, chillerNumToInfoMap);

        Collections.sort(compressed, orderer);

        int currentCapcity = 0;
        int currentStage = 0;
        int currentRank = 0;
        for (int comp : compressed) {

            //int row = stagingTable.get(i);
            int stage = orderer.getStage(comp);
            int capacity = orderer.getRowCap(comp);

            if (capacity != currentCapcity) {
                currentRank = 0;
                currentCapcity = capacity;
                currentStage++;
            }

            currentRank++;

            rows.add(new StagingTableRow(chillerInfos.size(), capacity, currentStage, currentRank, comp));

        }

    }

    public List<ChillerInfo> getChillerInfos() {
        return chillerInfos;
    }

    public List<StagingTableRow> getRows() {
        return rows;
    }

}
