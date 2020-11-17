package com.tjmt.procs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket detalheApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.select()
				.apis(RequestHandlerSelectors.basePackage("com.tjmt.procs.api.controller"))
				.paths(PathSelectors.any()).build()
				.apiInfo(this.informacoesApi().build())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessageForGET());
		;

		return docket;
	}

	
	private ApiInfoBuilder informacoesApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("Api-Proc-Eletronico");
		apiInfoBuilder.description("Api Spring REST para Processos Eletronicos.");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("https://www.linkedin.com/in/alex-araujo-souza/");
		apiInfoBuilder.contact(this.contato());

		return apiInfoBuilder;

	}

	private Contact contato() {

		return new Contact("Alex de Araujo Souza", "https://www.linkedin.com/in/alex-araujo-souza/",
				"alex_araujo09@hotmail.com");
	}

	private List<ResponseMessage> responseMessageForGET() {
		return new ArrayList<ResponseMessage>() {
			{
				add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("string")).build());
				add(new ResponseMessageBuilder().code(403).message("Forbidden!").build());
				add(new ResponseMessageBuilder().code(400).message("Caminho nao encontrado!").build());
				add(new ResponseMessageBuilder().code(201).message("Criado com sucesso!").build());
			}
		};
	}

}