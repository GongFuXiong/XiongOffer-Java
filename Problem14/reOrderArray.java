package Problem14;
/*
 * 实现一个函数来调整该函数数组中数字的顺序，奇前偶后
 * 每次只和前面一个数交换位置。或者利用辅助数组,
 * 注意扩展性和完整性
 */
public class reOrderArray {
	public static void main(String[] args) {
        int[] array= {0,11,12,6,3,3,2,4,5,6,7};      
        order(array);    
        for(int item:array)    			//item在array中的循环输出
            System.out.println(item);  
	}
	
    public static void order(int[] array) {    
        if(array==null||array.length==0)    //特殊情况
            return ;    
        int start=0;    			//初始化
        int end=array.length-1;    
        while(start<end) {    
            while(start<end&&!isEven(array[start])) {    //需要start<end重复判断，以免在start++出现超范围
                start++;    
            }    
            while(start<end&&isEven(array[end])) {    //碰到奇数即停止
                end--;    
            }    
//            if(start<end) {    
                int temp=array[start];    //互换数值
                array[start]=array[end];    
                array[end]=temp;    
//            }    
        }    
    }    
    private static boolean isEven(int n) {    //增加函数的扩展性，判断是否为偶数
        return (n&1)==0;    		//利用位运算判断
    } 
}
