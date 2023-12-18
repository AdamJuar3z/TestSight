package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Dealership;
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
public class DealershipRepository {
    private final DataSource dataSource;

    @Autowired
    public DealershipRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //CRUD functions for dealership
    //getAllDealerships, getDealershipById, createDealership, updateDealership, deleteDealership





    public List<Dealership> getAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String sql = "SELECT * FROM Dealership";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                dealerships.add(new Dealership(
                        rs.getString("NAME"),
                        rs.getString("address"),
                        rs.getString("phone")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dealerships;
    }

    // Read - Get Dealership By ID
    public Dealership getDealershipById(int dealershipId) {
        String sql = "SELECT * FROM Dealership WHERE dealership_id = ?";
        Dealership dealership = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dealershipId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dealership = new Dealership(
                        rs.getString("NAME"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dealership;
    }

    // Create - Add New Dealership
    public void createDealership(Dealership dealership) {
        String sql = "INSERT INTO Dealership (NAME, address, phone) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3, dealership.getPhone());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // Update - Modify Existing Dealership
    public void updateDealership(int dealershipId, Dealership dealership) {
        String sql = "UPDATE Dealership SET NAME = ?, address = ?, phone = ? WHERE dealership_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3, dealership.getPhone());
            ps.setInt(4, dealershipId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete - Remove Dealership
    public void deleteDealership(int dealershipId) {
        String sql = "DELETE FROM Dealership WHERE dealership_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dealershipId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}