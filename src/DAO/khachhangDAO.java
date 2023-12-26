/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.khachhang;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gjang
 */
public class khachhangDAO extends connect{
    ArrayList<khachhang> listkhachhang=new ArrayList<khachhang>();

    public ArrayList<khachhang> allkhachhang(){
        try {
            String sql = "select id, name, phone ,address from khachhang  ";

            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                khachhang kh=new khachhang();
                kh.setId(rs.getInt("id"));
                kh.setName(rs.getString("name"));
                kh.setPhone(rs.getString("phone"));
                kh.setAddress(rs.getString("address"));

                listkhachhang.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listkhachhang;
    }

    public int allkhachhangbyname(String name){
        khachhang kh= new khachhang();
        int i = 0;
        try {
            String sql = "select id, name, phone ,address from khachhang where name = "+name+"limit 1";

            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                kh.setId(rs.getInt("id"));
                kh.setName(rs.getString("name"));
                kh.setPhone(rs.getString("phone"));
                kh.setAddress(rs.getString("address"));
                
                i= rs.getInt("id");

                
            }
        } catch (SQLException ex) {
            
        }

        return i;
    }
     public int newkh(){
        khachhang kh= new khachhang();
        int i = 0;
        try {
            String sql = "select MAX(id) from khachhang ";

            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {           
                i= rs.getInt(1); 
            }
        } catch (SQLException ex) {
            
        }
        return i;
    }

    public int insertkhachhang(khachhang kh){
        String sql = "Insert into khachhang(`name`, `phone` ,`address`) Values(?,?,?)";
        try{
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setString(1, kh.getName());
            pre.setString(2, kh.getPhone());
            pre.setString(3,kh.getAddress());

            return pre.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}