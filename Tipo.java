package enums;

public enum Tipo {
	REALITY_SHOWS("Reality Show"),
	SERIES_REGULARES("Serie Regular"),
	PROGRAMAS_CONTINUOS("Programa Continuo");
	
	private String descricao;
	
	private Tipo(String d) {
		this.descricao = d;
	}
	public String getDescricao() {
		return descricao;
	}
	public static Tipo of(String s) {
		for(Tipo a: Tipo.values()) {
			if(a.getDescricao().equalsIgnoreCase(s))
				return a;
		}
		return null;
	}
}
