package br.com.tchars.agendacomsingleton.repositories;

import br.com.tchars.agendacomsingleton.models.Usuario;

public interface IUsuarioRepository {

    boolean SalvarUsuario(Usuario usuario);
    Usuario BuscarUsuarioPeloNomeDeUsuario(String nomeDeUsuario);
}
