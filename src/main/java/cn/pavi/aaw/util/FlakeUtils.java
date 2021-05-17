/*
 * Copyright (C) 2011-2019 ShenZhen iBOXCHAIN Information Technology Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of iBOXCHAIN Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with iBOXCHAIN inc.
 */
package cn.pavi.aaw.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 生成唯一订单号
 *
 * @AUTHOR Jream.Y
 * @CREATE 2019-07-07
 */
public class FlakeUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(FlakeUtils.class);

    /**
     * 起始时间戳， 2010/01/01 10:00:00
     **/
    private final static long START_STAMP = 1262311200000L;
    /**
     * 随机序列号，保证每次都是自增
     **/
    private static int sequence = 0;
    /**
     * 最后生成订单号的时间戳
     **/
    private static long lastStamp = -1L;
    /**
     * 服务器ip最后一段，标识不同服务器
     **/
    private static long ipSignal = -1L;
    private static boolean isRealIp = false;

    private final static long SEQUENCE_BIT = 2;
    private final static long IP_BIT = 8;
    private final static int MAX_SEQUENCE_NUM = (1 << SEQUENCE_BIT) - 1;

    private final static int RAND_ARRAY[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 20};

    private final static long TIMESTAMP_OFFSET_LEFT = SEQUENCE_BIT + IP_BIT;
    private final static long IP_OFFSET_LEFT = SEQUENCE_BIT;

    private FlakeUtils() {
    }

    /**
     * 生成唯一订单号
     *
     * @AUTHOR Jream.Y
     */
    public synchronized static String nextWorkerId() {

        initIpSignal();
        StringBuilder orderSerial = new StringBuilder();
        // 时间戳位
        long curStamp = System.currentTimeMillis();
        if (curStamp < lastStamp) {
            /* 回退服务器时间会导致该问题，每次需重刷当前时间 */
            lastStamp = curStamp;
        }
        // 毫秒级并发
        if (curStamp == lastStamp) {
            int randNum = randNum(sequence);
            sequence = (sequence + randNum);
            if (sequence >= MAX_SEQUENCE_NUM) {
                curStamp = nextMillis(curStamp);
            }
        } else {
            sequence = 0;
        }
        lastStamp = curStamp;

        orderSerial.append(
                (curStamp - START_STAMP) << TIMESTAMP_OFFSET_LEFT
                        | ipSignal << IP_OFFSET_LEFT
                        | sequence);
        return orderSerial.toString();
    }

    /**
     * 服务器ip初始化，取最后一段
     */
    private static void initIpSignal() {

        if (isRealIp) {
            return;
        }
        String hostIp = getHostIp();
        if (hostIp == null) {
            ipSignal = randNum(sequence);
            return;
        }
        isRealIp = true;
        ipSignal = Long.valueOf(hostIp.split("\\.")[3]);
    }

    private static long nextMillis(long curStamp) {
        do {
            long tempMillis = System.currentTimeMillis();
            if (tempMillis > curStamp) {
                return tempMillis;
            }
        } while (true);
    }

    /**
     * snowflake以自增方式，这里随机数自增大概率减少同一服务器时针回拨导致异常情况
     */
    private static int randNum(int curSequence) {
        return RAND_ARRAY[curSequence % 10];
    }

    public static String getHostIp() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.error("获取本机ip异常", e);
        }
        return ip;
    }

}
