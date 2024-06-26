import java.util.*;

public class L31Dynamic1D{

    //
    public static int fibonacci1(int n){
        int[] dp= new int[n+1];
        dp[0]=0;
        if(n>=2){
            dp[1]=1;
        }
        for(int i=2; i<=n; i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
        //O(n) & O(n)
    }

    public static int fibonacci2(int n){
        int p1=0;
        int p2=1;
        if(n<=1){
            return n;
        }
        int c= p1+p2;
        for(int i=2; i<=n; i++){
            c=p1+p2;
            p1=p2;
            p2=c;
        }
        
        return c;
        //O(n) & O(1)
    }
    //

    //Q1 Method 1:
    public static int solve(Vector<Integer> cost, int n){
        if(n==0) return cost.get(0);
        if(n==1) return cost.get(1);
        return cost.get(n)+ Math.min(solve(cost, n-1), solve(cost, n-2));
    }

    public static int minCostClimbingStairs(Vector<Integer> cost){
        int n= cost.size();
        return Math.min(solve(cost, n-1), solve(cost, n-2));
    }
    //Recursion

    //Q1 Method 2:
    public static int solve2(Vector<Integer> cost, int n, int[] dp){
        if(n==0) return cost.get(0);
        if(n==1) return cost.get(1);
        if(dp[n]!=-1) return dp[n];
        dp[n]= cost.get(n)+ Math.min(solve2(cost, n-1, dp), solve2(cost, n-2, dp));
        return dp[n];
    }

    public static int minCostClimbingStairs2(Vector<Integer> cost){
        int n= cost.size();
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve2(cost, n-1, dp), solve2(cost, n-2, dp));
    }
    //O(n) & O(n)+O(n)

    //Q1 Method 3:
    public static int minCostClimbingStairs3(Vector<Integer> cost){
        int n= cost.size();
        int[] dp= new int[n+1];
        dp[0]= cost.get(0);
        dp[1]= cost.get(1);
        for(int i=2; i<n; i++){
            dp[i]= cost.get(i)+ Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    //O(n) & O(n)

    //Q1 Method 4:
    public static int minCostClimbingStairs4(Vector<Integer> cost){
        int n= cost.size();
        int p2= cost.get(0);
        int p1= cost.get(1);
        for(int i=2; i<n; i++){
            int c= cost.get(i)+ Math.min(p1, p2);
            p2= p1;
            p1= c;
        }
        return Math.min(p1,p2);
    }
    //O(n) & O(1)

    //Q2 Method 1:
    public static int solve1Q2(Vector<Integer> value, int x){
        if(x==0) return 0;
        if(x<0) return Integer.MAX_VALUE;
        int mini= Integer.MAX_VALUE;
        for(int i=0; i<value.size(); i++){
            int ans= solve1Q2(value, x-value.get(i));
            if(ans!=Integer.MAX_VALUE){
                mini= Math.min(mini, 1+ans);
            }
        }
        return mini;
    }
    public static int minCoins(Vector<Integer> value, int x){
        int res= solve1Q2(value, x);
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res;
        }
    }
    //

    //Q2 Method 2:
    public static int solve2Q2(Vector<Integer> value, int x, int[] dp){
        if(x==0) return 0;
        if(x<0) return Integer.MAX_VALUE;
        if(dp[x]!=-1) return dp[x];
        int mini= Integer.MAX_VALUE;
        for(int i=0; i<value.size(); i++){
            int ans= solve2Q2(value, x- value.get(i), dp);
            if(ans!= Integer.MAX_VALUE) mini= Math.min(mini, 1+ans);
        }
        dp[x]= mini;
        return mini;
    }
    public static int minCoins2(Vector<Integer> value, int x){
        int[] dp= new int[x+1];
        Arrays.fill(dp,-1);
        int ans= solve2Q2(value, x, dp);
        if(ans==Integer.MAX_VALUE) return -1;
        else{
            return ans;
        }
    }
    //

    //Q2 Method 3:
    public static int minCoins3(Vector<Integer> value, int x){
        int[] dp= new int[x+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0; i<=x; i++){
            for(int j=0; j<value.size(); j++){
                if(i- value.get(j)>=0 && dp[i-value.get(j)]!=Integer.MAX_VALUE){
                    dp[i]= Math.min(dp[i], 1+dp[i-value.get(j)]);
                }
            }
        }
        if(dp[x]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[x];
    }
    //

    //Q3 Method 1:
    public static int solve1Q3(Vector<Integer> nums,int n){
        if(n<0) return 0;
        if(n==0) return nums.get(0);
        int inc= solve1Q3(nums, n-2)+ nums.get(n);
        int exc= solve1Q3(nums, n-1);
        return Math.max(inc, exc);
    }
    public static int maxNonAdjSum(Vector<Integer> nums){
        int n= nums.size();
        return solve1Q3(nums, n-1);
    }
    //

    //Q3 Method 2:
    public static int solve2Q3(Vector<Integer> nums,int n, int[] dp){
        if(n<0) return 0;
        if(n==0) return nums.get(0);
        if(dp[n]!=-1) return dp[n];
        int inc= solve2Q3(nums, n-2, dp)+ nums.get(n);
        int exc= solve2Q3(nums, n-1, dp);
        dp[n]= Math.max(inc, exc);
        return dp[n];
    }
    public static int maxNonAdjSum2(Vector<Integer> nums){
        int n= nums.size();
        int[] dp= new int[n];
        Arrays.fill(dp, -1);
        return solve2Q3(nums, n-1, dp);
    }
    //

    //Q3 Method 3:
    public static int maxNonAdjSum3(Vector<Integer> nums){
        int n= nums.size();
        int[] dp= new int[n];
        Arrays.fill(dp, 0);
        dp[0]= nums.get(0);
        dp[1]= Math.max(nums.get(0), nums.get(1));
        for(int i=2; i<n; i++){
            int inc= dp[i-2]+ nums.get(i);
            int exc= dp[i-1];
            dp[i]= Math.max(inc, exc);
        }
        return dp[n-1];
    }
    //

    //Q3 Method 4:
    public static int maxNonAdjSum4(Vector<Integer> nums){
        int n= nums.size();
        int p2=0;
        int p1= nums.get(0);
        for(int i=1; i<n; i++){
            int inc= p2+nums.get(i);
            int exc= p1;
            int ans= Math.max(inc, exc);
            p2= p1;
            p1= ans;
        }
        return p1;
    }

    //Q4 Method 1:
    public static int solve1Q4(int n, int x, int y, int z){
        if(n==0) return 0;
        if(n<0) return Integer.MIN_VALUE;
        int a= 1+ solve1Q4(n-x, x, y, z);
        int b= 1+ solve1Q4(n-y, x, y, z);
        int c= 1+ solve1Q4(n-z, x, y, z);
        return Math.max(a, Math.max(b, c));
    }

    public static int cutrod1(int n, int x, int y, int z){
        int ans= solve1Q4(n,x,y,z);
        if(ans<0) return 0;
        return ans;
    }
    //

    //Q4 Method 2:
    public static int solve2Q4(int n, int x, int y, int z, int[] dp){
        if(n==0) return 0;
        if(n<0) return Integer.MIN_VALUE;
        if(dp[n]!=-1) return dp[n];
        int a= 1+ solve2Q4(n-x, x, y, z, dp);
        int b= 1+ solve2Q4(n-y, x, y, z, dp);
        int c= 1+ solve2Q4(n-z, x, y, z, dp);
        dp[n]= Math.max(a, Math.max(b, c));
        return dp[n];
    }

    public static int cutrod2(int n, int x, int y, int z){
        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
        int ans= solve2Q4(n,x,y,z,dp);
        if(ans<0){
            return 0;
        }
        else{
            return ans;
        }
    }
    //

    //Q4 Method 3:
    public static int cutrod3(int n, int x, int y, int z){
        int[] dp= new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]= 0;
        for(int i=1; i<=n; i++){
            if(i-x>=0) dp[i]= Math.max(dp[i], dp[i-x]+1);
            if(i-y>=0) dp[i]= Math.max(dp[i], dp[i-y]+1);
            if(i-z>=0) dp[i]= Math.max(dp[i], dp[i-z]+1);
        }
        if(dp[n]<0) return 0;
        else{
            return dp[n];
        }
    }
    //

    //Q5 Method 1:
    final static int mod= 1000000007;

    public static long disarrangements1(int n){
        if(n==1) return 0;
        if(n==2) return 1;
        return ((n-1)*(disarrangements1(n-1)%mod+disarrangements1(n-2)%mod)%mod);
    }
    //
    
    //Q5 Method 2:
    public static long solve2Q5(int n, long[] dp){
        if(n==1) return 0;
        if(n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n]= (((n-1)%mod) * ((solve2Q5(n-1, dp)%mod)+ solve2Q5(n-2, dp)%mod)%mod);
        return dp[n];
    }

    public static long disarrangements2(int n){
        long[] dp= new long[n+1];
        Arrays.fill(dp,-1);
        return solve2Q5(n, dp);
    }
    //

    //Q5 Method 3:
    public static long disarrangements3(int n){
        long[] dp= new long[n+1];
        dp[1]= 0;
        dp[2]= 1;
        for(int i=3; i<=n; i++){
            long a= dp[i-1]%mod;
            long b= dp[i-2]%mod;
            long s= (a+b)%mod;
            long ans= ((i-1)*s)%mod;
            dp[i]= ans;
        }
        return dp[n];
    }
    //

    //Q5 Method 4:
    public static long disarrangements4(int n){
        if(n==1) return 0;
        if(n==2) return 1;
        long p1= 0;
        long p2= 1;
        for(int i=3; i<=n; i++){
            long a= p2%mod;
            long b= p1%mod;
            long s= (a+b)%mod;
            long ans= ((i-1)*s)%mod;
            p1= p2;
            p2= ans;
        }
        return p2;
    }
    //

    //Q6 Method 1:
    public static int paintFence(int n, int k){
        if(n==1) return k;
        if(n==2) return k*k;
        return (paintFence(n-2, k)*(k-1)+paintFence(n-1, k)*(k-1));
    }

    //Q6 Method 3:
    public static int paintFence3(int n, int k){
        if(n==1) return k;
        if(n==2) return k*k;
        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
        dp[1]= k;
        dp[2]= k*k;
        for(int i=3; i<=n; i++){
            dp[i]= (dp[i-2]*(k-1))+(dp[i-1]*(k-1));
        }
        return dp[n];
    }
    //

    //Q6 Method 4:
    public static int paintFence4(int n, int k){
        if(n==1) return k;
        if(n==2) return k*k;
        int p2= k;
        int p1= k*k;
        for(int i=3; i<=n; i++){
            int ans= (p2*(k-1))+(p1*(k-1));
            p2= p1;
            p1= ans;
        }
        return p1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}