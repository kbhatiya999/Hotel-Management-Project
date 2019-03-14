*DBUtils*
---------

A set of utilities for the database operations required by the project.


Usage Example
-------------
class BookingDao_Impl implements BookingDao {

    private DatabaseUtils dbutils;

    public BookingDao_Impl(){
        dbutils = new DatabaseUtils();
    }

    // Simple 1 line implementation logic
    public boolean insert(Booking booking) {
        return dbutils.insertBooking(booking);
    }

    public boolean delete(Booking booking) {
        return dbutils.deleteBooking(booking);
    }

    public boolean search(Booking booking) {
        return dbutils.searchBooking(booking);
    }

    public LinkedList<Booking> getAll() {
        return dbutils.getAllBookings();
    }

}
