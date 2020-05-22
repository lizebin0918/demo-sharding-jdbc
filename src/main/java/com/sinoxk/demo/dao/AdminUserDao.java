package com.sinoxk.demo.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinoxk.demo.dao.entity.AdminUser;

import java.util.Optional;

/**
 * 运营后台用户<br/>
 * Created on : 2020-05-12 19:37
 * @author chenpi 
 */
public interface AdminUserDao extends IService<AdminUser> {

    /**
     * 根据登录名称查询
     * @param loginName
     * @return
     */
    Optional<AdminUser> getOneByLoginName(String loginName);

}
