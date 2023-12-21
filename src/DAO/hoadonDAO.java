/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.hoadon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class hoadonDAO extends connect{
    ArrayList<hoadon> listhoadon=new ArrayList<hoadon>();
    
    public ArrayList<hoadon> allhoadon(){
        try {
            String sql = "select id, id_kh, id_sp,quantity,total from hoadon where status=1 ";

            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                hoadon hd=new hoadon();
                
                hd.setId(rs.getInt("id"));
                hd.setId_kh(rs.getInt("id_kh"));
                hd.setId_sp(rs.getInt("id_sp"));
                hd.setQuantity(rs.getInt("quantity"));
                hd.setTotal(rs.getInt("total"));
                
                listhoadon.add(hd);
            }
        }catch (SQLException ex) {
             ex.printStackTrace();
        }
        return listhoadon;       
    }
    
    public ArrayList<hoadon> inhoadon(){
        String sql="SELECT h.id, h.id_kh, s.name, s.price, h.quantity, s.price * h.quantity AS total FROM hoadon h "
                + "JOIN sanpham s ON h.id_sp = s.id ";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                hoadon hd=new hoadon();
                
                hd.setId(rs.getInt("id"));
                hd.setId_kh(rs.getInt("id_kh"));
                hd.setName(rs.getString("name"));
                hd.setPrice(rs.getInt("price"));
                hd.setQuantity(rs.getInt("quantity"));
                hd.setTotal(rs.getInt("total"));
          
                listhoadon.add(hd);
            }
        }catch (SQLException ex) {
             ex.printStackTrace();
        }
        return listhoadon;
    }
    
    public ArrayList<hoadon> inhoadonbyid(String id){
        String sql="SELECT h.id, h.id_kh, s.name, s.price, h.quantity, s.price * h.quantity AS total FROM hoadon h "
                + "JOIN sanpham s ON h.id_sp = s.id  Where id ="+id;
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                hoadon hd=new hoadon();
                
                hd.setId(rs.getInt("id"));
                hd.setId_kh(rs.getInt("id_kh"));
                hd.setName(rs.getString("name"));
                hd.setPrice(rs.getInt("price"));
                hd.setQuantity(rs.getInt("quantity"));
                hd.setTotal(rs.getInt("total"));
          
                listhoadon.add(hd);
            }
        }catch (SQLException ex) {
             ex.printStackTrace();
        }
        return listhoadon;
    }
        
    public int inserthoadon(hoadon hd){
        String sql = "Insert into hoadon(`id_kh`, `id_sp` ,`quantity`,`total`) Values(?,?,?,?)";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,hd.getId_kh());
            pre.setInt(2,hd.getId_sp());
            pre.setInt(3,hd.getQuantity());
            pre.setInt(4,hd.getTotal());
            
            return pre.executeUpdate();
        }catch (SQLException ex) {
             ex.printStackTrace();
        }
        return -1;
    }
    
    public int updatethoadon(hoadon hd){
        String sql = "update hoadon set`id_kh`=?, `id_sp`=? ,`quantity`=?,`total`=? where id=?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
          
            pre.setInt(1,hd.getId_kh());
            pre.setInt(2,hd.getId_sp());
            pre.setInt(2,hd.getQuantity());
            pre.setInt(4,hd.getTotal());
            pre.setInt(5,hd.getId());
            
            return pre.executeUpdate();
        }catch (SQLException ex) {
             ex.printStackTrace();
        }
        return -1;
    }
    public int deletethoadon(hoadon hd){
        String sql = "UPDATE hoadon SET  `status`=0 WHERE id = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hd.getId());
            return pre.executeUpdate();
            
        }catch (SQLException ex) {
             ex.printStackTrace();
        }
        return -1;
    }
}
