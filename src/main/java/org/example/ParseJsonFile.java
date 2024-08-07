package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
public class ParseJsonFile extends PrintWrite{
    public String objectMapper (Library library){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonBook;
        try {
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            jsonBook = writer.writeValueAsString(library);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonBook;
    }
}
