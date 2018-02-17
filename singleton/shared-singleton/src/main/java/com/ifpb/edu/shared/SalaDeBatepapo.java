package com.ifpb.edu.shared;

import java.util.List;

public interface SalaDeBatepapo {

    void novaMensagem(String mensagem);

    void removerMensagem(String mensagem);

    List<String> historico();

}
