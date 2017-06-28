package br.com.anacleto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.anacleto.model.Cliente;
import br.com.anacleto.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	// CADASTRAR CLIENTE
	@PostMapping(path = "/inserirCliente")
	public @ResponseBody String cadastrarCliente(@RequestBody Cliente cliente) {

		clienteRepository.save(cliente);

		return "Cliente inserido";
	}

	// EDITAR CLIENTE
	@PutMapping(path = "/editarCliente/{idCliente}")
	public @ResponseBody String editarCliente(
			@PathVariable(name = "idCliente") Long idCliente,
			@RequestBody Cliente cliente) {

		Cliente clienteSelecionado = clienteRepository.findOne(idCliente);
		if (clienteSelecionado == null) {
			return "Cliente não encontrado.";
		}
		
		clienteSelecionado.setNome(cliente.getNome());
		clienteSelecionado.setCpf(cliente.getCpf());
		
		clienteRepository.save(clienteSelecionado);
		
		return "Cliente editado com sucesso";
	}
	
	// LISTAR UM DETERMINADO CLIENTE
	@GetMapping(path = "/listarCliente/{idCliente}")
	  public Cliente buscar(@PathVariable Long idCliente) {
	    return clienteRepository.findOne(idCliente);
	  }

	// LISTAR TODOS OS CLIENTES
	@GetMapping(path = "/listarClientes")
	  public List<Cliente> listarClientes() {

	    return (List<Cliente>) clienteRepository.findAll();
	  }
	
	// DELETAR CLIENTE
	@DeleteMapping("/deletarCliente/{idCliente}")
	  public String deletar(@PathVariable Long idCliente)  {		
		
		Cliente cliente = clienteRepository.findOne(idCliente);
		if (cliente == null) {
			return "Cliente não localizado";
		} else {
			clienteRepository.delete(idCliente);			
			return "Cliente excluido com sucesso.";
		}
	  }
}
