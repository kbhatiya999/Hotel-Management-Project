*DBUtils*
---------

A set of utilities for the database operations required by the project.

NOTE : PLEASE FOLLOW THE SAME NAMES AS GIVEN HERE WHEN CREATING DATABASE COLUMNS!!


Usage Example
-------------
    class ReservationDao_Impl implements ReservationDao {

        private DatabaseUtils dbutils;

        public ReservationDao_Impl(){
            dbutils = new DatabaseUtils();
        }

        // Simple 1 line implementation logic
        public boolean insert(Reservation reservation) {
            return dbutils.insertBooking(reservation);
        }

        public boolean delete(int resID) {
            return dbutils.deleteBooking(resID);
        }

        public boolean search(int resID) {
            return dbutils.searchBooking(resID);
        }

        public ResultSet getAll() {
            return dbutils.getAllReservations();
        }

    }
