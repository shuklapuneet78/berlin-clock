# Solution to the "The Berlin Clock"

About Berlin Clock : 5 Rows with light bulbs to indicate the time
 
1st Row: 01 Yellow Lamp for Seconds. ON if Seconds is Even, else OFF. (Eg: "Y" for 0,2,4,6 and "O" for 1,3,5,6 etc)
2nd Row: 04 Red Lamps for Hour of the day. Each Lamp represents 5 Hrs. 
3rd Row: 04 Red Lamps for Hour of the day. Each Lamp represents 1 Hr.
4th Row: 11 Yellow Lamps for Minutes. Each Lamp represents 5 min. Every Quarter is denoted by 3rd, 6th & 9th Lamp being RED.
5th Row: 04 Yellow Lamps for Minutes. Each Lamp represents 1 min.

## The brief

Bunch of acceptance tests for the Berlin Clock can be run to verify the same.
Also added a list of JUnits for further verifying the end conditions.  

## Some hints
Created using Gradle with Eclipse (Oxygen).

JBehave used to provide definition of done for the task (in this case).