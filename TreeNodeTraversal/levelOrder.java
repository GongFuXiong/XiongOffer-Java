package TreeNodeTraversal;
import java.util.LinkedList;
import java.util.Queue;
import util.TreeNode;

public class levelOrder {
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
		levelTravel(root1);
	}
	
    public static void levelTravel(TreeNode root){  
        if(root==null)return;  
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();//利用链表来保存，先进先出的特点，和前序遍历stack相似
        queue.add(root);  
        while(!queue.isEmpty()){  
        	TreeNode node =  queue.poll();  
            if(node.left!=null)queue.add(node.left);  //先进先出，先保存left结点
            if(node.right!=null)queue.add(node.right); 
            System.out.print(node.value+" ");  
        }
    }  
} 

