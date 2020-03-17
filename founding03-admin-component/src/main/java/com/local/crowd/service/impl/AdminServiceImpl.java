package com.local.crowd.service.impl;

import com.local.crowd.entity.Admin;
import com.local.crowd.entity.AdminExample;
import com.local.crowd.mapper.AdminMapper;
import com.local.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author wangrq
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public int saveAdmin(Admin admin) {
        int count = adminMapper.insert(admin);
        if (1 == 1) {
            throw new RuntimeException("test");
        }
        return count;
    }

    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }
}
