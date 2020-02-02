package com.arrays;

import java.util.Arrays;

public class MeetingRooms {
	public int minMeetingRooms(int[][] intervals) {
		
			if (intervals == null)
				return 0;
			int room = 0;

			int start[] = new int[intervals.length];
			int end[] = new int[intervals.length];

			for (int i = 0; i < intervals.length; i++) {

				start[i] = intervals[i][0];
				end[i] = intervals[i][1];

			}

			Arrays.sort(start);
			Arrays.sort(end);

			int startptr = 0;
			int endptr = 0;

			while (startptr < end.length) {
				if (start[startptr] >= end[endptr]){
					room--;
	                endptr++;
			}
	            startptr++;
			    room++;
	        }
			

			return room;

		
	        
	    }
	}

