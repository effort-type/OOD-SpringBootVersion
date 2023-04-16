/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.se.ood.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * property 파일 읽는 방법 2가지
 * 1. 메소드 만들어서 PropertiesFactoryBean 사용해서 읽는 방법 => OodApplication에 있ㅇ므
 * 2. PropertySource 어노테이션 사용해서 바로 읽는 방법
 * 
 * Propertysource 어노테이션을 통해 config.properties에서 읽은 파일에 해당하는 값을
 * @Value 어노테이션을 통해 EL표현식으로 읽어온 config.properties 안에 있는 값을 통해 인스턴수 변수의 값을 초기화한다.
 * 
 * @author 정민수
 */
@Controller
@Slf4j
@PropertySource("classpath:/config.properties")
public class Ch06Controller {
    
    @Value("${mysql.server.ip}")
    private String mysqlServerIp;
    @Value("${mysql.server.port}")
    private String mysqlServerPort;
    
    @GetMapping("/ch06/showtable1")
    public String showTable1(Model model) {
        model.addAttribute("mysql_server_ip", this.mysqlServerIp);
        model.addAttribute("mysql_server_port", this.mysqlServerPort);
        log.info("mysql_server.ip = {}, mysql_server.port = {}", this.mysqlServerIp, this.mysqlServerPort);
        return "ch06/showtable1/index";
    }
}
