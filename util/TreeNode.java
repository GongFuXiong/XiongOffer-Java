package util;

public class TreeNode {
    public int value = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int value) {
        this.value = value;
    }
    
    public TreeNode() {
        this(0);
    }
    
    //先序遍历
    public static void preOrder(TreeNode root){
        if(root==null)return;
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public static void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }
    //后序遍历
    public static void postOrder(TreeNode root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
}
