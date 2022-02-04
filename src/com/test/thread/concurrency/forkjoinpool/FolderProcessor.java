package com.test.thread.concurrency.forkjoinpool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

public class FolderProcessor extends RecursiveTask<List<String>> {

    private final String path;

    private final String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();
        File file = new File(path);
        File contents[] = file.listFiles();
        if(contents != null){
            for(File content: contents ){
                    if(content.isDirectory()){
                            FolderProcessor task = new FolderProcessor(content.getAbsolutePath(), extension);
                            task.fork();
                            tasks.add(task);
                    }else if(content.getName().endsWith(extension)){
                            list.add(content.getAbsolutePath());
                    }
            }
        }
        if(tasks.size() > 50) {
            System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
        }
        tasks.parallelStream().forEach(c-> list.addAll(c.join()));
        return list;
    }
}
