package cn.pavi.aaw.util;

import cn.pavi.aaw.config.OkHttpInterceptor;
import okhttp3.*;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Http请求工具类
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
public class HttpUtils {

    private final static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final static int TIME_OUT = 5;

    private final static List<Interceptor> INTERCEPTORS = Arrays.asList(new OkHttpInterceptor());

    private final static OkHttpClient CLIENT = getHttpClient();

    private HttpUtils() {
    }

    /**
     * POST，不重试
     *
     * @param url
     * @param paramJson
     * @return
     */
    public static Map doHttpPostReturnAsMap(String url, String paramJson) {
        return doHttpPostReturnAsMap(url, paramJson, 1);
    }

    /**
     * POST，支持重试
     *
     * @param url
     * @param paramJson
     * @param failRetry 失败重试次数，不重试设置为1
     */
    public static Map doHttpPostReturnAsMap(String url, String paramJson, int failRetry) {

        Request request = buildRequest(url, paramJson);

        Response response = null;
        Boolean willReturn = false;
        while (true) {
            try {
                response = CLIENT.newCall(request).execute();
                if (response.isSuccessful()) {
                    willReturn = true;
                    return JSONUtils.jsonParse(response.body().string(), Map.class);
                }
                if (--failRetry == 0) {
                    willReturn = true;
                    return null;
                }
            } catch (Exception e) {
                LogUtils.error(HttpUtils.class, "doHttpPost error: {}", e);
                if (--failRetry == 0) {
                    willReturn = true;
                    return null;
                }
            } finally {
                if (willReturn && response != null) {
                    response.body().close();
                }
            }
        }
    }

    private static OkHttpClient getHttpClient() {
        return getHttpClient(TIME_OUT, INTERCEPTORS);
    }

    private static OkHttpClient getHttpClient(int timeout, List<Interceptor> interceptors) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .build();
        if (!CollectionUtils.isEmpty(interceptors)) {
            for (Interceptor interceptor : interceptors) {
                client = client.newBuilder().addInterceptor(interceptor).build();
            }
        }
        return client;
    }

    private static Request buildRequest(String url, String paramJson) {

        RequestBody body = RequestBody.create(JSON, paramJson);
        return new Request.Builder()
                .url(url)
                .post(body)
                .build();
    }
}
