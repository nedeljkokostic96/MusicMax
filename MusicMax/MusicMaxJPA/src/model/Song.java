package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@NamedQuery(name="Song.findAll", query="SELECT s FROM Song s")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_song")
	private int idSong;

	@Temporal(TemporalType.DATE)
	private Date released;

	@Column(name="text_song")
	private String textSong;

	private String title;

	//bi-directional many-to-one association to Grade
	@OneToMany(mappedBy="song")
	@JsonIgnore
	private List<Grade> grades;

	//bi-directional many-to-one association to Impression
	@OneToMany(mappedBy="song")
	@JsonIgnore
	private List<Impression> impressions;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	@JsonIgnore
	private Client client;

	//bi-directional many-to-one association to Creator
	@ManyToOne
	@JoinColumn(name="id_author")
	@JsonIgnore
	private Creator creator1;

	//bi-directional many-to-one association to Creator
	@ManyToOne
	@JoinColumn(name="id_composer")
	@JsonIgnore
	private Creator creator2;

	//bi-directional many-to-one association to Performer
	@ManyToOne
	@JoinColumn(name="id_performer")
	@JsonIgnore
	private Performer performer;

	//bi-directional many-to-one association to SongHasGenre
	@OneToMany(mappedBy="song")
	@JsonIgnore
	private List<SongHasGenre> songHasGenres;

	//bi-directional many-to-one association to UrlLink
	@OneToMany(mappedBy="song")
	@JsonIgnore
	private List<UrlLink> urlLinks;

	public Song() {
	}

	public int getIdSong() {
		return this.idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public Date getReleased() {
		return this.released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public String getTextSong() {
		return this.textSong;
	}

	public void setTextSong(String textSong) {
		this.textSong = textSong;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Grade addGrade(Grade grade) {
		getGrades().add(grade);
		grade.setSong(this);

		return grade;
	}

	public Grade removeGrade(Grade grade) {
		getGrades().remove(grade);
		grade.setSong(null);

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
		impression.setSong(this);

		return impression;
	}

	public Impression removeImpression(Impression impression) {
		getImpressions().remove(impression);
		impression.setSong(null);

		return impression;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Creator getCreator1() {
		return this.creator1;
	}

	public void setCreator1(Creator creator1) {
		this.creator1 = creator1;
	}

	public Creator getCreator2() {
		return this.creator2;
	}

	public void setCreator2(Creator creator2) {
		this.creator2 = creator2;
	}

	public Performer getPerformer() {
		return this.performer;
	}

	public void setPerformer(Performer performer) {
		this.performer = performer;
	}

	public List<SongHasGenre> getSongHasGenres() {
		return this.songHasGenres;
	}

	public void setSongHasGenres(List<SongHasGenre> songHasGenres) {
		this.songHasGenres = songHasGenres;
	}

	public SongHasGenre addSongHasGenre(SongHasGenre songHasGenre) {
		getSongHasGenres().add(songHasGenre);
		songHasGenre.setSong(this);

		return songHasGenre;
	}

	public SongHasGenre removeSongHasGenre(SongHasGenre songHasGenre) {
		getSongHasGenres().remove(songHasGenre);
		songHasGenre.setSong(null);

		return songHasGenre;
	}

	public List<UrlLink> getUrlLinks() {
		return this.urlLinks;
	}

	public void setUrlLinks(List<UrlLink> urlLinks) {
		this.urlLinks = urlLinks;
	}

	public UrlLink addUrlLink(UrlLink urlLink) {
		getUrlLinks().add(urlLink);
		urlLink.setSong(this);

		return urlLink;
	}

	public UrlLink removeUrlLink(UrlLink urlLink) {
		getUrlLinks().remove(urlLink);
		urlLink.setSong(null);

		return urlLink;
	}

}