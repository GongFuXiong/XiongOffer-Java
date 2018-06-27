package Problem32;
/*
 * 从1到整数n中1出现的次数
 * 
 */
public class NumberOf1Between1AndN {

	public static void main(String[] args) {
		System.out.println(getNumberOf1Between1AndN(20000));
		System.out.println(countOne(20000));
	}
	/*
	 * O(nlgn)，直接求法，不考虑时间效率,依次判断n中每个数是否符合要求
	 * 从个位开始判断，除以10，依次向上判断
	 */
	public static int getNumberOf1Between1AndN(int n) {
		if (n < 1) {
			return 0;
		}
		
		int count = 0;			//1的个数count
		for (int i = 1; i <= n; i++) {
			int val = i;
			while (val != 0) {				
				if (val % 10 == 1) {	//判断个位是否为1
					count++;
				}
				val = val / 10;			//前移一位
			}
		}
		
		return count;
	}
	
	/*
	 * 根据数据规律提高时间效率O(logn)
	 * 若百位上数字为0，百位上可能出现1的次数由更高位决定；若百位上数字为1，百位上可能出现1的次数
	 * 不仅受更高位影响还受低位影响；若百位上数字大于1，则百位上出现1的情况仅由更高位决定
	 * （根据数字规律这个理解有难度）
	 */
    public static long countOne(long n) {    
        long count = 0;    
        long i = 1;    
        long current = 0,after = 0,before = 0;    
        while((n / i) != 0) {    
            current = (n / i) % 10; //当前位数字    ，指与i相同的位数
            before = n / (i * 10); //高位数字    ，，，指与i以上的位数
            after = n - (n / i) * i; //低位数字    ，，，此可表示任何数的个位数
            
            if (current > 1)    		//如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
                count = count + (before + 1) * i;    
            else if (current == 0)    //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                count = count + before * i;    
            else if(current == 1)    //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + before * i + after + 1;    
            i = i * 10;    
        }    
        return count;    
    }  
}
