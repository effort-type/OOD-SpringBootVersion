/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.controller;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author 정민수
 */
@Controller
@Slf4j
public class Ch05Controller {
    
    @GetMapping("/ch05/eltest")
    public String elTest() {
        return "/ch05/eltest/index";
    }
    
    @GetMapping("/ch05/elimplicitobject")
    public String elimplicitObject() {
        return "ch05/elimplicitobject/index";
    }
    
    /**
     * @param number 1..3
     * @return 
     */
    @GetMapping("/ch05/simpletagtest/{number}")
    public String simpleTagTest(@PathVariable Integer number) {
        return String.format("ch05/simpletagtest/index%d", number);
    }
    
    /**
     * 
     * @param number 1 또는 2만 허용 (programming by contract에 의해 별도의 유효성 테스트는 하지 않음)
     * @return 
     */
    @GetMapping({"/ch05/tagfiletest", "/ch05/tagfiletest/{number}"})
    public String tagFileTest(@PathVariable Optional<Integer> number) {
        String execUrl = "ch05/tagfiletest/index";
        if (number.isPresent()) { // number 값이 있으면 그대로 사용, 없으면 디폴트로 설정되어 있는 execUrl 값 사용
            execUrl += String.format("%d", number.get());
        }
        log.debug("execUrl = {}", execUrl);
        return execUrl;
    }    
}
