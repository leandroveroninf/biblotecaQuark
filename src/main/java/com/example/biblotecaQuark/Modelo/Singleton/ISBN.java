package com.example.biblotecaQuark.Modelo.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ISBN {
    private static ISBN isbn;

    private static List<Integer> isbnList;

    private ISBN(){
        isbnList = new ArrayList<Integer>();
    }

    public static Boolean getInstance(int obISBN){
        if (isbn == null) {
            isbn = new ISBN();
        }



        return agregarISBN(obISBN);
    }

    private static Boolean agregarISBN(int obISBN){
        List<Integer> isbnfilt = isbnList.stream().filter(isbnop -> isbnop == obISBN).toList();

        if(isbnfilt.isEmpty()){
            isbnList.add(obISBN);
            return true;
        }
        return false;
    }

}
