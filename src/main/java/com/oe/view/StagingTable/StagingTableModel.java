package com.oe.view.StagingTable;

import com.oe.model.StagingTable;
import com.oe.model.StagingTableRow;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.joda.time.DateTime;

public class StagingTableModel extends AbstractTableModel {

    private final StagingTable stagingTable;

    public StagingTableModel(StagingTable stagingTable) {
        super();
        this.stagingTable = stagingTable;
    }

    @Override
    public int getRowCount() {
        return stagingTable.getRows().size();
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return EnumStagingTableColumns.Stage.getFriendlyName();
        } else if (col == 1) {
            return EnumStagingTableColumns.Rank.getFriendlyName();
        } else {
            return stagingTable.getChillerInfos().get(col - 2).getName();
        }
    }

    @Override
    public int getColumnCount() {
        return stagingTable.getChillerInfos().size() + 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object val = "?";

        StagingTableRow row = stagingTable.getRows().get(rowIndex);

        switch (columnIndex) {
            case 0:
                val = row.getStage();
                break;
            case 1:
                val = row.getRank();
                break;
            default:
                val = row.getFlags().get(columnIndex - 2);
                break;
        }

        return val;
    }

}
