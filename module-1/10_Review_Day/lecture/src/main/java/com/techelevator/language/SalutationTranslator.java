package com.techelevator.language;

import java.awt.*;

public class SalutationTranslator {

    private String defaultLanguage;

    public String getDefaultLanguage(){
        return defaultLanguage;
    }

    public void setDefaultLanguage(String language){
        this.defaultLanguage = defaultLanguage;
    }



    public String getGreeting(String language){
        if (language.equals("English")){
            return "Hello";
        }else if (language.equals("Spanish")){
            return "Hola";
        }else if (language.equals("French")){
            return "Bonjour";
        }
        return "";
    }
}
