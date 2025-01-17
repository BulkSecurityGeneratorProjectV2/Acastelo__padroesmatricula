package com.j7ss.view.aluno;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.j7ss.core.DAOException;
import com.j7ss.core.Messages;
import com.j7ss.entity.Documento;
import com.j7ss.entity.DocumentoCurso;
import com.j7ss.entity.DocumentoVagaEstagio;
import com.j7ss.entity.VagaEstagio;
import com.j7ss.entity.VagaEstagioAtividadeDiaria;
import com.j7ss.entity.constraint.AlunoStatus;
import com.j7ss.entity.constraint.DocumentoParse;
import com.j7ss.entity.constraint.DocumentoStatus;
import com.j7ss.view.LoginBean;

@ManagedBean
@ViewScoped
public class AlunoHomeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private VagaEstagio vagaEstagio; 
	
	private VagaEstagioAtividadeDiaria atividadeDiaria;
	
	private List<VagaEstagio> vagasEstagio;
	
	// DocumentView
	private String docPage;
	private DocumentoVagaEstagio documentoVagaEstagio;
	
	private boolean grid = true;
	private boolean formEstagio;
	private boolean gridAtividade;
	private boolean documentos;
	private boolean documentoView;
	private boolean formAtividade;
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public boolean isGrid() {
		return grid;
	}

	public void setGrid(boolean grid) {
		this.grid = grid;
	}

	public boolean isFormEstagio() {
		return formEstagio;
	}

	public void setFormEstagio(boolean formEstagio) {
		this.formEstagio = formEstagio;
	}

	public boolean isGridAtividade() {
		return gridAtividade;
	}

	public void setGridAtividade(boolean gridAtividade) {
		this.gridAtividade = gridAtividade;
	}

	public boolean isDocumentos() {
		return documentos;
	}

	public void setDocumentos(boolean documentos) {
		this.documentos = documentos;
	}

	public boolean isDocumentoView() {
		return documentoView;
	}

	public void setDocumentoView(boolean documentoView) {
		this.documentoView = documentoView;
	}

	public boolean isFormAtividade() {
		return formAtividade;
	}

	public void setFormAtividade(boolean formAtividade) {
		this.formAtividade = formAtividade;
	}

	public void setAtividadeDiaria(VagaEstagioAtividadeDiaria atividadeDiaria) {
		this.atividadeDiaria = atividadeDiaria;
	}

	public void setVagasEstagio(List<VagaEstagio> vagasEstagio) {
		this.vagasEstagio = vagasEstagio;
	}

	public void setDocPage(String docPage) {
		this.docPage = docPage;
	}

	/*public void documentos(){
		if(loginBean.getUsuario().getAluno().isStatusValido()){
			grid = false;
			formEstagio = false;
			formAtividade = false;
			gridAtividade = false;
			documentos = true;
			documentoView = false;
		}else{
			Messages.showGrowlWarn("Atenção!!!", "Aguarde a validação do seu cadastro por parte do setor de estágios");
		}
	}*/
	
	public void documentoView(){
		grid = false;
		formEstagio = false;
		formAtividade = false;
		gridAtividade = false;
		documentos = false;
		documentoView = true;
	}
	
	public void formEstagio(){
		grid = false;
		formEstagio = true;
		formAtividade = false;
		gridAtividade = false;
		documentos = false;
		documentoView = false;
	}
	
	public void formAtividade(){
		grid = false;
		formEstagio = false;
		formAtividade = true;
		gridAtividade = false;
		documentos = false;
		documentoView = false;
	}
	
	/*public void gridAtividade(){
		if(loginBean.getUsuario().getAluno().isStatusValido()){
			grid = false;
			formEstagio = false;
			formAtividade = false;
			gridAtividade = true;
			documentos = false;
			documentoView = false;
		}else{
			Messages.showGrowlWarn("Atenção!!!", "Aguarde a validação do seu cadastro por parte do setor de estágios");
		}
	}*/
	
	public void grid(){
		grid = true;
		formEstagio = false;
		formAtividade = false;
		gridAtividade = false;
		documentos = false;
		documentoView = false;
		vagaEstagio = null;
	}
	
	/*public void setVagaEstagio(VagaEstagio vagaEstagio) {
		this.vagaEstagio = vagaEstagio;
		int i = 0;
		boolean first = true;
		for (DocumentoCurso dc : getDocCursos()) {
			if(dc.getDocumento().getExtra()){									// Documento Obrigatório
				if(!isDocAluno(dc.getDocumento())){
					//TODO: AlunoVagaEstagioBean + AlunoHomeBean + AlunoDocumentoBean + AlunoAtividadeDiaria
					getDocVagaEstagio().add( new DocumentoVagaEstagio()
											.vagaEstagio(vagaEstagio)
											.documento(dc.getDocumento())
											.ordem(i)
											.status(DocumentoStatus.DISPONIVEL) );
				}
			}else if(!isEqualDocCursoAndAlunoByIndex(i)){								// Próximo Document
					//TODO: AlunoVagaEstagioBean + AlunoHomeBean + AlunoDocumentoBean + AlunoAtividadeDiaria
				getDocVagaEstagio().add( new DocumentoVagaEstagio()
											.vagaEstagio(vagaEstagio)
											.documento(dc.getDocumento())
											.ordem(i)
											.status(i < 3 ?  DocumentoStatus.DISPONIVEL : DocumentoStatus.INDISPONIVEL) );
				first = false;
			}
			i++;
		}
	}*/
	
	/*public void save(){
		try {
			if(vagaEstagio.getAluno().getStatus().equals(AlunoStatus.INVALIDO)){
				vagaEstagio.getAluno().status(AlunoStatus.VERIFICAR).save();
			}
			vagaEstagio.save();
			Messages.showGrowlInfo("Dados do Estágio", "Atualizado!");
		} catch (DAOException e) {
			Messages.showGrowlErro("Dados do Estágio", e.getMessage());
		}
		grid();
	}*/
	
	/*public void saveAtividadeDiaria(){
		try {
			if(atividadeDiaria.isNew()){
				vagaEstagio.addAtividadeDiaria(atividadeDiaria).save();
			}else{
				atividadeDiaria.save();
			}
			Messages.showGrowlInfo("Atividade Diária", "Salva com sucesso!");
		} catch (DAOException e) {
			Messages.showGrowlErro("Atividade Diária", e.getMessage());
		}
		gridAtividade();
	}*/
	
	/*public void removeAtividadeDiaria(VagaEstagioAtividadeDiaria atividadeDiaria){
		try {
			if(atividadeDiaria.remove()){
				vagaEstagio.getAtividadesDiaria().remove(atividadeDiaria);
				System.out.println("Removed");
			}
		} catch (DAOException e) {
			Messages.showGrowlErro("Atividade Diária", e.getMessage());
		}
		gridAtividade();
	}*/
	
	private boolean isEqualDocCursoAndAlunoByIndex(int id){
		if(getDocCursos() != null && getDocVagaEstagio() != null && getDocCursos().size() > id && getDocVagaEstagio().size() > id){
			return getDocCursos().get(id).getDocumento().getId().equals( getDocVagaEstagio().get(id).getDocumento().getId() );
		}
		return false;
	}
	
	private boolean isDocAluno(Documento doc){
		for (DocumentoVagaEstagio docVaga : getDocVagaEstagio()) {
			if(docVaga.getDocumento().equals(doc)){
				return true;
			}
		}
		return false;
	}

	/*public void saveDocumento(DocumentoStatus status){
		try {
			documentoVagaEstagio.status(status).save();
			Messages.showGrowlInfo("Documentos", "Atualizado!");
		} catch (DAOException e) {
			Messages.showGrowlErro("Documentos", e.getMessage());
		}
	}*/
	
	/*public void submeterAvaliacao(){
		try {
			documentoVagaEstagio.status(DocumentoStatus.AGUARDANDO_VERIFICACAO).save();
			Messages.showGrowlInfo("Documento enviado para avaliação", "Favor aguardar correção por parte da instituição.");
		} catch (DAOException e) {
			Messages.showGrowlErro("Documentos", e.getMessage());
		}
	}*/
	
	/*public boolean isDisponivel(){
		return documentoVagaEstagio.isStatusDisponivel() || documentoVagaEstagio.isVerificadoComErro();
	}*/
	
	/*public boolean isDisponivelDownload(){
		return documentoVagaEstagio.isStatusDisponivelDownload() || documentoVagaEstagio.isStatusConcluido();
	}*/
	
	
//******************************************************************************************************************************
//## Getters Setters
	public String getDocPage() {
		if(docPage == null){
			docPage = new DocumentoParse(documentoVagaEstagio).toPage();
		}
		return docPage;
	}
	
	public void setDocumentoVagaEstagio(DocumentoVagaEstagio documentoVagaEstagio) {
		this.documentoVagaEstagio = documentoVagaEstagio;
		this.docPage = null;
	}
	
	public DocumentoVagaEstagio getDocumentoVagaEstagio() {
		return documentoVagaEstagio == null ? documentoVagaEstagio = new DocumentoVagaEstagio() : documentoVagaEstagio;
	}
	
	public VagaEstagio getVagaEstagio() {
		return vagaEstagio == null ? vagaEstagio = new VagaEstagio() : vagaEstagio;
	}
	
	public List<DocumentoVagaEstagio> getDocVagaEstagio(){
		return getVagaEstagio().getDocumentosVagaEstagio();
	}
	
	private List<DocumentoCurso> getDocCursos(){
		return loginBean.getUsuario().getAluno().getCurso().getDocumentoCursos();
	}
	
	/*public List<VagaEstagio> getVagasEstagio() {
		return vagasEstagio == null ? vagasEstagio = VagaEstagio.findByAluno(loginBean.getUsuario().getAluno()) : vagasEstagio;
	}*/
	
	public VagaEstagioAtividadeDiaria getAtividadeDiaria() {
		return atividadeDiaria == null ? atividadeDiaria = new VagaEstagioAtividadeDiaria() : atividadeDiaria;
	}

}
