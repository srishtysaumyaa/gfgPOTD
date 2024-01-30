class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int dp[][][] = new int[n1][n2][n3];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return solve(A,B,C,0,0,0,dp);
        
    }
    public static int solve(String A,String B,String C,int i,int j,int k,int dp[][][]){
        if(i == A.length() || j == B.length() || k == C.length()){
            return 0;
        }
        if(A.charAt(i) == B.charAt(j) && B.charAt(j) == C.charAt(k) && A.charAt(i) == C.charAt(k)){
            return dp[i][j][k] = 1 + solve(A,B,C,i+1,j+1,k+1,dp); 
        }
        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        int l = solve(A,B,C,i+1,j,k,dp);
        int r = solve(A,B,C,i,j+1,k,dp);
        int s = solve(A,B,C,i,j,k+1,dp);
        ArrayList<Integer> al = new ArrayList<>();
        al.add(l);al.add(r);al.add(s);
        Collections.sort(al);
        return dp[i][j][k] = al.get(al.size()-1);
    }
}
