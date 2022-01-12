package atividade.bean;

public class AtividadePessoaPrestadorBean {
	private Integer id;
	private AtividadeBean atividade;
	private PessoaBean pessoaPrestador;
	private Integer porcentagem;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AtividadeBean getAtividade() {
		return atividade;
	}
	public void setAtividade(AtividadeBean atividade) {
		this.atividade = atividade;
	}
	public PessoaBean getPessoaPrestador() {
		if(pessoaPrestador == null) pessoaPrestador = new PessoaBean();
		return pessoaPrestador;
	}
	public void setPessoaPrestador(PessoaBean pessoaPrestador) {
		this.pessoaPrestador = pessoaPrestador;
	}
	public Integer getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}

}
