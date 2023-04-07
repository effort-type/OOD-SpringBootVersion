/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.beans.ch04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author 정민수
 * 
 * 일반적으로 getter, setter를 사용해서 Bean을 정의하는 클래스
 * 
 */
public class SumBean {
    private Logger log = LoggerFactory.getLogger(getClass());
    private int n;
    private int result;

    public SumBean() {
        log.debug("The instance SumBean created...");
        result = 0;
    }
    
    public void caculate() {
        result = n * (n + 5) / 2;
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
