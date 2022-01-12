package atividade.bo;

import java.util.HashMap;

import atividade.bean.AtividadeBean;
import atividade.bean.AtividadePessoaPrestadorBean;
import atividade.bean.PessoaBean;

public class AtividadeBO {
	AtividadePessoaPrestadorBean atPPBean = null;
	AtividadeBean ativBean = new AtividadeBean();
	PessoaBean pesBean = new PessoaBean();

	HashMap<Integer, AtividadeBean> atividadeHashMap =  new HashMap<Integer, AtividadeBean>();

	HashMap<Integer, AtividadePessoaPrestadorBean> pesPrestadorHashMap = new HashMap<Integer, AtividadePessoaPrestadorBean>(); 

	HashMap<Integer, AtividadePessoaPrestadorBean> ativPessoaTempMap = null;
	Integer id = 0;
	Integer idAtPP = 0;
	private PessoaBO pesBO;

	public void qualquer1 (Integer id) {
		ativBean = atividadeHashMap.get(id);

		ativPessoaTempMap = new HashMap<Integer, AtividadePessoaPrestadorBean>();
		for(Integer i : pesPrestadorHashMap.keySet()) {
			AtividadePessoaPrestadorBean ativPessoaPrestadorBean = pesPrestadorHashMap.get(i);

		}
	}
	public void iniciar() {
		ativBean = new AtividadeBean();
	}

	public void adicionarDados(String tarNome, Integer pesRequisitanteId) {
		id += 1;
		ativBean.setId(id);
		ativBean.setTarNome(tarNome);
		ativBean.getPessoaRequisitante().setId(pesRequisitanteId);
	}

	public void gravar() {
		atividadeHashMap.put(id, ativBean);
		if(atPPBean != null) {
			pesPrestadorHashMap.put(idAtPP, atPPBean);
		}
	}
	public void informaPessoaPrestador(Integer idPrestador) {
		idAtPP+=1;
		
		atPPBean = new AtividadePessoaPrestadorBean();
		atPPBean.setId(idAtPP);
		atPPBean.setAtividade(ativBean);
		atPPBean.getPessoaPrestador().setId(idPrestador);
		atPPBean.setPorcentagem(0);
	}

	public void informarPercentual(Integer id , Integer pesPrestadoraId , Integer tarPorcentagem ) {
		pesPrestadorHashMap.get(id).getAtividade().setTarPorcentagem(tarPorcentagem);
	}
	public String getPrestadores(Integer idTarefa) {
		String prestadores = null;
		try {
			prestadores = "";
			for (Integer i : pesPrestadorHashMap.keySet()) {
				AtividadePessoaPrestadorBean atPPbean = pesPrestadorHashMap.get(i);
				
				if (atPPBean.getAtividade().getId() == idTarefa) {
					PessoaBean pesPrestadorBean = pesBO.pessoaHashMap.get(atPPbean.getPessoaPrestador().getId());
					
					prestadores += pesPrestadorBean.getNome() + " [ " + atPPBean.getPorcentagem() + "% ] ";
				}
			}
		} catch (NullPointerException e) {
		}
		
		return prestadores;
	}
	public void setPessoaBO(PessoaBO pesBO) {
		this.pesBO = pesBO;
	}
	public void carregar(Integer id) {
		ativBean = atividadeHashMap.get(id);
	}
}