package cn.pavi.aaw.util;

/**
 * @Description: 随机数生成工具类
 * @Author: JreamY
 * @Date: 2021/4/25
 **/
public class RandUtils {

    private final static int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    private final static char[] symbols = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private final static int symbolLen = 36;

    private final static int numLen = 10;

    private RandUtils() {

    }

    public static String randStr(int len) {
        return randStr(len, false);
    }

    public static String randStr(int len, boolean allNums) {

        long timestamp = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();
        for (int idx = 1; idx <= len; idx++) {
            builder.append(symbols[(int) (timestamp / idx % (allNums ? numLen : symbolLen))]);
        }
        return builder.toString();
    }

}
