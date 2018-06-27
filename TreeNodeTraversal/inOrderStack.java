package TreeNodeTraversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import util.TreeNode;
/*
 * 栈模拟递归过程实现循环中序遍历二叉树
 *  * 根据输出的语句的位置，判断先转左还是先转右
 */
public class inOrderStack {
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
		inOrderStack(root1);
		theInOrderTraversal_Stack(root1);
	}
	
    public static void inOrderStack(TreeNode root){  //模拟递归的方法
        if(root==null)return;  
        Stack<TreeNode> s=new Stack<TreeNode>();  
        
        while(root!=null||!s.isEmpty()){  
            while(root!=null){  
                s.push(root);//先访问再入栈  
                root=root.left;  
            }  
            root=s.pop();  
            System.out.print(root.value+" ");  //在此处输出
            root=root.right;//如果是null，出栈并处理右子树  
        }  
    }
    
    public static void theInOrderTraversal_Stack(TreeNode root) {  //循环的方法
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode node = root;  
        while (node != null || stack.size() > 0) {  
            if (node != null) {  
                stack.push(node);   //直接将根结点压栈  
                node = node.left;  
            } else {  
                node = stack.pop(); //出栈并访问  
                System.out.print(node.value+" ");
                node = node.right; 		//转向right结点
            }  
        }  
    }
}
