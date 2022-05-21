package enums;

public enum DiaDaSemana {
	SEGUNDA("2"),
	TERCA("3"),
	QUARTA("4"),
	QUINTA("5"),
	SEXTA("6"),
	SABADO("7"),
	DOMINGO("1");
	
private String descricao;

	private DiaDaSemana(String d) {	
		this.descricao = d;
	}
	public String getDescricao() {
		return descricao;
	}
	public static DiaDaSemana of(String s) {
		for(DiaDaSemana a: DiaDaSemana.values()) {
			if(a.getDescricao().equals(s))
				return a;
		}
		return null;
	}
}

