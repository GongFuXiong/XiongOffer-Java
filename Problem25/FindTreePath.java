package Problem25;
import java.util.*;
import util.TreeNode;
/*
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值(利用栈储存数据)
 */
public class FindTreePath {
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
		ArrayList<ArrayList<Integer>> list = findPath(root1, 24);
		for (ArrayList<Integer> path : list) {			//循环输出路径中的数组链表，需要定义path类型
			System.out.println(path);
		}
	}

	public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int sum) {//一个函数跑不通，两个函数有必要
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();		//初始化一个数组链表，存储数组链表的数组链表
        if (null == root) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();		//定义初始化一个stack
        generate(root, sum, stack, list);

        return list;
    }

    private static void generate(TreeNode root, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> list) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {			//判断到叶节点
            if (root.value == target) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                for (int i : stack) {		//在子数组链表中加入全部stack
                    tmpList.add(i);
                }
                tmpList.add(root.value);
                list.add(tmpList);			//list为多个符合要求的数组链表
            }
        } else {
            stack.push(root.value);		//储存跟结点，利用stack结构来保存路径数据
            generate(root.left, target - root.value, stack, list);		//递归遍历，target随着改变
            generate(root.right, target - root.value, stack, list);
            stack.pop();
        }
    }
    
}
