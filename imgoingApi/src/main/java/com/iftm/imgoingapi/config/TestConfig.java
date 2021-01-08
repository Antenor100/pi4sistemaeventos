package com.iftm.imgoingapi.config;

import java.util.Date;

import com.iftm.imgoingapi.entities.*;
import com.iftm.imgoingapi.entities.enums.FormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.iftm.imgoingapi.repositories.CategoriaRepository;
import com.iftm.imgoingapi.repositories.CertificadoRepository;
import com.iftm.imgoingapi.repositories.EnderecoRepository;
import com.iftm.imgoingapi.repositories.EventoRepository;
import com.iftm.imgoingapi.repositories.IngressoRepository;
import com.iftm.imgoingapi.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CertificadoRepository certificadoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private IngressoRepository ingressoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {

		Usuario usu1 = new Usuario(null, "Anderson", null, "Anderson@gmail.com", "kuhbdwadaw45wd", "34998754875", new Date(), "12547854785", null);
		Categoria cat1 = new Categoria(null, "Acadêmico", "CUrso sobre botânica");
		Endereco end1 = new Endereco(null, "13600755", "Rua tanto faz teste", 55, "Santo teste", "Apartamento 12", "Uberlândia", "MG", null, null);
		Evento eve1 = new Evento(null, "Gostronomia com zé", "url/img/gastroeven", new Date(), new Date(), "Evento de gastronomia com o chefe zé ", 60, cat1, usu1, end1);
		Ingresso ing1 = new Ingresso(null, 50d, new Date(), 25d, new Date(), FormaPagamento.PAGAMENTO_BOLETO, usu1, eve1);
		Certificado cer1 = new Certificado(null, "www.linkdocertificado.com.br", new Date(), eve1, usu1);

		usuarioRepository.save(usu1);	
		categoriaRepository.save(cat1);		
		enderecoRepository.save(end1);	
		eventoRepository.save(eve1);
		ingressoRepository.save(ing1);
		certificadoRepository.save(cer1);
	}
}