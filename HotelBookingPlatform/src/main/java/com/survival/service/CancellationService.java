package com.survival.service;

import java.sql.SQLException;

public interface CancellationService {
	boolean isCancelled(int reservationId) throws ClassNotFoundException,SQLException;
}
