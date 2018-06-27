package Problem19;
import java.util.*;	//导入所有方法
import util.TreeNode;

/*
 * 使用递归方式交换每个节点的左右子树位置。
 */
public class MirrorTreeRec {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode();
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();
		root1.left = node1;					//定义root1二叉树
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		root1.value = 8;
		node1.value = 7;
		node2.value = 2;
		node3.value = 9;
		node4.value = 2;
		node5.value = 4;
		node6.value = 7;
		TreeNode node =mirrorTreeRec(root1);
		TreeNode.preOrder(node);		//前序遍历输出二叉树
	}
	
	public static TreeNode mirrorTreeRec(TreeNode root) {
		if (root==null) return null;
        if(root.left==null&&root.right==null) return root; 
        TreeNode temp=root.left;    //左右子树互换位置
        root.left=root.right;    
        root.right=temp;    
        if (root.left!=null) {
			mirrorTreeRec(root.left);	//递归求解left结点镜像
		}
        if (root.right!=null) {
			mirrorTreeRec(root.right);	//递归求解right结点镜像
		}
        return root;
	}
}
