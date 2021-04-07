package com.sinoxk.demo.cache;

import com.sinoxk.demo.common.constant.Constant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * 连锁管理映射缓存<br/>
 * Created on : 2021-04-02 11:49
 * @author chenpi 
 */
@Slf4j
@Component
@DependsOn({Constant.ADMIN_DATA_SOURCE})
public class AdminCache {

    @Resource(name = Constant.ADMIN_DATA_SOURCE)
    private DataSource adminDataSource;

    @Data
    public static class Key {

        private int customerId, year;

        public Key(int customerId, int year) {
            this.customerId = customerId;
            this.year = year;
        }

        public static Key build(int customerId, int year) {
            return new Key(customerId, year);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Key key = (Key) o;
            return customerId == key.customerId &&
                year == key.year;
        }

        @Override
        public int hashCode() {
            return Objects.hash(customerId, year);
        }
    }

    private static final Map<Key, String> CACHE = new HashMap<>();

    /**
     * 根据customerId返回数据库名称
     * @param key
     * @return
     */
    public static String getDbName(Key key) {
        return CACHE.get(key);
    }

    /**
     * 初始化映射，加载到内存
     */
    @PostConstruct
    public void init() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select customer_id, year, db_name from customer_mapping";
        try {
            conn = adminDataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CACHE.put(Key.build(rs.getInt(1), rs.getInt(2)), rs.getString(3));
            }
        } catch (Exception e) {
            log.error("加载连锁映射异常，请开发人员注意！！！！！！！！！", e);
        } finally {
            if (Objects.nonNull(rs)) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (Objects.nonNull(pstmt)) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (Objects.nonNull(conn)) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }
}
