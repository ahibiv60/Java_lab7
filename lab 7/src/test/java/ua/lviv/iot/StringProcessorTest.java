package ua.lviv.iot;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

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
    public void testProcessText() throws IOException {
        
        stringProcessor.setMyTextInput("yellow fox jump over green dog");

        stringProcessor.setFragmentsToRemove("ye"); // yellow
        stringProcessor.sentenceRegex();
        stringProcessor.setFragmentsToRemove("mp"); // jump
        stringProcessor.sentenceRegex();
        stringProcessor.setFragmentsToRemove("re"); // greed
        stringProcessor.sentenceRegex();
        
        Assert.assertEquals("fox over dog", stringProcessor.showResults());
    }

}