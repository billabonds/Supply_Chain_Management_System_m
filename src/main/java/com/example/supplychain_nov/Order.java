package com.example.supplychain_nov;

public class Order {
    public static boolean placeSingleOrder(Product product,String customerEmail){
            String orderQuery = String.format("INSERT into orders (quantity,customer_id ,product_id ,status) VALUES (1 , (SELECT cid FROM  customer WHERE email = '%s'), %s , 'ORDERED')",
                    customerEmail,product.getId());

            DatabaseConnection dbConn = new DatabaseConnection();

            if(dbConn.insertData(orderQuery) >= 1){
                    return true;
            }

        System.out.println(orderQuery);
        return false;
    }
}
