/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gjang
 */
public class userDAO extends connect {

    ArrayList<user> listuser = new ArrayList<user>();

    public user dangnhap(String username, String password) {
        user nd = null;
        try {
            String sql = "select * from user where status=1 and user_name=? and pw=?";

            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                nd = new user();
                nd.setId(rs.getInt("id"));
                nd.setName(rs.getString("name"));
                nd.setUser_name(rs.getString("user_name"));
                nd.setPw(rs.getString("pw"));
//                nd.setLevel(rs.getInt("level"));
//                nd.setStatus(rs.getInt("status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nd;
    }

    public user loginbyid(String id) {
        user nd = null;
        try {
            String sql = "select * from user where status = 1 and id = " + id;

            PreparedStatement pre = con.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nd = new user();
                nd.setId(rs.getInt("id"));
                nd.setName(rs.getString("name"));
                nd.setUser_name(rs.getString("user_name"));
                nd.setPw(rs.getString("pw"));
                nd.setBirth(rs.getString("birth"));
                nd.setBirth(rs.getString("phone"));
                nd.setLevel(rs.getInt("level"));
                nd.setStatus(rs.getInt("status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nd;
    }

    public ArrayList<user> alluser() {
        try {
            String sql = "select * from user where status = 1 ";

            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                user nd = new user();
                nd.setId(rs.getInt("id"));
                nd.setName(rs.getString("name"));
                nd.setUser_name(rs.getString("user_name"));
                nd.setPw(rs.getString("pw"));
                nd.setBirth(rs.getString("birth"));
                nd.setBirth(rs.getString("phone"));
                nd.setLevel(rs.getInt("level"));
                nd.setStatus(rs.getInt("status"));
                listuser.add(nd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listuser;
    }

    public ArrayList<user> alluserbyId(String id) {

        try {
            String sql = "select * from user where status = 1 and id = " + id;

            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                user nd = new user();
                nd.setId(rs.getInt("id"));
                nd.setName(rs.getString("name"));
                nd.setUser_name(rs.getString("user_name"));
                nd.setPw(rs.getString("pw"));
                nd.setBirth(rs.getString("birth"));
                nd.setBirth(rs.getString("phone"));
                nd.setLevel(rs.getInt("level"));
                nd.setStatus(rs.getInt("status"));
                listuser.add(nd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listuser;
    }

    public int insertUser(user us) {
        String sql = "Insert into user(`name`,`user_name`,`pw`,`birth`,`phone`,`level`) Values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setString(1, us.getName());
            pre.setString(2, us.getUser_name());
            pre.setString(3, us.getPw());
            pre.setString(4, us.getBirth());
            pre.setString(5, us.getPhone());
            pre.setInt(6, us.getLevel());

            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updatetUser(user us) {
        String sql = "Update user set `name`=?,`user_name`=?,`pw`=?,`birth`=?,`phone`=?,`level`=? where id=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setString(1, us.getName());
            pre.setString(2, us.getUser_name());
            pre.setString(3, us.getPw());
            pre.setString(4, us.getBirth());
            pre.setString(5, us.getPhone());
            pre.setInt(6, us.getLevel());
            pre.setInt(7, us.getId());

            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updatepassUser(user us) {
        String sql = "Update user set `pw`=? where id=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setString(1, us.getPw());
            pre.setInt(2, us.getId());

            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteUser(user us) {
        String sql = "Update user set `status`=0 where id=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setInt(1, us.getId());

            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
