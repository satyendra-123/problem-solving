package com.test.filesystem;

import java.util.UUID;

public class Inode {

    private String fileName;
    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public Inode(String fileName, String fileType){
        this.fileName = fileName;
        this.fileType = fileType;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        Inode inode = (Inode) obj;
        if(this.fileName.equals(inode.fileName))
            return true;
        return false;
    }

//    @Override
//    public int hashCode() {
//        return UUID.randomUUID().hashCode();
//    }
}
