package ru.x5.safe.consumer.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileService {


    public void writeFile(String name, String body) throws IOException {
        File file = File.createTempFile(name, ".msg");
        System.out.println(file.getAbsolutePath());
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(body);
        fileWriter.close();
    }
}
