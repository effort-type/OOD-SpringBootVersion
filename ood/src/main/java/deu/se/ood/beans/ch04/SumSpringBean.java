/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.beans.ch04;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author 정민수
 * 
 * Componet 어노테이션을 사용하여 정의한 SpringBean
 */
@Component // 개발자가 직접 작성한 어노테이션을 등록하기 위한 어노테이션
@Slf4j
public class SumSpringBean {
    
    @Getter
    @Setter
    private int n;
    
    @Getter
    private int result;    

    public SumSpringBean() {
        log.debug("The instance SumSpringBean created ...");
        result = 0;
    }
    
    public void calculate() {
        result = n * (n + 1) / 2;
    }
}
