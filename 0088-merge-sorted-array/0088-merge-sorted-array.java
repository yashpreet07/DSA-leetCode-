class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int [n + m];
        int i = 0; 
        for(;i < m;i++)
            temp[i] = nums1[i];
        for(int ele : nums2){
            temp[i] = ele;
            i++;
        }
        i = 0;
        int j = m;
        int k = 0;
        while(i < m && j < m + n){
            if(temp[i] >= temp[j]){
                nums1[k] = temp[j];
                j++;
            }
            else{
            nums1[k] = temp[i];
            i++;
            }
            k++;
        }
        while(i < m){
            nums1[k] = temp[i];
            i++;
            k++;
        }
        while(j < m + n){
            nums1[k] = temp[j];
            k++;
            j++;
        }
   }
}