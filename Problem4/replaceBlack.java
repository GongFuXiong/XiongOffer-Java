package Problem4;

public class replaceBlack {
    /**
     * 将空格替换为%20（复杂度优化版）
     */
    public static void replace(char[] chars,int cLength){
        //检查输入有效性
        if(chars==null) return;
        int numberOfChar=0;
        for (int j=0;j<chars.length;j++){
            if (chars[j]!='\u0000')
            numberOfChar++;
        }
        if (numberOfChar!=cLength) return;

        //统计空格个数
        int numberOfSpace = 0;
        for (int i=0;i<cLength;i++){
            if (chars[i]==' '){
                numberOfSpace++;
            }
        }

        int newLength = numberOfSpace*2+cLength;	//为替换后一共的str一共的长度
        if (newLength>chars.length)
            return;
        int indexOfOld = cLength-1;//替换前长度
        int indexOfNew = newLength-1;

        //从后往前替换
        while (indexOfOld>=0 && indexOfNew>indexOfOld){
            if (chars[indexOfOld]==' '){
                chars[indexOfNew--]='0';
                chars[indexOfNew--]='2';
                chars[indexOfNew--]='%';
            }
            else chars[indexOfNew--] = chars[indexOfOld];
            --indexOfOld;
        }

    }
	public static void main(String[] args) {
        char[] chars = new char[30];
        String s = "we are happy";
        char[] a = s.toCharArray();		//将str类型转化为char类型
        for (int i = 0;i<a.length;i++){
            chars[i]=a[i];
        }

        replace(chars,12);
        for (int i = 0; i <chars.length ; i++) {
            System.out.print(chars[i]);
        }
	}
}
