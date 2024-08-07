package model.dto;

public class RoomDTO {
	private int roomid;
	private String room;
	private int price;

public RoomDTO() {}

public RoomDTO(int roomid, String room, int price) {
	this.roomid = roomid;
	this.room = room;
	this.price = price;	
}

public int getRoomid() {
	return roomid;
}

public void setRoomid(int roomid) {
	this.roomid = roomid;
}

public String getRoom() {
	return room;
}

public void setRoom(String room) {
	this.room = room;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

}

