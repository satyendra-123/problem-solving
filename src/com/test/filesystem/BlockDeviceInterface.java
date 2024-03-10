package com.test.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlockDeviceInterface {

    private Map<Inode, List<Block>> files;

    private  static BlockDeviceInterface blockDeviceInterface;

    //allocates file to the blocks

    // divide by equal size
    //
    void divide(File file) {
        List<Block> blocks = new ArrayList<>();
        if(file.getInode().getFileType().equals("String")) {
            file.getData().stream().forEach(d -> {
                blocks.add(new Block<String>((String) d));
            });
        }
        files.put(file.getInode(), blocks);
    }

    private BlockDeviceInterface(Map<Inode, List<Block>> files){
        this.files = files;
    }

    public static BlockDeviceInterface getInstance(Map<Inode, List<Block>> files) {
        if(blockDeviceInterface == null)
           blockDeviceInterface =  new BlockDeviceInterface(files);
        return blockDeviceInterface;
    }
}
