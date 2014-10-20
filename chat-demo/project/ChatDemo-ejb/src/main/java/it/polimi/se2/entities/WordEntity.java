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

import lombok.Data;

@Entity
@NamedQueries({
		@NamedQuery(name = "Word.search", query = "SELECT DISTINCT w "
				+ "FROM WordEntity w WHERE w.content LIKE '%:filter%'"),
		@NamedQuery(name = "Word.all", query = "SELECT DISTINCT w from WordEntity w") })
@Table(name = "Word")
@Data public class WordEntity implements Serializable {
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

	@NotNull
	private Date createdAt;
}
