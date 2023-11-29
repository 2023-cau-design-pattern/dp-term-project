package com.holub.database;

import org.junit.*;

import static org.junit.Assert.*;
import java.io.*;
import java.util.Arrays;

public class XMLExporterTest {

//    private StringWriter stringWriter;
    private FileWriter fileWriter;
    private XMLExporter exporter;
    private File outputFile;

    @Before
    public void setUp() throws IOException {
//        stringWriter = new StringWriter();
        outputFile = new File("test.xml");
        fileWriter = new FileWriter(outputFile);
        exporter = new XMLExporter(fileWriter);
    }

    @Test
    public void testExportXML() throws IOException {
        exporter.startTable();
        exporter.storeMetadata("test_table", 2, 2, Arrays.asList("id", "name").iterator());

        exporter.storeRow(Arrays.asList("1", "John").iterator());
        exporter.storeRow(Arrays.asList("2", "Jane").iterator());
        exporter.endTable();

        fileWriter.close();

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


        // 파일 내용 읽기
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        }

        // 기대하는 XML 문자열과 파일에서 읽은 내용 비교
        assertEquals(expectedXML.trim(), fileContent.toString().trim());
    }
}
