/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package deu.se.ood.controller;

import deu.se.ood.beans.ch04.SumSpringBean;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 정민수
 */
@Controller
@Slf4j
public class Ch04Controller {
    
    /**
     * @Autowired : 자동으로 생성된 객체들이 연결이 되도록 해주는 어노테이션
     */
    
    @Autowired
    private ServletContext ctx;
    
    @Autowired
    private SumSpringBean sumBean;
    
    /**
     *  Model은 사용하면 제어에서 계산을 수행한 후에 다시 View쪽으로 값을 보내줄 때 사용하는 기술요소
     * @param m
     * @return /ch04/beans/index
     */     
    @GetMapping("/ch04/beans")
    public String ch04Beans(Model m) {
        log.debug("Real path of \"/\" = {}", ctx.getRealPath("/")); // 실제 애플리케이션이 돌아가고 있는 경로를 알려줌
        m.addAttribute("ctx_path", ctx.getRealPath("/"));
        
        return "/ch04/beans/index";
    }
    
    /**
     * View 내에 계산과 같은 로직이 포함되어 있음
     * 
     * @param request
     * @return ch04/beans/show_sum1 
     */
    @PostMapping("/ch04/beans/show_sum1")
    public String ch04BeansShowSum(HttpServletRequest request) {
        // log를 안 찍을 거면 매개변수 request는 지워도 됨.
        log.debug("show_sum: n = {}", request.getParameter("n"));
        
        return "ch04/beans/show_sum1";
    }
    
    
    /**
     * View 내에 있는 계산 로직을 분리하여 Controller에서 로직을 처리하도록 구현
     * @RequestParam 어노테이션이 붙으면 변수에 request.getParameter 한 결과가 바로 들어간다.
     * @param n
     * @param model
     * @return ch04/beans/show_sum2
     */
    @PostMapping("/ch04/beans/show_sum2")
    public String ch04BeansShowSum2(@RequestParam String n, Model model) {
        log.debug("show_sum2: n = {}", n);
        sumBean.setN(Integer.parseInt(n));
        sumBean.calculate();
        
        model.addAttribute("result", sumBean.getResult());
        
        return "ch04/beans/show_sum2";
    }
    
    @GetMapping("/ch04/include")
    public String ch04IncludeTest2() {
        return "ch04/include/index";
    }
}
