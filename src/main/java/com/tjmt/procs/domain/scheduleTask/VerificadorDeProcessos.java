package com.tjmt.procs.domain.scheduleTask;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tjmt.procs.domain.model.Tb_ProcessoJuiz;
import com.tjmt.procs.domain.model.Tb_juiz;
import com.tjmt.procs.domain.model.Tb_processo;
import com.tjmt.procs.domain.repository.Tb_ProcessoJuizRepository;
import com.tjmt.procs.domain.repository.Tb_juizRepository;
import com.tjmt.procs.domain.repository.Tb_processoRepository;

@Component
@EnableScheduling
public class VerificadorDeProcessos {

	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;
	private final long CINCO_MINUTOS = MINUTO * 5;
	private final long HORA = MINUTO * 60;

	@Autowired
	private Tb_juizRepository repJ;

	@Autowired
	private Tb_processoRepository repP;

	@Autowired
	private Tb_ProcessoJuizRepository repTPJ;

	@Scheduled(fixedDelay = SEGUNDO)
	public void verificaPorHora() {

		// Código que realiza a consulta de fluxo de vendas
		System.out.println("VERIFICADOR FUNCIONANDO..." + LocalDateTime.now());

		List<Tb_processo> p = repP.findNotExistsDistribuicao();
		if (!p.isEmpty()) {
			for (Tb_processo proc : p) {

				try {

					Tb_juiz j = repJ.findNotExistsprocs();

					Tb_juiz jj = repJ.findExistsprocs();

					// Busca de processos nao distribuidos e juizes com menos processos
					System.out.println("--> Proc" + proc.getId() + " - " + proc.getNrprocesso());

					// verifica se existe juiz sem processo
					if (j != null) {
						// se existir adicionar data de distribuicao em TB_Processos
						// e inserir o Juiz respectivo responsavel por esse projeto
						Tb_processo db = proc;
						db.setDatadistribuicao(OffsetDateTime.now());

						System.out.println("--> Juiz - " + j.getId() + " - " + j.getNome() + " - "
								+ db.getDatadistribuicao() + "  --> " + db.getId());

						repP.save(db);

						Tb_ProcessoJuiz tpj = new Tb_ProcessoJuiz();
						tpj.setProcesso(db.getId());
						tpj.setJuiz(j.getId());

						repTPJ.save(tpj);

						// se nao existir juiz sem processo buscar qual tem menos processo
					} else {

						// adicionar data de distribuicao em TB_Processos
						// e inserir o Juiz respectivo responsavel por esse projeto
						Tb_processo db = proc;
						db.setDatadistribuicao(OffsetDateTime.now());

						System.out.println("--> Juiz - " + jj.getId() + " - " + jj.getNome() + " - "
								+ db.getDatadistribuicao() + "  --> " + db.getId());

						repP.save(db);

						Tb_ProcessoJuiz tpj = new Tb_ProcessoJuiz();
						tpj.setProcesso(db.getId());
						tpj.setJuiz(jj.getId());

						repTPJ.save(tpj);

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

}
