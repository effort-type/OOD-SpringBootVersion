/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.bean.ch04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author admin
 */
public class SumBean {
    private Logger log = LoggerFactory.getLogger(getClass());
    private int n;
    private int result;

    public SumBean() {
        log.debug("The instance SumBean created...");
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
