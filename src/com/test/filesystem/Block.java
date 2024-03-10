package com.test.filesystem;

public class Block<T> {

    private T fileData;

    Block(T fileData){
        this.fileData = fileData;
    }

    public T getFileData() {
        return fileData;
    }
}
