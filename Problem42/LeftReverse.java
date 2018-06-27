package Problem42;
/*
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。 
 * substring截取字符串到后面即可
 */
public class LeftReverse {

	public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new LeftReverse().leftReverse(s, 2));

	}
	
	public StringBuffer  leftReverse(String str,int n) {
        if (null == str || str.length() <= 0) {
            return null;
        }
        StringBuffer reverseStr=new StringBuffer();//利用stringBuffer提高效率
        String str1=str.substring(0, n);	//截取长度
        String str2=str.substring(n,str.length());
        return reverseStr.append(str2).append(str1);		//改变两个先后顺序即可
	}
}
