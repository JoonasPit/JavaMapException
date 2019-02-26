public class Opintojakso {
	
	private String tunnus;
	private String nimi;
	private int laajuus;
	
	
	public Opintojakso(String tunnus, String nimi, int laajuus){
		this.tunnus = tunnus;
		this.nimi = nimi;
		this.laajuus = laajuus;
	}
	
	public void setTunnus(String tunnus){
		this.tunnus = tunnus;
	}
	public void setNimi(String nimi){
		this.nimi = nimi;
	}
	public void setLaajuus(int laajuus){
		this.laajuus = laajuus;
	}
	public String getTunnus(){
		return tunnus;
	}
	public String getNimi(){
		return nimi;
	}
	public int getLaajuus(){
		return laajuus;
	}
	public String toString() {
		return tunnus + ": " + nimi + " " + laajuus + " opintopistettä";
	}
	
}
