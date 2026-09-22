package com.shopping.dao;

import com.shopping.model.Product;
import com.shopping.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean addProduct(Product product) {

        String sql = "INSERT INTO product_details "
                + "(name, category, product, unit_price, district, phone_no, email_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setString(3, product.getProduct());
            ps.setBigDecimal(4, product.getUnitPrice());
            ps.setString(5, product.getDistrict());
            ps.setString(6, product.getPhoneNo());
            ps.setString(7, product.getEmailId());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<Product>();

        String sql = "SELECT * FROM product_details ORDER BY id ASC";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setProduct(rs.getString("product"));
                product.setUnitPrice(rs.getBigDecimal("unit_price"));
                product.setDistrict(rs.getString("district"));
                product.setPhoneNo(rs.getString("phone_no"));
                product.setEmailId(rs.getString("email_id"));

                products.add(product);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}