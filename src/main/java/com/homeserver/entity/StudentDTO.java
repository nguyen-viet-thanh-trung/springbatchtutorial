package com.homeserver.entity;

/**
 * Created by trung on 03/02/17.
 */
public class StudentDTO {
    private String name;
    private String email;
    private String purchasedPackage;

    public StudentDTO() {
    }

    public StudentDTO(String name, String email, String purchasedPackage) {
        this.name = name;
        this.email = email;
        this.purchasedPackage = purchasedPackage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurchasedPackage() {
        return purchasedPackage;
    }

    public void setPurchasedPackage(String purchasedPackage) {
        this.purchasedPackage = purchasedPackage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
                .append(" email: ").append(email)
                .append(" purchasedPackage").append(purchasedPackage);
        return sb.toString();
    }
}
