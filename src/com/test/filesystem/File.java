package com.test.filesystem;

import java.util.ArrayList;
import java.util.List;

public class File<T> {
    List<T> data;

    Inode inode;

    public Inode getInode() {
        return inode;
    }

    public List<T> getData() {
        return data;
    }

    public File (List<T> data, String fileName, String fileType){
        this.inode = new Inode(fileName, fileType);
        this.data = data;
    }
}
