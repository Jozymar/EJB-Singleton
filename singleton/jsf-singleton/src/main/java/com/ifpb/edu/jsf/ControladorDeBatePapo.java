package com.ifpb.edu.jsf;

import com.ifpb.edu.shared.SalaDeBatepapo;
import com.ifpb.edu.shared.ServiceLocator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorDeBatePapo implements Serializable {

    private SalaDeBatepapo sala;

    private String mensagem;

    @PostConstruct
    public void init() {
        sala = new ServiceLocator().lookup("host-core", "3700", "java:global/core-singleton/SalaDeBatepapoOnline");
    }

    public String add() {
        sala.novaMensagem(mensagem);
        mensagem = "";
        return null;
    }

    public String remove(String msg) {
        sala.removerMensagem(msg);
        return null;
    }

    public List<String> mensagens() {
        return sala.historico();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
