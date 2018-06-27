package Problem50;
import java.util.Stack;
import util.TreeNode;
/*
 * ��������ͨ������û��ָ�򸸽ڵ��ָ��
 * ��ջ��ʵ��������ָ�򸸽ڵ�ָ��Ĺ��ܣ�
 * ��ȡnode�ڵ��·��ʱ�临�Ӷ�ΪO(n),�����ܵ�ʱ�临�Ӷ���O(n),�ռ临�Ӷ���O(logn)
 * ��ø��ڵ㵽node�ڵ��·��  �������е������
 */
public class GetLowestCommonAncestor2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode getLowestCommonAncestor2(TreeNode root, TreeNode node1,TreeNode node2){  
        if(root == null || node1 == null || node2 == null)		return null;  
 
        Stack<TreeNode> path1 = new Stack<TreeNode>();  	//����ջ�ռ䣬����·��
        boolean flag1 = getThePathOfTheNode(root, node1,path1);  //��ǩ�Ƿ���node1������·��������ջpath1��
        if(!flag1){//����û��node1�ڵ�  
            return null;  
        }  
        Stack<TreeNode> path2 = new Stack<TreeNode>();  
        boolean flag2 = getThePathOfTheNode(root, node2,path2);  
        if(!flag2){//����û��node2�ڵ�  
            return null;  
        }  
        
        if(path1.size() > path2.size()){ //������·���ȳ�  
            while(path1.size() !=  path2.size()){  
                path1.pop();  
            }  
        }else{  
            while(path1.size() !=  path2.size()){  
                path2.pop();  
            }  
        }  
        
        while (!path1.peek().equals(path2.peek())){//�������ڵ���һ��·����ʱ��equalsֻ�Ƚ�ֵ�Ƿ�һ����==��һ��
            path1.pop();  
            path2.pop();
        } 
            return path1.peek();  
        }  
    }   
      
    //��ø��ڵ㵽node�ڵ��·��  �������е������
    public static boolean getThePathOfTheNode(TreeNode root,TreeNode node,Stack<TreeNode> path){  
        path.push(root);  
        if(root == node){  	//һֱ�������ҵ�nodeΪֹ
            return true;  
        }  
        boolean found = false;  //foundΪ�ҵ�node�ı�ǩ
        if(root.left != null){  
            found = getThePathOfTheNode(root.left, node, path);  //�������������ݹ�
        }  
        if(!found && root.right != null){  //!found��ʾ����������û�ҵ�node
            found = getThePathOfTheNode(root.right, node, path);  
        }
        if(!found){  //����û�ҵ�����pop��
            path.pop();  
        }  
        return found;  
    }  
}
