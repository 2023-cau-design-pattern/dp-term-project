package com.holub.database;

import java.io.*;
import java.util.Iterator;

public class HTMLExporter implements Table.Exporter {
    private final Writer out;

    public HTMLExporter(Writer out) {
        this.out = out;
    }

    @Override
    public void startTable() throws IOException {
        out.write("<html><body>\n");
        out.write("<table>\n");
    }

    @Override
    public void storeMetadata(String tableName, int width, int height, Iterator columnNames) throws IOException {
        out.write("<thead><tr>");
        out.write("<th colspan=\"" + width + "\">" + (tableName == null ? "Anonymous" : tableName) + "</th>");
        out.write("</tr></thead>\n");
        out.write("<tbody>\n");
        out.write("<tr>");
        while (columnNames.hasNext()) {
            out.write("<th>" + columnNames.next() + "</th>");
        }
        out.write("</tr>\n");
    }

    @Override
    public void storeRow(Iterator data) throws IOException {
        out.write("<tr>");
        while (data.hasNext()) {
            Object datum = data.next();
            out.write("<td>" + (datum == null ? "" : datum.toString()) + "</td>");
        }
        out.write("</tr>\n");
    }

    @Override
    public void endTable() throws IOException {
        out.write("</tbody>\n");
        out.write("</table>\n");
        out.write("</body></html>\n");
    }
}
