package com.holub.database;

import java.io.*;
import java.util.*;

public class XMLExporter implements Table.Exporter {
    private final Writer out;
    private String tableName;
    private int width;
    private List<String> columnNames = new ArrayList<>(); // 컬럼 이름을 저장하는 리스트 추가

    public XMLExporter(Writer out) {
        this.out = out;
    }

    @Override
    public void startTable() throws IOException {
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    }

    @Override
    public void storeMetadata(String tableName, int width, int height, Iterator columnNames) throws IOException {
        this.tableName = tableName == null ? "anonymous" : tableName;
        this.width = width;

        out.write("<table name=\"" + this.tableName + "\">\n");
        out.write("<columns>\n");
        while (columnNames.hasNext()) {
            String columnName = (String) columnNames.next();
            this.columnNames.add(columnName); // 컬럼 이름을 리스트에 저장
            out.write("<column>" + columnName + "</column>\n");
        }
        out.write("</columns>\n");
        out.write("<rows>\n");
    }

    @Override
    public void storeRow(Iterator data) throws IOException {
        out.write("<row>\n");
        int columnIndex = 0;
        while (data.hasNext()) {
            Object datum = data.next();
            String columnName = columnNames.get(columnIndex++);
            out.write("<" + columnName + ">" + (datum == null ? "" : datum.toString()) + "</" + columnName + ">\n");
        }
        out.write("</row>\n");
    }

    @Override
    public void endTable() throws IOException {
        out.write("</rows>\n");
        out.write("</table>\n");
    }
}
