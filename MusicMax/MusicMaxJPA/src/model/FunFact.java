package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fun_fact database table.
 * 
 */
@Entity
@Table(name="fun_fact")
@NamedQuery(name="FunFact.findAll", query="SELECT f FROM FunFact f")
public class FunFact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fun_fact")
	private int idFunFact;

	private String text;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_administrator")
	private Client client;

	//bi-directional many-to-one association to UrlLink
	@OneToMany(mappedBy="funFact")
	private List<UrlLink> urlLinks;

	public FunFact() {
	}

	public int getIdFunFact() {
		return this.idFunFact;
	}

	public void setIdFunFact(int idFunFact) {
		this.idFunFact = idFunFact;
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

	public List<UrlLink> getUrlLinks() {
		return this.urlLinks;
	}

	public void setUrlLinks(List<UrlLink> urlLinks) {
		this.urlLinks = urlLinks;
	}

	public UrlLink addUrlLink(UrlLink urlLink) {
		getUrlLinks().add(urlLink);
		urlLink.setFunFact(this);

		return urlLink;
	}

	public UrlLink removeUrlLink(UrlLink urlLink) {
		getUrlLinks().remove(urlLink);
		urlLink.setFunFact(null);

		return urlLink;
	}

}