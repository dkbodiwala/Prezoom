package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import gui.javafx.Entry;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting GUI...");
        Entry.main(args);
    }

    private static Properties readProperties() 
    {
        Properties properties = new Properties();
        Path path = Paths.get("config.properties");
       
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            properties.load(reader);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return properties;
    }

    public static String getTitle()
    {
        return readProperties().getProperty("title");
    }
}