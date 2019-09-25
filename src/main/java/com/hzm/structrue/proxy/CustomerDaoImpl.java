package com.hzm.structrue.proxy;

public class CustomerDaoImpl implements CustomerDao {
    public void select() {
        System.out.println("select...");
    }

    public void add() {
        System.out.println("add...");
    }

    public void delete() {
        System.out.println("delete...");
    }
}
