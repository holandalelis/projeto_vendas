package io.github.holandalelis;

import io.github.holandalelis.domain.entity.Cliente;
import io.github.holandalelis.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("--------------SALVANDO CLIENTES------------");
           clientes.salvar(new Cliente("Pedro"));
           clientes.salvar(new Cliente("João"));
            System.out.println("--------------LISTANDO------------");
           List<Cliente> todosClientes = clientes.obterTodos();

           todosClientes.forEach(System.out::println);
            System.out.println("--------------ATUALIZANDO CLIENTES------------");
           todosClientes.forEach(c ->{
                c.setNome(c.getNome() + "atualizado.");
                clientes.atualizar(c);
            });
            System.out.println("--------------BUSCANDO CLIENTES------------");
           clientes.buscarPorNome("ao").forEach(System.out::println);

           todosClientes = clientes.obterTodos();
           todosClientes.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}