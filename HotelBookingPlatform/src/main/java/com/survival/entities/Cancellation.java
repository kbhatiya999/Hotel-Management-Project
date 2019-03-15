package com.survival.entities;

import java.util.Date;

public class Cancellation {
             private int reservationId;
             private Date cancellationDate;
             private int chargeSlab;
             
			public Cancellation() {
				super();
			}

			public Cancellation(int reservationId, Date cancellationDate, int chargeSlab) {
				super();
				this.reservationId = reservationId;
				this.cancellationDate = cancellationDate;
				this.chargeSlab = chargeSlab;
			}

			public int getReservationId() {
				return reservationId;
			}

			public void setReservationId(int reservationId) {
				this.reservationId = reservationId;
			}

			public Date getCancellationDate() {
				return cancellationDate;
			}

			public void setCancellationDate(Date cancellationDate) {
				this.cancellationDate = cancellationDate;
			}

			public int getChargeSlab() {
				return chargeSlab;
			}

			public void setChargeSlab(int chargeSlab) {
				this.chargeSlab = chargeSlab;
			}

			
             
}
