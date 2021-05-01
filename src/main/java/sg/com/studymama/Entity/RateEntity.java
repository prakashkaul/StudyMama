package sg.com.studymama.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "rate")
public class RateEntity implements Serializable {
	
	private static final long serialVersionUID = -2379013249132428687L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATE_ID", length = 6)
    private Integer rateId; 
	
    @Column(name = "POST_ID", length = 6)
    private Integer postId; 
    
    @Column(name = "ACCOUNT_ID", length = 10)
    private Integer accountId;
    
    @Column(name = "rate_score", length = 250)
    private Integer rateScore;
    
    @Column(name = "RATE_DATE")
    private Timestamp rateDate;

	public Integer getRateId() {
		return rateId;
	}

	public void setRateId(Integer rateId) {
		this.rateId = rateId;
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

	public Integer getrateScore() {
		return rateScore;
	}

	public void setrateScore(Integer rateScore) {
		this.rateScore = rateScore;
	}

	public Timestamp getRateDate() {
		return rateDate;
	}

	public void setRateDate(Timestamp rateDate) {
		this.rateDate = rateDate;
	}

}
