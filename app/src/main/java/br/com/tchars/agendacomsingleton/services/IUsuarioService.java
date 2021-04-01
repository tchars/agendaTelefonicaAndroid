package br.com.tchars.agendacomsingleton.services;

import br.com.tchars.agendacomsingleton.models.Usuario;

public interface IUsuarioService {
    void CriarUsuario(Usuario usuario);
    Usuario BuscarUsuarioPeloNomeDeUsuario(String nomeDeUsuario);
    Usuario AutenticarUsuario(String nomeDeUsuario, String senha);
}
