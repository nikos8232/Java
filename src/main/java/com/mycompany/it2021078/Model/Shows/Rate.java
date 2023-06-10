package com.mycompany.it2021078.Model.Shows;

public class Rate {
    private String username;
    private int rate;

    public Rate(String username, int rate){
        this.username = username;
        this.rate = rate;
    }

    public String getUsername(){return this.username;}

    public int getRate() {return rate;}
    public void setUsername(String username){this.username = username;}
    public void setRate(int rate){this.rate = rate;}
}
