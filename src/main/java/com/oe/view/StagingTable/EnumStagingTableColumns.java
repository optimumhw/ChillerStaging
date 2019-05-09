
package com.oe.view.StagingTable;

import java.util.ArrayList;
import java.util.List;


public enum EnumStagingTableColumns {

    ShortName(0,"Stage", 20),
    ID(1,"Rank", 20);

    private final String friendlyName;
    private final int columnNumber;
    private final int width;

    EnumStagingTableColumns(int columnNumber, String name, int width) {
        this.friendlyName = name;
        this.columnNumber = columnNumber;
        this.width = width;
    }

    public static EnumStagingTableColumns getColumnFromColumnNumber(int colNumber) {

        for (EnumStagingTableColumns v : EnumStagingTableColumns.values()) {
            if (v.getColumnNumber() == colNumber) {
                return v;
            }
        }
        return null;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }
    
    public int getWidth(){
        return this.width;
    }

    public static List<String> getColumnNames() {
        List<String> names = new ArrayList<>();
        for (EnumStagingTableColumns v : EnumStagingTableColumns.values()) {
            names.add(v.getFriendlyName());
        }
        return names;
    }
}


