public class MainProgramasDeTV {
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		String opcao;
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes cdi = persistencia.recuperarCentral("central.xml") ;
		
		do {
			System.out.println("1 - Novo Programa\n"
							 + "2 - Listar Todos Os Programas\n"
							 + "3 - Listar Todos Os Programas De Um Mesmo Tipo\n"
							 + "4 - Novo Canal De Televisão\n"
							 + "5 - Listar Todos Os Canais\n"
							 + "6 - Gerar Relação Dos Programas De Um Mesmo Canal\n"
							 + "7 – enviar programação de hoje\n"
							 + "S - SAIR");
			opcao = ler.nextLine();
			switch(opcao) {
			
				case "1":
					
					if(cdi.getCanais().size()>0) {
						System.out.println("Qual o nome do programa que você que adicionar?");
						String nomePrograma = ler.nextLine().trim();
						if(nomePrograma.equals("")) {
							System.out.println("\nNome Inválido, Cadastre Novamente!\n");
							break;
						}
						System.out.println("Qual o tipo de programa que você quer adicionar? [ Reality Show, Serie Regular, Programa Continuo ]");
						String tipoPrograma = ler.nextLine().toLowerCase();
						if(Tipo.of(tipoPrograma) == null) {
							System.out.println("\nTipo Inválido, Cadastre Novamente.\n");
							break;
						}
						System.out.println("Qual o dia da semana que seu programa vai passar?\n"
										 + "2 - Segunda\n"
										 + "3 - Terça\n"
										 + "4 - Quarta\n"
										 + "5 - Quinta\n"
										 + "6 - Sexta\n"
										 + "7 - Sábado\n"
										 + "1 - Domingo\n");
						String diaPrograma = ler.nextLine();
						try {
							DiaDaSemana.of(diaPrograma) ;
						}catch(DateTimeException e){
							System.out.println("\nDia Inválido, Cadastre Novamente.\n");
							break;
						}
						System.out.println("Qual O Nome Do Canal Que O Programa Vai Ser Transmitido?");
						String transmitido = ler.nextLine();
						if(cdi.recuperarCanalPeloNome(transmitido) == null) {
							System.out.println("\nNão Existe Nenhum Canal Com Esse Nome!\n");
							break;
						}
						ProgramaDeTV p = new ProgramaDeTV(nomePrograma, Tipo.of(tipoPrograma), DiaDaSemana.of(diaPrograma), cdi.recuperarCanalPeloNome(transmitido));
						boolean adicionarPrograma = cdi.adicionarProgramaDeTV(p);
						if(adicionarPrograma) {
							System.out.println("\nPrograma Adicionado Com Sucesso!!!\n");
							persistencia.salvarCentral(cdi, "central.xml");
							break;
						} else {
							System.out.println("\nNão Foi Possível Adicionar o Programa, ID repetido ou Não Há Canais registrados.\n");
							break;
						}
					} else {
						System.out.println("\nAinda Não Há Canais Cadastrados.\n");
						break;
				}
					
				case "2":
					
					cdi.listarTodosOsProgramas();
					break;
					
				case "3":
					
					System.out.println("Qual Tipo De Programa Você Quer Checar? [ Reality Show, Serie Regular, Programa Continuo ] ");
					String t = ler.nextLine().toLowerCase();
					cdi.listarProgramasDeMesmoTipo(Tipo.of(t));
					break;
					
				case "4":
					
					System.out.println("Qual o nome do Canal que você quer adicionar?");
					String nomeCanal = ler.nextLine().trim();
					if(nomeCanal.equals("")) {
						System.out.println("Nome do Canal Inválido!\n");
						break;
					}
					System.out.println("Qual  tipo do Canal que você que Adicionar?");
					String tipoCanal = ler.nextLine().trim();
					if(tipoCanal.equals("")) {
						System.out.println("\nTipo de Canal Inválido!\n");
						break;
					}
					Canal canal = new Canal(nomeCanal, tipoCanal);
					boolean adicionarCanal = cdi.adicionarCanal(canal);
					if(adicionarCanal) {
						System.out.println("\nCanal Adicionado Com Sucesso!\n");
						persistencia.salvarCentral(cdi, "central.xml");
					}else {
						System.out.println("J\ná Existe Um Canal Com Esse Nome, Cadastre Novamente!\n");
					}
					break;
					
				case "5":
					
					cdi.listarTodosOsCanais();
					break;	
					
				case "6":
					
					if(cdi.getCanais().size() > 0 && cdi.getTodosOsProgramasDeTV().size() > 0 ) {
						System.out.println("Qual Canal Você Quer Checar A Programação?");
						String programacaoCanal = ler.nextLine();
						if(cdi.recuperarCanalPeloNome(programacaoCanal) == null){
							System.out.println("Não há nenhum canal com este nome");
							break;
						}else {
							GeradorDeRelatorios.obterProgramacaoDeUmCanal(cdi.recuperarCanalPeloNome(programacaoCanal));
						}
							
						System.out.println("\nRelatório Gerado Com Sucesso!\n");
					}else {
						System.out.println("\nAinda não há nenhum Canal ou Programa Cadastrado\n");
					}
					break;
					
				case "7":
					
					if(cdi.getCanais().size() > 0 && cdi.getTodosOsProgramasDeTV().size() > 0 ) {
						System.out.println("Qual o email do destinatário?");
						String destinatario = ler.nextLine();
						Mensageiro mensageiro = new Mensageiro();
						mensageiro.enviarProgramacaoDeHoje(destinatario);
						System.out.println("\nEmail enviado\n");
					}else {
						System.out.println("\nAinda não há nenhum Canal ou Programa Cadastrado\n");
					}
					break;
			}
		}while(!opcao.equals("S"));
		System.out.println("Você Saiu!!");
	}
}
