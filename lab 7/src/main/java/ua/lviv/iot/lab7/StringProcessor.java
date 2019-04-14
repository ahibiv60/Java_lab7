package ua.lviv.iot.lab7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private String myTextInput = "";
    private static String fragmentsToFind;

    public void setMyTextInput(String myTextInput) {
        this.myTextInput = myTextInput;
    }
    
    public void setFragmentsToRemove(String string) {
        fragmentsToFind = string;
    }

    public void sentenceRegex() throws IOException {

        StringBuilder textInputStringBuilder = new StringBuilder(myTextInput);

        Pattern pattern = Pattern.compile("(\\w+)?+(\\w+)?\\s");
        Matcher matcher = pattern.matcher(textInputStringBuilder);

        while (matcher.find()) {
            if (matcher.group().contains(fragmentsToFind)) {
                textInputStringBuilder.delete(matcher.start(), matcher.end());
                matcher = pattern.matcher(textInputStringBuilder.toString());
            }
        }

        myTextInput = textInputStringBuilder.toString();

    }

    public String showResults() {
        System.out.println("Result:");
        System.out.println(myTextInput);
        return myTextInput;
    }
}
