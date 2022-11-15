package com.lianxi;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
    int a=1;
    HashMap<Object,Integer> hashMap = new HashMap<>();
    for (int i=0;i<s.length();i++){
        Integer integer = hashMap.get(s.charAt(i));
        if (integer==null){
            hashMap.put(s.charAt(i),i);
        }else {
            hashMap.put(s.charAt(i),i);
            a=Math.max(a,i-integer);
        }
    }
    return a;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return bbb(image,sr,sc,color,image[sr][sc]);
    }

    public int[][] bbb(int[][] image, int sr, int sc, int color,int i){
        if (image[sr][sc]==color){
            return image;
        }
        image[sr][sc]=color;
        if(sr+1<image.length&&image[sr + 1][sc] == i){
            bbb(image,sr+1,sc,color,i);
        }
        if(sr-1>=0&&image[sr - 1][sc] == i){
            bbb(image,sr-1,sc,color,i);
        }
        if(sc+1<image[0].length&&image[sr][sc+1] == i){
            bbb(image,sr,sc+1,color,i);
        }
        if(sc-1>=0&&image[sr][sc-1] == i){
            bbb(image,sr,sc-1,color,i);
        }
        return image;
    }

    public int[][] aaa(int[][] image, int sr, int sc, int color,int i){
        int n = image.length;
        int m = image[0].length;
        if(sr+1<n&&image[sr+1][sc]!=i){
            image[sr+1][sc]=color;
            aaa(image,sr+1,sc,color,i);
        }
        if(sr-1>=0&&image[sr-1][sc]!=i){
            image[sr-1][sc]=color;
            aaa(image,sr-1,sc,color,i);
        }
        if(sc+1<m&&image[sr][sc+1]!=i){
            image[sr][sc+1]=color;
            aaa(image,sr,sc+1,color,i);
        }
        if(sc-1>0&&image[sr][sc-1]!=color){
            image[sr][sc-1]=color;
            aaa(image,sr,sc-1,color,i);
        }
        return image;
    }

    public int maxAreaOfIsland(int[][] grid) {
          int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans,dfs(grid,i,j));
            }
        }



          return  ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i<0||j<0||i>grid.length||j>grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
    }

    public TreeNode pruneTree(TreeNode root) {
     if (root==null){
         return root;
     }
     root.left=pruneTree(root.left);
     root.right=pruneTree(root.right);
     if (root.left==null&&root.right==null&&root.val==0){
         return null;
     }
     return root;
    }

    public int[] searchRange(int[] nums, int target) {
        int count = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (target>nums[i]){
                break;
            }
            if (target==nums[i]){
                count++;
            }
        }
        if (count==0){
            return new int[]{-1,-1};
        }
        return new int[]{i-1-count,i-1};
    }

    public int search(int[] nums, int target) {
        if (target>=nums[0]){
            for(int i=0;i<nums.length;i++){
              if (i!=nums.length-1&&nums[i]>nums[i+1]){
                  return -1;
              }
              if (target==nums[i]){
                  return i;
              }
            }
        }else {
            for(int i=nums.length-1;i>=0;i--){
                if (i!=0&&nums[i]<nums[i-1]){
                    return -1;
                }
                if (target==nums[i]){
                    return i;
                }
            }
        }
    return -1;

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (target<matrix[i][matrix[0].length-1]){
                for (int j = 0; j < matrix[0].length; j++) {
                    if (target==matrix[i][j]){
                        return true;
                    }
                    if(target<matrix[i][j]){
                        return false;
                    }
                }
            }
        }

        return false;
    }

    public int findMin(int[] nums) {
        if (nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        int n = nums.length;
        int i = 0,j= n-1;
        for (int m = (i+j)/2; i <j&&i!=m; ) {
            if (nums[m]<nums[i]){
                j=m;
            }else {
                i=m;
            }
            m=(i+j)/2;
        }
     return Math.min(nums[i],nums[j]);
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int n = intervals.length;
        //初始的两个元素
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        HashSet<Object> set = new HashSet<>();
        //从后向前遍历
        for (int i = n - 2; i >= 0; i--) {
            //开始分类讨论
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
            } else {
                next = cur;
                cur = intervals[i][0];
                ans++;
            }
        }
        return set.size();
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head==null){
            return  null;
        }
        ListNode a = new ListNode(0,head);
        ListNode c = head;
        HashSet set = new HashSet();
        while (c.next!=null){
            if (c.val==c.next.val&&!set.contains(c.val)){
                set.add(c.val);
                c=c.next;
            }
        }
        while (head!=null){
            if (!set.contains(head.val)){
                a.next=head;
                head=head.next;
            }
        }
        return a.next;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length&&nums[i]<=0; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=nums.length-1;
            int k = i+1;
            for (; k<j&&nums[j]>=0;) {
                if (k>i+1&&nums[k]==nums[k-1]){
                    k++;
                    continue;
                }
                if (j<nums.length-1&&nums[j]==nums[j+1]){
                    j--;
                    continue;
                }
                if (nums[k]+nums[j]<-nums[i]){
                    k++;
                }else if (nums[k]+nums[j]>-nums[i]){
                    j--;
                }else {
                    List<Integer>  ans = new LinkedList<>();
                    ans.add(nums[i]);
                    ans.add(nums[k]);
                    ans.add(nums[j]);
                    lists.add(ans);
                    k++;
                    j--;
                }
            }
        }
        return lists;
    }

    public boolean backspaceCompare(String s, String t) {
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i]!='#'){
                a.append(chars[i]);
            }else {
                a.deleteCharAt(a.length()-1);
            }
        }
        chars=t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            if (chars[i]!='#'){
                b.append(chars[i]);
            }else {
                b.deleteCharAt(b.length()-1);
            }
        }
        return a.equals(b);

    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        for (int i=0,j=0;i<firstList.length&&j<secondList.length;){
             int l = Math.max(firstList[i][0],secondList[j][0]);
             int r = Math.min(firstList[i][1],secondList[j][1]);
             if (l<=r){
                 list.add(new int[]{l,r});
             }
             if (firstList[i][1]<secondList[j][1]){
                 i++;
             }else {
                 j++;
             }
        }
        return list.toArray(new int[list.size()][]);

    }

    public int maxArea(int[] height) {
        int ans = 0;
        for (int i=0,j=height.length-1;i<j;){
            ans = Math.max(ans,Math.min(height[i],height[j])*(j-i));
            if (height[i+1]-height[i]>height[j]-height[j-1]){
                i++;
            }else {
                j--;
            }
        }
        return ans;
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int n = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0,j=0; j < nums.length; j++) {
            sum += nums[j];
            while (sum>=target){
                n = Math.min(n,j-i+1);
                sum-=nums[i];
                i++;
            }

        }
        return n==Integer.MAX_VALUE?0:n;

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int a = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    a++;
                    dfs(grid,i,j);
                }
            }
        }
        return a;
    }

    public void dfs(char[][]grid,int h,int l){
        if (h<0||l<0||h>=grid.length||l>=grid[0].length||grid[h][l]=='0'){
            return;
        }
        grid[h][l]='0';
        dfs(grid,h-1,l);
        dfs(grid,h+1,l);
        dfs(grid,h,l+1);
        dfs(grid,h,l-1);
    }

    public String solveEquation(String equation) {
       int a=0,b=0;
        int i = 0;
        int op = 0;
        String equ = null;
       if (equation.charAt(0)!='-'){
           equ = "+"+equation;
           op = 1;
       }
        for (; i < equ.length()&&equ.charAt(i)!='='; i++) {
            if (equ.charAt(i)=='+'){

            }
        }

        return "";
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
         return maxtre(nums,0,nums.length-1);
    }

    private TreeNode maxtre(int[] nums, int i, int j) {
        if (i>j){
            return null;
        }
        int a = i;
        for (int k = i+1; k <= j; k++) {
            if (nums[k]>nums[a]){
                a=k;
            }
        }
        TreeNode node = new TreeNode(nums[a]);
        node.left = maxtre(nums,i,a-1);
        node.right = maxtre(nums,a+1,j);
        return node;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i]<=queryTime&&queryTime<=endTime[i]){
                count++;
            }
        }
        return count;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        int count = 1 , c = 0;
        for (int i = 0; i < sentence.length(); i++) {
            while (c<sentence.length()&&sentence.charAt(c) !=' '){
                c++;
            }
            int j = 0;
            for ( ; j < searchWord.length(); j++) {
                if (sentence.charAt(i+j) != searchWord.charAt(j)){
                    break;
                }
            }
            if (j==searchWord.length()){
                return count;
            }
            count++;
            i=c;
            c++;
            }
        return -1;
    }

    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] a = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = n-1; i > 0 ; i--) {
            while (!stack.empty()&&(stack.peek()>prices[i])){
                stack.pop();
            }
            a[i] = stack.isEmpty()? prices[i] : prices[i]-stack.peek();
            stack.add(prices[i]);
        }
        return a;
    }

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] a = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            a[i] = prices[i];
            for (int j = i+1; j < n; j++) {
                if (prices[i]>prices[j]){
                    a[i] -= prices[j];
                    break;
                }
            }
        }
        return a;
    }


    int a = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return a;
    }

    private int dfs(TreeNode root) {
        if (root==null){
            return 0;
        }
        int l=0,r=0;
        
        if (root.left!=null && root.left.val == root.val){
            l = dfs(root.left)+1;
        }
        if (root.right!=null && root.right.val == root.val){
            r = dfs(root.right)+1;
        }
        a = Math.max(a,l+r);
        return Math.max(l,r);
    }

    public String reorderSpaces(String text) {
        int length = text.length();
        String[] words = text.split("\\s+");
        int cntSpace = length;
        for (String word : words) {
            cntSpace -= word.length();
        }
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < cntSpace; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int perSpace = cntSpace / (words.length - 1);
        int restSpace = cntSpace % (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                for (int j = 0; j < perSpace; j++) {
                    sb.append(' ');
                }
            }
            sb.append(words[i]);
        }
        for (int i = 0; i < restSpace; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] matrix = new int[0][];
        List<Integer> res = new LinkedList<>();
        int count = -1;
        char[] a = s.toCharArray();
        for(int i=0,j=0;j<s.length();j++){
            while(i<j&&a[i]!=a[j]){
                i++;
            }
            count=Math.min(j-i-1,count);
        }
        return count;
    }
    int l = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        test(root);
        return l;
    }

    private int test(TreeNode root) {
        if(root==null){
            return 0;
        }
        int le = root.val+test(root.left);
        int ri = root.val+test(root.right);
        int a = Math.max(Math.max(le,ri),le+ri-root.val);
        l=Math.max(root.val,Math.max(l,a));
        return Math.max(root.val,Math.max(le,ri));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n<4){
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = target-nums[i]-nums[j];
                for (int k = j+1,l=n-1; k <l; ) {
                    if (sum == nums[k]+nums[l]){
                        List<Integer> integerList = new LinkedList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(nums[k]);
                        integerList.add(nums[l]);
                        lists.add(integerList);
                        k++;
                        l++;
                    }else if (sum < nums[k]+nums[l]){
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        return lists;
    }

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = split.length; i >=0; i--) {
            stringBuffer.append(abc(split[i]));
            if (i!=split.length-1){
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private String abc(String s) {
        if (s.length()==0){
            return new String();
        }
        char[] chars = s.toCharArray();
        for (int i = 0,j=chars.length-1; i < j; i++,j--) {
            chars[i]^=chars[j];
            chars[j]^=chars[i];
            chars[i]^=chars[j];
        }

        return new String(chars);
    }

    public boolean isValid(String s) {
        Stack<Character> one = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                one.add(')');
            }else if (s.charAt(i)=='['){
                one.add('[');
            }else if (s.charAt(i)=='{'){
                one.add('}');
            } else {
                char ch = s.charAt(i);
                if (one.isEmpty()){
                    return false;
                }else if (one.peek()!=ch){
                    return false;
                }else {
                    one.pop();
                }

            }
        }
        return one.isEmpty();
    }

    public  List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun1(root,0);
        return res;
    }

    private void checkFun1(TreeNode root, int i) {
        if (root==null) return;
        if (res.size()<i+1){
            List<Integer> list= new ArrayList<>();
            res.add(list);
        }
        res.get(i).add(root.val);
        checkFun1(root.left,i+1);
        checkFun1(root.right,i+1);
    }

    private void checkFun2(TreeNode root) {
        if (root==null) return;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int j = queue.size();
            List<Integer> list= new ArrayList<>();
            while (j>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                j--;
            }
            res.add(list);
        }
    }

    LinkedList<LinkedList<Integer>> ress = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        checkFun1(root,0);
        for(int i=0;i<ress.size();i++){
            checkFun1(root,0);
            LinkedList<Integer> remove = ress.pop();
            list.add(remove.getLast());
        }
        return list;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res= new ArrayList<>();
        if (root==null) return null;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int j = queue.size();
            int i = queue.size();
            Double sum= Double.valueOf(0);
            while (j>0){
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                j--;
            }
            res.add((double) (sum/i));
        }
        return res;

    }

    public Node connect(Node root) {

        checkFun3(root);

        return root;
    }
    private void checkFun3(Node root) {
        if (root==null) return;
        Queue<Node> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int j = queue.size();
            List<Integer> list= new ArrayList<>();
            Node node = new Node();
            while (j>0){
                node = queue.poll();
                node.next = queue.peek();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                j--;
            }
            node.next = null;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode poll = queue.poll();

                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
                size--;
            }
            count++;
        }
        return count;
    }


}

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.add(x);
    }

    public int pop() {
        if (out.empty()){
            move();
        }
        return out.pop();
    }

    public int peek() {
        if (out.empty()){
            move();
        }
        return out.peek();
    }

    public boolean empty() {
        return in.empty()&& out.empty();
    }
    private void move(){
        while (in.empty()){
            out.add(in.pop());
        }
    }
}

class MyStack {
    Queue<Integer> one;
    Queue<Integer> two;
    public MyStack() {
        one = new LinkedList<>();
        two = new LinkedList<>();
    }

    public void push(int x) {
        two.add(x);
        while (!one.isEmpty()){
            two.add(one.poll());
        }
        Queue<Integer> three = one;
        one = two;
        two = three;

    }

    public int pop() {
        return one.poll();
    }

    public int top() {
        return one.peek();
    }

    public boolean empty() {
        return one.isEmpty();
    }
    private void move(){
        while (!two.isEmpty()){

        }
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


