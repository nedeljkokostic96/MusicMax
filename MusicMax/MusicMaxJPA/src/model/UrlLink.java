package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the url_link database table.
 * 
 */
@Entity
@Table(name="url_link")
@NamedQuery(name="UrlLink.findAll", query="SELECT u FROM UrlLink u")
public class UrlLink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_URL;

	@Column(name="url_resource")
	private String urlResource;

	//bi-directional many-to-one association to FunFact
	@ManyToOne
	@JoinColumn(name="id_fun_fact")
	private FunFact funFact;

	//bi-directional many-to-one association to Song
	@ManyToOne
	@JoinColumn(name="id_song")
	private Song song;

	public UrlLink() {
	}

	public int getId_URL() {
		return this.id_URL;
	}

	public void setId_URL(int id_URL) {
		this.id_URL = id_URL;
	}

	public String getUrlResource() {
		return this.urlResource;
	}

	public void setUrlResource(String urlResource) {
		this.urlResource = urlResource;
	}

	public FunFact getFunFact() {
		return this.funFact;
	}

	public void setFunFact(FunFact funFact) {
		this.funFact = funFact;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}