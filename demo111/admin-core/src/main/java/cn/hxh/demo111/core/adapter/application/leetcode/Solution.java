package cn.hxh.demo111.core.adapter.application.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

public class Solution {

    public int countSubstrings(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i / 2;
            int r = l + i % 2;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                sum++;
            }
        }
        return sum;
    }

    public int longestConsecutive(int[] nums) {
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key - 1)) {
                int cur = 1;
                while (!map.containsKey(key - 1)) {
                    cur++;
                }
                if (cur > max) max = cur;
            }
        }
        return max;
    }

    /**
     * 139.单词拆分
     *
     * @param s
     * @param wordDict
     * @return
     */

    private boolean result = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> dict = new HashMap<>();
        dfs(s, 0, wordDict, dict);
        return result;
    }

    //超时
    public void compaerAndCount(String s, int step, List<String> wordDict) {
        if (step == s.length()) {
            result = true;
        }
        int tmp = step;
        for (String str : wordDict) {
            step = tmp;
            int i = 0;
            while (i < str.length() && (step + i) < s.length() && s.charAt(step + i) == str.charAt(i)) {
                ++i;
            }
            if (i == str.length()) {
                step += i;
                compaerAndCount(s, step, wordDict);
            }
        }
    }

    public void dfs(String s, int step, List<String> wordDict, Map dict) {
        if (step == s.length()) {
            result = true;
        }
        String str = "";
        for (int i = step; i < s.length(); i++) {
            str = s.substring(step, i + 1);
            if (dict.containsKey(str)) {
                continue;
            }
            if (wordDict.contains(str)) {
                dfs(s, i + 1, wordDict, dict);
                dict.put(i + 1, true);
            }
        }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = Math.max(dfs(root.left), 0);
        int rightVal = Math.max(dfs(root.right), 0);
        int tmpMax = root.val + leftVal + rightVal;
        max = Math.max(tmpMax, max);
        return root.val + Math.max(leftVal, rightVal);

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    class Node implements Comparable<Node> {
        ListNode node;
        int value;

        public Node(ListNode node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return node.value - value;
        }
    }

    private PriorityQueue<Node> smallHeap = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            smallHeap.offer(new Node(lists[i], lists[i].val));
        }
        while (smallHeap.size() > 0) {
            ListNode node = smallHeap.poll().node;
            if (head == null) {
                head = node;
                cur = node;
            } else {
                cur.next = node;
                cur = node;
            }
            if (head.next != null) {
                smallHeap.offer(new Node(node.next, node.next.val));
            }
        }
        return head;
    }

    public int longestValidParentheses(String s) {
        if (s.isEmpty() || s.length() == 1) return 0;
        int maxLength = 0;
        int tmpLength = 0;
        char right = s.charAt(1);
        char left = s.charAt(0);
        int i = 2;
        while (i < s.length()) {
            if (right == ')' && left == '(') {
                tmpLength += 2;
                i += 2;
                continue;
            } else {
                if (tmpLength > maxLength) {
                    maxLength = tmpLength;
                }
                tmpLength = 0;
            }
            if (right == ')' && (i + 2) < s.length()) {
                right = s.charAt(i + 2);
                left = s.charAt(i + 1);
                i += 2;
            } else if (right == '(' && (i + 1) < s.length()) {
                left = right;
                right = s.charAt(i + 1);
                i += 1;
            } else break;
        }
        return maxLength;
    }

    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode res = null;
        do {
            if (pre != null) {
                pre.next = null;
            }
            smallHeap.offer(new Node(cur, cur.val));
            pre = cur;
            cur = cur.next;
        } while (cur != null);

        while (!smallHeap.isEmpty()) {
            ListNode node = smallHeap.poll().node;
            if (res == null) {
                res = node;
                cur = node;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        return res;
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // find mid
        ListNode fast = head, slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        return mergeTwoList(sortList(head, mid), sortList(mid, tail));
    }

    public ListNode mergeTwoList(ListNode h1, ListNode h2) {
        ListNode cur1 = h1, cur2 = h2, head = new ListNode(0);
        ListNode tHead = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val >= cur2.val) {
                tHead.next = cur2;
                cur2 = cur2.next;
            } else {
                tHead.next = cur1;
                cur1 = cur1.next;
            }
        }
        while (cur1 != null) {
            tHead.next = cur1;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            tHead.next = cur2;
            cur2 = cur2.next;
        }
        return head.next;
    }

    int maxWidth;
    int maxHeight;

    public int numIslands(char[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int maxWidth = grid.length;
        int maxHeight = grid[0].length;
        int result = 0;

        for (int w = 0; w < maxWidth; w++) {
            for (int h = 0; h < maxHeight; h++) {
                if (grid[w][h] == '1') {
                    result++;
                    dfs(grid, w, h);
                }
            }
        }
        return 0;
    }

    public void dfs(char[][] grid, int w, int h) {
        if (w < 0 || h < 0 || w >= maxWidth || h >= maxHeight || grid[w][h] == '0') {
            return;
        }
        grid[w][h] = '0';
        dfs(grid, w - 1, h);
        dfs(grid, w + 1, h);
        dfs(grid, w, h - 1);
        dfs(grid, w, h + 1);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表，表示A->B,C,D  -> 表示指向
        List<List<Integer>> edges = new ArrayList<>();
        // 指向该节点的边数 如 B->A,C->A 则边数为2
        int incomeNums[] = new int[numCourses];
        int nums = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            incomeNums[prerequisites[i][0]]++;
        }
        for (int i = 0; i < edges.size(); i++) {
            if (incomeNums[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            nums--;
            for (Integer targetNum : edges.get(i)) {
                incomeNums[targetNum]--;
                if (incomeNums[targetNum] == 0) {
                    queue.offer(targetNum);
                }
            }
        }
        return nums == 0;
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++){
                dp[j][i] = Math.max(dp[j][i-1]*nums[i],dp[j][i]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j][i] > result){
                    result = dp[j][i];
                }
            }
        }
        return result;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0){
                    dp[i] = Math.min(dp[i],dp[amount-coins[j]]);
                }
            }
            if(dp[i] != Integer.MAX_VALUE){
                dp[i] += 1;
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(left < nums.length && nums[left] >= nums[left-1]){
            left++;
        }
        while(right > left && nums[right] >= nums[right-1]){
            right--;
        }
        if(left == nums.length){
            return 0;
        }
        for (int i = left; i <= right; i++) {
            if(nums[i] < min){
                min = nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        while(left > 0 && nums[left-1] > min){
            left--;
            if(nums[left] > max){
                max = nums[left];
            }
        }
        while(right < nums.length-1 && nums[right+1] < max){
            right++;
        }
        return right - left + 1;
    }

    public int leastInterval(char[] tasks, int n) {
        int[] countArray = new int[26];
        int[] waitArray = new int[26];
        int total = 0;

        for(int i=0;i<tasks.length;i++){
            int pos = tasks[i]-'A';
            countArray[pos]++;
            total++;
        }
        int res = 0;
        while(total>0){
            int[] tmpArray = Arrays.copyOf(countArray,countArray.length);
            for(int i=0; i<waitArray.length; i++){
                if(waitArray[i] > 0){
                    waitArray[i]--;
                    tmpArray[i] = -1;
                }
            }
            int maxPos = getMaxPos(tmpArray);
            if(maxPos>=0){
                countArray[maxPos]--;
                waitArray[maxPos] = n;
                total--;
            }
            tmpArray = null;
            res++;
        }
        return res;
    }

    public int getMaxPos(int[] array){
        int res = -1;
        int max = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
                res = i;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Solution so = new Solution();
        //System.out.println(so.countSubstrings("aaa"));

//        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1,-1,-2,-3};
//        System.out.println(so.longestConsecutive(nums));

        List list = Lists.newArrayList(1,3,2,2);
        int[] array = new int[]{1,3,2,2,2};
        char[] chars = new char[]{'A','A','A','A','B','B'};
        System.out.println(so.leastInterval(chars,0));
    }
}