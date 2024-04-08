Here is a Java console application that solves the problem:

```java
import java.util.Scanner;

class Node {
    int data;
    int maxPathSum;
    Node left, right;

    Node(int item) {
        data = item;
        maxPathSum = Integer.MIN_VALUE;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    int findMaxUtil(Node node) {
        if (node == null)
            return 0;

        int left = findMaxUtil(node.left);
        int right = findMaxUtil(node.right);

        int max_single = Math.max(Math.max(left, right) + node.data, node.data);

        int max_top = Math.max(max_single, left + right + node.data);

        node.maxPathSum = Math.max(node.maxPathSum, max_top);

        return max_single;
    }

    int findMaxSum() {
        findMaxUtil(root);
        return root.maxPathSum;
    }
}

public class Main {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " + tree.findMaxSum());
    }
}
```

This program creates a binary tree and finds the maximum path sum in the tree. The maximum path sum is calculated as the maximum of the sum of the node's value and the maximum path sum of its left and right children. The maximum path sum of a node is stored in the node's `maxPathSum` field. The `findMaxSum` method returns the maximum path sum of the root of the tree.