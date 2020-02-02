package com.arrays;

public class TappingRainWater {
	public int trap(int[] height) {

		if (height == null)
			return 0;

		if (height.length == 0 || height.length == 1 || height.length == 2)
			return 0;

		int result = 0;

		int[] left = new int[height.length];
		int[] right = new int[height.length];

		int currentleftmax = -1;
		int currentrightmax = -1;
		for (int i = 1; i < height.length; i++) {

			currentleftmax = Math.max(currentleftmax, height[i - 1]);
			left[i] = Math.max(currentleftmax, height[i - 1]);
		}

		for (int i = height.length - 2; i >= 0; i--) {

			currentrightmax = Math.max(currentrightmax, height[i + 1]);
			right[i] = Math.max(currentrightmax, height[i + 1]);
		}

		for (int i = 0; i < height.length; i++) {
			if ((Math.min(left[i], right[i]) - height[i]) > 0)
				result += Math.min(left[i], right[i]) - height[i];
		}

		return result;

	}
}
