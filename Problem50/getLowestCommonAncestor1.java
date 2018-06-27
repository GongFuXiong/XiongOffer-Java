package Problem50;
import util.TreeNode;

/*
 * 若树是普通树，但有指向父节点的指针
 * 两个节点如果在两条路径上，类似于求两个链表的第一个公共节点。
 * 由于每个节点的深度最多为logn，所以时间复杂度为O(logn),空间复杂度O(1)
 */
public class getLowestCommonAncestor1 {
	public static void main(String[] args) {
		// 需要新定义指向父结点的node，转换成链表
	}
	
	public static TreeNode  getLowestCommonAncestor1(TreeNode root,TreeNode node1,TreeNode node2){  
        if(root == null || node1 == null || node2 == null)     return null;  

        int depth1 = findTheDepthOfTheNode(root, node1, node2);  //返回node1的深度
        if(depth1 == -1){  //node1和node2在一条路径上
            return node2.parentNode;  
        }  
        int depth2 = findTheDepthOfTheNode(root, node2, node1);  //返回node2深度
        if(depth2 == -1){  
            return node1.parentNode;  
        }  
        
        //p指向较深的节点，q指向较浅的节点  
        TreeNode p = depth1 > depth2 ? node1 : node2;  
        TreeNode q = depth1 > depth2 ? node2 : node1;  
        int depth =  Math.abs(depth1 - depth2);  //求其绝对值
        while(depth > 0){  			//先走depth步,使等长
            p = p.parentNode;  
            depth --;  
        }  
        while(p != q){  //遍历到相同为止
            p = p.parentNode;  
            q = q.parentNode;  
        }  
        return p;  
    }  
      
    //求node1的深度，如果node1和node2在一条路径上，则返回-1，否则返回node1的深度  
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
