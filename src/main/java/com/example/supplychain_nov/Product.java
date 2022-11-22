package com.example.supplychain_nov;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Product {

    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleDoubleProperty price;

    Product(int id,String name,double price) {

        this.id= new SimpleIntegerProperty(id);
        this.name= new SimpleStringProperty(name);
        this.price=new SimpleDoubleProperty(price);
    }

    public static ObservableList<Product> getAllProducts(){
        DatabaseConnection dbConn = new DatabaseConnection();
        ObservableList<Product> data = FXCollections.observableArrayList();
        String selectAllProducts = "SELECT * FROM  product";

        try{
            ResultSet rs = dbConn.getQueryTable(selectAllProducts);
            while( rs.next() ){
                data.add(new Product(rs.getInt("pid") , rs.getString("name") , rs.getDouble("price") ) );
            }
            rs.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Product> getProductsByName(String name){
        DatabaseConnection dbConn = new DatabaseConnection();
        ObservableList<Product> data = FXCollections.observableArrayList();
        String selectAllProducts = String.format("SELECT * FROM  product WHERE LOWER(name) like '%%%s%%' " , name.toLowerCase());

        try{
            ResultSet rs = dbConn.getQueryTable(selectAllProducts);
            while( rs.next() ){
                data.add(new Product(rs.getInt("pid") ,
                        rs.getString("name") ,
                        rs.getDouble("price") ) );
            }
            rs.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public int getId() {
        return id.get();
    }

    public String getName(){
        return name.get();
    }

    public double getPrice(){
        return price.get();
    }
}
