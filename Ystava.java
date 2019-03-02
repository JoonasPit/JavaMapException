public class Ystava{
	
	
	public String fullName;
	public String nickName;
	public String phoneNr;
	public String birthDay;

	public Ystava() {
		fullName = "";
		nickName = "";
		phoneNr = "";
		birthDay = null;
	}
	public Ystava(String fullName, String nickName, String phoneNr, String birthDay){
		this.fullName = fullName;
		this.nickName = nickName;
		this.phoneNr = phoneNr;
		this.birthDay = birthDay;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setPhone(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getFullName() {
		return fullName;
	}
	public String getNickName() {
		return nickName;
	}
	public String getPhone() {
		return phoneNr;
	}
	public String getBirthDay() {
		return birthDay;
	}
	
	public String toString() {
		return "lempinimi= " + nickName + ", nimi= " + fullName + ", puhelin= " + phoneNr
				+ ", syntpvm= " + birthDay;
	}


}
