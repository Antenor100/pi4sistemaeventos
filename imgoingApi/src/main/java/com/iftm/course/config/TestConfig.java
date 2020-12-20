package com.iftm.course.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.iftm.course.entities.Categoria;
import com.iftm.course.entities.Endereco;
import com.iftm.course.entities.Evento;
import com.iftm.course.entities.Usuario;
import com.iftm.course.repositories.CategoriaRepository;
import com.iftm.course.repositories.CertificadoRepository;
import com.iftm.course.repositories.EnderecoRepository;
import com.iftm.course.repositories.EventoRepository;
import com.iftm.course.repositories.IngressoRepository;
import com.iftm.course.repositories.UsuarioRepository;

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

		Usuario usu1 = new Usuario(null, "Anderson", null, "Anderson@gmail.com", "kuhbdwadaw45wd", new Date(), "12547854785", null);	
		
		Categoria cat1 = new Categoria(null, "Acadêmico", "CUrso sobre botânica");
		
		Endereco end1 = new Endereco(null, "13600755", "Rua tanto faz teste", 55, "Santo teste", "Apartamento 12", "Uberlândia", "MG", null, null);

		Evento eve1 = new Evento(null, "Gostronomia com zé", "url/img/gastroeven", new Date(), new Date(), "Evento de gastronomia com o chefe zé ", 60, cat1, usu1, end1);
		
		usuarioRepository.save(usu1);	
		categoriaRepository.save(cat1);		
		enderecoRepository.save(end1);	
		eventoRepository.save(eve1);	
	}
}