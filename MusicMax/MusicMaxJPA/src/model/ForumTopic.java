package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the forum_topic database table.
 * 
 */
@Entity
@Table(name="forum_topic")
@NamedQuery(name="ForumTopic.findAll", query="SELECT f FROM ForumTopic f")
public class ForumTopic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_forum_topic")
	private int idForumTopic;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String topic;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="forumTopic")
	private List<Comment> comments;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	public ForumTopic() {
	}

	public int getIdForumTopic() {
		return this.idForumTopic;
	}

	public void setIdForumTopic(int idForumTopic) {
		this.idForumTopic = idForumTopic;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setForumTopic(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setForumTopic(null);

		return comment;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}