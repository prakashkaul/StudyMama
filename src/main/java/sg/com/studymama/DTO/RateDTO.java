package sg.com.studymama.DTO;

public class RateDTO {
	
	private Integer postId;
	private Integer accountId;
    private Integer rateId;
    private Integer rateScore;
    
	public RateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RateDTO(Integer postId, Integer accountId, Integer rateId, Integer rateScore) {
		super();
		this.postId = postId;
		this.accountId = accountId;
		this.rateId = rateId;
		this.rateScore = rateScore;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getRateId() {
		return rateId;
	}

	public void setRateId(Integer rateId) {
		this.rateId = rateId;
	}

	public Integer getRateScore() {
		return rateScore;
	}

	public void setRateScore(Integer rateScore) {
		this.rateScore = rateScore;
	}

}
