package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private int idClient;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="birth_date")
	private Date birthDate;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="client")
	private List<Comment> comments;

	//bi-directional many-to-one association to Festival
	@OneToMany(mappedBy="client")
	private List<Festival> festivals;

	//bi-directional many-to-one association to FestivalComment
	@OneToMany(mappedBy="client")
	private List<FestivalComment> festivalComments;

	//bi-directional many-to-one association to ForumTopic
	@OneToMany(mappedBy="client")
	private List<ForumTopic> forumTopics;

	//bi-directional many-to-one association to Grade
	@OneToMany(mappedBy="client")
	private List<Grade> grades;

	//bi-directional many-to-one association to Impression
	@OneToMany(mappedBy="client")
	private List<Impression> impressions;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setClient(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setClient(null);

		return comment;
	}

	public List<Festival> getFestivals() {
		return this.festivals;
	}

	public void setFestivals(List<Festival> festivals) {
		this.festivals = festivals;
	}

	public Festival addFestival(Festival festival) {
		getFestivals().add(festival);
		festival.setClient(this);

		return festival;
	}

	public Festival removeFestival(Festival festival) {
		getFestivals().remove(festival);
		festival.setClient(null);

		return festival;
	}

	public List<FestivalComment> getFestivalComments() {
		return this.festivalComments;
	}

	public void setFestivalComments(List<FestivalComment> festivalComments) {
		this.festivalComments = festivalComments;
	}

	public FestivalComment addFestivalComment(FestivalComment festivalComment) {
		getFestivalComments().add(festivalComment);
		festivalComment.setClient(this);

		return festivalComment;
	}

	public FestivalComment removeFestivalComment(FestivalComment festivalComment) {
		getFestivalComments().remove(festivalComment);
		festivalComment.setClient(null);

		return festivalComment;
	}

	public List<ForumTopic> getForumTopics() {
		return this.forumTopics;
	}

	public void setForumTopics(List<ForumTopic> forumTopics) {
		this.forumTopics = forumTopics;
	}

	public ForumTopic addForumTopic(ForumTopic forumTopic) {
		getForumTopics().add(forumTopic);
		forumTopic.setClient(this);

		return forumTopic;
	}

	public ForumTopic removeForumTopic(ForumTopic forumTopic) {
		getForumTopics().remove(forumTopic);
		forumTopic.setClient(null);

		return forumTopic;
	}

	public List<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Grade addGrade(Grade grade) {
		getGrades().add(grade);
		grade.setClient(this);

		return grade;
	}

	public Grade removeGrade(Grade grade) {
		getGrades().remove(grade);
		grade.setClient(null);

		return grade;
	}

	public List<Impression> getImpressions() {
		return this.impressions;
	}

	public void setImpressions(List<Impression> impressions) {
		this.impressions = impressions;
	}

	public Impression addImpression(Impression impression) {
		getImpressions().add(impression);
		impression.setClient(this);

		return impression;
	}

	public Impression removeImpression(Impression impression) {
		getImpressions().remove(impression);
		impression.setClient(null);

		return impression;
	}

}