package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import enums.Tipo;

public class CentralDeInformacoes {
	
	private ArrayList<ProgramaDeTV> todosOsProgramas = new ArrayList<ProgramaDeTV>();
	private ArrayList<Canal> canais = new ArrayList<Canal>();
	
	public boolean adicionarProgramaDeTV(ProgramaDeTV programa) {
		for(ProgramaDeTV a: todosOsProgramas) {
			if(programa.equals(a)) {
				return false;
			}
		}
		todosOsProgramas.add(programa);
		return true;
	}
	public String dadosProgramas(ProgramaDeTV p) {
		return "\nPrograma " + (getTodosOsProgramasDeTV().indexOf(p)+1)
				+ "\nNome: " + p.getNome() 
				+ "\nTipo: " + p.getTipo().getDescricao()
				+ "\nDia Da Semana: " + p.getDia()
				+ "\nCanal: " + p.getCanal().getNome()
				+ "\nID: " + p.getId() + "\n";
	}
	public ProgramaDeTV recuperarProgramaDeTVPeloId(long id) {
		
		for(ProgramaDeTV p: todosOsProgramas) {
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	public String recuperarProgramaDeTVPeloDia() {
		boolean temDia = false;
		String progs = "";
		Calendar calendario = Calendar.getInstance();
		for(ProgramaDeTV p: todosOsProgramas) {
			if(calendario.get(Calendar.DAY_OF_WEEK) == Integer.parseInt(p.getDia().getDescricao())) {
				progs += dadosProgramas(p);
			}
			temDia = true;
			
		}
		if(temDia == true)
			return progs;
		else
			return "Ainda Não Há nenhum Programa De TV Transmitido Nesse Dia";
	}
	public boolean adicionarCanal(Canal c) {
		for(Canal x: canais) {
			if(x.equals(c))
				return false;
		}
		canais.add(c);
		return true;
	}
	public Canal recuperarCanalPeloNome(String n) {
		for(Canal x: canais) {
			if(x.getNome().equalsIgnoreCase(n))
				return x;
		}
		return null;
	}
	public void listarTodosOsProgramas() {
		boolean temPrograma = false;
		for(ProgramaDeTV p: todosOsProgramas) {
			System.out.printf(dadosProgramas(p));
			temPrograma = true;
		}
		if(temPrograma == false)
			System.out.println("Ainda Não Temos Nenhum Programa Cadastrado.\n");
	}
	public void listarProgramasDeMesmoTipo(Tipo t) {
		boolean temPrograma = false;
		for(ProgramaDeTV p: todosOsProgramas) {	
			if(p.getTipo().equals(t)) {
				System.out.printf(dadosProgramas(p));
				
				temPrograma = true;
			}		
		}
		if(!temPrograma) 
			System.out.println("Ainda Não Temos Nenhum Programa Desse Tipo.\n");
	}
	public void listarTodosOsCanais() {	
		boolean temCanal = false;
		for (Canal c: canais) {
			System.out.printf("Canal %d:"
							+ "\nNome: " + c.getNome()
							+ "\nTipo: " + c.getTipo() + "\n\n", canais.indexOf(c)+1);
			temCanal = true;
		}
		if(!temCanal)
			System.out.println("Ainda Não Temos Nenhum Canal Cadastrado.\n");
	}
	public ArrayList<Canal> getCanais(){
		return this.canais;
	}
	public void setCanais(ArrayList<Canal> c) {
		this.canais = c;
	}
	public ArrayList<ProgramaDeTV> getTodosOsProgramasDeTV(){
		return this.todosOsProgramas;
	}
	public void setTodosOsProgramasDeTV(ArrayList<ProgramaDeTV> p) {
		this.todosOsProgramas = p;
	}
}