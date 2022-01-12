package atividade.bean;

public class AtividadeBean {
	private String tarNome;
	private Integer id;
	private Integer tarPorcentagem;
	private PessoaBean pessoaRequisitante;
	
	public String getTarNome() {
		return tarNome;
	}
	public void setTarNome(String tarNome) {
		this.tarNome = tarNome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTarPorcentagem() {
		return tarPorcentagem;
	}
	public void setTarPorcentagem(Integer tarPorcentagem) {
		this.tarPorcentagem = tarPorcentagem;
	}
	public PessoaBean getPessoaRequisitante() {
		if(pessoaRequisitante == null) pessoaRequisitante = new PessoaBean();
		return pessoaRequisitante;
	}
	public void setPessoaRequisitante(PessoaBean pessoaRequisitante) {
		this.pessoaRequisitante = pessoaRequisitante;
	}
	
}
