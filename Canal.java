package classes;

public class Canal {
	private String nome, tipo;
	public Canal() {
		
	}
	public Canal(String n, String t) {
		this.nome = n;
		this.tipo = t;
	}
	public String toString() {
		return nome;
	}
	public boolean equals(Canal c) {
		if(c.nome.equalsIgnoreCase(nome))
			return true;
		return false;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String novoTipo) {
		this.tipo = novoTipo;
	}
}
