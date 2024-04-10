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