package com.survival.persistence;

import com.survival.entities.Package;
import com.survival.dbutils.DatabaseUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PackageDao_Impl implements PackageDao {

    private DatabaseUtils dbutils;

    public PackageDao_Impl() {
        this.dbutils = new DatabaseUtils();
    }

    public boolean insert(Package pack) throws SQLException{
        return dbutils.insertPackage(pack);
    }

    public boolean delete(Integer packageID) throws SQLException{
        return dbutils.deletePackage(packageID);
    }

    public Package search(Integer packageID) throws SQLException{
        return dbutils.searchPackage(packageID);
    }

    public ResultSet getAll() throws SQLException{
        return dbutils.getAllPackages();
    }

}
