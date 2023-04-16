/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.se.ood.model.ch06;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *  HikariCP를 설정하기 위해서 datasource를 만들 수 있는 클래스
 * @author 정민수
 */
@Configuration
@PropertySource("classpath:/application.properties") // application.properties를 읽을 수 있도록 해주는 어노테이션
@Slf4j
public class HikariConfiguration {
    
    /**
     * config 관련된 내용을 HikariConfig 객체가 읽어옴
     * @return HikariConfig 객체
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }
    
    @Bean
    public DataSource dataSource() throws Exception {
        DataSource dataSource = (DataSource) new HikariDataSource(hikariConfig());
        log.debug("hikari dataSource = {}", dataSource.toString());
        return dataSource;
    }
}
