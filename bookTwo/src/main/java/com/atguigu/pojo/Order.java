package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String order_id ;
    private Date creat_time ;
    private BigDecimal total_money ;
    private Integer status = 0 ;//{0表示未发货，1表示已发货，2表示已签收}
    private Integer user_id ;

    public Order() {
    }

    public Order(String order_id, Date creat_time, BigDecimal total_money, Integer status, Integer user_id) {
        this.order_id = order_id;
        this.creat_time = creat_time;
        this.total_money = total_money;
        this.status = status;
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", creat_time=" + creat_time +
                ", total_money=" + total_money +
                ", status=" + status +
                ", user_id=" + user_id +
                '}';
    }
}
