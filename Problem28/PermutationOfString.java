package Problem28;
import java.util.*;
/*
 * 输入一个字符串，打印出该字符串中字符的所有排列
 * 将当前位置的字符和前一个字符位置交换，（循环递归）
 */
public class PermutationOfString {

	public static void main(String[] args) {
        PermutationOfString testPermutation = new PermutationOfString();
        ArrayList<String> list = testPermutation.Permutation("abc");
        System.out.println(list);

	}
	
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();			//定义一个数组链表
        if (null == str || str.length() <= 0) {
            return null;
        }

        int index = 0;
        int length = str.length();

        TreeSet<String> set = new TreeSet<>();//treeset子类 ，不能重复，结果有序排放
        permCore(set, str.toCharArray(), index, length);	//str.toCharArray()将字符串对象中的字符转换为一个字符数组

        list.addAll(set);		//将集合元素添加到列表里面
        return list;
    }

    private void permCore(TreeSet<String> set, char[] array, int index, int length) {
        if (index == length) {
            set.add(String.valueOf(array));	//必须将array转换成string
        } else {
            for (int i = index; i <= length-1; i++) {						//循环递归。。。难理解
                swap(array, i, index);			//下标i和low互换
                permCore(set, array, index + 1, length);		//回退一位，递归到后面一位
                swap(array, i, index);				//恢复
            }
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
