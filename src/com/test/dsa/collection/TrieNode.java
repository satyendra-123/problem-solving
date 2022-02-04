package com.test.dsa.collection;

import java.util.List;


public class TrieNode {
    public char value;
    private List<TrieNode> children;
    private boolean isLastNode;

    public TrieNode(char c){
        this.value =c;
    }

    public void setChildren(List<TrieNode> children) {
        this.children = children;
    }

    public void setLastNode(boolean lastNode) {
        isLastNode = lastNode;
    }

    public List<TrieNode> getChildren() {
        return children;
    }

    public boolean isLastNode() {
        return isLastNode;
    }

    public char getValue() {
        return value;
    }
}
