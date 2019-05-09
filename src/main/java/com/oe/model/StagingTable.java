package com.oe.model;

import java.util.ArrayList;
import java.util.List;

public class StagingTable {

    private final List<ChillerInfo> chillerInfos;
    private final List<StagingTableRow> rows;

    public StagingTable(List<ChillerInfo> chillerInfos) {
        this.chillerInfos = chillerInfos;
        rows = new ArrayList<>();

    }

    public List<ChillerInfo> getChillerInfos() {
        return chillerInfos;
    }

    public List<StagingTableRow> getRows() {
        return rows;
    }

}
