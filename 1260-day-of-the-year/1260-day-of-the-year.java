// Your Code Fully wrong Use data structures!!!
// class Solution {
//     boolean isLeapYear(int year)
//     {
//         if(year % 100 == 0)
//             if(year % 400 == 0)
//                 if(year % 4 == 0)
//                     return true;
//         return false;
//     }
//     public int dayOfYear(String date) {
//         int y = Integer.valueOf(date.substring(0,4));
//         int m = Integer.valueOf(date.substring(5,7));
//         int d = Integer.valueOf(date.substring(8));
//         int day = 0;
//         if(m == 1)
//         return d;
//         day = 31;
//             while(m > 1)
//             {
//                 if(m == 2 && isLeapYear(y))
//                 day += 29;
//                 else
//                 day += 28; 
//                 if(m % 2 != 0 && m != 2)
//                 day += 31;
//                 else
//                 day += 30;
//                 m--;
//             }
//        return day + d;
//     }
// }


class Solution {
    boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
        }
        return false;
    }

    public int dayOfYear(String date) {
        int y = Integer.valueOf(date.substring(0, 4));
        int m = Integer.valueOf(date.substring(5, 7));
        int d = Integer.valueOf(date.substring(8));

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(y)) {
            daysInMonth[1] = 29; // February has 29 days in a leap year
        }

        int dayOfYear = d;
        for (int i = 0; i < m - 1; i++) {
            dayOfYear += daysInMonth[i];
        }

        return dayOfYear;
    }
}