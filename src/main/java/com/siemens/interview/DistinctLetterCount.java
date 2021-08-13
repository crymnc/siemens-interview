package com.siemens.interview;

import com.siemens.interview.validation.LineValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistinctLetterCount {

    public static void print(List<String> lines) {
        //create a stream to loop lines
        IntStream.range(0, lines.size()).mapToObj(index -> {
                    String line = lines.get(index);
                    //calculate deletion count and return it with line number as a string
                    return index + 1 + "- " + calculateDeletionCount(line);
                }
        ).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static int calculateDeletionCount(String text) {
        //run constraints
        if (!LineValidator.validate(text))
            throw new IllegalArgumentException("Illegal text " + (text));
        //Stores count of letters
        HashMap<Character, Integer> letters = new HashMap<>();
        //Parse the text to chars for counting letters
        for (Character letter : text.toCharArray()) {
            //if a letter repeats itself, increase the count by 1
            letters.put(letter, letters.get(letter) == null ? 1 : letters.get(letter) + 1);
        }

        //Stores minimum deletion count
        int deletionCount = 0;

        //Stores repeated letter counts (rlc list)
        List<Integer> repeatedLetterCounts = new ArrayList<>();
        //Loop in letters to compare every letter count with repeated letter count
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            Integer currentLetterCount = entry.getValue();
            //if current value exists in the rlc list, to calculate how many letters we should delete to find unused count
            if (repeatedLetterCounts.contains(currentLetterCount)) {
                //loop until to find a unused count
                while (repeatedLetterCounts.contains(currentLetterCount) && currentLetterCount > 0) {
                    //increase delete count by 1 every time that not find unused count
                    deletionCount++;
                    // and decrease letter count to store how many letters we have for deletion
                    currentLetterCount--;
                }
                //check zero because it is not a usable count
                if (currentLetterCount != 0)
                    //add used letter count to rlc list to compare later
                    repeatedLetterCounts.add(currentLetterCount);
            } else
                //add used letter count to rlc list
                repeatedLetterCounts.add(entry.getValue());
        }
        return deletionCount;
    }
}
