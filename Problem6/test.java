package Problem6;

import util.TreeNode;

public class test {

	public static void main(String[] args) throws Exception {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        constructBiTree constructTest=new constructBiTree();
        TreeNode root=constructTest.constructtree(pre, in);
//        System.out.println(root.value);		//此输出仅仅为跟节点

	}

}
