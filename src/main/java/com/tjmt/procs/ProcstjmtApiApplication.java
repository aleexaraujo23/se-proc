package com.tjmt.procs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tjmt.procs.api.model.Classe_csv;
import com.tjmt.procs.api.model.Tb_classe;
import com.tjmt.procs.api.repository.Tb_classeRepository;

@SpringBootApplication
public class ProcstjmtApiApplication {

	static List<Classe_csv> listaClasses;

	@Autowired
	Tb_classeRepository tb_classeRepository;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProcstjmtApiApplication.class, args);
	}

	// carregaBD classes
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

//			String cep = "77024002";
//			Endereco endereco = client.buscaEnderecoPor(cep);
//			System.out.println(endereco);

			// verificar se ja tem itens na table Table_Classes
			long qtd = tb_classeRepository.count();

			System.out.println(qtd);
			if (qtd == 0) {
				System.out.println("--> Nao Existem Registros Salvos. Tabela vazia");
				System.out.println("--");

				listaClasses = new ArrayList<>();
				lerAsClasses2();

				for (Classe_csv classe : listaClasses) {

					Tb_classe classes = new Tb_classe();
					classes.setId_cnj(classe.getId_cnj());
					classes.setDs_classe(classe.getDs_classe());
					classes.setSigla(classe.getSigla());
					classes.setTipo(classe.getTipo());

					try {
						this.tb_classeRepository.save(classes);
					} catch (Exception e) {
						e.printStackTrace();
					}

					System.out.println("INSERINDO ==>> ID FAKE: " + classe.getId() + " - Id CNJ: " + classe.getId_cnj()
							+ " - DS Classe: " + classe.getDs_classe() + " - Sigla: " + classe.getSigla() + " - Tipo: "
							+ classe.getTipo());
				}

			} else {

				System.out.println("--> Existem Registros Salvos. " + qtd);
				List<Tb_classe> tb = tb_classeRepository.findAll();

				for (Tb_classe classe : tb) {
					System.out.println("IMPRIMINDO ==>> ID FAKE: " + classe.getId() + " - Id CNJ: " + classe.getId_cnj()
							+ " - DS Classe: " + classe.getDs_classe() + " - Sigla: " + classe.getSigla() + " - Tipo: "
							+ classe.getTipo());
				}

			}

		};
	}

	/**
	 * Metodo que lê de arquivos .CSV
	 */
	public static void lerAsClasses(String csv) throws FileNotFoundException {
		Scanner bufferedScanner = new Scanner(new BufferedReader(new FileReader(csv)));
		try {
			bufferedScanner.nextLine();
			while (bufferedScanner.hasNext()) {
				String linhaCurrente = bufferedScanner.nextLine();
				Scanner linhaScanner = new Scanner(linhaCurrente);

				linhaScanner.useDelimiter(",");
				listaClasses
						.add(new Classe_csv(Long.parseLong(linhaScanner.next().replace("\"", "")), linhaScanner.next(),
								linhaScanner.next().replaceFirst(", ", ""), linhaScanner.next(), linhaScanner.next()));

				linhaScanner.close();
			}
		} catch (Exception anException) {
			System.out.println("Erro: " + anException);
			anException.printStackTrace();
		} finally {
			try {
				bufferedScanner.close();
			} catch (Exception anException) {
				System.out.println("Error: " + anException);
			}
		}
	}

	/**
	 * Metodo que lê de arquivos .CSV
	 */
	public static void lerAsClasses2() throws FileNotFoundException {

		try {

			File f1 = new File("src/main/java/com/tjmt/procs/api/file//TABELA_DE_CLASSES_ATIVAS.csv");
			String path = f1.getAbsolutePath();

			Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)));
			scanner.useDelimiter(",");

			int i = 1;
			scanner.nextLine();
			while (scanner.hasNext()) {
				String linha = scanner.nextLine();
				if (linha != null && !linha.trim().isEmpty()) {
					linha = linha.replaceAll(", ", " ");

					String[] dados = linha.split("\\,");

					Classe_csv classe = new Classe_csv((long) i, dados[1], dados[2], dados[3], dados[4]);

					listaClasses.add(classe);
					i++;

				}

			}

		} catch (Exception anException) {
			System.out.println("Erro: " + anException);
			anException.printStackTrace();
		} finally {

		}
	}

}
