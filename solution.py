Here is a Python console application that solves the problem:

```python
class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def find_max_path_sum(root):
    if root is None:
        return 0

    left = find_max_path_sum(root.left)
    right = find_max_path_sum(root.right)

    max_single = max(max(left, right) + root.data, root.data)

    max_top = max(max_single, left + right + root.data)

    find_max_path_sum.res = max(find_max_path_sum.res, max_top)

    return max_single

def find_max_sum(root):
    find_max_path_sum.res = float("-inf")

    find_max_path_sum(root)

    return find_max_path_sum.res

if __name__ == "__main__":
    root = Node(10)
    root.left = Node(2)
    root.right = Node(10)
    root.left.left = Node(20)
    root.left.right = Node(1)
    root.right.right = Node(-25)
    root.right.right.left = Node(3)
    root.right.right.right = Node(4)

    print("Max path sum is ", find_max_sum(root))
```

This Python console application creates a binary tree and finds the maximum path sum in the tree. The maximum path sum is the maximum possible sum of the values of nodes from one leaf node to another leaf node. The path must contain at least one node and does not need to go through the root. The function `find_max_path_sum` is a helper function that calculates the maximum path sum and updates the result. The function `find_max_sum` is the main function that returns the maximum path sum.