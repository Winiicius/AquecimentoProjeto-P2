public class ProgramaDeTV {
	private long id;
	private String nome;
	private Canal canal;
	private Tipo tipo;
	private DiaDaSemana dia;
	
	public ProgramaDeTV(String s, Tipo t, DiaDaSemana d, Canal c) {
		id = System.currentTimeMillis();
		this.nome = s;
		this.tipo = t;
		this.dia = d;
		this.canal = c;
	}
	public boolean equals(ProgramaDeTV p) {
		CentralDeInformacoes cdi = new CentralDeInformacoes();
		for(ProgramaDeTV a: cdi.getTodosOsProgramasDeTV()) {
			if(p.id == a.id)
				return true;
		}	
		return false;
	}
	public String toString() {
		return nome;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public DiaDaSemana getDia() {
		return dia;
	}
	public void setDia(DiaDaSemana dia) {
		this.dia = dia;
	}
	public Canal getCanal() {
		return canal;
	}
	public void setCanal(Canal canal) {
		this.canal = canal;
	}
}
