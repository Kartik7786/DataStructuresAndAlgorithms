package com.strings;

import java.util.Arrays;

public class ReorderLogs {

	public String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, (log1, log2) -> {

			String[] split1 = ((String) log1).split(" ", 2);
			String[] split2 = ((String) log2).split(" ", 2);
			char[] c1 = split1[1].toCharArray();
			char[] c2 = split2[1].toCharArray();

			boolean isdigit1 = Character.isDigit(c1[0]) ? true : false;
			boolean isdigit2 = Character.isDigit(c2[0]) ? true : false;

			if (isdigit1 && isdigit2)
				return 0;
			else {

				if (isdigit1 && !isdigit2)
					return 1;
				if (!isdigit1 && isdigit2)
					return -1;

				if (!isdigit1 && !isdigit2) {
					int x = split1[1].compareTo(split2[1]) == 0 ? split1[0].compareTo(split2[0])
							: split1[1].compareTo(split2[1]);
					return x;
				}

			}
			return 0;
		});

		return logs;

	}

}
/*
 * Input: logs =
 * ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output:
 * ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
