package Problem41;
import java.util.*;
/*
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序
 * 还是定义两个指针，分别递增，寻找和为s的序列
 * 利用list来处理序列问题
 */
public class FindContinuousSequence {

	public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().find(9));
        int[] a={1,2,3};//数组为{}
	}
	
    public List<List<Integer>> find(int num) {
        List<List<Integer>> list = new ArrayList<>();		//定义包含list的list
        if (num < 3) {
            return null;
        }

        int low = 1;
        int high = 2;
        while (low < (num + 1) /2) {		//低下标必须小于中间数
            int curSum = 0;
            for (int i = low; i <= high; i++) {
                curSum += i;		//list所加之和
            }
            
            if (curSum == num) {
                List<Integer> tempList = new ArrayList<>();
                for (int i = low; i<= high; i++) {	//若相等则加入list中所有元素
                    tempList.add(i);		
                }
                list.add(tempList);
                low++;				//继续寻找下一个符合的list
            } else {
                if (curSum > num) {			//利用low和high缩小范围
                    low++;
                } else {
                    high++;
                }
            }
        }
        return list;
    }
}
