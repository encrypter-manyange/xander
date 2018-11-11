package com.example.demo.files;

import java.util.*;

public class second {

    public static String processor(ArrayList<process> mylist) {

        int aa, b, c, i, ii, iii, iiii;
        int no_Process, total_Burst_Time = 0;
        int totalwaitingTime = 0, totalturnaroundtime = 0;;
        int count = 0;
        double large = 0, averagewaitingTime = 0, averageturnaroundtime = 0;
        double num;

        no_Process = mylist.size();
        ArrayList<process> process = new ArrayList();
        for (i = 0; i < no_Process; i++) {
            process.add(new process(mylist.get(i).processName,mylist.get(i).arrivalTime,mylist.get(i).burstTime,mylist.get(i).priorityvalue));
        }
        for (ii = 0; ii < no_Process; ii++) {
            total_Burst_Time += process.get(ii).burstTime;
            process.get(ii).burstTime1 = process.get(ii).burstTime;
            process.get(ii).completion = 0;
        }
        while (count <= total_Burst_Time) {
            b = 0;
            large = 0;
            for (aa = 0; aa < no_Process; aa++) {
                if (process.get(aa).arrivalTime > count||process.get(aa).burstTime<=0) {
                    b++;
                }
            }

            if (b == no_Process) {
                count++;
                continue;
            }

            for (iii = 0; iii < no_Process; iii++) {
                if (process.get(iii).arrivalTime > count || process.get(iii).burstTime <= 0) {
                    continue;
                } else {

                    //      for(iiii=0;iiii<no_Process;iiii++)
                    //        {
                    if (process.get(iii).priorityvalue > large) {
                        large = process.get(iii).priorityvalue;
                    }
                }           //       }
            }
            for (int iiiii = 0; iiiii < no_Process; iiiii++) {
                if (large == process.get(iiiii).priorityvalue) {
                    process.get(iiiii).burstTime = process.get(iiiii).burstTime - 1;
                    count++;
                    System.out.println(" this one  "+process.get(iiiii).processName);
                    //   System.out.println(" count=  " + count);
                    if (process.get(iiiii).burstTime <= 0) {
                        process.get(iiiii).completion = count;
                        System.out.println(" this one  "+process.get(iiiii).processName+""+process.get(iiiii).completion);
                    }
                    //  process.get(iiiii).turnaroundtime=count-process.get(iiiii).arrivalTime;
                }
            }
        }
        //  }

        for (int tt = 0; tt < no_Process; tt++) {
            process.get(tt).waitingTime = process.get(tt).completion - process.get(tt).burstTime1 - process.get(tt).arrivalTime;
            System.out.println(" waiting time of " + process.get(tt).processName + " = " + process.get(tt).waitingTime);
            System.out.println(" completion time of " + process.get(tt).processName + " = " + process.get(tt).completion);
            process.get(tt).turnaroundtime = process.get(tt).completion - process.get(tt).arrivalTime;
            System.out.println(" turnaround time of " + process.get(tt).processName + " = " + process.get(tt).turnaroundtime);
        }

        for (int ttt = 0; ttt < no_Process; ttt++) {
            totalwaitingTime = +totalwaitingTime + process.get(ttt).waitingTime;
            //  System.out.println(" total waiting time = " + totalwaitingTime);
            totalturnaroundtime = totalturnaroundtime + process.get(ttt).turnaroundtime;
        }
        averagewaitingTime = totalwaitingTime / no_Process;
        averageturnaroundtime = totalturnaroundtime / no_Process;

        System.out.println("Average waiting time = " + averagewaitingTime);
        System.out.println("Average turnaround  time = " + averageturnaroundtime);
        return String.valueOf(mylist.size());

    }

    static class process {

        String processName;
        int arrivalTime;
        int burstTime;
        int burstTime1;
        int completion;
        int waitingTime;
        int startTime;
        double ratio;
        double num;
        int turnaroundtime;
        int priorityvalue;
        Scanner vinnu1 = new Scanner(System.in);

        public  process(String processName, int arrivalTime, int burstTime, int priorityvalue) {
            this.processName=processName;
            this.priorityvalue=priorityvalue;
            this.burstTime=burstTime;
            this.arrivalTime=arrivalTime;



        }
    }
}
