package com.hewanning.module;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

/**
 * @ClassName SysUser
 * @Author hewanning
 * @Date 2019/4/27 14:16
 * @Description TODO
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "sys_user")
public class SysUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @Transient
    private List<SysRole> roles;


}
