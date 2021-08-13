package com.siemens.interview.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class IOUtils {

    public static Path getFilePathFromConsole(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String filePathString = in.nextLine();
        return Paths.get(filePathString);
    }
}
