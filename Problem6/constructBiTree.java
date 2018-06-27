package Problem6;

import java.util.Arrays;
import util.TreeNode;
/*
 * 先找出根节点，然后利用递归方法构造二叉树
 * 把构建二叉树的大问题分解为构建左右子树的两个小问题
 */
public class constructBiTree {
	public static TreeNode constructtree(int[] preorder,int[] inorder) throws Exception{
		if (preorder==null || inorder==null||preorder.length!= inorder.length) {			//判断是否为空
			throw new Exception("长度不一致");
		}

		TreeNode root=new TreeNode();
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i]==preorder[0]) {		//寻找根结点
				root.value=inorder[i];
				System.out.println(root.value);		//必须为此处输出
				/*
				 * Arrays.copyOfRange方法将一个原始的数组original，从小标from开始复制，复制到小标to，生成一个新的数组。
				 * 此处使用递归方法,分别从新生成中序和前序遍历数据，并构建左右子树
				 */
				root.left=constructtree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
				System.out.println("hhhhhh"+root.value);		//打个标记
				root.right=constructtree(Arrays.copyOfRange(preorder, i+1,preorder.length), Arrays.copyOfRange(inorder, i+1,preorder.length));
				System.out.println("ffff"+root.value);		//打个标记
			}
			
		}
		return root;
	}
}
