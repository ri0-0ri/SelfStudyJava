package model.dto;

public class HotelDTO {
	private String hotelid;
	private String hotelname;
	
	public HotelDTO(String hotelid, String hotelname) {
		this.hotelid = hotelid;
		this.hotelname = hotelname;
	}

	public String getHotelid() {
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	
	
}
