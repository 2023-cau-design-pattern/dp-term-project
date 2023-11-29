package com.holub.database;

import com.holub.tools.ArrayIterator;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLImporter implements Table.Importer {
    private BufferedReader in;
    private String tableName;
    private List<String> columnNames = new ArrayList<>();
    private NodeList rows;
    private int currentRow = 0;

    public XMLImporter(Reader in) {
        this.in = in instanceof BufferedReader ? (BufferedReader) in : new BufferedReader(in);
    }

    @Override
    public void startTable() throws IOException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(in));
            Element tableElement = doc.getDocumentElement();
            tableName = tableElement.getAttribute("name");

            NodeList columns = tableElement.getElementsByTagName("column");
            for (int i = 0; i < columns.getLength(); i++) {
                columnNames.add(columns.item(i).getTextContent());
            }

            rows = tableElement.getElementsByTagName("row");
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException("Failed to parse XML", e);
        }
    }

    @Override
    public String loadTableName() {
        return tableName;
    }

    @Override
    public int loadWidth() {
        return columnNames.size();
    }

    @Override
    public Iterator loadColumnNames() {
        return columnNames.iterator();
    }

    @Override
    public Iterator loadRow() {
        if (currentRow >= rows.getLength()) {
            return null; // No more rows
        }

        Element rowElement = (Element) rows.item(currentRow++);
        NodeList cells = rowElement.getChildNodes();
        String[] rowData = new String[cells.getLength()];
        for (int i = 0; i < cells.getLength(); i++) {
            rowData[i] = cells.item(i).getTextContent();
        }
        return new ArrayIterator(rowData);
    }

    @Override
    public void endTable() {
        // No specific action required at the end
    }
}
