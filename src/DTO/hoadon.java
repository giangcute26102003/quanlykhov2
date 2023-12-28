/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.security.Timestamp;

/**
 *
 * @author gjang
 */
public class hoadon {

    private int id;
    private int id_kh;
    private int id_sp;
    private String namesp;
    private String namekhachang;
    private int quantity;
    private int total;
    private int status;
    private String name;
    private int price;
    private String create_at;

    public String getNamesp() {
        return namesp;
    }

    public void setNamesp(String namesp) {
        this.namesp = namesp;
    }

    public String getNamkhachang() {
        return namekhachang;
    }

    public void setNamkhachang(String namkhachang) {
        this.namekhachang = namkhachang;
    }

    public hoadon(int id, int id_kh, int id_sp, int quantity, int total, int status, String name, int price, String create_at, String namesp, String namkhachang) {
        this.id = id;
        this.id_kh = id_kh;
        this.id_sp = id_sp;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
        this.name = name;
        this.price = price;
        this.create_at = create_at;
        this.namesp = namesp;
        this.namekhachang = namkhachang;
    }

    public hoadon(String create_at) {
        this.create_at = create_at;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public int getId_kh() {
        return id_kh;
    }

    public int getId_sp() {
        return id_sp;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_kh(int id_kh) {
        this.id_kh = id_kh;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "hoadon{" + "id=" + id + ", id_kh=" + id_kh + ", id_sp=" + id_sp + ", quantity=" + quantity + ", total=" + total + ", status=" + status + ", name=" + name + ", price=" + price + '}';
    }

    public hoadon() {

    }
}
