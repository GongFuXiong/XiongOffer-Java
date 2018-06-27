package Problem50;
import util.TreeNode;

/*
 * �����������ڵ����͹�������(���Ƕ���������)
 * �����ĸ��ڵ㿪ʼ������������ڵ��ֵ��������һ���ڵ㣬С������һ���ڵ㣬����ڵ������͹�������
 * ʱ�临�Ӷ���O(logn)���ռ临�Ӷ���O(1)
 */
public class GetLowestCommonAncestor {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode();
		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();
		root1.left = node1;					//����root1Ϊ����������
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
		System.out.println(getLowestCommonAncestor(root1,node6,node5).value);
	}
	
	public static TreeNode getLowestCommonAncestor(TreeNode root,TreeNode node1,TreeNode node2){
		if(root == null || node1 == null || node2 == null) return null;

		if((root.value - node1.value)*(root.value - node2.value) < 0){//�������ֵ���м䣬��һ��Ϊ�����
			return root;
			}
		else if((root.value - node1.value)*(root.value - node2.value) > 0){//������node��ͬһ��
			//�жϸ����λ������node������������ͬʱ��������node����������ֵ�¸����
			TreeNode newRoot = ((root.value > node1.value) && (root.value > node2.value))? root.left : root.right;
			return getLowestCommonAncestor(newRoot, node1, node2);		//��ֵ�������ݹ�
			}
		else{
			return root;//�����Ϊһ�н��ĸ����
			}
 }
}
