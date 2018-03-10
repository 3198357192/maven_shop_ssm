package com.iotek.dao;

import com.iotek.po.Product;

/**
 * Created by xiaohuang on 2018/3/1.
 */
public interface ProductMapper {

    Product  queryProductById(int pid);
}
