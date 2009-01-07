package deus.model.contactprofile.proj.party;

import java.util.List;

public class PersonName {

	private String first;
	private String last;
	private List<String> additional;

	private List<String> prefixes;
	private List<String> suffixes;

	private String maiden;
	private String nick;
	
	
	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getLast() {
		return last;
	}


	public void setLast(String last) {
		this.last = last;
	}


	public List<String> getAdditional() {
		return additional;
	}


	public void setAdditional(List<String> additional) {
		this.additional = additional;
	}


	public List<String> getPrefixes() {
		return prefixes;
	}


	public void setPrefixes(List<String> prefixes) {
		this.prefixes = prefixes;
	}


	public List<String> getSuffixes() {
		return suffixes;
	}


	public void setSuffixes(List<String> suffixes) {
		this.suffixes = suffixes;
	}


	public String getMaiden() {
		return maiden;
	}


	public void setMaiden(String maiden) {
		this.maiden = maiden;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}

}
