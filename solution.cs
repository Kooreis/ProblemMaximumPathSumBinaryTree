Here is a C# console application that solves the problem:

```csharp
using System;

public class Node
{
    public int data;
    public Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class BinaryTree
{
    public Node root;

    public int FindMaxSum()
    {
        int res = int.MinValue;
        FindMaxUtil(root, ref res);
        return res;
    }

    private int FindMaxUtil(Node node, ref int res)
    {
        if (node == null)
            return 0;

        int l = FindMaxUtil(node.left, ref res);
        int r = FindMaxUtil(node.right, ref res);

        int max_single = Math.Max(Math.Max(l, r) + node.data, node.data);
        int max_top = Math.Max(max_single, l + r + node.data);

        res = Math.Max(res, max_top);

        return max_single;
    }
}

class Program
{
    static void Main(string[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        Console.WriteLine("maximum path sum is : " + tree.FindMaxSum());
    }
}
```

This program creates a binary tree and finds the maximum path sum in the tree. The maximum path sum is calculated as the maximum of the sum of the node's value and the maximum path sum of its left and right children. The maximum path sum of a node is the maximum of the node's value, the node's value plus the maximum path sum of its left child, and the node's value plus the maximum path sum of its right child.