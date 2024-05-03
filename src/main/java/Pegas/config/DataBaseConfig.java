package Pegas.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "db")
public record DataBaseConfig (String username, String password, String driver, String url, String hosts,
                              DataBaseConfig.PoolProperties pool, List<DataBaseConfig.PoolProperties> pools, Map<String, Object> properties){
        public static record PoolProperties(Integer size, Integer timeout){}
}
