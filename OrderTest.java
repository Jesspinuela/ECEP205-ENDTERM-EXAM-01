package com.ecpe205;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderTest {
    Order order;

    @BeforeAll
    void setup(){
        order = new Order();
        order.addItem(new Product("111110","beef",55),10);
        order.addItem(new Product("111100","chicken",10),5);
        order.addItem(new Product("111000","egg",12),8);
        order.addItem(new Product("110000","tocino",45),12);
        order.addItem(new Product("100000","ham",40),3);
    }

    @Test
    void add5Items(){
        order.addItem(new Product("222220","cologne",18),13);
        order.addItem(new Product("222200","deodorant",15),6);
        order.addItem(new Product("222000","toner",20),4);
        order.addItem(new Product("220000","soap",16),2);
        order.addItem(new Product("200000","shampoo",25),14);
        assertEquals(77,order.getTotalQuantity());
        assertEquals(2142,order.getGrandTotal());

    }

    @Test
    void remove5Items(){
        for (int i = order.getItems().size(); i<5; i--){
            order.removeItem(i);
        }
        assertEquals(38,order.getTotalQuantity());
        assertEquals(1356,order.getGrandTotal());
    }



    @Test
    void getAmounts(){
        Order order = new Order();

        //1.
        order.addItem(new Product("111110","beef",55),10);
        assertEquals(550,order.getItems().get(0).getAmount());

        //2.
        order.addItem(new Product("111110","beef",55),10);
        order.getItems().get(1).setProduct(new Product("111100", "chicken", 10));
        assertEquals(100,order.getItems().get(1).getAmount());

        //3.
        order.addItem(new Product("111000","egg",12),5);
        order.getItems().get(2).setQuantity(10);
        assertEquals(10,order.getItems().get(2).getQuantity());

    }
}
//https://github.com/Jesspinuela/ECEP205-ENDTERM-EXAM-01.git