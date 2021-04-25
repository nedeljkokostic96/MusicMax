package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comment")
	private int idComment;

	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int likes;

	private int unlikes;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client_added_comment")
	private Client client;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="id_comment_reply")
	private Comment commentBean;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="commentBean")
	private List<Comment> comments;

	//bi-directional many-to-one association to ForumTopic
	@ManyToOne
	@JoinColumn(name="id_forum_topic")
	private ForumTopic forumTopic;

	public Comment() {
	}

	public int getIdComment() {
		return this.idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLikes() {
		return this.likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getUnlikes() {
		return this.unlikes;
	}

	public void setUnlikes(int unlikes) {
		this.unlikes = unlikes;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Comment getCommentBean() {
		return this.commentBean;
	}

	public void setCommentBean(Comment commentBean) {
		this.commentBean = commentBean;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setCommentBean(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setCommentBean(null);

		return comment;
	}

	public ForumTopic getForumTopic() {
		return this.forumTopic;
	}

	public void setForumTopic(ForumTopic forumTopic) {
		this.forumTopic = forumTopic;
	}

}