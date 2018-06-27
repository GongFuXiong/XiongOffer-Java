package Problem12;
/*
 * 输入数字n, 按顺序打印出从1到最大的n位十进制数
 * 注意数字较大情况，用数组来储存，用字符串来表示数字上模拟加法
 */
public class PrintToMaxDigit {
	public static void main(String[] args) throws Exception {
		print1ToMaxOfNDigits(3);
		
		char a= (char) (11 + '0');
		System.out.println(a);
	}
/*
 * 利用递归法全排列数字
 */
    public static void print1ToMaxOfNDigits(int n) throws Exception {
        if (n <= 0) throw new Exception("n为0-------------------");
        char[] number = new char[n];		//划分出有n个位数的字符型数组
        /*
         * number值储存为数字代表的字符型，字符串最后一个结束符为'0'
         * 在最高位输出n位置上的9个不同数字
         */
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');	//初始化char[0]位置储存，此处为最高位
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

	private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {			//控制输出数字长度
            String s = new String(number);		//将char[]转换为string类型,s为n维字符串
            //此for循环作用为删除001前面的数字0
//            for (int i = 0; i <s.length(); i++) {
//                if (s.charAt(0) != '0') {		//去掉01数字前面的0
            	System.out.println("ffffffffffffffffffffffffffff");//打标签
                System.out.println(s.substring(0));//截取掉s从首字母起长度为i的字符串，将剩余字符串赋值给s
//                    break;				//需要break，不输出多位数后面的数字
//                }
//            }
            return;				//必须使用return，执行return这个函数剩余的部分就不会再执行了，当index到顶，返回主函数
        }
        //在n的其他位做相同操作，
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }
	
	/*
	 * 跑不出来的
	 */
	public static void printMaxDitgit(int n) throws Exception {
		int[] array=new int[n];		//定义一个n容量的数组
		if (n<=0) {
			throw new Exception("n为0-----------");
		}
		printArray(array,0);
	}
	
	private static void printArray(int[] array, int n) {
		for (int i = 0; i < 10; i++) {			//输出10个数
			if (n!=array.length) {
				array[n]=i;
				printArray(array, n+1);			//使用递归填充array
			}else {
				boolean isFirstNo0=false;
				for (int j = 0; j < array.length; j++) {
					if (array[j]!=0) {
						System.out.println(array[j]);
						if (!isFirstNo0) {
							isFirstNo0=true;
						}else {
							if (isFirstNo0) {
								System.out.println(array[j]);
							}
						}
					}
					System.out.println();
					return;
				}
			}
		}
	}
}
