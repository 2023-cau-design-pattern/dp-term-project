package com.holub.database;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class HTMLExporterTest {

    private StringWriter stringWriter;
    private HTMLExporter exporter;

    @Before
    public void setUp() {
        stringWriter = new StringWriter();
        exporter = new HTMLExporter(stringWriter);
    }

    @Test
    public void testExportHTML() throws IOException {
        exporter.startTable();
        exporter.storeMetadata("test_table", 2, 2, Arrays.asList("id", "name").iterator());

        exporter.storeRow(Arrays.asList("1", "John").iterator());
        exporter.storeRow(Arrays.asList("2", "Jane").iterator());
        exporter.endTable();

        String expectedHTML =
                "<html><body>\n" +
                        "<table>\n" +
                        "<thead><tr><th colspan=\"2\">test_table</th></tr></thead>\n" +
                        "<tbody>\n" +
                        "<tr><th>id</th><th>name</th></tr>\n" +
                        "<tr><td>1</td><td>John</td></tr>\n" +
                        "<tr><td>2</td><td>Jane</td></tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</body></html>\n";

        assertEquals(expectedHTML, stringWriter.toString());
    }
}
