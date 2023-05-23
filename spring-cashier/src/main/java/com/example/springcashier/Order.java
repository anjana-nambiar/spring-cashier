
package com.example.springcashier;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drink;
    private String milk;
    private String size;
    private String total;
    private String register;
    private String status;

    public static Order GetNewOrder() {
        Order o = new Order();
        Random random = new Random();

        List<String> drinks = Arrays.asList("Caffe Latte", "Caffe Americano", "Caffe Mocha", "Cappuccino", "Espresso");
        List<String> sizes = Arrays.asList("tall", "grande", "venti");
        List<String> milks = Arrays.asList("Whole Milk", "2% Milk", "Nonfat Milk", "Soy Milk");

        o.drink = drinks.get(random.nextInt(drinks.size()));
        o.size = sizes.get(random.nextInt(sizes.size()));
        o.milk = milks.get(random.nextInt(milks.size()));

        double price = 0;

        switch (o.drink) {
            case "Caffe Latte":
                if (o.size.equals("tall"))
                    price = 2.95;
                else if (o.size.equals("grande"))
                    price = 3.65;
                else
                    price = 3.95;
                break;
            case "Caffe Americano":
                if (o.size.equals("tall"))
                    price = 2.25;
                else if (o.size.equals("grande"))
                    price = 2.65;
                else
                    price = 2.95;
                break;
            case "Caffe Mocha":
                if (o.size.equals("tall"))
                    price = 3.45;
                else if (o.size.equals("grande"))
                    price = 4.15;
                else
                    price = 4.45;
                break;
            case "Cappuccino":
                if (o.size.equals("tall"))
                    price = 2.95;
                else if (o.size.equals("grande"))
                    price = 3.65;
                else
                    price = 3.95;
                break;
            case "Espresso":
                if (o.size.equals("short"))
                    price = 1.75;
                else
                    price = 1.95;
                break;
        }

        o.status = "Ready for Payment";
        o.total = String.format("$%.2f", price);

        return o;
    }
}

/*
 *
 * https://priceqube.com/menu-prices/%E2%98%95-starbucks
 *
 * var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha",
 * "Espresso", "Cappuccino" ];
 * var MILK_OPTIONS = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk",
 * "Soy Milk" ];
 * var SIZE_OPTIONS = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];
 *
 * Caffè Latte
 * =============
 * tall $2.95
 * grande $3.65
 * venti $3.95 (Your Own Cup)
 *
 * Caffè Americano
 * ===============
 * tall $2.25
 * grande $2.65
 * venti $2.95 (Your Own Cup)
 *
 * Caffè Mocha
 * =============
 * tall $3.45
 * grande $4.15
 * venti $4.45 (Your Own Cup)
 *
 * Cappuccino
 * ==========
 * tall $2.95
 * grande $3.65
 * venti $3.95 (Your Own Cup)
 *
 * Espresso
 * ========
 * short $1.75
 * tall $1.95
 *
 */
