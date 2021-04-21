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
@Table(name = "comment")
public class CommentEntity implements Serializable {
	
	private static final long serialVersionUID = -2379013249132428687L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", length = 6)
    private Integer commentId; 
	
    @Column(name = "POST_ID", length = 6)
    private Integer postId; 
    
    @Column(name = "ACCOUNT_ID", length = 10)
    private Integer accountId;
    
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
   
    @Column(name = "COMMENT_DATE")
    private Timestamp commentDate;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

}
