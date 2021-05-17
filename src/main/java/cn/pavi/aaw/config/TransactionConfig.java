package cn.pavi.aaw.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Description: 数据库事务管理配置类
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
@Configuration
@MapperScan(basePackages = "cn.pavi.aaw.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class TransactionConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionConfig.class);

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "custom.datasource")
    public DataSource dataSource() {
        LOGGER.info("load dataSource start");
        return new DruidDataSource();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        LOGGER.info("load SqlSessionFactoryBean start");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));
        return factoryBean;
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        LOGGER.info("load sqlSessionTemplate start");
        return new SqlSessionTemplate(factory);
    }

    @Bean(name = "trans")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        LOGGER.info("load dataSourceTransactionManager start");
        return new DataSourceTransactionManager(dataSource);
    }


}
