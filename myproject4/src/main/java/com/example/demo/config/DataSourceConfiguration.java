package com.example.demo.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.example.demo.strategy.ZteDatabaseShardingAlgorithm;
import com.example.demo.strategy.ZteTableShardingAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "dataSource0")
    @ConfigurationProperties(prefix = "spring.datasource.test0")
    public DataSource dataSource0() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSourceRule dataSourceRule(@Qualifier("dataSource0") DataSource dataSource0,
                                         @Qualifier("dataSource1") DataSource dataSource1) {
        Map<String, DataSource> dataSourceMap = new HashMap<>(); //设置分库映射
        dataSourceMap.put("dataSource0", dataSource0);
        dataSourceMap.put("dataSource1", dataSource1);
        return new DataSourceRule(dataSourceMap, "dataSource0"); //设置默认库，两个库以上时必须设置默认库。默认库的数据源名称必须是dataSourceMap的key之一
    }


    @Bean
    public ShardingRule shardingRule(DataSourceRule dataSourceRule) {
        //具体分库分表策略
        TableRule orderTableRule = TableRule.builder("t_order")
                .actualTables(Arrays.asList("t_order_0", "t_order_1"))
                .dataSourceRule(dataSourceRule)
                .build();

        //绑定表策略，在查询时会使用主表策略计算路由的数据源，因此需要约定绑定表策略的表的规则需要一致，可以一定程度提高效率
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(orderTableRule))
                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ZteDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ZteTableShardingAlgorithm())).build();

        return shardingRule;
    }

    @Bean(name = "dataSource")
    public DataSource shardingDataSource(ShardingRule shardingRule) throws SQLException {
        return ShardingDataSourceFactory.createDataSource(shardingRule);
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }
}
