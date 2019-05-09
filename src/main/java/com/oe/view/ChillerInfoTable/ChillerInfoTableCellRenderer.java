
package com.oe.view.ChillerInfoTable;

import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ChillerInfoTableCellRenderer extends DefaultTableCellRenderer {

    final Color limeGreen;

    public ChillerInfoTableCellRenderer() {
        limeGreen = new Color(204, 255, 204);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        
        //EnumChillerInfoTableColumns colEnum = EnumChillerInfoTableColumns.getColumnFromColumnNumber(column);

        Color color = Color.WHITE;
        setBackground(isSelected ? color : color);
        this.setHorizontalAlignment(JLabel.LEFT);

        if (value == null) {
            color = Color.lightGray;
            value = "---";
        } else if (value instanceof String) {
            color = Color.WHITE;
            String temp = (String) value;
            if (temp.compareTo("NaN") == 0) {
                value = "'NaN'";
            }
        } else if (value instanceof Double) {
            try {
                String precFormatString = "#0";
                String stringOfZeros = "000000";
                if (3 > 0) {
                    precFormatString += ".";
                    precFormatString = precFormatString.concat(stringOfZeros.substring(0, 3));
                }
                NumberFormat formatter = new DecimalFormat(precFormatString);
                value = formatter.format(value);
            } catch (Exception ex) {
                color = Color.pink;
                value = "oops";
            }
        }

        setBackground(isSelected ? color : color);
        return super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
    }
}

