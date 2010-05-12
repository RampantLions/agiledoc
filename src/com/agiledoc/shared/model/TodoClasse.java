package com.agiledoc.shared.model;

import java.io.Serializable;

public class TodoClasse implements Comparable<TodoClasse>, Serializable {

	private Classe classe;

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public int compareTo(TodoClasse todoClasse) {

		return new Integer(getClasse().getPriority()).compareTo(todoClasse
				.getClasse().getPriority());
	}

}
