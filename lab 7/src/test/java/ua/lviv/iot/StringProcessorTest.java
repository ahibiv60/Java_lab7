package ua.lviv.iot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import ua.lviv.iot.lab7.StringProcessor;

public class StringProcessorTest {

    private StringProcessor stringProcessor;

    @BeforeEach
    public void setUp() {
        stringProcessor = new StringProcessor();

    }

    @Test
    public void testReadInputText() {

        String expectedInput = "String processor. ";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Assert.assertEquals("String processor. ", StringProcessor.readInputText());

    }

    @Test
    public void testShowResult() {
        Assert.assertEquals("", stringProcessor.showResults());
    }

    @Test
    public void testProcessText() throws IOException {

        stringProcessor.setMyTextInput("yellow fox jump over green dog");

        stringProcessor.setFragmentsToRemove("ye");
        stringProcessor.sentenceRegex();
        stringProcessor.setFragmentsToRemove("mp");
        stringProcessor.sentenceRegex();
        stringProcessor.setFragmentsToRemove("re");
        stringProcessor.sentenceRegex();

        Assert.assertEquals("fox over dog", stringProcessor.showResults());
    }

}