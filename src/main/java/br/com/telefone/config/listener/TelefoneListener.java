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

import java.util.ArrayList;
import java.util.Random;

@Component
public class TelefoneListener {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("O sistema está em execução. ");

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Contato contato = new Contato("Contato" + i);
            contato.setTelefones(new ArrayList<>());


            int ddi = 55;
            int ddd = random.nextInt(90) + 10;
            long numero = random.nextInt(1000000000);

            Telefone telefone = new Telefone(ddi, ddd, numero);
            telefone.setTipoTelefone(TipoTelefone.TELEFONE_PRINCIPAl);

            telefone.setContato(contato);
            contato.getTelefones().add(telefone);

            contato = contatoRepository.save(contato);
            System.out.println("Contato salvo" + contato);


        }


    }

}
