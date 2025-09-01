class Solution {
    public int maximum69Number (int num) {

     StringBuilder number = new StringBuilder(String.valueOf(num));
     int n = number.length();
     for(int i = 0;i < n;i++){
            if(number.charAt(i) == '6'){
                number.setCharAt(i,'9');
                break;
            }
     }   
     return Integer.valueOf(number.toString());
    }
}