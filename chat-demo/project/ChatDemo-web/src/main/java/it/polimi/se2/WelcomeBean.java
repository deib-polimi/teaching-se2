package it.polimi.se2;

import it.polimi.se2.beans.Word;
import it.polimi.se2.entities.WordEntity;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("wilcommen")
@RequestScoped
public class WelcomeBean {
	@Inject private Word wb;

	public String getLol() {
		return "LOL";
	}

	public List<WordEntity> getAll() {
		List<WordEntity> l = wb.all();
		return l;
	}
}
