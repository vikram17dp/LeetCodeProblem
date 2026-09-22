class Solution {

    static class Node {
        int[] cnt;
        int product;

        Node(int k) {
            cnt = new int[k];
            product = 1 % k;
        }
    }

    int n;
    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Update nums[index]
            update(1, 0, n - 1, index, value);

            // Query [start, n - 1]
            Node res = query(1, 0, n - 1, start, n - 1);

            answer[q] = res.cnt[x];
        }

        return answer;
    }

    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {
            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].cnt[rem] = 1;
            tree[node].product = rem;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node left, Node right) {

        Node result = new Node(k);

        // Product of entire segment
        result.product = (left.product * right.product) % k;

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            result.cnt[r] += left.cnt[r];
        }

        // Prefixes that contain all of left
        // and some prefix of right
        for (int r = 0; r < k; r++) {

            if (right.cnt[r] > 0) {

                int newRemainder =
                    (left.product * r) % k;

                result.cnt[newRemainder] += right.cnt[r];
            }
        }

        return result;
    }

    private void update(
        int node,
        int left,
        int right,
        int index,
        int value
    ) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].cnt[rem] = 1;
            tree[node].product = rem;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node query(
        int node,
        int left,
        int right,
        int queryLeft,
        int queryRight
    ) {

        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (queryRight <= mid) {
            return query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
            );
        }

        if (queryLeft > mid) {
            return query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
            );
        }

        Node leftResult = query(
            node * 2,
            left,
            mid,
            queryLeft,
            queryRight
        );

        Node rightResult = query(
            node * 2 + 1,
            mid + 1,
            right,
            queryLeft,
            queryRight
        );

        return merge(leftResult, rightResult);
    }
}