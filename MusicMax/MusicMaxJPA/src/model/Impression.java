package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the impression database table.
 * 
 */
@Entity
@NamedQuery(name="Impression.findAll", query="SELECT i FROM Impression i")
public class Impression implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_impression")
	private int idImpression;

	private String text;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Song
	@ManyToOne
	@JoinColumn(name="id_song")
	private Song song;

	public Impression() {
	}

	public int getIdImpression() {
		return this.idImpression;
	}

	public void setIdImpression(int idImpression) {
		this.idImpression = idImpression;
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

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}