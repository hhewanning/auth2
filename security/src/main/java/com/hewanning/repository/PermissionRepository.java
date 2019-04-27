package com.hewanning.repository;

import com.hewanning.module.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName PermissionRepository
 * @Author hewanning
 * @Date 2019/4/27 14:18
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface PermissionRepository extends CrudRepository<Permission,Integer> {

}