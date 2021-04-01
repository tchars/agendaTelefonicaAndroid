package br.com.tchars.agendacomsingleton.services;

import java.util.ArrayList;

import br.com.tchars.agendacomsingleton.models.Contato;

public interface IContatoService {
    void CadastrarContato(Contato contato);
    Contato BuscarContatoPeloId(int idContato);
    ArrayList<Contato> BuscarTodosContatosDoUsuario(int idUsuarioLogado);
    void AtualizarContato(Contato contato);
}
