package Problem50;
import util.TreeNode;

/*
 * ��������ͨ��������ָ�򸸽ڵ��ָ��
 * �����ڵ����������·���ϣ�����������������ĵ�һ�������ڵ㡣
 * ����ÿ���ڵ��������Ϊlogn������ʱ�临�Ӷ�ΪO(logn),�ռ临�Ӷ�O(1)
 */
public class getLowestCommonAncestor1 {
	public static void main(String[] args) {
		// ��Ҫ�¶���ָ�򸸽���node��ת��������
	}
	
	public static TreeNode  getLowestCommonAncestor1(TreeNode root,TreeNode node1,TreeNode node2){  
        if(root == null || node1 == null || node2 == null)     return null;  

        int depth1 = findTheDepthOfTheNode(root, node1, node2);  //����node1�����
        if(depth1 == -1){  //node1��node2��һ��·����
            return node2.parentNode;  
        }  
        int depth2 = findTheDepthOfTheNode(root, node2, node1);  //����node2���
        if(depth2 == -1){  
            return node1.parentNode;  
        }  
        
        //pָ�����Ľڵ㣬qָ���ǳ�Ľڵ�  
        TreeNode p = depth1 > depth2 ? node1 : node2;  
        TreeNode q = depth1 > depth2 ? node2 : node1;  
        int depth =  Math.abs(depth1 - depth2);  //�������ֵ
        while(depth > 0){  			//����depth��,ʹ�ȳ�
            p = p.parentNode;  
            depth --;  
        }  
        while(p != q){  //��������ͬΪֹ
            p = p.parentNode;  
            q = q.parentNode;  
        }  
        return p;  
    }  
      
    //��node1����ȣ����node1��node2��һ��·���ϣ��򷵻�-1�����򷵻�node1�����  
    public static int findTheDepthOfTheNode(TreeNode root,TreeNode node1,TreeNode node2){  
        int depth = 0;  
        while(node1.parentNode != null){  
            node1 = node1.parentNode;  
            depth ++;  
            if(node1 == node2){  
                return -1;  
            }  
        }  
        return depth;  
    } 
}
