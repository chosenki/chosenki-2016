package com.ki.common.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by Wangxiang on 2016/8/28.
 */
@NoRepositoryBean
public interface BaseDao<T, I extends Serializable> extends JpaRepository<T, I>,JpaSpecificationExecutor<T> {

}
