package Problem23;
import java.util.*;
import util.TreeNode;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 *利用队列（链表）储存，辅助实现。
 *利用链表的先进先出特点可以储存，如果用stack先进后出会造成输出错误
 */
public class LevelOrder {

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
		levelOrder(root1);
	}

    public static void levelOrder(TreeNode root) {//利用链表的先进先出特点
        if (null == root) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();		//定义一个链表
        queue.offer(root);					//使用offer添加数据
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();		//使用poll输出queue中的值
            System.out.println(node.value);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
    }
    
    public static void levelOrderStack(TreeNode root) {//用stack先进后出会造成输出错误
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();		//定义一个链表
        stack.push(root);					//使用offer添加数据
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();		//使用poll输出queue中的值
            System.out.println(node.value);
            if (null != node.left) {
            	stack.push(node.left);
            }
            if (null != node.right) {
            	stack.push(node.right);
            }
        }
    }
}
