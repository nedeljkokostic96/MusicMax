package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_genre")
	private int idGenre;

	private String name;

	//bi-directional many-to-one association to SongHasGenre
	@OneToMany(mappedBy="genre")
	private List<SongHasGenre> songHasGenres;

	public Genre() {
	}

	public int getIdGenre() {
		return this.idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SongHasGenre> getSongHasGenres() {
		return this.songHasGenres;
	}

	public void setSongHasGenres(List<SongHasGenre> songHasGenres) {
		this.songHasGenres = songHasGenres;
	}

	public SongHasGenre addSongHasGenre(SongHasGenre songHasGenre) {
		getSongHasGenres().add(songHasGenre);
		songHasGenre.setGenre(this);

		return songHasGenre;
	}

	public SongHasGenre removeSongHasGenre(SongHasGenre songHasGenre) {
		getSongHasGenres().remove(songHasGenre);
		songHasGenre.setGenre(null);

		return songHasGenre;
	}

}