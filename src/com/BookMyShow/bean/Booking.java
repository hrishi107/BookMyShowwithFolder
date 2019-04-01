package com.BookMyShow.bean;

import java.util.Date;

public class Booking {
private long bookingId;
private long fkbooking_seatstableid;
private long fkbooking_theaterscreenid;
private long fkbooking_userinfoid;
private String seatnumber;
private String status;
private Date bookingdate;

public long getBookingId() {
	return bookingId;
}
public void setBookingId(long bookingId) {
	this.bookingId = bookingId;
}
public long getFkbooking_seatstableid() {
	return fkbooking_seatstableid;
}
public void setFkbooking_seatstableid(long fkbooking_seatstableid) {
	this.fkbooking_seatstableid = fkbooking_seatstableid;
}
public long getFkbooking_theaterscreenid() {
	return fkbooking_theaterscreenid;
}
public void setFkbooking_theaterscreenid(long fkbooking_theaterscreenid) {
	this.fkbooking_theaterscreenid = fkbooking_theaterscreenid;
}
public long getFkbooking_userinfoid() {
	return fkbooking_userinfoid;
}
public void setFkbooking_userinfoid(long fkbooking_userinfoid) {
	this.fkbooking_userinfoid = fkbooking_userinfoid;
}
public String getSeatnumber() {
	return seatnumber;
}
public void setSeatnumber(String seatnumber) {
	this.seatnumber = seatnumber;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getBookingdate() {
	return bookingdate;
}
public void setBookingdate(Date bookingdate) {
	this.bookingdate = bookingdate;
}


}
