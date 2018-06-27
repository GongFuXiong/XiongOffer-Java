package Problem28;
/*
 * 只利用循环（难理解循环是怎么全部输出的）
 */
public class PermutationOfStringLoop {

	public static void main(String[] args) {
        permutation("abcd");

	}

    public static void permutation(String str) {    
        int count=0;    			//排列个数
        if(str==null)    
            return;    
        char[] chs=str.toCharArray();    //将字符串对象中的字符转换为一个字符数组
        int point=0;    
        System.out.print(chs);    //同排输出
        System.out.print(" ");    
        count++;    
        char temp1=chs[point];    
        chs[point]=chs[++point];    
        chs[point]=temp1;    
        while(!String.valueOf(chs).equals(str)) {    //循环输出（判断是否和原str相同）
            System.out.print(chs);    
            System.out.print(" ");    
            count++;    
            if(point==chs.length-1) {    //循环和下一位下标互换
                char temp=chs[point];    
                chs[point]=chs[0];    
                chs[0]=temp;    
                point=0;    
            } else {    
                char temp=chs[point];    
                chs[point]=chs[++point];    
                chs[point]=temp;    
            }    
        }    
        System.out.println(count);    
    }
}
