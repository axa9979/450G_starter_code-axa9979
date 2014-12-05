package edu.louisiana.cacs.cacse450GProject;
import javax.swing.table.TableModel;

public abstract class SeparatorPolicy
{

    public SeparatorPolicy()
    {
    }

    public SeparatorPolicy(TableModel tableModel)
    {
        this.tableModel = tableModel;
    }

    public TableModel getTableModel()
    {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel)
    {
        this.tableModel = tableModel;
    }

    abstract boolean hasSeparatorAt(int i);

    protected TableModel tableModel;
}
