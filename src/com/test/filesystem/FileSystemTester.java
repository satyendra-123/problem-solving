package com.test.filesystem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSystemTester {
    public static void main(String[] args) {
        List<String> data = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
        File file = new File(data, "file1", "String");
        FileSystem instance = FileSystem.getInstance();
        instance.write(file);

        instance.read(file).stream().forEach(d-> {
            System.out.println(d.getFileData());
        });
    }
}
