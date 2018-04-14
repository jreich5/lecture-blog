package com.codeup.lectureblog.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PigLatinSvc {

    public String translate(String phrase) {

        List<String> words = Arrays.asList(phrase.split("\\s+"));
        ArrayList<String> outputWords = new ArrayList<>();

        for (String word : words) {
            outputWords.add(translateWord(word));
        }

        return String.join(" ", outputWords);

    }

    public String translateWord(String word) {

        String output = word;

        if (word.substring(0, 1).toLowerCase().matches("[b-df-hj-np-tv-z]")) {
            output = word.substring(1) + word.substring(0, 1) + "ay";
        } else {
            output = word + "way";
        }

        return output;

    }


}
