package Problem20;
/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 终止行号大于起始行号，终止列号大于起始列号，画图解决问题
 * 定义一个变量为遍历的圈数
 */
public class PrintMatrix {
	public static void main(String[] args) {
		int[][] array= {    {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(array[0].length);
		printMatixClockwisely(array);
	}
	
	//初始化循环函数
    public static void printMatixClockwisely(int[][] array) {    
        if(array==null)    
            return;    
        int CircleNum=0;    		//CircleNum表示打印的圈数
        int row = array.length;			//定义行数
        int column = array[0].length;
        while(column>CircleNum*2&&row>CircleNum*2) {    //前提条件为行列大于2
            printOneCircle(array,CircleNum,row,column);    
            CircleNum++;    
        }    
    }    
    //判断函数
    public static void printOneCircle(int[][] array, int CircleNum,int row,int column) {   
    	
    	// 从左到右打印一行
        for(int i=CircleNum; i<column-CircleNum; i++) {//column-CircleNum代表一行的在CircleNum圈时的个数
            System.out.print(array[CircleNum][i]+" ");    
        }    
        
        // 从上向下打印一列
        if(row-1>CircleNum*2) {    //判断是否满足列长度,,row-1代表行下标的数字
            for(int i=CircleNum+1; i<row-CircleNum-1; i++) {    //最后一行不完全输出
                System.out.print(array[i][column-1-CircleNum]+" ");    
            }    
        }
        
        // 在最低行从右向左打印一行
        if(column-1>CircleNum*2 && row-1>CircleNum*2) {    //注意判断语句
            for(int i=row-CircleNum-1; i>CircleNum; i--) {    //最后一列不完全输出
                System.out.print(array[row-CircleNum-1][i]+" ");    
            }    
        }
        
        // 第一列从下往上打印一列
        if(column-1>CircleNum*2 && row-1>CircleNum*2) {    //判断条件一样
            for(int i=row-CircleNum-1; i>CircleNum; i--) {    
                System.out.print(array[i][CircleNum]+" ");    
            }    
        }    
    }  

}
