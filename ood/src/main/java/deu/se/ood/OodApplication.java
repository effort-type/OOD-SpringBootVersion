package deu.se.ood;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@Slf4j
public class OodApplication {

    public static void main(String[] args) {
        SpringApplication.run(OodApplication.class, args);
    }
    
    /**
     * 6장 ShowTable 실습에 필요한 빈. 8장의 웹 초기화 개념 대체 (web.xml 사용 안함)
     * 
     * PropertiesFactoryBean은 스프링부트에서 미리 만들어 둔 객체임
     * 
     * @return PropertiesFactoryBean 객체 반환
     *
     */
    @Bean
    public PropertiesFactoryBean configProperties() {
        log.debug("configProperties() called ...");
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("/config.properties")); // 필요한 환경 설정 파일을 config.properties에서 읽어드림
        return bean;
    }
}
