package br.com.telefone.config.listener;

import br.com.telefone.model.Contato;
import br.com.telefone.model.Telefone;
import br.com.telefone.model.enums.TipoTelefone;
import br.com.telefone.repository.ContatoRepository;
import br.com.telefone.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TelefoneListener {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("O sistema está em execução. ");

        Telefone telefone = new Telefone(22, 32, 34565436L);
        telefone.setTipoTelefone(TipoTelefone.TELEFONE_PRINCIPAl);
        telefone = telefoneRepository.save(telefone);
        System.out.println(telefone);

        Contato contato = new Contato("Ana");
        contato = contatoRepository.save(contato);
        System.out.println(contato);


    }

}
