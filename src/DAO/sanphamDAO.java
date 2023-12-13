/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.san_pham;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author gjang
 */
public class sanphamDAO extends connect{
    public ArrayList<san_pham> allsanpham(){
        ArrayList<san_pham> allsp = new ArrayList<san_pham>();
        try {
            String sql = "Select sp.id,sp.name,sp.desc,sp.photo,sp.price,sp.quantity,nsx.name as namensx from sanpham sp "
                    + "join nhasanxuat nsx on sp.id_nsx=nsx.id where sp.status=1  ";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet  rs = pre.executeQuery();
            while(rs.next()){
                san_pham sp = new san_pham();

                sp.setId(rs.getInt("id"));
                sp.setName(rs.getString("name"));
                sp.setDesc(rs.getString("desc"));
                sp.setPhoto(rs.getString("photo"));
                sp.setPrice(rs.getInt("price"));
                sp.setQuantity(rs.getInt("quantity"));
                sp.setNamensx(rs.getString("namensx"));
                
                allsp.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allsp;
    }
    
    public ArrayList<san_pham> filterAll(String s){
        ArrayList<san_pham> allsp = new ArrayList<san_pham>();
        try{
            String sql = "Select sp.id,sp.name,sp.desc,sp.photo,sp.price,sp.quantity,nsx.name as namensx  from sanpham sp "
                    + "join nhasanxuat nsx on sp.id_nsx=nsx.id "
                    + "where sp.status=1  and (sp.name like ? or sp.desc like ? or nsx.name like ?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,"%"+s+"%");
            pre.setString(2,"%"+s+"%");
            pre.setString(3,"%"+s+"%");
            ResultSet  rs = pre.executeQuery();
            while(rs.next()){
                san_pham sp = new san_pham();

                sp.setId(rs.getInt("id"));
                sp.setName(rs.getString("name"));
                sp.setDesc(rs.getString("desc"));
                sp.setPhoto(rs.getString("photo"));
                sp.setPrice(rs.getInt("price"));
                sp.setQuantity(rs.getInt("quantity"));
                sp.setNamensx(rs.getString("namensx"));
                
                allsp.add(sp);
            }        
        }catch (Exception e) {
            e.printStackTrace();
        }
        return allsp;
    }
    
    public int luusp(san_pham sp){
        String sql = "INSERT INTO `sanpham`(`name`, `desc`, `photo`, `price`, `quantity`, `status`, `id_nsx`) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            
            pre.setString(1, sp.getName());
            pre.setString(2, sp.getDesc());
            pre.setString(3, sp.getPhoto());
            pre.setInt(4, sp.getPrice());
            pre.setInt(5, sp.getQuantity());
            pre.setInt(6, sp.getStatus());
            pre.setInt(7, sp.getId_nsx());

            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public int update(san_pham sp){
        String sql = "UPDATE `sanpham` SET `name`=?, `desc`=?, `photo`=?, `price`=?, `quantity`=?, `status`=?, `id_nsx`=? WHERE id = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            
            pre.setString(1, sp.getName());
            pre.setString(2, sp.getDesc());
            pre.setString(3, sp.getPhoto());
            pre.setInt(4, sp.getPrice());
            pre.setInt(5, sp.getQuantity());
            pre.setInt(6, sp.getStatus());
            pre.setInt(7, sp.getId_nsx());
            pre.setInt(8, sp.getId());
             
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<san_pham> xuatkho (String name){
        ArrayList<san_pham> xk = new ArrayList<san_pham>();
        try{
            String sql="select id,name,quantity from sanpham where status=1 and name=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,name);
            ResultSet rs= pre.executeQuery();
            while(rs.next()){
                san_pham sp=new san_pham();
                sp.setId(rs.getInt("id"));
                sp.setName(rs.getString("name"));
                sp.setQuantity(rs.getInt("quantity"));
                
                xk.add(sp);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return xk;
    }
}
