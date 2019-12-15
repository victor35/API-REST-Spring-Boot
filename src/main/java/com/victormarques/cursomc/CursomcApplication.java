package com.victormarques.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.victormarques.cursomc.domain.Categoria;
import com.victormarques.cursomc.domain.Cidade;
import com.victormarques.cursomc.domain.Cliente;
import com.victormarques.cursomc.domain.Endereco;
import com.victormarques.cursomc.domain.Estado;
import com.victormarques.cursomc.domain.Pagamento;
import com.victormarques.cursomc.domain.PagamentoComBoleto;
import com.victormarques.cursomc.domain.PagamentoComCartao;
import com.victormarques.cursomc.domain.Pedido;
import com.victormarques.cursomc.domain.Produto;
import com.victormarques.cursomc.domain.enums.EstadoPagamento;
import com.victormarques.cursomc.domain.enums.TipoCliente;
import com.victormarques.cursomc.repository.CategoriaRepository;
import com.victormarques.cursomc.repository.CidadeRepository;
import com.victormarques.cursomc.repository.ClienteRepository;
import com.victormarques.cursomc.repository.EnderecoRepository;
import com.victormarques.cursomc.repository.EstadoRepository;
import com.victormarques.cursomc.repository.PagamentoRepository;
import com.victormarques.cursomc.repository.PedidoRepository;
import com.victormarques.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner  {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidioRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null,"Sao Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"Sao Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null,"Rua Flores", "300", "Apto 303","Jardim","38220834",cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida Matos", "3105", "Sala 800","Centro","387777012",cli1,c2);
	
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagt2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null); 
		ped2.setPagamento(pagt2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidioRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagt2));
		
	}

}
