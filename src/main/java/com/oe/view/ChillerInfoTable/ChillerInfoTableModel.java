
package com.oe.view.ChillerInfoTable;

import com.oe.model.ChillerInfo;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ChillerInfoTableModel extends AbstractTableModel {
    
    private List<ChillerInfo> chillerInfos;


    public ChillerInfoTableModel(List<ChillerInfo> chillerInfos ) {
        super();
        
        this.chillerInfos = chillerInfos;
        
    }
    
    public ChillerInfo getRow(int idx) {
        return chillerInfos.get(idx);
    }

    @Override
    public int getRowCount() {
        return chillerInfos.size();
    }

    @Override
    public String getColumnName(int col) {
        return EnumChillerInfoTableColumns.getColumnFromColumnNumber(col).getColumnName();
    }

    @Override
    public int getColumnCount() {
        return EnumChillerInfoTableColumns.getColumnNames().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object val = "?";

        EnumChillerInfoTableColumns enumCol = EnumChillerInfoTableColumns.getColumnFromColumnNumber(columnIndex);

        ChillerInfo chillerInfo = chillerInfos.get(rowIndex);

        switch (enumCol) {
            case ShortName:
                val = chillerInfo.getName();
                break;
            case Size:
                val = chillerInfo.getSize();
                break;
            case Eff:
                val = chillerInfo.getEff();
                break;
 
        }

        return val;
    }
    
}
