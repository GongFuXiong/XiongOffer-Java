package TreeNodeTraversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import util.TreeNode;
/*
 *  * 根据输出的语句的位置，判断先转左还是先转右
 */
public class postOrderStack {
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
		thePostOrderTraversal_Stack(root1);
		postorderTraversal(root1);

	}
	
    public static void thePostOrderTraversal_Stack(TreeNode root) {   //利用两个栈后序遍历  
        Stack<TreeNode> stack = new Stack<TreeNode>();  //stack中间栈来存储逆后序遍历的结果
        Stack<TreeNode> outStack = new Stack<TreeNode>();  //outStack保存全部结果
        TreeNode node = root;  
        while (node != null || stack.size() > 0) {  
            if (node != null) {  
            	outStack.push(node);  //两个栈均保存
                stack.push(node);                 
                node = node.right;  	//先保存right子树
            } else {  
                node = stack.pop();               //stack返回后，转向保存left子树
                node = node.left;
            }  
        }  
        
        System.out.println(outStack.size());
        while (outStack.size() > 0) {			//一直输出outStack保存的结果
        	System.out.print(outStack.pop().value+" "); 
        }  
    }
    /*
     * 迭代实现，使用栈实现，出栈得到节点顺序为根右左，每次向list最开头插入元素 
     */
    public static void postorderTraversal(TreeNode root) {  
    	List<Integer> result = new ArrayList<Integer>();//利用链表保存结果，，可以随时加元素
        if(root == null)   return;  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        stack.push(root);   //首先将根节点压栈  
        
        while(!stack.isEmpty()) {  
            TreeNode node = stack.pop(); //首先出栈的为根节点，其后先出右子节点，后出左子节点  
            if(node.left != null)  
                stack.push(node.left);  //将左子节点压栈  
            if(node.right != null) {  
                stack.push(node.right); //将右子节点压栈  
            }  
            result.add(0,node.value); //因为出栈顺序为“根右左”，所以需要每次将元素插入list开头  
        }  
        System.out.print(result); 
    } 
}
