package dacus.model.attention;

public class Notice extends AttentionElement {

	private final String notice;
	
	public Notice(String notice) {
		this.notice = notice;
	}
	
	public String getNotice() {
		return notice;
	}
	
}
