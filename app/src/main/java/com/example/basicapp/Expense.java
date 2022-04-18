package com.example.basicapp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Expense {

    @JsonProperty("description")
    String description;

    @JsonProperty("amount")
    int amount;

    @JsonProperty("date")
    Date date;

    @JsonProperty("payers")
    Map<String,Integer> payers;

    Expense(String descrption, int amount, Date date){
        this.description = descrption;
        this.amount = amount;
        this.date = date;
        payers = new HashMap<String, Integer>();
    }

    public int getAmount () {
        return this.amount;
    }
    public Integer getAmountSpentByUser(String userName) {

        return payers.get(userName);
    }

    public void AddNewPayer (String name, int amount) {
        payers.put(name,amount);
    }
    public void RemovePayer (String name) {
        payers.remove(name);
    }

    public String toString() {
        String info = "";
        info +="{";
        info +="\n - Expense: " + this.description;
        info +="\n - Amount: " + this.amount;
        info +="\n - Date: " + this.getDate();
        info +="\n - Payers: " + this.payers;
        info +="\n}";
        return info;
    }

    private String getDate () {
        String date = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = formatter.format(this.date);

        return date;
    }

}