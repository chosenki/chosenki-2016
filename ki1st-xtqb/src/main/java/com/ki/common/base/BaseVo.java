package com.ki.common.base;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Wangxiang on 2016/8/28.
 */
public abstract class BaseVo implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5771973207268837024L;
    /**
     * 主键
     */
    private String id;

    /**
     * 排序列集合
     */
    private Map<String, String> sortFieldMap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getSortFieldMap() {
        return sortFieldMap;
    }

    public void setSortFieldMap(Map<String, String> sortFieldMap) {
        this.sortFieldMap = sortFieldMap;
    }
}

