package ua.lviv.iot.lab7;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private String myTextInput = "";
    private static String fragmentsToFind;
    public static boolean checker = false;

    public void setMyTextInput(String myTextInput) {
        this.myTextInput = myTextInput;
    }

    public void setFragmentsToRemove(String string) {
        fragmentsToFind = string;
    }

    public static void main(String[] args) throws IOException {
        StringProcessor stringProcessor = new StringProcessor();

        stringProcessor.textEnter();

        stringProcessor.readFragmentsToRemove();

        stringProcessor.sentenceRegex();

        while (true) {
            if (checker == false && fragmentsToFind.split(" ").length == 1) {
                stringProcessor.readFragmentsToRemove();
                stringProcessor.sentenceRegex();
            } else if (checker == true) {
                break;
            } else {
                System.out.print("You enter more than one fragment\n");
                stringProcessor.readFragmentsToRemove();
                stringProcessor.sentenceRegex();
            }

        }

        stringProcessor.showResults();
    }

    public static String readInputText() {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in, "UTF-8");

        return scanner.nextLine().trim().replaceAll("\\s*[.]\\s*", ". ");
    }

    public void textEnter() {
        System.out.print("Enter your text here: ");
        myTextInput = readInputText();
    }

    public void readFragmentsToRemove() {
        while (true) {

            System.out.print("Enter fragments you want to find and delete: ");
            fragmentsToFind = readInputText();

            if (fragmentsToFind.equals("break")) {
                checker = true;
            }
            break;
        }
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
