package Problem31;
/*
 * 求连续子数组（包含负数）的最大和
 * 若和小于0，则将最大和置为当前值，否则计算最大和。
 */
public class FindGreatestSubArray {

	public static void main(String[] args) {
        int[] array= {1,-2,3,10,-4,7,2,-5};    
        System.out.println(findGreatestSubArray(array)); 
        System.out.println(findGreatestSumOfSubArrayWithDP(array)); 

	}
	
    public static int findGreatestSubArray(int[] array) {    
        if(array==null)    
            return 0;    
        int currentSum=0;    			//定义当前和以及最大和
        int greatestSum=0;    
        for(int i=0; i<array.length; i++) {    
            if(currentSum<=0) {    			//计算当前和是否有增加
                currentSum=array[i];    
            } else {    
                currentSum+=array[i];    
            }    
            
            if(currentSum>greatestSum)    	//保持最大的当前和
                greatestSum=currentSum;
        }    
        return greatestSum;    
    } 
    /*
     * 使用动态规划,,,和上面的代码相似
     */
    public static int findGreatestSumOfSubArrayWithDP(int[] array) {
        if (null == array || array.length <= 0) {
            return 0;
        }
        int greatestSum = 0;
        int currentSum = 0;
        for (int i = 1; i < array.length; i++) {
        	currentSum = (currentSum < 0) ? array[i] : (currentSum + array[i]);
            if (currentSum > greatestSum) {
            	greatestSum = currentSum;
            }
        }
        return greatestSum;
    }
}
