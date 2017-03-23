package nowcode;

import java.util.HashSet;
import java.util.Set;
/**
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，
 * 已知他的位置以及商家的位置，但是由于城市道路交通的原因，他只能在左右中选择一个方向，
 * 在上下中选择一个方向，现在问他有多少种方案到达商家地址。
 * 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，
 * 0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 * 测试样例：
 * [[0,1,0],[2,0,0]],2,3
 * 返回：2
 * @author Administrator
 *
 */
public class Main10 {
		
    public int countPath(int[][] map, int n, int m) {
    	int i,j;
    	int x1 =0,x2=0,y1=0,y2=0;
    	for(i=0;i<n;i++){
    		for(j=0;j<m;j++){
    			if(map[i][j]==1){
    				x1 = i;y1 = j;
    			}
    			if(map[i][j]==2){
    				x2 = i;y2 = j;
    			}
    		}
    	}
    	if(x1==x2&&y1==y2){
    		return 1;
    	}
    	//x1,y1用来保存行下标较小者
    	if(x1 > x2){
    		int tmp = x1;
    		x1 = x2;
    		x2 = tmp;
    		tmp = y1;
    		y1 = y2;
    		y2 = tmp;
    	}
    	int[][] dp = new int[n][m];
    	dp[x1][y1] = 1;
    	//如果是在主对角线上
    	if(y1 < y2){
    		for(i = x1+1;i<=x2;i++){
    			dp[i][y1] = map[i][y1]==-1?0:dp[i-1][y1];
    		}
    		for(j=y1+1;j<=y2;j++){
    			dp[x1][j] = map[x1][j]==-1?0:dp[x1][j-1];
    		}
    		for(i=x1+1;i<=x2;i++){
    			for(j=y1+1;j<=y2;j++){
    				dp[i][j] = map[i][j]==-1? 0:dp[i-1][j]+dp[i][j-1];
    			}
    		}
    	}else{
    		for(i = x1+1;i<=x2;i++){
    			dp[i][y1] = map[i][y1]==-1?0:dp[i-1][y1];
    		}
    		for(j = y1-1;j>=y2;j--){
    			dp[x1][j] = map[x1][j]==-1?0:dp[x1][j+1];
    		}
    		for(i = x1+1;i<=x2;i++){
    			for(j = y1-i;j>=y2;j--){
    				dp[i][j] = map[i][j]==-1?0:dp[i-1][j]+dp[i][j+1];
    			}
    		}
    	}
    	return dp[x2][y2];
    }
    
	public static void main(String[] args) {
	}

}
