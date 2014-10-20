package it.polimi.se2;

import it.polimi.se2.beans.Word;
import it.polimi.se2.entities.WordEntity;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ManagedBean(name="welcome", eager=true)
@RequestScoped
public class WelcomeBean {
	@Inject Word wb;

	// @PostConstruct
	// public void init(){
	// System.out.println("POST CONSTRUCT CALLED");
	// try {
	// InitialContext ic = new InitialContext();
	// wb = (Word) ic.lookup(Word.class.getName());
	// } catch (NamingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	public String getLol() {
		return "LOL";
	}

	public List<WordEntity> getAll() {
		 System.out.println("#############");
		 WordEntity[] arr = {new WordEntity("ciao"),
		 new WordEntity("sono"),
		 new WordEntity("io")};
		 List<WordEntity> l = Arrays.asList(arr);
		//List<WordEntity> l = wb.all();
		for (WordEntity w : l) {
			System.out.println(w.getContent());
		}
		return l;
	}
}
