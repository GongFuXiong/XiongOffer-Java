package Problem42;
/*
 * 先将整个字符串翻转，然后将每个单词翻转
 */
public class ReverseSentence {

	public static void main(String[] args) {
		String string="I am a student."; 
		new ReverseSentence().reverseSentence(string);

	}
	/*
	 * 利用空格分离sentence，从后向前append
	 */
    public void reverseSentence(String sentence) {    
        if(sentence==null)    
            return;    
        String[] str=sentence.split(" ");    //利用空格分离
        StringBuffer sb=new StringBuffer();    //定义一个stringBuffer类型
        for(int i=str.length-1; i>=0; i--) {    
            sb.append(str[i]+" ");    
        }    
        System.out.println(sb);    
    }  
}
