/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.model.ch06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author 정민수
 */
@Slf4j
public class AddrBookManager {
    
    private String mysqlServerIp;
    private String mysqlServerPort;
    private String userName;
    private String password;
    private String jdbcDriver;
    
    public AddrBookManager() {
        log.debug("AddrBookManager() : mysqlServerIp = {}, jdbcDriver = {}", mysqlServerIp, jdbcDriver);
    }
    
    public AddrBookManager(String mysqlServerIp, String mysqlServerPort, String userName, String password, String jdbcDriver) {
        this.mysqlServerIp = mysqlServerIp;
        this.mysqlServerPort = mysqlServerPort;
        this.userName = userName;
        this.password = password;
        this.jdbcDriver = jdbcDriver;
        log.debug("AddrBookManager() : mysqlServerIp = {}, jdbcDriver = {}", mysqlServerIp, jdbcDriver);
    }
    
    public List<AddrBookRow> getAllRows() {
        List<AddrBookRow> dataList = new ArrayList<>();
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", this.mysqlServerIp, this.mysqlServerPort);
        
        log.debug("AddrBookManager() : mysqlServerIp = {}, jdbcDriver = {}", mysqlServerIp, jdbcDriver);
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // 1. JDBC 드라이버 적재
            Class.forName(jdbcDriver);

            // 2. DB 연결
            conn = DriverManager.getConnection(JDBC_URL, userName, password);

            // 3. Statement 생성
            stmt = conn.createStatement();

            // 4. SQL 질의 실행
            String sql = "SELECT * FROM addrbook";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                dataList.add(new AddrBookRow(email, name, phone));
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            log.error("오류가 발생했습니다. (발생 오류: {})", ex.getMessage());
        }
        
        return dataList;
    }    
    
    public void addRow(String email, String name, String phone) {
        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", mysqlServerIp, mysqlServerPort);
        
        log.debug("JDBC_URL = {}", JDBC_URL);
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // 1. JDBC 드라이버 적재
            Class.forName(jdbcDriver);

            // 2. DB 연결
            conn = DriverManager.getConnection(JDBC_URL, this.userName, this.password);

            // 3. PreparedStatement 객체 생성
            String sql = "INSERT into addrbook VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 4. SQL문 완성
            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);

            // 5. 실행
            pstmt.executeUpdate();

            // 6. 자원 해제
            if (pstmt != null) {
                pstmt.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }            
        } catch (Exception ex) {
            log.error("오류가 발생했습니다. (발생 오류: {})", ex.getMessage());
        }
    }
}
