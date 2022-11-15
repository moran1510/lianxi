package com.lianxi;

import javax.management.Query;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue = new ArrayDeque<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        TreeNode n = this.root;
        queue.add(this.root);
        while (n.left!=null){
            queue.add(n.left);
            if (n.right!=null){
                queue.add(n.right);
                queue.poll();
            }
        }
    }

    public int insert(int val) {
     TreeNode b = new TreeNode(val);
     TreeNode a = queue.element();
     if (a.left==null){
         a.left = b;
         queue.add(b);
     }else {
         a.right = b;
         queue.add(b);
         a=queue.poll();
     }
     return a.val;
    }

    public TreeNode get_root() {
      return root;
    }
}