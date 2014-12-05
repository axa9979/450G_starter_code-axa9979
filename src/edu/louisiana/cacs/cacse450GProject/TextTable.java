package edu.louisiana.cacs.cacse450GProject;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.*;


public class TextTable
{

    public TextTable(TableModel tableModel)
    {
        separatorPolicies = new ArrayList();
        this.tableModel = tableModel;
    }

    public TextTable(TableModel tableModel, boolean addNumbering)
    {
        separatorPolicies = new ArrayList();
        this.tableModel = tableModel;
        addRowNumbering = addNumbering;
    }

    public TextTable(String columnNames[], Object data[][])
    {
        separatorPolicies = new ArrayList();
        tableModel = new DefaultTableModel(data, columnNames);
    }

    public TableModel getTableModel()
    {
        return tableModel;
    }

    public void setAddRowNumbering(boolean addNumbering)
    {
        addRowNumbering = addNumbering;
    }

    public void addSeparatorPolicy(SeparatorPolicy separatorPolicy)
    {
        separatorPolicies.add(separatorPolicy);
        separatorPolicy.setTableModel(tableModel);
    }

    public void setSort(int column)
    {
        setSort(column, SortOrder.ASCENDING);
    }

    public void setSort(int column, SortOrder sortOrder)
    {
        rowSorter = new TableRowSorter(tableModel);
        List sortKeys = new ArrayList();
        sortKeys.add(new javax.swing.RowSorter.SortKey(column, sortOrder));
        rowSorter.setSortKeys(sortKeys);
    }

    public void printTable()
    {
        printTable(System.out, 0);
    }

    public void printTable(PrintStream ps, int indent)
    {
        TextTableRenderer renderer = new TextTableRenderer(this);
        renderer.render(ps, indent);
    }

   

    protected Object getValueAt(int row, int column)
    {
        int rowIndex = row;
        if(rowSorter != null)
            rowIndex = rowSorter.convertRowIndexToModel(row);
        return tableModel.getValueAt(rowIndex, column);
    }

    protected boolean hasSeparatorAt(int row)
    {
        for(Iterator i$ = separatorPolicies.iterator(); i$.hasNext();)
        {
            SeparatorPolicy separatorPolicy = (SeparatorPolicy)i$.next();
            if(separatorPolicy.hasSeparatorAt(row))
                return true;
        }

        return false;
    }

    protected TableModel tableModel;
    protected List separatorPolicies;
    protected boolean addRowNumbering;
    protected RowSorter rowSorter;
    protected boolean headless;
}
