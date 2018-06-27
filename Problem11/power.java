package Problem11;
/*
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 考虑输入值的多种情况
 */
public class power {

	public static void main(String[] args) throws Exception {
		double a=powerfun(2.0, 5);    			//double类型为2.0
		System.out.println(a);
		
	}
	
	public static  double powerfun(double base,int exponent) throws Exception {		//需在此定义异常
		double result=0.0;
		if (equal(base,0.0)&&exponent<0) {		//不能用==比较两个浮点数是否相等，因为有误差。
			throw new Exception("0的负数次幂没有意义");
		}
		result=powerWithExpoment(base, exponent);
		if (exponent<0) {				//处理exponent为负数的情况，为倒数
			result=1.0/result;
		}
		return result;
		
	}

	private static double powerWithExpoment(double base, int exponent) {
		if (exponent==0) {
			return 1;
		}
		if (exponent==1) {
			return base;
		}
		double result=1.0;		
		/*
		 * 常规循环解法
		 */
//		for (int i = 1; i <= exponent; i++) {
//			result=result*base;
//		}
//		return result;
		/*
		 * 递归优化法，奇数和偶数相加次数即为exponent值，与result=result*base连乘相似
		 * 递归到最底层，然后从最底层一层层返回到最高层，计算结果
		 */
        result = powerWithExpoment(base, exponent >> 1);	//利用递归求解，右移一位代替除以2操作
        result *= result;
        if ((exponent & 1) == 1) result *= base;	//利用位与运算&代替求与运算%，效率高。在递归中奇数会调用
        return result;
	}

	private static  boolean equal(double num1, double num2) {	//利用函数判断base是否为0
		if (Math.abs(num1-num2)<0.0000001){					//利用math方法求绝对值
			return true;
		}else {
			return false;
		}
	}
}
