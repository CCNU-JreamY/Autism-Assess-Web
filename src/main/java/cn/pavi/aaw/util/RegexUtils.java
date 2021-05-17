package cn.pavi.aaw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * @Description: 正则校验工具类
 * @Author: JreamY
 * @Date: 2021/5/1
 **/
public class RegexUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegexUtils.class);

    private final static String numberRegex = "^[0-9]*$";

    private final static Pattern numberPattern = Pattern.compile(numberRegex);

    private RegexUtils() {

    }

    /**
     * 纯数字校验
     *
     * @param str
     * @return
     */
    public static boolean allNumber(String str) {
        return numberPattern.matcher(str).find();
    }

    /**
     * 自定义正则校验
     *
     * @param patternStr
     * @param originStr
     * @return
     */
    public static boolean customPattern(String patternStr, String originStr) {
        return Pattern.matches(patternStr, originStr);
    }
}
