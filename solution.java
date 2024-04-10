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
}