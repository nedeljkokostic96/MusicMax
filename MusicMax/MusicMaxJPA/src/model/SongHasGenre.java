package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the song_has_genre database table.
 * 
 */
@Entity
@Table(name="song_has_genre")
@NamedQuery(name="SongHasGenre.findAll", query="SELECT s FROM SongHasGenre s")
public class SongHasGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_song_has_genre")
	private int idSongHasGenre;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="id_genre")
	private Genre genre;

	//bi-directional many-to-one association to Song
	@ManyToOne
	@JoinColumn(name="id_song")
	private Song song;

	public SongHasGenre() {
	}

	public int getIdSongHasGenre() {
		return this.idSongHasGenre;
	}

	public void setIdSongHasGenre(int idSongHasGenre) {
		this.idSongHasGenre = idSongHasGenre;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}