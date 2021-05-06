package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the festival database table.
 * 
 */
@Entity
@NamedQuery(name="Festival.findAll", query="SELECT f FROM Festival f")
public class Festival implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_festival")
	private int idFestival;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_begin")
	private Date dateBegin;

	@Column(name="date_end")
	private String dateEnd;

	private String description;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_administrator")
	private Client client;

	//bi-directional many-to-one association to FestivalComment
	@OneToMany(mappedBy="festival")
	private List<FestivalComment> festivalComments;

	public Festival() {
	}

	public int getIdFestival() {
		return this.idFestival;
	}

	public void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
	}

	public Date getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<FestivalComment> getFestivalComments() {
		return this.festivalComments;
	}

	public void setFestivalComments(List<FestivalComment> festivalComments) {
		this.festivalComments = festivalComments;
	}

	public FestivalComment addFestivalComment(FestivalComment festivalComment) {
		getFestivalComments().add(festivalComment);
		festivalComment.setFestival(this);

		return festivalComment;
	}

	public FestivalComment removeFestivalComment(FestivalComment festivalComment) {
		getFestivalComments().remove(festivalComment);
		festivalComment.setFestival(null);

		return festivalComment;
	}

}