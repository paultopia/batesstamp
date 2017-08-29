package batesstamp;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.Matrix;

// based on http://svn.apache.org/repos/asf/pdfbox/trunk/examples/src/main/java/org/apache/pdfbox/examples/pdmodel/AddMessageToEachPage.java

public class BatesStamp {
    private static float fontSize = 12.0f;
    private static PDFont font = PDType1Font.HELVETICA_BOLD;
    
    private static void addToPage(PDDocument doc, PDPage page, String pg) throws IOException {
        try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, true, true)) {
            contentStream.beginText();
            contentStream.setFont( font, fontSize );
            contentStream.setNonStrokingColor(255, 0, 0);
            contentStream.setTextMatrix(Matrix.getTranslateInstance(5, 5));
            contentStream.showText(pg);
            contentStream.endText();
        }
    }
    
    public static void main(String[] args) throws IOException {
        String file = args[0];
        String outfile = args[1];
        int pagenum = 1;
        try (PDDocument doc = PDDocument.load(new File(file))) {
            for (PDPage page : doc.getPages()){
                String pg = Integer.toString(pagenum++); // reminder to self: post-eval black magic java trick https://stackoverflow.com/questions/2315705/what-is-the-difference-between-i-i-in-for-loop-java
                addToPage(doc, page, pg);
            }
            doc.save(outfile);
        }
    }
}
