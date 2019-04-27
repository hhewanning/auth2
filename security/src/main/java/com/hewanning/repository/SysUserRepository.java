package com.hewanning.repository;

import com.hewanning.module.SysUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SysUserRepository
 * @Author hewanning
 * @Date 2019/4/27 14:19
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface SysUserRepository extends CrudRepository<SysUser,Integer> {

    @Query("select a from SysUser a where a.name=:name")
    public SysUser getUserByName(@Param("name") String name);
}