package com.holub.database;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class XMLExporterTest {

    private StringWriter stringWriter;
    private XMLExporter exporter;

    @Before
    public void setUp() {
        stringWriter = new StringWriter();
        exporter = new XMLExporter(stringWriter);
    }

    @Test
    public void testExportXML() throws IOException {
        exporter.startTable();
        exporter.storeMetadata("test_table", 2, 2, Arrays.asList("id", "name").iterator());

        exporter.storeRow(Arrays.asList("1", "John").iterator());
        exporter.storeRow(Arrays.asList("2", "Jane").iterator());
        exporter.endTable();

        String expectedXML =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<table name=\"test_table\">\n" +
                        "<columns>\n" +
                        "<column>id</column>\n" +
                        "<column>name</column>\n" +
                        "</columns>\n" +
                        "<rows>\n" +
                        "<row>\n<id>1</id>\n<name>John</name>\n</row>\n" +
                        "<row>\n<id>2</id>\n<name>Jane</name>\n</row>\n" +
                        "</rows>\n" +
                        "</table>\n";

        assertEquals(expectedXML, stringWriter.toString());
    }
}
