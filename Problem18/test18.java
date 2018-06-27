package Problem18;
import util.TreeNode;

public class test18 {

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
		TreeNode root2 = new TreeNode();	  //定义root2二叉树
		TreeNode a = new TreeNode();
		TreeNode b = new TreeNode();
		root2.left = a;
		root2.right = b;
		root2.value = 8;
		a.value = 7;
		b.value = 2;
		boolean flag=HasSubTree.HasSubtree(root1, root2);
		System.out.println(flag);
	}

}
