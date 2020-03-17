package com.local.crowd.service.api;

import com.local.crowd.entity.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 添加用户
     * @param admin
     * @return
     */
    int saveAdmin(Admin admin);

    List<Admin> getAll();
}
