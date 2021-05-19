package cn.pavi.aaw.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: nacos配置中心配置获取类
 * @Author: JreamY
 * @Date: 2021/5/19
 **/
@Configuration
@NacosPropertySource(dataId = "testConfig.properties", groupId = "testgroup", autoRefreshed = true)
@Getter
public class NacosConfig {

    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

    @NacosValue(value = "${age:0}", autoRefreshed = true)
    private Integer age;

    @NacosValue(value = "${gender}", autoRefreshed = true)
    private String gender;

}
