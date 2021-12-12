package com.basic.greedy.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

class Meeting {
    int start;
    int end;
    int pos;
    
    public Meeting(int _start, int _end, int _pos) {
        start = _start;
        end = _end;
        pos = _pos;
    }
}

class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
        if(o1.end < o2.end) {
            return -1;
        }
        else if(o1.end > o2.end) {
            return 1;
        }
        else if(o1.pos < o2.pos) {
            return -1;
        }
        return 1;
    }
}

public class NmeetingsInOneRoom 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    // https://www.youtube.com/watch?v=II6ziNnub1Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=46
    // Take u forward
    
    // T.C : O(n + nlogn + n)   ~ O(logn)
    // SC : O(n)
    public static int maxMeetings(int start[], int end[], int n)
    {
            List<Meeting> ls = new ArrayList<>();
            for(int i =0; i<n; i++) 
                ls.add(new Meeting(start[i], end[i], i+1));
                
            MeetingComparator mc = new MeetingComparator();
            Collections.sort(ls, mc);
            
            int limit = ls.get(0).end;
            int count  = 1;
            
            for(int i = 1;i<start.length;i++) {
                if(ls.get(i).start > limit) {
                    limit = ls.get(i).end; 
                    count++;
                }
            }
        return count;    
    }
}
