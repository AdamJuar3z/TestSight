package com.dealership.demo.models.repositories;


import com.dealership.demo.models.services.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class VehicleRepository {
    //Dependency
    //Without this, we can't connect to the database
    private final DataSource dataSource;

    //Autowired says, go and get me a copy of this
    @Autowired
    public VehicleRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Vehicle> getAllVehicles() {
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vehicles.add(new Vehicle(rs.getInt("VIN"), rs.getInt("Year"),
                        rs.getString("Make"), rs.getString("Model"), rs.getString("Color"),
                        rs.getString("VehicleType"), rs.getInt("Odometer"), rs.getDouble("Price")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    //C/R/UD The R in crud stands for read
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE price BETWEEN ? AND ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(mapResultSetToVehicle(rs));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }


    //R
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE make = ? AND model = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, make);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    //R
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE year BETWEEN ? AND ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    //R
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE color = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, color);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    //R
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE odometer BETWEEN ? AND ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    //R
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE vehicleType = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vehicleType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehicles.add(mapResultSetToVehicle(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    //C/RUD C is created or add
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO Vehicle (VIN, year, make, model, vehicleType, color, odometer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, vehicle.getVin());
            ps.setInt(2, vehicle.getYear());
            ps.setString(3, vehicle.getMake());
            ps.setString(4, vehicle.getModel());
            ps.setString(5, vehicle.getVehicleType());
            ps.setString(6, vehicle.getColor());
            ps.setInt(7, vehicle.getOdometer());
            ps.setDouble(8, vehicle.getPrice());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    //CRU/D is to delete or remove
    public void removeVehicle(String vin) {
        String sql = "DELETE FROM Vehicle WHERE VIN = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vin);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private Vehicle mapResultSetToVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(
                rs.getInt("VIN"),
                rs.getInt("year"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getString("vehicleType"),
                rs.getString("color"),
                rs.getInt("odometer"),
                rs.getDouble("price")
        );
    }
}













