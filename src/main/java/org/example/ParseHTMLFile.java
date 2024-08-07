package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ParseHTMLFile extends PrintWrite{
    private final String skillboxURL = "https://skillbox.ru";
    private final static String path = "https://skillbox.ru/code/";

    public Document HTMLParse(){
        Document document;
        try {
             document = Jsoup.connect(path).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return document;
    }
    public String readCode(String code){
        StringBuilder builder = new StringBuilder();
        try {
            List<String> list = Files.readAllLines(Path.of(code));
            list.forEach(l -> builder
                    .append(l)
                    .append(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }
    public String productSkillboxDeveloper (Document document, String write, String code) {
        Elements elements = document.getElementsByAttributeValue("href", "/course/profession-python/");
        String pagePython;
        StringBuilder title = new StringBuilder();
        for (Element elementHref : elements){
            pagePython = elementHref.attr("href");
            Document doc;
            try {
                doc =  Jsoup.connect(skillboxURL + pagePython).get();
                printWrite(write, String.valueOf(HTMLParse()));
                readCode(code);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Elements title2 = doc.select("h1.start-screen-v3__title");
            title.append(title2.text());
        }
        return title.toString();
    }
}