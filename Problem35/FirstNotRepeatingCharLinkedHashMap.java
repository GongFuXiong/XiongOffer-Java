package Problem35;

import java.util.*;

/*
 * 寻找只第一个出现一次的字符
 * LinkedHashMap实现,利用LinkedHashMap保存字符和出现次数。
 */
public class FirstNotRepeatingCharLinkedHashMap {

	public static void main(String[] args) {
		System.out.println(getFirstNotRepeating("aba"));

	}

	public static Character getFirstNotRepeating(String s) {
		if (null == s || s.length() <= 0) {
			return null;
		}

		Map<Character, Integer> map = new LinkedHashMap<>();//定义一个hash表
		
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {		//判断是否包含key
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);		//若包含增value加一
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		
		for (Character key : map.keySet()) {	//keySet返回的是一个set集合
			if (map.get(key) == 1) {
				return key;
			}
		}
		
		return null;
	}
}
