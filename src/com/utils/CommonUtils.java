package com.utils;

import java.lang.reflect.Array;

public class CommonUtils {
	/*
	 * Return Trimmed array removing null value at end
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] squashArray(T[] arr, Class<?> c) {
		if (arr[0] == null)
			return (T[]) Array.newInstance(c, 0);

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null)
				count++;
		}

		T[] result = (T[]) Array.newInstance(c, count);

		for (int i = 0; i < count; i++) {
			result[i] = arr[i];
		}

		return result;
	}
}
