package edu.louisiana.cacs.cacse450GProject;
import javax.swing.table.AbstractTableModel;

public abstract class TextTableModel extends AbstractTableModel
{

    public TextTableModel()
    {
    }

    public abstract boolean allowNumberingAt(int i);

    public abstract boolean addSeparatorAt(int i);

    private static final long serialVersionUID = 0xf6cc736fcb7e5027L;
}
