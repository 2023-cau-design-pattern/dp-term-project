package com.holub.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HTMLExporterTest {

    private File outputFile;
    private FileWriter fileWriter;
    private HTMLExporter exporter;

    @BeforeEach
    public void setUp() throws IOException {
        outputFile = new File("test.html");
        fileWriter = new FileWriter(outputFile);
        exporter = new HTMLExporter(fileWriter);
    }

    @Test
    public void testExportHTML() throws IOException {
        exporter.startTable();
        exporter.storeMetadata("test_table", 2, 2, Arrays.asList("id", "name").iterator());

        exporter.storeRow(Arrays.asList("1", "John").iterator());
        exporter.storeRow(Arrays.asList("2", "Jane").iterator());
        exporter.endTable();

        fileWriter.close();

        // 파일 내용 읽기
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        }

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

        assertEquals(expectedHTML.trim(), fileContent.toString().trim());
    }
}
