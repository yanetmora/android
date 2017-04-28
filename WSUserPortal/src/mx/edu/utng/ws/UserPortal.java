package mx.edu.utng.ws;

public class UserPortal {
	
	private int id;
	private String portal;
	private String userPortall;
	private String createDate;
	private String Autorised;
	private String isdeleted;
	private String refreshRoles;
	
	
	



	public UserPortal(int id, String portal, String userPortall, String createDate, String autorised, String isdeleted,
			String refreshRoles) {
		super();
		this.id = id;
		this.portal = portal;
		this.userPortall = userPortall;
		this.createDate = createDate;
		this.Autorised = autorised;
		this.isdeleted = isdeleted;
		this.refreshRoles = refreshRoles;
	}






	public UserPortal(){
		this(0, "","","","","","");
		
	}






	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPortal() {
		return portal;
	}



	public void setPortal(String portal) {
		this.portal = portal;
	}



	public String getUserPortall() {
		return userPortall;
	}



	public void setUserPortall(String userPortall) {
		this.userPortall = userPortall;
	}



	public String getCreateDate() {
		return createDate;
	}



	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	public String getAutorised() {
		return Autorised;
	}



	public void setAutorised(String autorised) {
		Autorised = autorised;
	}



	public String getIsdeleted() {
		return isdeleted;
	}



	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}



	public String getRefreshRoles() {
		return refreshRoles;
	}



	public void setRefreshRoles(String refreshRoles) {
		this.refreshRoles = refreshRoles;
	}



	@Override
	public String toString() {
		return "UserPortals [id=" + id + ", portal=" + portal + ", userPortall=" + userPortall + ", createDate="
				+ createDate + ", Autorised=" + Autorised + ", isdeleted=" + isdeleted + ", refreshRoles="
				+ refreshRoles + "]";
	}

	
	
	
	
	
}