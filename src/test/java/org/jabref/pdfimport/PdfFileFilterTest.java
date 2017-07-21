package org.jabref.pdfimport;

import org.junit.Test;

import static org.junit.Assert.*;


public class PdfFileFilterTest {

    @Test
    public void test1() {
        PdfFileFilter test = new PdfFileFilter();
        String path;
        path = test.replaceDotsByHifens("arquivo.teste.caso.01.pdf");
        assertEquals("arquivo-teste-caso-01.pdf", path);
    }

    @Test
    public void test2() {
        PdfFileFilter test = new PdfFileFilter();
        String path;
        path = test.replaceDotsByHifens("arquivo.teste.caso.01.engenharia.de.software.pdf");
        assertEquals("arquivo-teste-caso-01-engenharia-de-software.pdf", path);
    }

    @Test
    public void test3() {
        PdfFileFilter test = new PdfFileFilter();
        String path;
        path = test.replaceDotsByHifens(".arquivo.teste.caso.01.engenharia.de.software..pdf");
        assertEquals("-arquivo-teste-caso-01-engenharia-de-software-.pdf", path);
    }

}
