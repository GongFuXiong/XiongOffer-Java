package Problem19;
import java.util.*;	//导入所有方法
import util.TreeNode;

/*
 * 给定的二叉树，将其变换为源二叉树的镜像。
 * 使用循环方式交换每个节点的左右子树位置。利用栈结构
 */
public class MirrorTree {
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
		TreeNode node =mirrorTreeLoop(root1);
		System.out.println(node.value);
//		TreeNode.preOrder(node);		//前序遍历输出二叉树
	}
	/*
	 * 有空指针错误
	 */
    public static TreeNode mirrorTreeLoop(TreeNode root) {    
        if(root==null) {    
            return null;    
        }    
        if(root.left==null&&root.right==null) return root; 
        
        Stack<TreeNode> stack=new Stack<TreeNode>();    //使用栈结构储存
        while(root!=null||!stack.isEmpty()) {    
            while(root!=null) {    
                TreeNode temp=root.left;    //左右子树互换位置
                root.left=root.right;    
                root.right=temp;    
                stack.push(root);    //使根结点暂时保持
                root=root.left;    		//循环镜像左结点
            }    
            if (!stack.isEmpty()) {
                root=stack.pop();    	//输出跟结点
                root=root.right;    	//循环镜像右结点，使right结点不断移向left结点，在left结点下不断循环镜像
			}

        }    
        return root;    
    }

}
