package com.test.filesystem;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * File system can keep track of blocks allocated or unallocated to file
 * File System
 */
public class FileSystem {

    private static Map<Inode, List<Block>> files = new HashMap<>();

    private static BlockDeviceInterface blockDeviceInterface;

    private static FileSystem fileSystem;

    static FileSystem getInstance(){
        if(fileSystem == null) {
            fileSystem = new FileSystem();
            blockDeviceInterface = BlockDeviceInterface.getInstance(files);
        }
        return fileSystem;
    }

    public List<Block> read(File file){
        try{
            open(file);
        }
        catch (RuntimeException ex){
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
       return files.get(file.getInode());
    }

    public void write(File file){
        blockDeviceInterface.divide(file);
    }

    public void delete(File file){
        try{
            open(file);
        }
        catch (RuntimeException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        files.remove(file.getInode());
    }

    public void open(File file){
        if(!files.containsKey(file.getInode()))
            throw new RuntimeException("File not found");
        //checks file path and if not found throws error
    }
}
