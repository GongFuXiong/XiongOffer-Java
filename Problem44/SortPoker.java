package Problem44;
import java.util.Arrays;

/*
 * 从扑克牌中随机抽 5 张牌，判断是不是顺子
 * 用数组记录五张扑克牌，将数组调整为有序的，若0出现的次数>=顺子的差值，即为顺子
 */
public class SortPoker {
	public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 5, 0};
        int[] b = new int[] {1, 2, 4, 0, 0};
        System.out.println(new SortPoker().isContinuous(a));
        System.out.println(new SortPoker().isContinuous(b));

	}
	
    public boolean isContinuous(int[] a) {
        if (null == a || a.length != 5) {
            return false;
        }

        Arrays.sort(a);	//排序先
        int numberOfZero = 0;
        int numberOfGap = 0;

        // 统计数组中0的个数
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                numberOfZero++;
            } else {
                break;		//break是因为排序之后，后面没有0值，可以减少代码计算量
            }
        }
        System.out.println(numberOfZero);

        // 统计数组中的间隔数目
        int small = numberOfZero;
        int big = small + 1;		//指0值后一位数
        while (big < a.length) {
            if (a[small] == a[big]) {		//两个相等，则不可能为顺子
                return false;
            }
            numberOfGap += (a[big] - a[small] - 1);//要减一才能计算代沟插差值
            small = big;		//重新赋值
            big++;
        }

        return (numberOfGap > numberOfZero) ? false : true;
    }
}
