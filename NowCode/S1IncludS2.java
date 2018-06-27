package NowCode;
import java.util.List;
import java.util.Scanner;

import com.sun.jmx.snmp.SnmpOid;

import sun.management.snmp.util.SnmpCachedData;
import sun.management.snmp.util.SnmpListTableCache;
import sun.management.snmp.util.SnmpTableHandler;

public class S1IncludS2 {
	
		//判断s1是否包含s2
		public static boolean find(String s1,String s2) {
			//System.out.println("---------"+s1+" "+s2);
			int j=0;
			for(int i=0;i<s1.length();i++){
				//System.out.println(j);
				if(s2.charAt(j)==s1.charAt(i))  //判断字母是否相等
				{
					if(j==s2.length()-1)
						return true;
					j++;
					
				}
				
			}
			return false;
		}
		//迭代计算相同的
		public static int  cacl(StringBuffer s1,StringBuffer s2) {
			//System.out.println(s1+" "+s2);
			if(find(s2.toString(), s1.toString()))
				return s1.length();
			for(int i=0;i<s1.length();i++){
				StringBuffer temp=s1.delete(i, i+1);
				//System.out.println(temp);
				cacl(temp, s2);
			}
			return 0;
		}

        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            while(in.hasNext()) {
            	//读2个字符串
                String[] tStrings=in.nextLine().split("/");
                //StringBuffer s1=new StringBuffer(tStrings[0]); 
                //String s2=tStrings[1];
                StringBuffer s1=new StringBuffer();
                StringBuffer s2=new StringBuffer();
                //利用同去除不重复的
                int[] c1=new int [200];
                int[] c2=new int [200];
                for(int i=0;i<tStrings[0].length();i++){  //
                	c1[tStrings[0].charAt(i)]++;
                }
                for(int i=0;i<tStrings[1].length();i++){
                	c2[tStrings[1].charAt(i)]++;
                }
                
                for(int i=0;i<tStrings[0].length();i++){
                	if(c2[tStrings[0].charAt(i)]>0)
                		s1.append(tStrings[0].charAt(i));
                }
                for(int i=0;i<tStrings[1].length();i++){
                	if(c1[tStrings[1].charAt(i)]>0)
                		s2.append(tStrings[1].charAt(i));
                }
               // System.out.println(s1);
               // System.out.println(s2);
                //System.out.println(find("ea", "ea"));
                //
                
               int count=tStrings[0].length()+tStrings[1].length()-(s1.length()>s2.length()?cacl(s2, s1):cacl(s1, s2))*2;
               //System.out.println(cacl(s1, s2)); 
               System.out.println(count);
                //System.out.println(s1.delete(0, 1));

            }
        }


}
