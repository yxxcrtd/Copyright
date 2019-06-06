package cn.digitalpublishing.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class PinyinUtils {

	public static String getPinyinFirstChar(String str) {
		if (str == null) {
			return str;
		}
		StringBuilder buff = new StringBuilder();
		try {
			HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
			outputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
			char[] strArr = str.toCharArray();
			for (char c : strArr) {
				String[] arr = PinyinHelper.toHanyuPinyinStringArray(c, outputFormat);
				if (arr == null) {
					buff.append(c);
				} else {
					buff.append(arr[0].toCharArray()[0]);
				}
			}
		} catch (Exception e) {
		}
		return buff.toString().toUpperCase();
	}

}