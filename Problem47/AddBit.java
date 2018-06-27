package Problem47;
/*
 * 求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 利用位运算
 */
public class AddBit {
	public static void main(String[] args) {
		System.out.println(new AddBit().add(13, 2));

	}
	
    public int add (int num1, int num2) {
        int sum = 0;
        int carry = 0;//表示进位
        
        while (num2 != 0){//没有进位即停止，有进位继续相加
            sum = num1 ^ num2;//相加和异或结果一直，只是没有进位
            carry = (num1 & num2) << 1;//仅仅两个位都是1时才有进位，两个同时为1的位进一位表示进位

            num1 = sum;
            num2 = carry;
        } 
        return num1;
    }
}
