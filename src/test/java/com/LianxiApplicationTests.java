package com;

import com.demo.Paixu;
import com.lianxi.ListNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.lianxi.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@SpringBootTest
class LianxiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void reverseWords() {
        String s = "Let's take LeetCode contest";
        String b="";
        String[] split = s.split(" ");
        for (int k=0;k<split.length;k++){
            char[] chars = split[k].toCharArray();
            for (int i=0,j=chars.length-1;i<j;i++,j--){
                char a=chars[i];
                chars[i]=chars[j];
                chars[j]=a;
            }

            b+=String.valueOf(chars)+" ";
        }
        System.out.println(b);
    }

    @Test
    public void findLUSlength() {
        String[] strs={"aabbcc", "aabbcc","c"};
        int a=-1,b=0;
        for (int i=0;i<strs.length;i++){
            b=0;
            for (int j=0;j<strs.length;j++){
                if(zuida(strs[i],strs[j])==-1&&i!=j){
                    b=1;
                    break;
                }

            }
            if(b==0){
                a=Math.max(a,strs[i].length());
                System.out.println(a);
            }else {
                continue;
            }
        }

    }

    @Test
    private int zuida(String a,String b) {
        int i=0,j=0;
        while(i<a.length()&&j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;j++;
            }else j++;
        }
        if (i==a.length()-1||j<b.length()){
            return -1;
        }else {
            return 0;
        }
    }


    @Test
    public boolean checkInclusion(String s1, String s2) {
        int i = s2.length()-1;

        while (s2.charAt(i)!=s1.charAt(0)){
            i--;
        }
        for (int j=0;j<s1.length();){
            if (s2.charAt(i)==s1.charAt(j)){
                j++;
                i--;
            }else {
                return false;
            }
            if (j<0){
                return false;
            }
        }
        return true;
    }

    @Test
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] split = sentence.split(" ");
        HashSet<String> hashSet = new HashSet<>();
        for (String a : dictionary){
            hashSet.add(a);
        }
        for (int i=0;i<split.length;i++){
            for (int j=0;j<split[i].length();j++){
                if (hashSet.contains(split[i].substring(0,j))){
                    split[i]=split[i].substring(0,j);
                    break;
                }
            }
        }

        return String.join(" ",split);
    }
    @Test
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    @Test
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode a=null,b=null;
     int h=0;
     for (;l1!=null||l2!=null;){
        int i = l1!=null?l1.val:0;
        int j = l2!=null?l2.val:0;
        int c=i+j+h;
         if (a == null) {
             a = b = new ListNode(c % 10);
         } else {
             b.next = new ListNode(c % 10);
             b = b.next;
         }
         h=c/10;
         if (l1!=null){
             l1=l1.next;
         }
         if (l2!=null){
             l2=l2.next;
         }

     }
     if (h!=0){
     b.next=new ListNode(h);
     }

     return a;
    }

    @Test
    public int minCostToMoveChips(int[] position) {
        int a=0,b=0;
        for (int i = 0; i < position.length; i++) {
            if (position[i]%2==0){
                a++;
            }else b++;
        }
        return Math.min(a,b);
    }

    @Test
    public void aaa(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(2);
        objects.add(1);
        objects.add(1);
        System.out.println(objects);
    }


    @Test
    public void test1(){
        String a = "abcdefg";
        System.out.println(a.substring(6,7));
    }

    @Test
    public void floodFill() {

        int[][] image=new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        HashSet<Character> a = new HashSet<>();
        HashSet<Character> b = new HashSet<>();
        a.add('a');
        a.add('b');

        b.add('a');
        b.add('b');
        b.add('a');



        System.out.println( a.equals(b));
    }

    public int[][] bbb(int[][] image, int sr, int sc, int color,int i){
        if (image[sr][sc]!=i){
            return image;
        }
        image[sr][sc]=color;
        int n = image.length;
        int m = image[0].length;
        if(sr+1<m){
            bbb(image,sr+1,sc,color,i);
        }
        if(sr-1>=0){
            bbb(image,sr-1,sc,color,i);
        }
        if(sc+1<n){
            bbb(image,sr,sc+1,color,i);
        }
        if(sc-1>0){
            bbb(image,sr,sc-1,color,i);
        }
        return image;
    }

    @Test
    public void search() {
    int[] nums = new int[]{4,5,6,7,0,1,2};
    int[][] aa = new int[][]{{1,2},{3,4},{4,5}};
    for (int[] a : aa) {
        System.out.println(a[1]);
    }
    int target=0;
        if (target>=nums[0]){
            for(int i=0;i<nums.length;i++){
                if (i!=nums.length-1&&nums[i]>nums[i+1]){
                    System.out.println(-1);
                }
                if (target==nums[i]){
                    System.out.println(i);
                }
            }
        }else {
            for(int i=nums.length-1;i>=0;i--){
                if (i!=0&&nums[i]<nums[i-1]){
                    System.out.println(-1);
                }
                if (target==nums[i]){
                    System.out.println(i);
                }
            }
        }
    System.out.println(-1);

    }

    @Test
    public void backspaceCompare() {
        String s="ab#c";
        String t="ab#c";
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i]!='#'){
                a.append(chars[i]);
            }else {
                if (a.length()!=0)
                a.deleteCharAt(a.length()-1);
            }
        }
        chars=t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            if (chars[i]!='#'){
                b.append(chars[i]);
            }else {
                if (b.length()!=0)
                b.deleteCharAt(b.length()-1);
            }
        }
        System.out.println(a.toString().equals(b.toString()));

    }

    @Test
    public void isPrefixOfWord() {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int count = 1,c = 0;
        char[] a = sentence.toCharArray();
        char[] b = searchWord.toCharArray();
        for (int i = 0; i < sentence.length(); i++) {
            while (c<searchWord.length()&&a[i] !=' '){
                c++;
            }
            int j = 0;
            for ( ; j < searchWord.length(); j++) {
                if (a[j+i+1] != b[j]){
                    break;
                }
            }
            if (j==searchWord.length()){
                System.out.println(count);;
            }
            count++;
            i=c;
        }
        System.out.println(-1);;
    }

    @Test
    public void finalPrices() {
        int[] prices = {10,1,1,6};
        int n = prices.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = prices[i];
            for (int j = i+1; j < n; j++) {
                if (prices[i]>prices[j]){
                     a[i] -= prices[j];
                    break;
                }
            }
        }
        System.out.println(a);
    }

    @Test
    public void s1(){
        int a = 1;
        int[] b = new int[5];
        f1(a);
        f2(b);
        System.out.println(a);
        System.out.println(b[1]);
    }

    private void f2(int[] b) {
        b[0] = 0;
        b[1] = 1;
    }

    private void f1(int a) {
        a=a+1;
    }

    @Test
    public void s2(){
        String s = "  abc abc  abc   a";
        String[] s1 = s.split("\\s+");
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
    }

    @Test
    public void s3(){
        int[] nums = {1,9,4,5,6};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    public void spiralOrder() {
        int[][] matrix  = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int a = 0,b=0;
        int c=matrix[0].length;
        int d=matrix.length;
        int i,j;
        List<Integer> res = new LinkedList<>();
        while(a<c/2||a<d/2){
            a++;
            for(i=b;i<c-a;i++){
                res.add(matrix[b][i]);
            }
            System.out.println(res);
            for(j=b;j<d-a;j++){
                res.add(matrix[j][i]);
            }
            System.out.println(res);
            for(;i>=a;i--){
                res.add(matrix[j][i]);
            }
            System.out.println(res);
            for(;j>=a;j--){
                res.add(matrix[j][b]);
            }
            System.out.println(res);
            b++;
        }

        if(c%2==1){
            res.add(matrix[b][b]);
        }

        System.out.println(res);

    }

    class MyLinkedList {
        int size;
        ListNode head;
        ListNode end;
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
            end = head;
        }

        public int get(int index) {
            if(index<0||index>=size){
                return -1;
            }
            if(index==size-1){
                return end.val;
            }
            ListNode a = head;
            for(int i = 0; i < index; i++){
                a = a.next;
            }
            return a.val;
        }

        public void addAtHead(int val) {
            ListNode a = new ListNode(val);
            a.next = head.next;
            head.next = a;
            size++;
            if(size==1){
                end = a;
            }
        }

        public void addAtTail(int val) {
            ListNode a = new ListNode(val);
            end.next = a;
            end = a;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if(index>size){
                return;
            }
            ListNode a = new ListNode(val);
            if(index == size){
                addAtTail(val);
                return;
            }
            if(index<=0){
                addAtHead(val);
                return;
            }
            ListNode b = head;
            for(int i=0; i<index-1; i++){
                b = b.next;
            }
            a.next=b.next;
            b.next = a;
            size++;

        }

        public void deleteAtIndex(int index) {
            if(index>=size||index<0){
                return;
            }

            if(index==size-1){
                ListNode a = head;
                for(int i=0 ; i<index-1;i++){
                    a = a.next;
                }
                end = a;
                end.next = null;
                size--;
                return;
            }

            if(index == 0 ){
                head = head.next;
                size--;
                return ;
            }

            if(index>0&&index<size-1){
                ListNode a = head;
                for(int i=0 ; i<index-2;i++){
                    a = a.next;
                }
                a.next = a.next.next;
                size--;
            }


        }
    }
    @Test
    public void abc(){
        MyLinkedList  a = new MyLinkedList();
        a.addAtHead(7);
        a.addAtTail(7);
//        a.addAtHead(9);
//        a.addAtTail(8);
//        a.addAtHead(6);
//        a.addAtHead(0);
//        System.out.println(a.get(5));
//        a.addAtHead(0);
//        System.out.println(a.get(2));
//        System.out.println(a.get(5));

        a.addAtIndex(1,2);
        System.out.println(a.get(1));

        System.out.println("111");

    }

    @Test
    public void isAnagram() {
        String s = "rat";
        String t = "car";
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int d = s.length();
        int[] c = new int[26];
        for(int i = 0;i < s.length(); i++){
            c[a[i]-'a']++;
        }
        for(int i = 0;i < t.length(); i++){
            if(c[b[i]-'a']==0){
                System.out.println("false");
            }
            c[b[i]-'a']--;
        }
        for(int i : c){
            if(i!=0){
                System.out.println("false");
            }
        }
        System.out.println("true");

    }
    
    @Test
    public void  test() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序配置未配置成功!!!");
        }
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/yuangong?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "1234");
        Statement st=c.createStatement();
        String sqlStr="SELECT * FROM kecheng";

        ResultSet rs=st.executeQuery(sqlStr);

        System.out.println("课程号\t课程名\t教材号\t时间\t教室号\t培训机构"+"\n");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+" "+"\t");
            System.out.println(rs.getString(2)+" "+"\t");
            System.out.println(rs.getString(3)+" "+"\t");
            System.out.println(rs.getString(4)+" "+"\t");
            System.out.println(rs.getString(5)+" "+"\t");
            System.out.println(rs.getString(6)+"\n");
            HashSet<Integer> set = new HashSet<>();
        }
    }
    Solution solution = new Solution();

    @Test
    public void abcd(){

        fulei  a = new zilei();
        a.a(1);
    }

    @Autowired
    private Paixu paixu;

    @Test
    public void demo() throws ParseException {

        String ac = "2021年2月2号";

        System.out.println(ac.replace("年","-").replace("月","-").replace("日","-"));
    }






}
