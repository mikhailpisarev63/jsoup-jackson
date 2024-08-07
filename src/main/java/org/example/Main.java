package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
    private final static String dataFileOne = "data/codeSkillbox.html";
    private final static String dataFileTwo = "data/coursePython.html";
    private final static String dataJsonFile = "data/book.json";
    private static ParseHTMLFile parseHTMLFile = new ParseHTMLFile();
    private static Library library = new Library();
    private static Reader reader = new Reader();
    private static Book book = new Book();
    private static ParseJsonFile parseJsonFile = new ParseJsonFile();
    public static void main(String[] args) {

        parseHTMLFile.HTMLParse();
        parseHTMLFile.printWrite(dataFileOne, String.valueOf(parseHTMLFile.HTMLParse()));
        Document document = Jsoup.parse(parseHTMLFile.readCode(dataFileOne));
        System.out.println("Вывод заголовка с курса Python-разработчик" + System.lineSeparator() +
                parseHTMLFile.productSkillboxDeveloper(document, dataFileTwo, dataFileTwo)
                + System.lineSeparator());

        book.setTitle("Обитаемый остров");
        book.setAuthor("Стругацкий А., Стругацкий Б.");
        book.setPages(413);
        reader.setId(1);
        reader.setNameReader("Михаил Писарев");
        reader.setBook(book);

        library.setNameLibrary("Солнышко");
        library.setReader(reader);
        parseJsonFile.printWrite(dataJsonFile, parseJsonFile.objectMapper(library));
        System.out.println("Вывод файла Json с форматированием" + System.lineSeparator() +
                parseJsonFile.objectMapper(library));
    }
}