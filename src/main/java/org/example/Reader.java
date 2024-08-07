package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Reader{
    private int id;
    private String nameReader;
    private Book book;
}

