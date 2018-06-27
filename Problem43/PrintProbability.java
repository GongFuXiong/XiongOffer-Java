package Problem43;
/**
 * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s，输入n，打印出s的所有可能的值出现的概率。。。
 * 和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3, n-4,n-5，n-6的次数总和，
 * 所以我们把另一个数组的第n个数字设为前一个数组对应n-1,n-2,n-3,n-4,n-5，n-6之和
 * 要想到用数组来存放n个骰子的每个点数出现的次数
 */
public class PrintProbability {
	public static void main(String[] args) {
		printProbability(2);
	}

	private static void printProbability(int num) {
		if(num<1)
			return;
		int gMaxValue=6;
		int[][] probabilities=new int[2][gMaxValue*num+1];		//定义2个输出长数组
		int flag=0;  // 标记当前要使用的是第0个数组还是第1个数组
		
		// 当抛出一个骰子时出现的各种情况
		for(int i=1;i<=gMaxValue;i++){
			probabilities[flag][i]=1;	//将0数组前6个全部赋值为1
		}
		// 抛出其它骰子
		for(int k=2;k<=num;k++){
			// 如果抛出了k个骰子，那么和为[0, k-1]的出现次数为0
			for(int i=0;i<k;i++){ 
			    probabilities[1-flag][i]=0; 	//将0赋值给第二个数组前k个值
			   } 
			// 抛出k个骰子，所有和的可能
			for(int i=k;i<=gMaxValue*k;i++){ 
			    probabilities[1-flag][i]=0; 	//将0赋值给第二个数组后k个值
			    // 每个骰子的出现的所有可能的点数
			    for(int j=1;j<=i&&j<=gMaxValue;j++)   
			    	// 统计出和为i的点数出现的次数，，，，，将第二个数组的第n个数赋值为0数组的后n-6的累加和
			    	probabilities[1-flag][i]+=probabilities[flag][i-j]; //
		}
			 flag=1-flag;		//循环一次就改变一次两个数组之间的顺序
	}
		
		double total=Math.pow(gMaxValue, num);		//总的排列个数
		for(int i=num;i<=gMaxValue*num;i++){ 		//输出每个色子的概率
			   double ratio=(double)probabilities[flag][i]/total; //概率值，此时flag为1
			   System.out.print(i+" "); 
			   System.out.println(ratio); 
	}
  }
}
