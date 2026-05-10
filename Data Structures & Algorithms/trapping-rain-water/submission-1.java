class Solution {
    public int trap(int[] height) {
       int l =0;int r = height.length -1;
       int lmax=0; int rmax= 0;;
       int water = 0; int twater =0;

       while(l<=r){
if (lmax<rmax){
    
water =lmax-height[l];
if(water>0){twater+=water;}

lmax = Math.max(lmax,height[l]);
l++;
}
else{
    water=rmax-height[r];
    if(water>0){twater+=water;}

rmax = Math.max(rmax,height[r]);
r--;
}
       }
       return twater;
}
}