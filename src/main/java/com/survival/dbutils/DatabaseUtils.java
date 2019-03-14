package com.survival.dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.survival.entities.Feedback;
import com.survival.entities.Guest;
import com.survival.entities.Hotel;
import com.survival.entities.Login;
import com.survival.entities.Package;
import com.survival.entities.Reservation;
import com.survival.entities.Room;
import com.survival.entities.User;

public class DatabaseUtils {

	// USAGE EXAMPLE :
	// DatabaseUtils dbUtils = new DatabaseUtils();
	// dbUtils.getAllBookings();
	// dbUtils.end();

	private Connection conn;

	public DatabaseUtils() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "tiger");
		}
		catch(ClassNotFoundException | SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	// To use connection if necessary
	public Connection getConn() { return conn; }

	// FEEDBACK START

	public boolean insertFeedback(Feedback feedback) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO FEEDBACK VALUES (?,?,?)");
		pState.setInt(1, feedback.getBookingID());
		pState.setDouble(2, feedback.getHotelRating());
		pState.setString(3, feedback.getFeedbackDescription());
		return pState.executeUpdate() > 0;
	}

	public boolean deleteFeedback(int bookingID) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM FEEDBACK WHERE BID=?");
		pState.setInt(1, bookingID);
		return pState.executeUpdate() > 0;
	}

	public Feedback searchFeedback(int bookingID) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM FEEDBACK WHERE BID="+bookingID);
		return new Feedback(rSet.getInt("BID"), rSet.getDouble("HRATING"), rSet.getString("FDESCRIPTION"));
	}

	public ResultSet getAllFeedback() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM FEEDBACK");
	}

	// FEEDBACK END

	// HOTEL START

	public boolean insertHotel(Hotel hotel) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("INSERT INTO HOTELS VALUES (?,?,?,?,?,?,?)");
		pState.setInt(1, hotel.getHotelID());
		pState.setString(2, hotel.getHotelCity());
		pState.setString(3, hotel.getHotelName());
		pState.setDouble(4, hotel.getHotelRating());
		pState.setString(5, hotel.getHotelAddress());
		pState.setInt(6, hotel.getNumOfRoomsInHotel());
		pState.setDouble(7, hotel.getHotelDiscount());
		return pState.executeUpdate() > 0;
	}

	public boolean deleteHotel(String hotelName) throws SQLException {
		PreparedStatement pState = conn.prepareStatement("DELETE FROM HOTELS WHERE HNAME=?");
		pState.setString(1, hotelName);
		return pState.executeUpdate() > 0;
	}

	public Hotel searchHotel(String hotelName) throws SQLException {
		Statement state = conn.createStatement();
		ResultSet rSet = state.executeQuery("SELECT * FROM HOTELS WHERE HNAME="+hotelName);
		return new Hotel(rSet.getInt("HID"), rSet.getString("HCITY"), rSet.getString("HNAME"), rSet.getDouble("HRATING"), rSet.getString("HADDR"), rSet.getInt("HNUMROOM"), rSet.getDouble("HDISCOUNT"));
	}

	public ResultSet getAllHotels() throws SQLException {
		Statement state = conn.createStatement();
		return state.executeQuery("SELECT * FROM HOTELS");
	}

	// HOTEL END
	
	// LOGIN START

		public boolean insertLogin(Login login) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("INSERT INTO LOGIN VALUES (?,?,?,?,?)");
			pState.setInt(1, login.getUserID());
			pState.setBoolean(2, login.getIsActive());
			pState.setInt(3, login.getUserRole());
			pState.setString(4, login.getUserName());
			pState.setString(5, login.getUserPassword());
			return pState.executeUpdate() > 0;
		}

		public boolean deleteLogin(String userName) throws SQLException {
			Login theLoginToSoftDelete = searchLogin(userName);
			theLoginToSoftDelete.setIsActive(false);
			return true;
		}

		public Login searchLogin(String userName) throws SQLException {
			Statement state = conn.createStatement();
			ResultSet rSet = state.executeQuery("SELECT * FROM LOGIN WHERE UNAME="+userName);
			return new Login(rSet.getInt("UID"), rSet.getBoolean("UISACTIVE"), rSet.getInt("UROLE"), rSet.getString("UNAME"), rSet.getString("UPASS"));
		}

		public ResultSet getAllLogins() throws SQLException {
			Statement state = conn.createStatement();
			return state.executeQuery("SELECT * FROM LOGIN");
		}

	// LOGIN END
	
	// PACKAGE START

		public boolean insertPackage(Package pack) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("INSERT INTO PACKAGES VALUES (?,?,?,?,?,?,?,?,?)");
			pState.setInt(1, pack.getPackageID());
			pState.setInt(2, pack.getHotelID());
			pState.setInt(3, pack.getReservationID());
			pState.setInt(4, pack.getPackageType());
			pState.setInt(5, pack.getPackageNumDays());
			pState.setDouble(6, pack.getPackagePrice());
			pState.setString(7, pack.getPackageDescription());
			pState.setString(8, pack.getPackageLocation());
			pState.setInt(9, pack.getPackageNumOfRoomsBooked());
			return pState.executeUpdate() > 0;
		}

		public boolean deletePackage(int packageID) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("DELETE FROM PACKAGES WHERE PID=?");
			pState.setInt(1, packageID);
			return pState.executeUpdate() > 0;
		}

		public Package searchPackage(int packageID) throws SQLException {
			Statement state = conn.createStatement();
			ResultSet rSet = state.executeQuery("SELECT * FROM PACKAGES WHERE PID="+packageID);
			return new Package(rSet.getInt("PID"), rSet.getInt("HID"), rSet.getInt("RID"), rSet.getInt("PTYPE"), rSet.getInt("PNUMDAYS"), rSet.getDouble("PPRICE"), rSet.getString("PDESCRIPTION"), rSet.getString("PLOCATION"), rSet.getInt("PNUMROOMSBOOKED"));
		}

		public ResultSet getAllPackages() throws SQLException {
			Statement state = conn.createStatement();
			return state.executeQuery("SELECT * FROM PACKAGES");
		}

	// PACKAGE END
		
	// RESERVATION START

		public boolean insertReservation(Reservation reservation) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("INSERT INTO RESERVATIONS VALUES (?,?,?,?,?,?,?,?,?,?)");
			pState.setInt(1, reservation.getReservationID());
			pState.setInt(2, reservation.getBookingID());
			pState.setInt(3, reservation.getUserID());
			pState.setInt(4, reservation.getHotelID());
			pState.setDate(5, (Date) reservation.getReservationCheckInDate());
			pState.setDate(6, (Date) reservation.getReservationCheckOutDate());
			pState.setDouble(7, reservation.getReservationBillAmount());
			pState.setString(8, reservation.getUserEmailID());
			pState.setInt(9, reservation.getPackageType());
			pState.setInt(10, reservation.getReservationStatus());
			return pState.executeUpdate() > 0;
		}

		public boolean deleteReservation(String userEmail) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("DELETE FROM RESERVATIONS WHERE UEMAILID=?");
			pState.setString(1, userEmail);
			return pState.executeUpdate() > 0;
		}

		public Reservation searchReservation(String userEmail) throws SQLException {
			Statement state = conn.createStatement();
			ResultSet rSet = state.executeQuery("SELECT * FROM RESERVATIONS WHERE UEMAILID="+userEmail);
			return new Reservation(rSet.getInt("RID"),rSet.getInt("BID"), rSet.getInt("UID"),rSet.getInt("HID"), rSet.getDate("RSTARTDATE"), rSet.getDate("RENDDATE"), rSet.getDouble("RBILLAMOUNT"), rSet.getString("UEMAILID"),  rSet.getInt("PTYPE"), rSet.getInt("RRESERVATIONSTATUS"));
		}

		public ResultSet getAllReservations() throws SQLException {
			Statement state = conn.createStatement();
			return state.executeQuery("SELECT * FROM RESERVATIONS");
		}
	// RESERVATION END
		
	// ROOM START

		public boolean insertRoom(Room room) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("INSERT INTO ROOMS VALUES (?,?,?,?,?)");
			pState.setInt(1, room.getRoomID());
			pState.setInt(2, room.getHotelID());
			pState.setInt(3, room.getRoomType());
			pState.setInt(4, room.getNumOfRooms());
			pState.setDouble(5, room.getRoomPrice());
			return pState.executeUpdate() > 0;
		}

		public boolean deleteRoom(int roomID) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("DELETE FROM ROOMS WHERE RID=?");
			pState.setInt(1, roomID);
			return pState.executeUpdate() > 0;
		}

		public Room searchRoom(int roomID) throws SQLException {
			Statement state = conn.createStatement();
			ResultSet rSet = state.executeQuery("SELECT * FROM ROOMS WHERE RID="+roomID);
			return new Room(rSet.getInt("RID"),rSet.getInt("HID"),rSet.getInt("RTYPE"),rSet.getInt("NUMOFROOMS"), rSet.getDouble("RPRICE"));
		}

		public ResultSet getAllRooms() throws SQLException {
			Statement state = conn.createStatement();
			return state.executeQuery("SELECT * FROM ROOMS");
		}

	// ROOM END
		
	// USER START

		public boolean insertUser(User user) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?,?,?)");
			pState.setInt(1, user.getUserID());
			pState.setString(2, user.getUserAddress());
			pState.setString(3, user.getUserPhoneNumber());
			pState.setString(4, user.getUserFullName());
			pState.setInt(5, user.getUserType());
			pState.setString(6, user.getUserEmail());
			return pState.executeUpdate() > 0;
		}

		public boolean deleteUser(String userFullName) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("DELETE FROM USERS WHERE UFULLNAME=?");
			pState.setString(1, userFullName);
			return pState.executeUpdate() > 0;
		}

		public User searchUser(String userFullName) throws SQLException {
			Statement state = conn.createStatement();
			ResultSet rSet = state.executeQuery("SELECT * FROM USERS WHERE UFULLNAME="+userFullName);
			return new User(rSet.getInt("UID"), rSet.getString("UADDR"), rSet.getString("UPHONENUM"), rSet.getString("UFULLNAME"), rSet.getInt("UTYPE"), rSet.getString("UEMAIL"));
		}

		public ResultSet getAllUsers() throws SQLException {
			Statement state = conn.createStatement();
			return state.executeQuery("SELECT * FROM USERS");
		}

	// USER END
	
	// GUEST START

		public boolean insertGuest(Guest guest) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("INSERT INTO GUESTS VALUES (?,?,?,?,?,?,?,?)");
			pState.setInt(1, guest.getGuestID());
			pState.setInt(2, guest.getBookingID());
			pState.setString(3, guest.getGuestName());
			pState.setString(4, guest.getGuestPhoneNumber());
			pState.setInt(5, guest.getBookedNumRooms());
			pState.setInt(6, guest.getGuestModeOfPayment());
			pState.setDouble(7, guest.getGuestBillAmount());
			pState.setString(8, guest.getGuestEmail());
			return pState.executeUpdate() > 0;
		}

		public boolean deleteGuest(String guestName) throws SQLException {
			PreparedStatement pState = conn.prepareStatement("DELETE FROM GUESTS WHERE GNAME=?");
			pState.setString(1, guestName);
			return pState.executeUpdate() > 0;
		}

		public Guest searchGuest(String guestName) throws SQLException {
			Statement state = conn.createStatement();
			ResultSet rSet = state.executeQuery("SELECT * FROM GUESTS WHERE GNAME="+guestName);
			return new Guest(rSet.getInt("GID"), rSet.getInt("BID"), rSet.getString("GNAME"), rSet.getString("GPHONENUM"), rSet.getInt("GNUMBOOKEDROOMS"), rSet.getInt("GMODEPAYMENT"), rSet.getDouble("GBILLAMOUNT"), rSet.getString("GEMAIL"));
		}

		public ResultSet getAllGuests() throws SQLException {
			Statement state = conn.createStatement();
			return state.executeQuery("SELECT * FROM GUESTS");
		}

	// GUEST END
	
	public void end() throws SQLException {
		conn.close();
	}


}
