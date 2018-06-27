package Problem50;
import java.util.Stack;
import util.TreeNode;
/*
 * 若树是普通树，并没有指向父节点的指针
 * 用栈来实现类似于指向父节点指针的功能，
 * 获取node节点的路径时间复杂度为O(n),所以总的时间复杂度是O(n),空间复杂度是O(logn)
 * 获得根节点到node节点的路径  ，，，有点难理解
 */
public class GetLowestCommonAncestor2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode getLowestCommonAncestor2(TreeNode root, TreeNode node1,TreeNode node2){  
        if(root == null || node1 == null || node2 == null)		return null;  
 
        Stack<TreeNode> path1 = new Stack<TreeNode>();  	//定义栈空间，保存路径
        boolean flag1 = getThePathOfTheNode(root, node1,path1);  //标签是否有node1，并把路径保存在栈path1中
        if(!flag1){//树上没有node1节点  
            return null;  
        }  
        Stack<TreeNode> path2 = new Stack<TreeNode>();  
        boolean flag2 = getThePathOfTheNode(root, node2,path2);  
        if(!flag2){//树上没有node2节点  
            return null;  
        }  
        
        if(path1.size() > path2.size()){ //让两个路径等长  
            while(path1.size() !=  path2.size()){  
                path1.pop();  
            }  
        }else{  
            while(path1.size() !=  path2.size()){  
                path2.pop();  
            }  
        }  
        
        while (!path1.peek().equals(path2.peek())){//当两个节点在一条路径上时，equals只比较值是否一样与==不一样
            path1.pop();  
            path2.pop();
        } 
            return path1.peek();  
        }  
    }   
      
    //获得根节点到node节点的路径  ，，，有点难理解
    public static boolean getThePathOfTheNode(TreeNode root,TreeNode node,Stack<TreeNode> path){  
        path.push(root);  
        if(root == node){  	//一直遍历到找到node为止
            return true;  
        }  
        boolean found = false;  //found为找到node的标签
        if(root.left != null){  
            found = getThePathOfTheNode(root.left, node, path);  //往左子树继续递归
        }  
        if(!found && root.right != null){  //!found表示在左子树中没找到node
            found = getThePathOfTheNode(root.right, node, path);  
        }
        if(!found){  //若都没找到，则pop出
            path.pop();  
        }  
        return found;  
    }  
}
