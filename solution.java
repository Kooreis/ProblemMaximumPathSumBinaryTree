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