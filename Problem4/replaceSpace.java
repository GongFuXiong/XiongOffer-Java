package Problem4;

public class replaceSpace {
	/*
	 * 将一个字符串中的空格替换成“%20”
	 * static方便在没有创建对象的情况下来进行调用（方法/变量）
	 */
	public static String replace(String input) {		//必须采用static方法才能调用replace方法
		if (input==null) {
			return null;
		}
		StringBuffer outputstr= new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
//			if (String.valueOf(input.charAt(i)).equals(" ")) {				//	==比较的是地址，equals比较的内容
			if (input.charAt(i)==' ') {				//	==比较的是地址，equals比较的内容
				outputstr.append("20%");			//只有StringBuffer才有append方法
			}
			else {
				outputstr.append(input.charAt(i));

			}
		}
//		return outputstr.toString();			//必须转换成string类
		return String.valueOf(outputstr);		//利用valueOf方法取值也行
//		return new String(outputstr);			//也可以重新定义一个string
	}
	
	/*
	 * 直接利用置换函数来做
	 */
	public static String replaceByRegex(String input) {
		if (input ==null ) {
			return null;
		}
		return input.replace(" ", "%20");
	}
	
	public static void main(String[] args) {
		String str= "we are happy";
		System.out.println(replaceByRegex(str));
	}
}

