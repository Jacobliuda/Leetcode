package ComprehensiveTest;
import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/28-16:05
 * @description
 */
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.
public class Main {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc=new Scanner(System.in);

        // m 是生命总数 n 是木板总数 k 是缺失的木板数量
        int m=sc.nextInt();
        int n=sc.nextInt();
        int k=sc.nextInt();

        // num 保存木板是否缺失
        int[] num=new int[100];
        for(int ii=1;ii<=k;ii++){
            int p=sc.nextInt();
            num[p]=1;
        }
        long result=0;

        // dp[i][j] 表示跳到第i快木板还有j条生命的方法数量
        long[][] dp=new long[100][100];
        dp[0][m]=1;

        for(int i=1;i<=n+1;i++){
            for(int j=1;j<=m;j++){
                // 如果该块木板不缺失
                if(num[i]!=1){
                    // 上一次的三种跳跃情况
                    if(i>=3)dp[i][j]+=dp[i-3][j];
                    if(i>=2)dp[i][j]+=dp[i-2][j];
                    if(i>=1)dp[i][j]+=dp[i-1][j];
                }else{
                    // 如果该块木板缺失
                    if(j==1)continue; // 已经没有生命了，不需要再继续 （dp数组默认为0,默认就代表0个方法）
                    if(i>=3)dp[i][j-1]+=dp[i-3][j]; // j-1是指这个位置会失去一条命,但是j-1>0,接下来还能继续。
                    if(i>=2)dp[i][j-1]+=dp[i-2][j];
                    if(i>=1)dp[i][j-1]+=dp[i-1][j];
                }
            }
            if(i==n+1){
                for(int j=1;j<=m;j++){
                    result+=dp[i][j];
                }
            }
        }
        System.out.println(result);
    }
}
