def find_max_path_sum(root):
    if root is None:
        return 0

    left = find_max_path_sum(root.left)
    right = find_max_path_sum(root.right)

    max_single = max(max(left, right) + root.data, root.data)

    max_top = max(max_single, left + right + root.data)

    find_max_path_sum.res = max(find_max_path_sum.res, max_top)

    return max_single