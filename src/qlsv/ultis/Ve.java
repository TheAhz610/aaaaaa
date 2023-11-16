/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsv.ultis;

import java.io.Serializable;

/**
 *
 * @author theanh
 * 
 */
public class Ve implements Serializable{
    private String id,name;
    private Double Giaphong,tongtien;
    private Double SGhe;
    public Ve() {
    }

    public Ve(String id, String name, Double SGhe, Double Giaphong, Double tongtien) {
        this.id = id;
        this.name = name;
        this.SGhe = SGhe;
        this.Giaphong = Giaphong;
        this.tongtien = tongtien;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getLyThuyet() {
//        return SNgayO;
//    }
//
//    public void setLyThuyet(Double lyThuyet) {
//        this.SNgayO = lyThuyet;
//    }
//
//    public Double getThucHanh() {
//        return Giaphong;
//    }
//
//    public void setThucHanh(Double thucHanh) {
//        this.Giaphong = thucHanh;
//    }
//
//    public Double getAvg() {
//        return tongtien;
//    }
//
//    public void setAvg(Double avg) {
//        this.tongtien = avg;
//    }
//    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSGhe() {
        return SGhe;
    }

    public void setSGhe(Double SGhe) {
        this.SGhe = SGhe;
    }

    public Double getGiaphong() {
        return Giaphong;
    }

    public void setGiaphong(Double Giaphong) {
        this.Giaphong = Giaphong;
    }

    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
