/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.beans.ch04;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author 정민수
 * 
 * 일반적으로 getter, setter를 사용해서 Bean을 정의하는 클래스
 * 
 */
@Slf4j
public class SumBean {    
    private int n;
    private int result;

    public SumBean() {
        log.debug("The instance SumBean created...");
        result = 0;
    }
    
    public void caculate() {
        result = n * (n + 1) / 2;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    

    
    
}
