package com.example.demo.repositories;

import com.example.demo.models.*;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepoImpl implements IOrderRepo {
    private Connection conn;

    public OrderRepoImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Order order) {
        return false;
    }

    @Override
    public Order read(int oID, Season season) {
        Order orderToReturn = new Order();

        orderToReturn.setSeason(season);

        Customer customer = new Customer();
        orderToReturn.setCustomer(customer);

        ArrayList<Motorhome> MHList = new ArrayList<Motorhome>();
        orderToReturn.setMotorhomesInOrder(MHList);

        ArrayList<Extra> EXList = new ArrayList<Extra>();
        orderToReturn.setExtrasList(EXList);

        Location location = new Location();
        orderToReturn.setDropOffLocation(location);

        Date endDate = new Date();
        Date startDate = new Date();

        orderToReturn.setEndDate(endDate);
        orderToReturn.setStartDate(startDate);

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT Orders.OrderID, Orders.CustomerCPR, c.CustomerName, c.DriversLicenseID, c.CreditCardNo, Orders.Seasons, do.DropOffLocation, l.CityName, l.StreetName, l.StreetNo, l.ZIPCode\n" +
                                                            "FROM Orders\n" +
                                                            "INNER JOIN Seasons s ON Orders.Seasons = s.SeasonID\n" +
                                                            "INNER JOIN DropOffs do ON Orders.OrderID = do.OrderID\n" +
                                                            "INNER JOIN Customers c ON Orders.CustomerCPR = c.CustomerCPR " +
                                                            "INNER JOIN Locations l ON do.DropOffLocation = l.LocationID" +
                                                            "WHERE orderID='" + oID +"';");
            ResultSet rs = ps.executeQuery();

            PreparedStatement MHinOrder = conn.prepareStatement("SELECT MotorhomeID FROM Motorhome_Orders WHERE OrderID='" + oID + "';");
            ResultSet MHOset = MHinOrder.executeQuery();

            PreparedStatement EXinOrder = conn.prepareStatement("SELECT Extras_orders.ExtraID, e.ExtraName, e.ExtraPrice\n" +
                                                                    "FROM Extras_Orders\n" +
                                                                    "INNER JOIN Extras e ON extras_orders.ExtraID = e.ExtraID\n" +
                                                                    "WHERE OrderID='" + oID + "';");
            ResultSet EXOset = EXinOrder.executeQuery();

            PreparedStatement dates = conn.prepareStatement("SELECT DAY(StartDate), MONTH(StartDate), YEAR(StartDate), DAY(EndDate), MONTH(EndDate), YEAR(EndDate) FROM Orders WHERE OrderID='" +oID + "';");
            ResultSet datesSet = dates.executeQuery();

            while(MHOset.next()){
                Motorhome motorhome = new Motorhome();
                motorhome.setID(MHOset.getInt(1));
                MHList.add(motorhome);
            }

            while(EXOset.next()){
                Extra extra = new Extra();
                extra.setExtraID(EXOset.getInt(1));
                extra.setExtraName(EXOset.getString(2));
                extra.setExtraPrice(EXOset.getDouble(3));
            }

            while(datesSet.next()){
                startDate.setDay(datesSet.getInt(1));
                startDate.setMonth(datesSet.getInt(2));
                startDate.setYear(datesSet.getInt(3));
                endDate.setDay(datesSet.getInt(4));
                endDate.setMonth(datesSet.getInt(5));
                endDate.setYear(datesSet.getInt(6));
            }

            while(rs.next()){
                orderToReturn.setOrderID(rs.getInt(1));
                customer.setCPR(rs.getString(2));
                customer.setName(rs.getString(3));
                customer.setDriverLicensID(rs.getString(4));
                customer.setCreditCardNo(rs.getString(5));
                location.setLocationID(rs.getInt(7));
                location.setCityName(rs.getString(8));
                location.setStreetName(rs.getString(9));
                location.setStreetNo(rs.getString(10));
                location.setZIPCode(rs.getInt(11));
            }
        } catch(SQLException s){
            s.printStackTrace();
        }

        return orderToReturn;
    }

    @Override
    public List<Order> readAll() {
        return null;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(int mID) {
        return false;
    }
}
