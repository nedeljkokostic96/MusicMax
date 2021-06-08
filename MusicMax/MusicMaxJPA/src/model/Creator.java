package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the creator database table.
 * 
 */
@Entity
@NamedQuery(name="Creator.findAll", query="SELECT c FROM Creator c")
public class Creator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_creator")
	private int idCreator;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="creator1")
	@JsonIgnore
	private List<Song> songs1;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="creator2")
	@JsonIgnore
	private List<Song> songs2;

	public Creator() {
	}

	public int getIdCreator() {
		return this.idCreator;
	}

	public void setIdCreator(int idCreator) {
		this.idCreator = idCreator;
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

	public List<Song> getSongs1() {
		return this.songs1;
	}

	public void setSongs1(List<Song> songs1) {
		this.songs1 = songs1;
	}

	public Song addSongs1(Song songs1) {
		getSongs1().add(songs1);
		songs1.setCreator1(this);

		return songs1;
	}

	public Song removeSongs1(Song songs1) {
		getSongs1().remove(songs1);
		songs1.setCreator1(null);

		return songs1;
	}

	public List<Song> getSongs2() {
		return this.songs2;
	}

	public void setSongs2(List<Song> songs2) {
		this.songs2 = songs2;
	}

	public Song addSongs2(Song songs2) {
		getSongs2().add(songs2);
		songs2.setCreator2(this);

		return songs2;
	}

	public Song removeSongs2(Song songs2) {
		getSongs2().remove(songs2);
		songs2.setCreator2(null);

		return songs2;
	}

}