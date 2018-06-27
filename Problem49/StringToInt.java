package Problem49;
/*
 * 将一个字符串转换成一个整数，数值为0或者字符串不是一个合法的数值则返回0
 * 若为负数，则输出负数，字符0对应48,9对应57，不在范围内则返回false
 * 注意多种情况
 */
public class StringToInt {

	public static void main(String[] args) throws Exception {
		String str="+132A111111111113";
		int digit = str.charAt(2)-'0' ;
//		System.out.println(digit);
//		System.out.println(str.charAt(2));
		
		System.out.println(strtoInt("1234"));
		System.out.println(strtoInt("-123434"));
		System.out.println(strtoInt("+-----++"));
	}
	
    public static int strtoInt(String s) throws Exception {
        int index = 0, sign = 1, total = 0;

        // 无效输入处理
        if (null == s || s.length() <= 0) {
            throw new Exception("空字符");
        }

        // 全为空格
        while (s.charAt(index) == ' ' && index < s.length()) {
            index++;
            if (index == s.length()) {
                throw new NumberFormatException("全为有空格");
            }
        }

        // 处理符号
        while (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;		//保存符号标记
            index++;
            if (index >1) {
                throw new NumberFormatException("多个符号");
            }
        }

        /*
         * 转换string，，处理避免溢出......主程序
         */
        while (index < s.length()) {
            int digit = s.charAt(index)-'0';//char‘1’和int‘1’的数值不一样，必须要减去‘0’才能比较，或者直接比较‘0’
            if (digit < 0 || digit > 9) {
                throw new NumberFormatException("数值溢出");
            }

            if (total > Integer.MAX_VALUE / 10 ||total<Integer.MIN_VALUE) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;//以此遍历之后乘以10
            index++;
        }

        return sign * total;//注意符号
    }
}
