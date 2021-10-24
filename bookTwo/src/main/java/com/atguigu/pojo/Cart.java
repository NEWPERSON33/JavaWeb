package com.atguigu.pojo;

import org.apache.commons.collections.map.FixedSizeMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    //private Integer totalCount ;
    //private BigDecimal totalPrice ;
    private Map<Integer,CartItem> items ;



    public void addItem(CartItem item){
        CartItem cartItem = items.get(item.getId());
        if(cartItem!= null){
            cartItem.setCount(item.getCount()+1);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
            //item.setTotalPrice(item.getPrice().add(item.getTotalPrice()) );
        }else {
            items.put(item.getId(), item);
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }

    public void updateCount(Integer id , Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }


    public Cart() {
        if (items == null){
            items = new HashMap<>();
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0 ;
        for (Map.Entry<Integer , CartItem> entry:items.entrySet()) {
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }

//    public void setTotalCount(Integer totalCount) {
//        this.totalCount = totalCount;
//    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer , CartItem> entry:items.entrySet()){
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

//    public void setTotalPrice(BigDecimal totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    public Map< Integer,CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer,CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
