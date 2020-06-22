//Attendance.java
/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
*/

class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(char c: s.toCharArray()) {
            if(c == 'A') {
                absent++;
                if(absent > 1) {
                    return false;
                }
                late = 0;
            }
            else if(c == 'L') {
                late++;
                if(late > 2) {
                    return false;
                }
            }
            else {
                late = 0;
            }
            //System.out.println(absent + " " + late);
        }
        return true;
    }
}
