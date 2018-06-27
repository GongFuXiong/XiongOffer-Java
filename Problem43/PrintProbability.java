package Problem43;
/**
 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�����
 * ��Ϊn�����ӳ��ִ���Ӧ�õ�����һ��ѭ�������ӵ�����Ϊn-1,n-2,n-3, n-4,n-5��n-6�Ĵ����ܺͣ�
 * �������ǰ���һ������ĵ�n��������Ϊǰһ�������Ӧn-1,n-2,n-3,n-4,n-5��n-6֮��
 * Ҫ�뵽�����������n�����ӵ�ÿ���������ֵĴ���
 */
public class PrintProbability {
	public static void main(String[] args) {
		printProbability(2);
	}

	private static void printProbability(int num) {
		if(num<1)
			return;
		int gMaxValue=6;
		int[][] probabilities=new int[2][gMaxValue*num+1];		//����2�����������
		int flag=0;  // ��ǵ�ǰҪʹ�õ��ǵ�0�����黹�ǵ�1������
		
		// ���׳�һ������ʱ���ֵĸ������
		for(int i=1;i<=gMaxValue;i++){
			probabilities[flag][i]=1;	//��0����ǰ6��ȫ����ֵΪ1
		}
		// �׳���������
		for(int k=2;k<=num;k++){
			// ����׳���k�����ӣ���ô��Ϊ[0, k-1]�ĳ��ִ���Ϊ0
			for(int i=0;i<k;i++){ 
			    probabilities[1-flag][i]=0; 	//��0��ֵ���ڶ�������ǰk��ֵ
			   } 
			// �׳�k�����ӣ����к͵Ŀ���
			for(int i=k;i<=gMaxValue*k;i++){ 
			    probabilities[1-flag][i]=0; 	//��0��ֵ���ڶ��������k��ֵ
			    // ÿ�����ӵĳ��ֵ����п��ܵĵ���
			    for(int j=1;j<=i&&j<=gMaxValue;j++)   
			    	// ͳ�Ƴ���Ϊi�ĵ������ֵĴ����������������ڶ�������ĵ�n������ֵΪ0����ĺ�n-6���ۼӺ�
			    	probabilities[1-flag][i]+=probabilities[flag][i-j]; //
		}
			 flag=1-flag;		//ѭ��һ�ξ͸ı�һ����������֮���˳��
	}
		
		double total=Math.pow(gMaxValue, num);		//�ܵ����и���
		for(int i=num;i<=gMaxValue*num;i++){ 		//���ÿ��ɫ�ӵĸ���
			   double ratio=(double)probabilities[flag][i]/total; //����ֵ����ʱflagΪ1
			   System.out.print(i+" "); 
			   System.out.println(ratio); 
	}
  }
}
