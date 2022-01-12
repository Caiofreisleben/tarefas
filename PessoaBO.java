package atividade.bo;

import java.util.HashMap;

public class PessoaBO {
	PessoaBean pesBean = new PessoaBean();
	HashMap<Integer, PessoaBean> pessoaHashMap =  new HashMap<Integer, PessoaBean>();

	Integer id = 0;

	public void iniciar() {
		pesBean = new PessoaBean();
	}
	
	public void cadastraDados(String nome , Integer idade , String cidade , String email , String endereco , Integer tipo) {
		id += 1;
		pesBean.setNome(nome);
		pesBean.setIdade(idade);
		pesBean.setCidade(cidade);
		pesBean.setEmail(email);
		pesBean.setEndereco(endereco);
		pesBean.setTipo(tipo);
		pesBean.setId(id);
		
	}
	
	public void gravar() {
		pessoaHashMap.put(id, pesBean);
	}
	public void editarDados(Integer id, Integer tarPorcentagem) {
		
	}


}
