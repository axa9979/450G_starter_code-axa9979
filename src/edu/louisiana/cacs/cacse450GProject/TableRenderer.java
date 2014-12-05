package edu.louisiana.cacs.cacse450GProject;
import java.io.OutputStream;
import java.io.Writer;

public interface TableRenderer
{

    public abstract void render(OutputStream outputstream, int i);

    public abstract void render(Writer writer, int i);
}
