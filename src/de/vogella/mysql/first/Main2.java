package de.vogella.mysql.first;

import de.vogella.mysql.first.MySQLAccess;

public class Main2 {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}