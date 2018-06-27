package Problem24;
import java.util.Arrays;
/*
 * 容易理解版
 */
public class VerifyBST {
    public static void main(String[] args) {
      int[] array= {5,7,6,9,11,10,8};    
//    int[] array={7,4,6,5};    
//    int[] array={6,7,8,5};    
    System.out.println(verfiySequenceOfBST(array)); 
  }
	
	
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return jugde(sequence, 0, sequence.length - 1);
    }

    private static boolean jugde(int[] a, int start, int root) {//避免了Arrays.copyOfRange截取数组

        if (start == root) return true;

        //寻找左子树的根
        int i = root - 1;
        while (a[root] < a[i] && i > start)
            i--;
        for (int j = start; j < i; j++) {
            if (a[j] > a[root]) return false;//如果左子树有大于跟结点的则返false
        }

        jugde(a, start, i);
        jugde(a, i + 1, root);


        return true;

    }
    /*
     * 改编版，也跑的通
     */
    public static boolean verfiySequenceOfBST(int[] sequence) {
        if(sequence==null||sequence.length==0)    return false;    //特殊情况
        if (sequence.length==1) return true;
        
        int length=sequence.length;    
        int root=sequence[length-1];    //跟结点
      //寻找左子树的根
        int leftIndex=length-1-1;		//左结点初始化为root-1，左右子树的分界点
        while (root<sequence[leftIndex] && leftIndex>0) {//寻找左右子树的分界点
        	leftIndex--;
		}
        for (int j = 0; j < leftIndex; j++) {	//这个j=0是对的，因为新的sequence也是从下标为0开始的
			if (sequence[j]>root) {//如果左子树有大于跟结点的则返false
				return false;
			}
		}
        //产生递归循环，生成新的sequence
        verfiySequenceOfBST(Arrays.copyOfRange(sequence,0, leftIndex));
        verfiySequenceOfBST(Arrays.copyOfRange(sequence,leftIndex, length-1));
        return true;
	}


}
