package TreeNodeTraversal;
import java.util.Stack;
import util.TreeNode;
/*
 * 栈实现循环先序遍历二叉树
 * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。
 * 根据输出的语句的位置，判断先转左还是先转右
 */
public class preOrderStack {
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
//		TreeNode.preOrder(root1);
		preOrderStack(root1);
		
//      Stack<TreeNode> stack=new Stack<TreeNode>();  //定义stack
//		stack.push(root1);  //压入之后，还是可以访问二叉树
//		System.out.println(stack.peek().value); 
//		System.out.println(root1.value); 
//		System.out.println(root1.left.right.value); 
	}
	
    public static void preOrderStack(TreeNode root){  
        if(root==null)return;  
        Stack<TreeNode> stack=new Stack<TreeNode>();  //定义stack
        stack.push(root);  
        
        while(!stack.isEmpty()){  
        	TreeNode node=stack.pop();  //定义一个临时变量node
            if(node.right!=null) stack.push(node.right);  //先压入right
            if(node.left!=null) stack.push(node.left);  	//后压入left
            System.out.print(node.value+" ");  
        }  
    }
}
