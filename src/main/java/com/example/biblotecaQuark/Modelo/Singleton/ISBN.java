package com.example.biblotecaQuark.Modelo.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ISBN {
    private static ISBN isbn;

    private static List<String> isbnList;

    private ISBN(){
        isbnList = new ArrayList<String>();
    }

    public static Boolean getInstance(String obISBN){
        if (isbn == null) {
            isbn = new ISBN();
        }



        return agregarISBN(obISBN);
    }

    private static Boolean agregarISBN(String obISBN){
        List<String> isbnfilt = isbnList.stream().filter(isbnop -> Objects.equals(isbnop, obISBN)).toList();

        if(isbnfilt.isEmpty()){
            isbnList.add(obISBN);
            return true;
        }
        return false;
    }

}
