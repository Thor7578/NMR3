package com.example.demo.repositories;

import com.example.demo.models.Motorhome;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepoImpl implements IMotorhomeRepo {
    private Connection conn;

    public MotorhomeRepoImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Motorhome motorhome) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Motorhomes" +
                    " VALUES ('" +
                    motorhome.getLicensePlate() + "','" +
                    motorhome.getModel() + "','" +
                    motorhome.getBeds() + "','" +
                    motorhome.getPricePerDay() + "','" + "');");
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Motorhome read(int mID) {
        Motorhome motorhomeToReturn = new Motorhome();
        try {
            PreparedStatement getSingleMotorhome = conn.prepareStatement("SELECT * FROM Motorhomes WHERE id='" + mID + "'");
            ResultSet rs = getSingleMotorhome.executeQuery();
            while(rs.next()){
                motorhomeToReturn = new Motorhome();
                motorhomeToReturn.setModel(rs.getString(1));
                motorhomeToReturn.setModel(rs.getString(2));
                motorhomeToReturn.setModel(rs.getString(3));
                motorhomeToReturn.setModel(rs.getString(4));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return motorhomeToReturn;

    }

    @Override
    public List<Motorhome> readAll() {
        List<Motorhome> allMotorhomes = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Motorhomes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Motorhome tempMotorhome = new Motorhome();
                tempMotorhome.setID(rs.getInt(1));
                tempMotorhome.setLicensePlate(rs.getString(2));
                tempMotorhome.setModel(rs.getString(3));
                tempMotorhome.setBeds(rs.getInt(4));
                tempMotorhome.setPrice((int) rs.getDouble(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorhomes;
    }

    @Override
    public boolean update(Motorhome motorhome) {
        return false;
    }

    @Override
    public boolean delete(int mID) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Motorhomes WHERE MotorhomeID='" + mID + "';");
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
