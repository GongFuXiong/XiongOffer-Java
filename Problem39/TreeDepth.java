package Problem39;
import util.TreeNode;

public class TreeDepth {
	public static void main(String[] args) {
        TreeNode root=new TreeNode();    
        TreeNode node1=new TreeNode();    
        TreeNode node2=new TreeNode();    
        TreeNode node3=new TreeNode();    
        TreeNode node4=new TreeNode();    
        TreeNode node5=new TreeNode();    
        TreeNode node6=new TreeNode();    
        root.left=node1;    
        root.right=node2;    
        node1.left=node3;    
        node1.right=node4;    
        node2.right=node5;    
        node4.left=node6;    
        root.value=1;    
        node1.value=2;    
        node2.value=3;    
        node3.value=4;    
        node4.value=5;    
        node5.value=6;    
        node6.value=7;      
        TreeDepth test =new TreeDepth();
        System.out.println(test.getDepth(root));
        System.out.println(test.isBalanced(root));
        System.out.println(test.isBalanced2(root,0));

	}
	/*
	 * 输入一棵二叉树，求该树的深度
	 * 利用递归遍历分别返回左右子树深度
	 */
    public int getDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = getDepth(root.left);//递归left
        int right = getDepth(root.right);

        return (left > right) ? left+1:right+1;//此处+1，，必须要有，，不然值不变
    }
    
    /*
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树，任意子树深度不超过1
     * 结点会重复遍历多次，时间效率不高
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        int leftDepth = getDepth(root.left);//调用树深度
        int rightDepth = getDepth(root.right);
        int diff = leftDepth - rightDepth;	//深度差
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);	//递归判断左右子树
    }
    /*
     * 在遍历结点时同时记录根点的深度，结点只遍历一次
     */
    private boolean isBalanced2(TreeNode root, int depth) {    
        if(root==null) {    
            depth=0;    
            return true;    
        }    
        int leftDepth=0,rightDepth=0;    
        if(isBalanced2(root.left,leftDepth)&&isBalanced2(root.right, rightDepth)){//遍历的同时在判断    
            int diff=leftDepth-rightDepth;    //深度差
            if(diff<=1&&diff>=-1) {    
                depth=1+(leftDepth>rightDepth ? leftDepth : rightDepth);    
                return true;    
            }    
        }    
        return false;    
    }   
}
