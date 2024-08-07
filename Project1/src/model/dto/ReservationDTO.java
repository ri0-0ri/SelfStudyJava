package model.dto;

public class ReservationDTO {
	private int reserNum;
	private String userid;
	private int hotelid;
	private int roomid;
	private String checkindate;
	private String checkoutdate;
	private int period;
	private int poolcount;
	private int gymcount;
	private int amount;

public ReservationDTO() {}

public ReservationDTO(int reserNum, String userid, int hotelid, int roomid, String checkindate, String checkoutdate,
		int period, int poolcount, int gymcount, int amount) {
	this.reserNum = reserNum;
	this.userid = userid;
	this.hotelid = hotelid;
	this.roomid = roomid;
	this.checkindate = checkindate;
	this.checkoutdate = checkoutdate;
	this.period = period;
	this.poolcount = poolcount;
	this.gymcount = gymcount;
	this.amount = amount;
}

public ReservationDTO(String userid, int hotelid, int roomid, String checkindate, String checkoutdate, int period,
		int poolcount, int gymcount, int amount) {
	super();
	this.userid = userid;
	this.hotelid = hotelid;
	this.roomid = roomid;
	this.checkindate = checkindate;
	this.checkoutdate = checkoutdate;
	this.period = period;
	this.poolcount = poolcount;
	this.gymcount = gymcount;
	this.amount = amount;
}

public int getReserNum() {
	return reserNum;
}

public void setReserNum(int reserNum) {
	this.reserNum = reserNum;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public int getHotelid() {
	return hotelid;
}

public void setHotelid(int hotelid) {
	this.hotelid = hotelid;
}

public int getRoomid() {
	return roomid;
}

public void setRoomid(int roomid) {
	this.roomid = roomid;
}

public String getCheckindate() {
	return checkindate;
}

public void setCheckindate(String checkindate) {
	this.checkindate = checkindate;
}

public String getCheckoutdate() {
	return checkoutdate;
}

public void setCheckoutdate(String checkoutdate) {
	this.checkoutdate = checkoutdate;
}

public int getPeriod() {
	return period;
}

public void setPeriod(int period) {
	this.period = period;
}

public int getPoolcount() {
	return poolcount;
}

public void setPoolcount(int poolcount) {
	this.poolcount = poolcount;
}

public int getGymcount() {
	return gymcount;
}

public void setGymcount(int gymcount) {
	this.gymcount = gymcount;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

}