package cn.pavi.aaw.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 开关配置类
 * @Author: JreamY
 * @Date: 2021/5/18
 **/
@Component
@ConfigurationProperties(prefix = "custom.switch")
@Getter
@Setter
public class SwitchConfig {

    /**
     * 生产服务器是否单台
     */
    private Boolean singleServer;

    /**
     * 生产是否使用redis
     */
    private Boolean redisOpen;
}
