package Problem45;
import java.util.*;
/*
 * 圆圈中最后剩下的数字（约瑟夫环）双向循环链表
 * 利用循环链表实现
 */
public class JosephLoopLastRemaining {
	public static void main(String[] args) {
        System.out.println(new JosephLoopLastRemaining().lastRemaining(5, 2));
        System.out.println(new JosephLoopLastRemaining().lastOneWay2(5, 2));
	}
	
	public int lastRemaining(int sum,int count){    
        if (sum < 1 || count < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();//双向链表
        for (int i = 0; i < sum; i++) {
            list.add(i);		//添加元素
        }

        // 要删除的元素位置
        int index = 0;
        while (list.size() > 1) {
        	index = (index+count-1) % list.size();//index+count-1为新的下标
            list.remove(index);
        }
        return list.get(0);//返回值
    }
	
    // 时间复杂度O(n)空间复杂度O(1)
    /**
     * 递推公式
     * f(n,m) = 0, n = 1
     * f(n,m) = (f(n-1,m) + m) % n, n > 1
     * 推导过程：
     * 记f(n, m)为每次在n个数字0,1, … , n-1中每次删除第m个数字最后剩下的数字。
     * 第一个被删除的(m - 1)%n,记为k.删除以后记为f'(n-1, m),且f(n,m) = f'(n-1,m)
     * 将k+1,...,n-1,0,1,...,k-1做一个映射，映射的结果为一个0到n-2的序列,将映射定义为p
     * 则p(x) = (x-k-1)%n,表示映射前的数字如果为x，则映射后为(x-k-1)%n，
     * 则该映射的逆映射为p-1(x)=(x+k+1)%n,映射之后也是0开始的连续序列，则
     * f(n,m)=f'(n-1,m)=p-1(f(n-1,m))=(f(n-1,m)+k+1)%n
     * 则f(n,m)=(f(n-1,m)+m)%n
     */
    public int lastOneWay2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }
}
