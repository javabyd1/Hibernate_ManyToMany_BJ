package com.mojafirma;

import com.mojafirma.model.Order;
import com.mojafirma.model.Product;
import com.mojafirma.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Order order1 = new Order();
        order1.setOrderDate(LocalDate.of(2017, 11, 15));
        Order order2 = new Order();
        order2.setOrderDate(LocalDate.of(2017, 11, 10));

        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setDescription("Asus F540YA to doskonały, uniwersalny laptop stworzony do pracy i rozrywki.");
        Product product2 = new Product();
        product2.setName("Monitor");
        product2.setDescription("Cienki monitor HP 22er ma elegancką i przyciągającą wzrok konstrukcję.");
        Product product3 = new Product();
        product3.setName("Klawiatura");
        product3.setDescription("Klawiatura do PC.");

        order1.getProducts().add(product1);
        order1.getProducts().add(product2);

        order2.getProducts().add(product1);
        order2.getProducts().add(product2);
        order2.getProducts().add(product3);

        Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();

        session.save(order1);
        session.save(order2);

        session.getTransaction().commit();
        session.close();
    }
}
