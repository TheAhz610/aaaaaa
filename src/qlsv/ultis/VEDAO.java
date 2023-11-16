/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsv.ultis;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Theanh
 */
public class VEDAO implements Serializable{
    private ArrayList<Ve> list = new ArrayList<>();

    public ArrayList<Ve> getList() {
        return list;
    }
    
    boolean checkDeducateAdd(Ve sv){
        for(Ve st: list){
            if(st.getId().equalsIgnoreCase(sv.getId())){
                JOptionPane.showMessageDialog(null, "Đã tồn tại sinh viên với mã "+st.getId());
                return false;
            }
        }
        return true;
    }
    
    public void addToArray(Ve sv){
        if(checkDeducateAdd(sv)){
            list.add(sv);
        }
    }
    
    public Ve findByID(String id){
        for(Ve sv : list){
            if(sv.getId().equalsIgnoreCase(id)){
                return sv;
            }
        }
        return null;
    }
    
    public boolean edit(Ve svNew){
        for(Ve svOld : list){
            if(svOld.getId().equalsIgnoreCase(svNew.getId())){
                svOld.setTongtien(svNew.getTongtien());
                svOld.setSGhe(svNew.getSGhe());
                svOld.setName(svNew.getName());
                svOld.setGiaphong(svNew.getGiaphong());
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteByID(String id){
        for(Ve sv : list){
            if(sv.getId().equalsIgnoreCase(id)){
                int choose = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn xóa sinh viên này");
                if(choose == JOptionPane.YES_OPTION){
                    list.remove(sv);
                    JOptionPane.showMessageDialog(null, "đã xóa thành công");
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    
    public int indexOfsv(Ve sv){
        return list.indexOf(sv);
    }
    
    public void sort(boolean isSort){
        if(list==null){
            return;
        }
        if(isSort){
            list.sort((Ve s1,Ve s2) -> Double.compare(s1.getTongtien(), s2.getTongtien()));
        
        }
        else{
            list.sort((Ve s1,Ve s2) -> Double.compare(s2.getTongtien(), s1.getTongtien()));
        }
    }
}
