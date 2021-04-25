package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the festival_comment database table.
 * 
 */
@Entity
@Table(name="festival_comment")
@NamedQuery(name="FestivalComment.findAll", query="SELECT f FROM FestivalComment f")
public class FestivalComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_festival_comment")
	private int idFestivalComment;

	private String text;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Festival
	@ManyToOne
	@JoinColumn(name="id_festival")
	private Festival festival;

	public FestivalComment() {
	}

	public int getIdFestivalComment() {
		return this.idFestivalComment;
	}

	public void setIdFestivalComment(int idFestivalComment) {
		this.idFestivalComment = idFestivalComment;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Festival getFestival() {
		return this.festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

}