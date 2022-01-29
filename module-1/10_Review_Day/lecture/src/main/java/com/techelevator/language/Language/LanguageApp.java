package com.techelevator.language.Language;

import com.techelevator.language.SalutationTranslator;

public class LanguageApp {
    public static void main(String[] args) {
        SalutationTranslator translator= new SalutationTranslator();

        System.out.println(translator.getGreeting("Spanish"));

        translator.setDefaultLanguage("Spanish");


    }

}
