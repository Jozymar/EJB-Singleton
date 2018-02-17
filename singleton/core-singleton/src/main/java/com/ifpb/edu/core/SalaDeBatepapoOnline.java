package com.ifpb.edu.core;

import com.ifpb.edu.shared.SalaDeBatepapo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;

import javax.ejb.Singleton;

@Singleton
@Remote(SalaDeBatepapo.class)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Lock(LockType.READ)
public class SalaDeBatepapoOnline implements SalaDeBatepapo {

    private List<String> mensagens = new ArrayList<>();

    @Override
    @Lock(LockType.WRITE)
    public void novaMensagem(String mensagem) {
        System.out.println("antes");
        synchronized (mensagem) {
            mensagens.add(mensagem);
        }
        System.out.println("depois");
    }

    @Override
    @Lock(LockType.WRITE)
    public synchronized void removerMensagem(String mensagem) {
        mensagens.remove(mensagem);

    }

    @Override
    public List<String> historico() {
        return Collections.unmodifiableList(mensagens);
    }

}
