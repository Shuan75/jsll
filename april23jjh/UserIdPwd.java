package april23jjh;

public class UserIdPwd {
	private String id;
	private String pwd;

	// 은닉된 변수에 데이터를 넣어주는 method를 만듬(setter)
	
	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}
	
	
}
