package com.ki.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Wangxiang on 2016/8/28.
 */
public abstract class BaseService<T extends BaseId<String>, K extends BaseVo> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}

