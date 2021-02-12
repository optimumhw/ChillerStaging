
package com.oe.view.ChillerInfoTable;

import java.util.ArrayList;
import java.util.List;


public enum EnumChillerInfoTableColumns {

    ChillerName(0,"Name", 100),
    ChillerNumber(1, "Number", 100),
    Ranking(2,"Ranking", 50);

    private final int columnNumber;
    private final String columnName;
    private final int width;

    EnumChillerInfoTableColumns(int columnNumber, String columnName, int width) {
        
        this.columnNumber = columnNumber;
        this.columnName = columnName;
        this.width = width;
    }

    public static EnumChillerInfoTableColumns getColumnFromColumnNumber(int colNumber) {

        for (EnumChillerInfoTableColumns v : EnumChillerInfoTableColumns.values()) {
            if (v.getColumnNumber() == colNumber) {
                return v;
            }
        }
        return null;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public String getColumnName() {
        return this.columnName;
    }
    
    public int getWidth(){
        return this.width;
    }

    public static List<String> getColumnNames() {
        List<String> names = new ArrayList<>();
        for (EnumChillerInfoTableColumns v : EnumChillerInfoTableColumns.values()) {
            names.add(v.columnName);
        }
        return names;
    }
}
