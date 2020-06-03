package com.example.demo.repositories;

import com.example.demo.models.Extra;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtrasRepoImpl implements ExtrasRepo {
    private Connection conn;

    public ExtrasRepoImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    public Extra read(String extraName) {
        Extra extraToReturn = new Extra();
        try {
            PreparedStatement getSingleExtra = conn.prepareStatement("SELECT * FROM extras WHERE extraName='" + extraName + "'");
            ResultSet rs = getSingleExtra.executeQuery();
            while(rs.next()){
                extraToReturn.setExtraPrice(Double.parseDouble(rs.getString(1)));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return extraToReturn;
    }


}
