package Problem24;
import java.util.Arrays;
/*
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果(左边小于根结点，右边大于根结点)
 * 先找到右子树的开始位置，然后分别进行左右子树递归处理
 */
public class VerifySequence {			//这个比较难理解

	public static void main(String[] args) {
//        int[] array= {5,7,6,9,11,10,8};    
        int[] array={7,4,6,5};    
//        int[] array1={6,7,8,5};    
        System.out.println(verfiySequenceOfBST(array)); 
	}

    public static boolean verfiySequenceOfBST(int[] sequence) {    
        if(sequence==null||sequence.length==0)    
            return false;    
        int length=sequence.length;    
        int root=sequence[length-1];    //跟结点
        int cut=0;    			//循环计算根结点的次数
        for(int i=0; i<length-1; i++) {    
            if(sequence[i]>root)    //循环计算根结点的次数
            	cut++;    
            	break;    		//确保每次循环cut有且只增加1
        }    
        if(cut==0) {    
            verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, length-1));//截取全部数组
        } else {    
            for(int j=cut; j<length-1; j++) {    //判断剩余sequence中最后一个数是否为左结点
                if(sequence[j]<root)    
                    return false;    
            }    
        }    
        boolean left=true;    //左子树递归循环，判断是不是二叉搜索树
        if(cut>0)    
            left= verfiySequenceOfBST(Arrays.copyOfRange(sequence,0, cut));    
        
        boolean right=true;   //右子树递归循环，判断是不是二叉搜索树
        if(cut<length-1)  
        	right=verfiySequenceOfBST(Arrays.copyOfRange(sequence,cut,length-1));    
        return (right&&left);    
    }
}
