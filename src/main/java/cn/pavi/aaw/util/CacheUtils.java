package cn.pavi.aaw.util;

import cn.pavi.aaw.config.SwitchConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 缓存工具类
 * @Author: JreamY
 * @Date: 2021/5/
 **/
public class CacheUtils {

    private CacheUtils() {
    }

    private final static CacheUtils instance;

    static {
        instance = new CacheUtils();
    }

    private Container container;

    {
        instance.container = new Container();
    }

    private volatile SwitchConfig switchConfig;


    public static void put(String key, Object value) {
        getCache().put(key, value);
    }

    public static Object get(String key) {
        return getCache().get(key);
    }


    private static AbstractCache getCache() {

        instance.initSwitchConfig();
        SwitchConfig switchConfig = BeanUtils.getBean(SwitchConfig.class);
        Boolean singleServer = switchConfig.getSingleServer();
        Boolean redisOpen = switchConfig.getRedisOpen();
        return singleServer && !redisOpen ?
                instance.container.stringObjectMapCache : instance.container.stringObjectRedisCache;
    }

    private void initSwitchConfig() {
        if (instance.switchConfig == null) {
            synchronized (this) {
                if (instance.switchConfig == null) {
                    instance.switchConfig = BeanUtils.getBean(SwitchConfig.class);
                }
            }
        }
    }

    class Container {

        public MapCache<String, Object> stringObjectMapCache;
        public RedisCache<String, Object> stringObjectRedisCache;

        {
            stringObjectMapCache = new MapCache<>(64);
            stringObjectRedisCache = new RedisCache<>();
        }

    }

    class RedisCache<K, V> extends AbstractCache<K, V> {

        @Override
        public void put(K key, V value) {
            // todo
        }

        @Override
        public V get(K key) {
            // todo
            return null;
        }
    }

    class MapCache<K, V> extends AbstractCache<K, V> {

        private Map<K, V> container;

        public MapCache(int capacity) {
            this(new HashMap<>(capacity << 1));
        }

        public MapCache(Map<K, V> container) {
            this.container = container;
        }

        @Override
        public void put(K key, V value) {
            this.container.put(key, value);
        }

        @Override
        public V get(K key) {
            return this.container.get(key);
        }
    }

    abstract class AbstractCache<K, V> {

        public abstract void put(K key, V value);

        public abstract V get(K key);
    }
}
