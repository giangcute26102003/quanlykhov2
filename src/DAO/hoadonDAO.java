/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.hoadon;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.san_pham;

/**
 *
 * @author gjang
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

    public ArrayList inhoadon(String search){
        String sql="SELECT  h.id_kh,kh.name as namekh , s.name as namesp, s.price, h.quantity, s.price * h.quantity AS total ,h.create_at "
                + "FROM hoadon h JOIN sanpham s ON h.id_sp = s.id join khachhang kh on h.id_kh = kh.id where kh.name like ? or s.name like ?;";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,  '%'+search+'%');
            pre.setString(2,  '%'+search+'%');
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                hoadon hd=new hoadon();
                
                hd.setNamkhachang(rs.getString("namekh"));
                hd.setNamesp(rs.getString("namesp"));
                hd.setCreate_at(rs.getString("create_at"));
                hd.setId_kh(rs.getInt("id_kh"));
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
        String sql = "Insert into hoadon(`id_kh`, `id_sp` ,`quantity`,`total` ,`create_at`) Values(?,?,?,?,?)";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,hd.getId_kh());
            pre.setInt(2,hd.getId_sp());
            pre.setInt(3,hd.getQuantity());
            pre.setInt(4,hd.getTotal());
            pre.setString(5,hd.getCreate_at());

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