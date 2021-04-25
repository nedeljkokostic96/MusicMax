package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the performer database table.
 * 
 */
@Entity
@NamedQuery(name="Performer.findAll", query="SELECT p FROM Performer p")
public class Performer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_performer")
	private int idPerformer;

	@Column(name="band_name")
	private String bandName;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="performer")
	private List<Song> songs;

	public Performer() {
	}

	public int getIdPerformer() {
		return this.idPerformer;
	}

	public void setIdPerformer(int idPerformer) {
		this.idPerformer = idPerformer;
	}

	public String getBandName() {
		return this.bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
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

	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Song addSong(Song song) {
		getSongs().add(song);
		song.setPerformer(this);

		return song;
	}

	public Song removeSong(Song song) {
		getSongs().remove(song);
		song.setPerformer(null);

		return song;
	}

}