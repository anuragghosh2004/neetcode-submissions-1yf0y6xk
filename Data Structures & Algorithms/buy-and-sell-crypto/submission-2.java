class Solution {
    public int maxProfit(int[] prices) {
 int l =0;int r =l+1;
 int profit=0; int mprofit=0;
 while(r<prices.length){
    if(prices[l]<prices[r]){
        // we are in profit 
        profit = prices[r]- prices[l];
        mprofit=Math.max(mprofit, profit);
      
    }else{
        l=r;
    }
    r++;
    
 }  return mprofit;
}
}
