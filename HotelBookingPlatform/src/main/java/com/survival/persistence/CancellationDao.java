package com.survival.persistence;

import java.sql.SQLException;

public interface CancellationDao {
            int isCancelled(int reservationId) throws ClassNotFoundException,SQLException;
}
