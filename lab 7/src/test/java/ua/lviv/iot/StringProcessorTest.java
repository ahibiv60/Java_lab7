package ua.lviv.iot;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        assertEquals("String processor. ", StringProcessor.readInputText());

    }

    @Test
    public void testShowResult() {
        assertEquals("", stringProcessor.showResults());
    }

}