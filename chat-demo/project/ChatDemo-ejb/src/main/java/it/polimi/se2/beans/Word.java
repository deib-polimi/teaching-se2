package it.polimi.se2.beans;

import it.polimi.se2.entities.WordEntity;

import java.util.List;

public interface Word {

	public WordEntity add(String word);
	public WordEntity get(Long id);
	public List<WordEntity> search(String filter);
	public void delete(Long id);
	public WordEntity update(Long id, String newContent);
	public WordEntity first();
	public List<WordEntity> all();
}
