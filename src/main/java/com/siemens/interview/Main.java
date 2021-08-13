package com.siemens.interview;

import com.siemens.interview.util.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path filePath = IOUtils.getFilePathFromConsole();
        if (Files.exists(filePath)) {
            final List<String> lines = Files.readAllLines(filePath);
            DistinctLetterCount.print(lines);
        } else {
            throw new FileNotFoundException("File not found at " + filePath.toString());
        }
    }
}
