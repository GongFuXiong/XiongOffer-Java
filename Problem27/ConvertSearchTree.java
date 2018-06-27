package Problem27;
import util.TreeNode;

/*
 * 将二叉搜索树转换为一个排序的双向链表
 * 定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点（画图理解）
 * （难理解怎么连接根结点和左结点的最大值和右结点的最小值）
 */
public class ConvertSearchTree {

    public TreeNode convert(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode lastNode = null;		//定义链表尾结点
        convertNode(root, lastNode);	//调用函数
        while (null != lastNode && lastNode.left != null) {
            lastNode = lastNode.left;					
        }
        return lastNode;
    }

    private void convertNode(TreeNode root,TreeNode lastNode) {
        if (null == root) {
            return;
        }
        TreeNode current = root;		//定义一个临时结点current
        if (null != current.left) {		//将left子树递归
            convertNode(current.left,lastNode);
        }
        current.left = lastNode;		//反复将链表尾结点赋值给left
        if (null != lastNode) {
            lastNode.right = current;		//难理解，画图容易理解，将临时变量赋值给链表right
        }
        lastNode = current;				//赋值链表尾结点
        
        if (null != current.right) {			//递归right子树结点
            convertNode(current.right,lastNode);
        }
    }

}
