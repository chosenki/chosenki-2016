package com.ki.common.base;

import java.io.Serializable;

/**
 * Created by Wangxiang on 2016/8/28.
 */

public interface BaseId<E extends Serializable> {

    public E getId();

    public void setId(E id);

}
