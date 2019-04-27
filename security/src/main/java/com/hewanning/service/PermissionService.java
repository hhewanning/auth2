package com.hewanning.service;

import com.hewanning.module.Permission;

import java.util.List;

/**
 * @ClassName PermissionService
 * @Author hewanning
 * @Date 2019/4/27 14:21
 * @Description TODO
 * @Version 1.0
 */
public interface PermissionService {
    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
