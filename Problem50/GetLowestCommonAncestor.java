package Problem50;
import util.TreeNode;

/*
 * 求树中两个节点的最低公共祖先(树是二叉搜索树)
 * 从树的根节点开始遍历，如果根节点的值大于其中一个节点，小于另外一个节点，则根节点就是最低公共祖先
 * 时间复杂度是O(logn)，空间复杂度是O(1)
 */
public class GetLowestCommonAncestor {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode();
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();
		root1.left = node1;					//定义root1为二叉搜索树
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = node5;
		node4.right = node6;
		root1.value = 8;
		node1.value = 4;
		node2.value = 9;
		node3.value = 3;
		node4.value = 6;
		node5.value = 5;
		node6.value = 7;
		System.out.println(getLowestCommonAncestor(root1,node6,node5).value);
	}
	
	public static TreeNode getLowestCommonAncestor(TreeNode root,TreeNode node1,TreeNode node2){
		if(root == null || node1 == null || node2 == null) return null;

		if((root.value - node1.value)*(root.value - node2.value) < 0){//若根结点值在中间，则一定为根结点
			return root;
			}
		else if((root.value - node1.value)*(root.value - node2.value) > 0){//若两个node在同一边
			//判断根结点位于两个node的左右子树，同时大于两个node，则将子树赋值新根结点
			TreeNode newRoot = ((root.value > node1.value) && (root.value > node2.value))? root.left : root.right;
			return getLowestCommonAncestor(newRoot, node1, node2);		//赋值子树，递归
			}
		else{
			return root;//根结点为一切结点的父结点
			}
 }
}
