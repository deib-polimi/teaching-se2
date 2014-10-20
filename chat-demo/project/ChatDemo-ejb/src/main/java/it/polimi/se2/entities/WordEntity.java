package it.polimi.se2.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
		@NamedQuery(name = "Word.search", query = "SELECT DISTINCT w "
				+ "FROM WordEntity w WHERE w.content LIKE '%:filter%'"),
		@NamedQuery(name = "Word.all", query = "SELECT DISTINCT w from WordEntity w") })
@Table(name = "Word")
public class WordEntity implements Serializable {
	public WordEntity() {
		super();
		this.content = "empty_word";
		this.createdAt = new Date((new java.util.Date()).getTime());
	}

	public WordEntity(String content) {
		super();
		this.content = content;
		this.createdAt = new Date((new java.util.Date()).getTime());
	}

	private static final long serialVersionUID = -2979048530473922024L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String content;

	private Date createdAt;

	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
