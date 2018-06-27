package Problem25;
import java.util.*;
import util.TreeNode;
/*
 * 错误代码，跑不通
 */
public class FindTreePath2 {
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
		ArrayList<ArrayList<Integer>> list = find(root1, 24);
		for (ArrayList<Integer> path : list) {			//循环输出路径中的数组链表，需要定义path类型
			System.out.println(path);
		}
	}
	
    public static  ArrayList<ArrayList<Integer>> find(TreeNode root, int sum) {//一个函数跑不通
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();		//初始化一个数组链表，存储数组链表的数组链表
        if (null == root) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();		//定义初始化一个stack
        if (null == root.left && null == root.right) {
            if (root.value == sum) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                for (int i : stack) {
                    tmpList.add(i);
                }
                tmpList.add(root.value);
                list.add(tmpList);
            }
        } else {
            stack.push(root.value);
            find(root.left, sum - root.value);
            find(root.right, sum - root.value);
            stack.pop();
        }
        return list;
	}

}
