package com.notification.utility;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class PdfGenerator {

    public static Path generateSimplePdf(String content) {

        try {
            Path pdfPath = Path.of(
                    System.getProperty("java.io.tmpdir"),
                    "notification-" + System.currentTimeMillis() + ".pdf"
            );

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath.toFile()));

            document.open();
            document.add(new Paragraph("Notification PDF"));
            document.add(new Paragraph("-----------------------"));
            document.add(new Paragraph(content));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Generated at: " + LocalDateTime.now()));
            document.close();

            return pdfPath;

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF", e);
        }
    }
}
