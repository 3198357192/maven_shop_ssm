package com.iotek.dao;

import com.iotek.po.OrderList;

import java.util.List;

/**
 * Created by xiaohuang on 2018/3/3.
 */
public interface OrderListMapper {
   List<OrderList> findOrderListByCid(int cid);
}

