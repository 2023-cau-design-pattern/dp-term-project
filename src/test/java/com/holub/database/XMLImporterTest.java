package com.holub.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XMLImporterTest {

    private static final String TEST_XML =
            "<table name='test_table'>" +
                    "<columns>" +
                    "<column>id</column>" +
                    "<column>name</column>" +
                    "</columns>" +
                    "<rows>" +
                    "<row><id>1</id><name>John</name></row>" +
                    "<row><id>2</id><name>Jane</name></row>" +
                    "</rows>" +
                    "</table>";

    private XMLImporter importer;

    @BeforeEach
    public void setUp() throws IOException {
        importer = new XMLImporter(new StringReader(TEST_XML));
        importer.startTable();
    }

    @Test
    public void testLoadTableName() {
        assertEquals("test_table", importer.loadTableName());
    }

    @Test
    public void testLoadWidth() {
        assertEquals(2, importer.loadWidth());
    }

    @Test
    public void testLoadColumnNames() {
        Iterator columnNames = importer.loadColumnNames();
        assertEquals("id", columnNames.next());
        assertEquals("name", columnNames.next());
        assertFalse(columnNames.hasNext());
    }

    @Test
    public void testLoadRow() {
        Iterator firstRow = importer.loadRow();
        assertEquals("1", firstRow.next());
        assertEquals("John", firstRow.next());

        Iterator secondRow = importer.loadRow();
        assertEquals("2", secondRow.next());
        assertEquals("Jane", secondRow.next());
    }

    @Test
    public void testEndTable() {
        importer.endTable(); // just to ensure no exceptions are thrown
    }
}
