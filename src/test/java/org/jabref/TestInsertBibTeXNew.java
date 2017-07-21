package org.jabref;

import java.io.IOException;
import java.io.StringWriter;

import org.jabref.logic.bibtex.BibEntryWriter;
import org.jabref.logic.bibtex.LatexFieldFormatter;
import org.jabref.logic.bibtex.LatexFieldFormatterPreferences;
import org.jabref.logic.util.OS;
import org.jabref.model.database.BibDatabaseMode;
import org.jabref.model.entry.BibEntry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author felipejosebento
 *
 *   Teste da Inserção:
 *   Na funcionalidade Inserção de item bibliográfico (BibTeX → New
 *   entry), para as categorias book e article, realizar os seguintes
 *   incrementos:
 *   – Validar os seguintes campos de acordo com as seguintes regras:
 *   -> Year: deve ser um ano válido (de acordo com o calendário da linguagem Java)
 *   -> Bibtexkey: definido pelo usuário ou automaticamente, deve ter no mínimo 2
 *      caracteres, sendo o primeiro uma letra maiúscula ou minúscula
 */
public class TestInsertBibTeXNew {

    BibEntryWriter bibEntryWriter;

    @Before
    public void setUpWriter() {
        LatexFieldFormatterPreferences latexFieldFormatterPreferences = new LatexFieldFormatterPreferences();
        bibEntryWriter = new BibEntryWriter(new LatexFieldFormatter(latexFieldFormatterPreferences), true);
    }

    /**
     * Iremos testar com os campos do artigo vázios
     * @throws IOException
     */
    @Test
    public void TestIfFildIsEmptyArticle() throws IOException {

//        New writer
        StringWriter stringWriter;
        stringWriter = new StringWriter();

//        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Article");

//        Inserts writing and compare
        bibEntryWriter.write(bibEntry, stringWriter, BibDatabaseMode.BIBTEX);

        String stringReceived = stringWriter.toString();
        String stringSucess;
        stringSucess = OS.NEWLINE + "@Article{," + OS.NEWLINE + "}" + OS.NEWLINE;

//        Equality check #stringTest #stringSucess
        assertEquals(stringReceived, stringSucess);
    }

    /**
     * Iremos testar com alguns dos campos do artigo preenchidos
     * @throws Exception
     */
    @Test
    public void TestIfFildIsFullArticle() throws Exception {

//        New writer
        StringWriter stringWriter;
        stringWriter = new StringWriter();

//        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Article");

        //        Entry request insert
        bibEntry.setField("author", "Leonardo DaVince");
        bibEntry.setField("title", "Anatomy");
        bibEntry.setField("journal", "Anatomy and physiology");
        bibEntry.setField("year", "1500");
        bibEntry.setField("bibtexkey", "DaVince_Key");
        bibEntry.setField("volume", "14");
        bibEntry.setField("number", "401");
        bibEntry.setField("pages", "8");
        bibEntry.setField("month", "December");
        bibEntry.setField("note", "DaVince_note");
        bibEntry.setField("crossref", "anatomy");
        bibEntry.setField("keywords", "DaVince");
        bibEntry.setField("url", "davince.com");
        bibEntry.setField("owner", "journal_davince");
        bibEntry.setField("timestamp", "1500-01-01");
        bibEntry.setField("review", "very, excellent");

//        Inserts writing and compare
        bibEntryWriter.write(bibEntry, stringWriter, BibDatabaseMode.BIBTEX);

        String stringReceived = stringWriter.toString();
        String stringSucess;

        stringSucess = OS.NEWLINE + "@Article{DaVince_Key," + OS.NEWLINE +
                "  author    = {Leonardo DaVince}," + OS.NEWLINE +
                "  title     = {Anatomy}," + OS.NEWLINE +
                "  journal   = {Anatomy and physiology}," + OS.NEWLINE +
                "  year      = {1500}," + OS.NEWLINE +
                "  volume    = {14}," + OS.NEWLINE +
                "  number    = {401}," + OS.NEWLINE +
                "  pages     = {8}," + OS.NEWLINE +
                "  month     = {December}," + OS.NEWLINE +
                "  note      = {DaVince_note}," + OS.NEWLINE +
                "  crossref  = {anatomy}," + OS.NEWLINE +
                "  keywords  = {DaVince}," + OS.NEWLINE +
                "  owner     = {journal_davince}," + OS.NEWLINE +
                "  review    = {very, excellent}," + OS.NEWLINE +
                "  timestamp = {1500-01-01}," + OS.NEWLINE +
                "  url       = {davince.com}," + OS.NEWLINE +
                "}" + OS.NEWLINE;

//        Equality check #stringTest #stringSucess
        assertEquals(stringReceived, stringSucess);
    }

    /**
     * Iremos testar com os campos do livro vázios
     * @throws IOException
     */
    @Test
    public void TestIfFildIsEmptyBook() throws Exception {

        //      New writer
        StringWriter stringWriter;
        stringWriter = new StringWriter();

        //      New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Book");

        //    Inserts writing and compare
        bibEntryWriter.write(bibEntry, stringWriter, BibDatabaseMode.BIBTEX);

        String stringReceived = stringWriter.toString();
        String stringSucess;
        stringSucess = OS.NEWLINE + "@Book{," + OS.NEWLINE + "}" + OS.NEWLINE;

        //    Equality check #stringTest #stringSucess
        assertEquals(stringReceived, stringSucess);
    }

    /**
     * Iremos testar com alguns dos campos do livro preenchidos
     * @throws IOException
     */
    @Test
    public void TestIfFildIsFullBook() throws Exception {
        //      New writer
        StringWriter stringWriter;
        stringWriter = new StringWriter();

        //      New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Book");

        bibEntry.setField("title", "Harry Potter");
        bibEntry.setField("bibtexkey", "harrypotter_Key");
        bibEntry.setField("publisher", "Amazon");
        bibEntry.setField("year", "2007");
        bibEntry.setField("author", "JKR");
        bibEntry.setField("volume", "2");
        bibEntry.setField("number", "1");
        bibEntry.setField("series", "harry potter");
        bibEntry.setField("edition", "4");
        bibEntry.setField("month", "March");
        bibEntry.setField("note", "hard cover");
        bibEntry.setField("keywords", "harry potter");
        bibEntry.setField("url", "www.harrypotter.com");
        bibEntry.setField("comment", "fine book");
        bibEntry.setField("owner", "JKR");
        bibEntry.setField("abstract", "harry");
        bibEntry.setField("review", "very, fine");

        //        Inserts writing and compare
        bibEntryWriter.write(bibEntry, stringWriter, BibDatabaseMode.BIBTEX);

        String stringReceived = stringWriter.toString();
        String stringSucess;

        stringSucess = OS.NEWLINE + "@Book{harrypotter_Key," + OS.NEWLINE +
                "  title     = {Harry Potter}," + OS.NEWLINE +
                "  publisher = {Amazon}," + OS.NEWLINE +
                "  year      = {2007}," + OS.NEWLINE +
                "  author    = {JKR}," + OS.NEWLINE +
                "  volume    = {2}," + OS.NEWLINE +
                "  number    = {1}," + OS.NEWLINE +
                "  series    = {harry potter}," + OS.NEWLINE +
                "  edition   = {4}," + OS.NEWLINE +
                "  month     = {March}," + OS.NEWLINE +
                "  note      = {hard cover}," + OS.NEWLINE +
                "  abstract  = {harry}," + OS.NEWLINE +
                "  comment   = {fine book}," + OS.NEWLINE +
                "  keywords  = {harry potter}," + OS.NEWLINE +
                "  owner     = {JKR}," + OS.NEWLINE +
                "  review    = {very, fine}," + OS.NEWLINE +
                "  url       = {www.harrypotter.com}," + OS.NEWLINE +
                "}" + OS.NEWLINE;

        //        Equality check #stringTest #stringSucess
        assertEquals(stringReceived, stringSucess);
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Artigo/Autor
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerArticleAuthor() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Article");

        bibEntry.setField("author", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Artigo/Titulo
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerArticleTitle() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Article");

        bibEntry.setField("title", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Artigo/Ano
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerArticleYear() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Article");

        bibEntry.setField("year", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Livro/Titulo
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerBookTitle() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("book");

        bibEntry.setField("title", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Livro/Autor
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerBookAuthor() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("book");

        bibEntry.setField("author", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Livro/Ano
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerBookYear() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("book");

        bibEntry.setField("year", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Livro/Chave
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerBookKey() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("book");

        bibEntry.setField("bibtexkey", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de NullPointerException.class
     * Objeto Testado: Artigo/Chave
     */
    @Test(expected = NullPointerException.class)
    public void isNullPointerArticleKey() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("article");

        bibEntry.setField("bibtexkey", null);
        fail();
    }

    /**
     * Teste: Ocorrencia de IllegalArgumentException.class
     * Objeto Testado: Date
     */
    @Test(expected = IllegalArgumentException.class)
    public void isExceptionArticleYear() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Article");

        bibEntry.setField("year", "-20000");
        fail();
    }

    /**
     * Teste: Ocorrencia de IllegalArgumentException.class
     * Objeto Testado: Date
     */
    @Test(expected = IllegalArgumentException.class)
    public void isExceptionArticleYear2() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("Article");

        bibEntry.setField("year", "Ano?");
        fail();
    }

    /**
     * Teste: Ocorrencia de IllegalArgumentException.class
     * Objeto Testado: Key
     */
    @Test(expected = IllegalArgumentException.class)
    public void isExceptionArticleKey() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("bibtexkey");
        bibEntry.setField("bibtexkey", "007");
        fail();
    }

    /**
     * Teste: Ocorrencia de IllegalArgumentException.class
     * Objeto Testado: Key
     */
    @Test(expected = IllegalArgumentException.class)
    public void isExceptionArticleKey2() {

        //        New common entrance
        BibEntry bibEntry;
        bibEntry = new BibEntry("bibtexkey");
        bibEntry.setField("bibtexkey", "Fa");
        fail();
    }
}