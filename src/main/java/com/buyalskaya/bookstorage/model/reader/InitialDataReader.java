package com.buyalskaya.bookstorage.model.reader;

import com.buyalskaya.bookstorage.model.exception.ProjectException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class InitialDataReader {
    public static final String DEFAULT_PATH = "resources/initialStorage.txt";

    public List<String> readInitialData(String filePath) throws ProjectException {
        List<String> data;
        if (filePath == null || filePath.equals("") || !Files.exists(Paths.get(filePath))) {
            filePath = DEFAULT_PATH;
        }
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            data = bufferedReader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new ProjectException("Error in opening file " + filePath, e);
        }
        return data;
    }
}
