package com.hewanning.module;
import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName SysRole
 * @Author hewanning
 * @Date 2019/4/27 14:17
 * @Description TODO
 * @Version 1.0
 */
@Data
@Entity
@Table(name="sys_role")
public class SysRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}