package com.test.dsa.collection;

import com.test.dsa.Node;

public class TreeTester {

    static int max_level = 0;
    public static void main(String[] args) {
        Node root = createBinaryTree();
        //preOrder(root);
        System.out.print("\n");
        //postOrder(root);
        System.out.print("\n");
        //printLeafNodes(root);

        //levelOrder(root);

        printleftview(root);

    }

    /**
     * create binary tree from a given array
     * @param arr
     * @return
     */
    private static Node createBinaryTree(int[] arr){

        return null;
    }

    //binary tree
    private static Node createBinaryTree(){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(5);

        node.left.left = new Node(3);
        node.left.right = new Node(4);

        node.right.right = new Node(6);
        node.right.left = new Node(7);
        node.right.left.left = new Node(8);

        return node;
    }

    private static Node insertLeft(Node node, int data){
        return   node.left = new Node(data);
    }

    private static Node insertRight(Node node, int data){
        return   node.right = new Node(data);
    }

    //2 Pow(h+1) - 1 max node

    private static void givenLevel(Node node, int level){
        if(node == null){
            return;
        }
        if(level == 0){
            System.out.print(node.getData());
        }
            givenLevel(node.left, level-1);
            givenLevel(node.right, level-1);
    }

    private static void givenLevelLeftView(Node node, int level){
        if(node == null){
            return;
        }
        if( max_level <level ){
            System.out.print(node.getData());
            max_level = level;
        }
        givenLevelLeftView(node.left, level+1);
        givenLevelLeftView(node.right, level+1);
    }


    //LOT level order traversal
    private static void levelOrder(Node node) {
        int h =  depth(node);
        //System.out.print(h);
        for(int i=0; i<=h; i++){
            givenLevel(node, i);
        }
    }

    //depth
    private static int depth(Node root){
        if(root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(root.left != null){

            left = depth(root.left);
            left++;
        }
        if(root.right != null){
             right = depth(root.right);
            right++;
        }
        if(left > right)
            return left;
        else
            return right;
    }

    //Pre order
    private static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.getData());
        preOrder(node.left);
        preOrder(node.right);
    }

    //post order
    private static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getData());

    }

    //in order
    private static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.getData());

        inOrder(node.right);

    }

    //left view of binary tree
    private static void printleftview(Node root){
        givenLevelLeftView(root, 1);
    }

    //print all leaf nodes
    private static void printLeafNodes(Node root){
        if(root == null){
                return;
        }
        if(root.left == null && root.right == null){
            System.out.print(root.getData());
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);

    }

    //find an element in BST

    //Mirror or duplicate binary tree

}
