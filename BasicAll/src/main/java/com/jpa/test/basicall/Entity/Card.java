package com.jpa.test.basicall.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CardDetails")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String Name;
    @Column
    private String Email;
    @Column
    private String cardNO;

    public Card() {
    }

    public Card(int id, String name, String email, String c) {
        this.id = id;
        Name = name;
        Email = email;
        this.cardNO = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getC() {
        return cardNO;
    }

    public void setC(String c) {
        this.cardNO= c;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", c='" + cardNO + '\'' +
                '}';
    }
}