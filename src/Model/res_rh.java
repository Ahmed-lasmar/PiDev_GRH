/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class res_rh {
    private int Id_RH ;

    public res_rh() {
    }

    public res_rh(int Id_RH) {
        this.Id_RH = Id_RH;
    }

    public int getId_RH() {
        return Id_RH;
    }

    public void setId_RH(int Id_RH) {
        this.Id_RH = Id_RH;
    }

    @Override
    public String toString() {
        return "res_rh{" + "Id_RH=" + Id_RH + '}';
    }

    
    
    
}
