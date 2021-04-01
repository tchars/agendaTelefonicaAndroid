package br.com.tchars.agendacomsingleton.repositories;

import java.util.ArrayList;

import br.com.tchars.agendacomsingleton.models.Contato;

public interface IContatoRepository {
    boolean CriarContato(Contato contato);
    Contato BuscarContatoPeloId(int idContato);
    ArrayList<Contato> BuscarTodosContatosDoUsuario(int idUsuarioLogado);
    void AtualizarContato(Contato contato);
}
