package Queen8;
/*
 * 八个皇后放在8*8棋盘上，没有两个皇后是在同一行、同一列或者同一对角上。
 */
public class Queen8 {

    public static void main(String[] args) {
        Empress a=new Empress();
        a.find(0);
        System.out.println("八皇后问题共有："+a.count+"种可能");
    }
}

class Empress{			//重新定义一个类
    public int[][] array=new int[8][8];    //棋盘，放皇后,元素赋值1代表存在一个皇后，0表示无。
    public  int count=0;     //存储方案结果

    public void find(int row){    //寻找皇后节点
        if(row>7){    //八皇后解  
        	count++;
            print();
            return;
        }
        for(int m=0;m<8;m++){       //深度优先,递归算法(循环递归)
            if(rule(array,row,m)){
            	array[row][m]=1;
                find(row+1);			//递归循环下一位，，count累加
                array[row][m]=0;		//退回
                }
        }   
    }
    
    public   boolean rule(int[][] array,int k,int j){    //判断节点是否合适
        for(int i=0;i<8;i++){       //行列冲突
             if(array[i][j]==1)
                return false;
        }
        for(int i=k-1,m=j-1;i>=0&&m>=0;i--,m--){    //左对角线(两个变量i,m的变化)
            if(array[i][m]==1)
                return false;
        }
        for(int i=k-1,m=j+1;i>=0&&m<=7;i--,m++){    //右对角线
            if(array[i][m]==1)
                return false;
        }
        return true;
    }


    public void print(){      //打印方法结果
        System.out.print("方案"+count+":");
        for(int i=0;i<8;i++){
            for(int m=0;m<8;m++){
                if(array[i][m]==1){  					//加入数组有1位则证明是对的，打印输出
                    System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+m+"列\t");

                }
            }
        }
        System.out.println();		//隔一行
    }
}
