/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.se.ood.controller;

import deu.se.ood.model.ch06.AddrBookManager;
import deu.se.ood.model.ch06.AddrBookRow;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @Autowired
    private Environment env; // application.propertys의 값을 읽어오게 해주는 객체
    
    @GetMapping("/ch06/showtable1")
    public String showTable1(Model model) {
        model.addAttribute("mysql_server_ip", this.mysqlServerIp);
        model.addAttribute("mysql_server_port", this.mysqlServerPort);
        log.info("mysql_server.ip = {}, mysql_server.port = {}", this.mysqlServerIp, this.mysqlServerPort);
        return "ch06/showtable1/index";
    }
    
    @GetMapping("/ch06/showtable2")
    public String showTable2(Model model) {
        log.debug("showtable2: server = {}, port = {}", mysqlServerIp, mysqlServerPort);
        
        model.addAttribute("mysql_server_ip", mysqlServerIp);
        model.addAttribute("mysql_server_port", mysqlServerPort);
        return "ch06/showtable2/index";
    }
    
    @GetMapping("/ch06/inserttable")
    public String insertTable(Model model) {
        // env를 사용해서 property 값을 가지고 올 수 있는 것 기억하기
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");
        log.debug("ip = {}, port = {}", this.mysqlServerIp, this.mysqlServerPort);
        
        AddrBookManager manager = new AddrBookManager(mysqlServerIp, mysqlServerPort, userName, password, jdbcDriver);
        List<AddrBookRow> dataRows = manager.getAllRows();
        model.addAttribute("dataRows", dataRows);
        
        return "ch06/inserttable/index";
    }
    
    @GetMapping("/ch06/insert_addrbook")
    public String insertAddressBook() {
        return "ch06/inserttable/insert_addrbook";
    }
    
    @PostMapping("/ch06/insert.do")
    public String insertAddressBook(@RequestParam String email, @RequestParam String name, @RequestParam String phone, Model model) {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");
        
        AddrBookManager manager = new AddrBookManager(mysqlServerIp, mysqlServerPort, userName, password, jdbcDriver);
        manager.addRow(email, name, phone);
        
        List<AddrBookRow> dataRows = manager.getAllRows();
        model.addAttribute("dataRows", dataRows);
        
        
        /**
         * redirect는 페이지를 반환하는 것이 아니라 URL 주소를 반환한다.
         * 여기서 /ch06/inserttable은 페이지가 아니라 바로 위에 있는 메소드에서 반환하는 페이지인
         * ch06/inserttable/insert_addrbook.jsp를 뜻한다.
         * 사용법 중요하니까 반드시 기억하기
         * 형태 : redirect:/URL 주소         * 
         */
        
        return "redirect:/ch06/inserttable";  // 사용법 중요함!!
    }
}
