/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author admin
 */
@Controller
@Slf4j // 9장에 나오는 로깅 관련 롬복 어노테이션
public class Ch03Controller {
    
    @GetMapping("/ch03/simple_page_directive")
    public String ch03SimplePageDirective() {
        log.debug("/ch03/simple_page_directive called...");
        return "ch03/simple_page/index"; // ch03/simple_page안에 index.jsp를 반환
    }
    
    @GetMapping("/ch03/error_page/index1")
    public String ch03Error1() {
        return "ch03/error_page/index1";
    }
    
    @GetMapping("/ch03/error_page/index2")
    public String ch03Error2() {
        return "ch03/error_page/index2";
    }
    
    @GetMapping("/ch03/include")
    public String ch03Include() {
        log.debug("/ch03/include Called..");
        return "ch03/include/index";
    }
}
