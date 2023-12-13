/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.nha_san_xuat;
import com.mysql.cj.PreparedQuery;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Statement;
import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author gjang
 */
public class nsxDAO extends connect{
    public ArrayList<nha_san_xuat> allnsx() {
        ArrayList<nha_san_xuat> listnsx  = new ArrayList<nha_san_xuat>();
        try {
            String sql = "SELECT id,name,address,email,phone FROM nhasanxuat where status=1";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                nha_san_xuat nsx = new nha_san_xuat();
                
                nsx.setId(rs.getInt("id"));
                nsx.setName(rs.getString("name"));
                nsx.setAddress(rs.getString("address"));
                nsx.setEmail(rs.getString("email"));
                nsx.setPhone(rs.getString("phone"));
  
                listnsx.add(nsx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listnsx;
    }
    
    public ArrayList<nha_san_xuat> allnsxbyID(String id){
        ArrayList<nha_san_xuat> listnsx = new ArrayList<nha_san_xuat>();
        try {
            String sql = "select id,name,address,email,phone from nhasanxuat where id = ? and status=1";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,id);
            ResultSet rs= pstm.executeQuery();
            while (rs.next()) {
                    nha_san_xuat nsx = new nha_san_xuat();
                    
                    nsx.setId(rs.getInt("id"));
                    nsx.setName(rs.getString("name"));
                    nsx.setAddress(rs.getString("address"));
                    nsx.setEmail(rs.getString("email"));
                    nsx.setPhone(rs.getString("phone"));

                    listnsx.add(nsx); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listnsx; 
    }
    
    public ArrayList<nha_san_xuat> allnsxbyName(String namensx){
        ArrayList<nha_san_xuat> listnsx = new ArrayList<nha_san_xuat>();
        try {
            String sql = "select id,name,address,email,phone from nhasanxuat where name = ? and status=1";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1, namensx);
            ResultSet rs= pstm.executeQuery();
            while (rs.next()) {
                    nha_san_xuat nsx = new nha_san_xuat();
                    
                    nsx.setId(rs.getInt("id"));
                    nsx.setName(rs.getString("name"));
                    nsx.setAddress(rs.getString("address"));
                    nsx.setEmail(rs.getString("email"));
                    nsx.setPhone(rs.getString("phone"));

                    listnsx.add(nsx); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listnsx; 
    }
    
    public int returnID(String namensx){
       int idnsx=-1;
        try { 
            String sql = "select id from nhasanxuat where name = ? and status=1";
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, namensx);
            ResultSet a = pre.executeQuery(sql);
            while(a.next()){
                idnsx = a.getInt("id");
            }
            return idnsx;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int luuNSX(nha_san_xuat nsx){
        String sql = "INSERT INTO `nhasanxuat` (`name`, `address`,`email`,`phone`,`status`) VALUES ( ?,?,?,?,?)";
        try {
              PreparedStatement pre = con.prepareStatement(sql);
              pre.setString(1, nsx.getName());
              pre.setString(2, nsx.getAddress());
              pre.setString(3,nsx.getEmail());
              pre.setString(4, nsx.getPhone());
              pre.setInt(5,nsx.getStatus());
              return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int update(nha_san_xuat nsx){
        String sql = "UPDATE `nhasanxuat` SET `name`=?,`address`=?,`email`=?,`phone`=?,`status`=? WHERE id = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, nsx.getName());
            pre.setString(2, nsx.getAddress());
            pre.setString(3,nsx.getEmail());
            pre.setString(4, nsx.getPhone());
            pre.setInt(5,nsx.getStatus());
            pre.setInt(6, nsx.getId());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }     
}
