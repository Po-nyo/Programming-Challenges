package Q30;

public class Record implements Comparable<Record>{
	
	private String dateTime;
	private String detail;
	private String site;
	
	public Record(String dateTime, String detail, String site) {
		this.dateTime = dateTime;
		this.detail = detail;
		this.site = site;
	}

	@Override
	public int compareTo(Record o) {
		// TODO Auto-generated method stub
		return this.dateTime.compareTo(o.dateTime);
	}

	public String getDetail() {
		return detail;
	}

	public String getSite() {
		return site;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
}
