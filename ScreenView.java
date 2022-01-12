package atividade;

import java.util.Scanner;

import atividade.bean.AtividadePessoaPrestadorBean;
import atividade.bean.PessoaBean;
import atividade.bo.AtividadeBO;
import atividade.bo.PessoaBO;

public class ScreenView {
	public static void main(String[] args) {
		String iniciar;
		Scanner sc = new Scanner(System.in);
		AtividadeBO ativBO = new AtividadeBO();	
		PessoaBO pesBO = new PessoaBO();
		ativBO.setPessoaBO(pesBO);
		AtividadePessoaPrestadorBean atPPBean = new AtividadePessoaPrestadorBean();
		do {
			for(Integer i : pesBO.pessoaHashMap.keySet()) {
				if(pesBO.pessoaHashMap.get(i).getTipo() == 1) {
					System.out.println("("+pesBO.pessoaHashMap.get(i).getId()+")("+pesBO.pessoaHashMap.get(i).getNome()+")("+pesBO.pessoaHashMap.get(i).getIdade()+")("+pesBO.pessoaHashMap.get(i).getCidade()+")("+pesBO.pessoaHashMap.get(i).getEmail()+")("+pesBO.pessoaHashMap.get(i).getEndereco()+")(Requisitante)");
				}else {
					System.out.println("("+pesBO.pessoaHashMap.get(i).getId()+")("+pesBO.pessoaHashMap.get(i).getNome()+")("+pesBO.pessoaHashMap.get(i).getIdade()+")("+pesBO.pessoaHashMap.get(i).getCidade()+")("+pesBO.pessoaHashMap.get(i).getEmail()+")("+pesBO.pessoaHashMap.get(i).getEndereco()+")(Prestador)");

				}
			}
			mostraListaTarefas(ativBO, pesBO);
			System.out.println("Selecione A B C D");
			System.out.println("A-Cadastrar pessoa;");		
			System.out.println("B-Adicionar tarefa;");
			System.out.println("C-Adicionar prestador a tarefa;");
			System.out.println("D-Informa o percentual de uma tarefa;");

			iniciar = sc.next();
			if(iniciar.equalsIgnoreCase("B")) {
				System.out.println("Qual tarefa voce deseja adicionar ?");
				pesBO.iniciar();
				String erro = (sc.nextLine());
				ativBO.iniciar();
				String tarNome = sc.nextLine();
				System.out.println("Digite o numero do requisitante");
				Integer pesRequisitanteId = sc.nextInt();

				ativBO.adicionarDados(tarNome, pesRequisitanteId);
				ativBO.gravar();
				iniciar = "Sim";
				System.out.println("Tarefa Adicionada ;)");

			}else if(iniciar.equalsIgnoreCase("C")){
				mostraListaTarefas(ativBO, pesBO);
				System.out.println("Informe o numero da TAREFA");
				ativBO.carregar(sc.nextInt());
				System.out.println("Escreva o ID do prestador");
                Integer idPrestador = sc.nextInt();
				ativBO.informaPessoaPrestador(idPrestador);
				ativBO.gravar();
				iniciar = "Sim";
			}else if(iniciar.equalsIgnoreCase("A")) {
				pesBO.iniciar();
				System.out.println("Digite o nome;");
				String error = sc.nextLine();
				String nome = sc.nextLine();
				System.out.println("Digite a idade;");
				Integer idade = sc.nextInt();
				System.out.println("Digite a cidade;");
				String error2 = sc.nextLine();
				String cidade = sc.nextLine();
				System.out.println("Digite o email");
				String email = sc.next();
				System.out.println("Digite o endereco");
				String error3 = sc.nextLine();
				String endereco = sc.nextLine();
				System.out.println("1-Requisitante 2-Prestador");
				Integer requisitante = sc.nextInt();
				pesBO.cadastraDados(nome, idade, cidade, email, endereco, requisitante);
				pesBO.gravar();
					System.out.println("Informacoes cadastrada");
			}else if(iniciar.equalsIgnoreCase("D")) {{
				for(Integer i: ativBO.atividadeHashMap.keySet()) {
					PessoaBean pesRequisiBean = pesBO.pessoaHashMap.get(ativBO.atividadeHashMap.get(i).getPessoaRequisitante().getId());
					System.out.println(pesRequisiBean.getNome()+"("+ativBO.atividadeHashMap.get(i).getId()+")"+ativBO.atividadeHashMap.get(i).getTarNome()+" "+"["+ativBO.atividadeHashMap.get(i).getTarPorcentagem()+"%]"+ativBO.ativPessoaTempMap.get(i).getPessoaPrestador());
				}
				System.out.println("Informe o ID do prestador da atividade;");
				Integer pesPrestadoraId = sc.nextInt();
				System.out.println("Informe a porcentagem concluida do prestador");
				Integer tarPorcentagem = sc.nextInt();
				System.out.println("Informe o numero da ATIVIDADE");
				ativBO.informarPercentual(sc.nextInt(), pesPrestadoraId, tarPorcentagem);
				ativBO.gravar();
				System.out.println(pesPrestadoraId+" "+tarPorcentagem);
				iniciar = "Sim";
			}
				
			}
			iniciar = "sim";
		}while(iniciar.equalsIgnoreCase("Sim"));



	}

	private static void mostraListaTarefas(AtividadeBO ativBO, PessoaBO pesBO) {
		for(Integer i: ativBO.atividadeHashMap.keySet()) {

			PessoaBean pesRequisiBean = pesBO.pessoaHashMap.get(ativBO.atividadeHashMap.get(i).getPessoaRequisitante().getId());
			String prestadores = ativBO.getPrestadores(i);
			if(prestadores == null) {
				System.out.println(pesRequisiBean.getNome()+ativBO.atividadeHashMap.get(i).getId()+"-"+ativBO.atividadeHashMap.get(i).getTarNome());
			}else {
				System.out.println(pesRequisiBean.getNome()+ativBO.atividadeHashMap.get(i).getId()+"-"+ativBO.atividadeHashMap.get(i).getTarNome()+ " - " + prestadores);
			}
		}
	}
}