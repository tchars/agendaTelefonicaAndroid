package br.com.tchars.agendacomsingleton.services;

import android.content.Context;

import java.util.ArrayList;

import br.com.tchars.agendacomsingleton.models.Contato;
import br.com.tchars.agendacomsingleton.repositories.ContatoRepository;

public class ContatoService implements IContatoService {

    private ContatoRepository _contatoRepository;

    public ContatoService(Context context) {
        this._contatoRepository = new ContatoRepository(context);
    }

    @Override
    public void CadastrarContato(Contato contato) {
        _contatoRepository.CriarContato(contato);
    }

    @Override
    public Contato BuscarContatoPeloId(int idContato) {
        return _contatoRepository.BuscarContatoPeloId(idContato);
    }

    @Override
    public ArrayList<Contato> BuscarTodosContatosDoUsuario(int idUsuarioLogado) {
        ArrayList<Contato> contatos = _contatoRepository.BuscarTodosContatosDoUsuario(idUsuarioLogado);
        return contatos;
    }

    @Override
    public void AtualizarContato(Contato contato) {
        _contatoRepository.AtualizarContato(contato);
    }
}
