package com.ki.feature.entity;

import com.ki.common.base.IdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Wangxiang on 2016/8/28.
 */
@Entity
@Table(name = "USER")
@Data
public class User extends IdEntity {


    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;
}

