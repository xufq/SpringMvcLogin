package com.xufq.common.utils;

import java.util.UUID;

public class UUIDUtil {

	/**
	 * 获得UUID
	 * @param replaceFlag true：替换中杠 false：不替换中杠
	 * @return
	 */
	public static String getUUID(boolean replaceFlag) {
		UUID uuid = UUID.randomUUID();
		if (replaceFlag) {
			return uuid.toString().replace("-", "");
		} else {
			return uuid.toString();
		}
	}
}
