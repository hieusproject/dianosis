/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author VanHau
 */
public class CareerType {
    private int caree_id;
    private String carrer_title,career_description;

    public CareerType(int caree_id, String carrer_title, String career_description) {
        this.caree_id = caree_id;
        this.carrer_title = carrer_title;
        this.career_description = career_description;
    }

    public void setCaree_id(int caree_id) {
        this.caree_id = caree_id;
    }

    public void setCarrer_title(String carrer_title) {
        this.carrer_title = carrer_title;
    }

    public void setCareer_description(String career_description) {
        this.career_description = career_description;
    }

    public int getCaree_id() {
        return caree_id;
    }

    public String getCarrer_title() {
        return carrer_title;
    }

    public String getCareer_description() {
        return career_description;
    }
}
