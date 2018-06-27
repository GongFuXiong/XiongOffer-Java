package Problem18;
import util.TreeNode;
/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * 若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别在左右子树中查找。
 * 第一个递归为root1中寻找相同的根结点，第二个递归为寻找根结点相同时的子树是否相同
 */
public class HasSubTree {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean flag = false;

        if (null != root1 && null != root2) {
            if (root1.value == root2.value) {//根结点判断
                flag = isSubTree(root1, root2);
            }
            if (!flag) {//假如跟结点不相同，继续利用递归在root1中的子树中寻找
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right,root2);
            }
        }
        return flag;
    }

    private static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (null == root2) {//作用为之后递归的判断，此为root2仅为一个跟结点
            return true;
        }
        if (null == root1) {//作用为之后的递归判断，root1仅为一个根结点
            return false;
        }
        if (root1.value != root2.value) {	//判断值相等
            return false;
        } else {//递归判断根结点相同时，子结点是否相同
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
    }
}
