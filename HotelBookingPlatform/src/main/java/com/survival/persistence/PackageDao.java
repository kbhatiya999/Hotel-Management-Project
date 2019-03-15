package com.survival.persistence;

import com.survival.entities.Package;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PackageDao {

    public boolean insert(Package pack) throws SQLException;

    public boolean delete(Integer pID) throws SQLException;

    public Package search(Integer pID) throws SQLException;

    public ResultSet getAll() throws SQLException;

}
