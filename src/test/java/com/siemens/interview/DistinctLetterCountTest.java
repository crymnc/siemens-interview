package com.siemens.interview;

import com.siemens.interview.util.IOUtils;
import com.siemens.interview.validation.LineValidator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DistinctLetterCountTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void shouldPrintDeletionCount(){
        List<String> lines = Arrays.asList("aaaabbbb","bbbccaa","eeoooppdddddfff");
        List<Integer> results = new ArrayList<>();
        for(String line: lines){
            results.add(DistinctLetterCount.calculateDeletionCount(line));
        }
        Assert.assertEquals(Arrays.asList(1,1,4),results);
    }

    @Test
    public void shouldNotValidate(){
        Assert.assertTrue(!LineValidator.validate("AA"));
        Assert.assertTrue(!LineValidator.validate("aa99"));
        Assert.assertTrue(!LineValidator.validate(" "));
        Assert.assertTrue(!LineValidator.validate(""));
        Assert.assertTrue(!LineValidator.validate("a".repeat(300001)));
    }

    @Test
    public void shouldValidate(){
        Assert.assertTrue(LineValidator.validate("aaeeddd"));
    }

    @Test
    public void shouldThrowIllegalArgumentException(){
        List<String> lines = Arrays.asList("AS22");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DistinctLetterCount.print(lines));
        String expectedMessage = "Illegal text AS22";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void shouldPrintDeletionCountToConsole(){
        List<String> lines = Arrays.asList("aabbccc","eeeeddddcccxx");
        DistinctLetterCount.print(lines);
        assertEquals("1- 1\r\n2- 3\r\n", outContent.toString());
    }

    @Test
    public void shouldFindPath(){
        ByteArrayInputStream in = new ByteArrayInputStream("resources\\test.txt".getBytes());
        System.setIn(in);
        assertEquals("test.txt",IOUtils.getFilePathFromConsole().getFileName().toString());
    }

    @Test
    public void shouldThrowFileNotFoundException() {
        ByteArrayInputStream in = new ByteArrayInputStream("resources\\test1.txt".getBytes());
        System.setIn(in);
        Exception exception = assertThrows(IOException.class, () -> Main.main(new String[]{}));

        String expectedMessage = "File not found at resources\\test1.txt";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }
}
