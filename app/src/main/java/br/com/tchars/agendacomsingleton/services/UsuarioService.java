package br.com.tchars.agendacomsingleton.services;

import android.content.Context;

import br.com.tchars.agendacomsingleton.models.Usuario;
import br.com.tchars.agendacomsingleton.repositories.UsuarioRepository;

public class UsuarioService implements IUsuarioService {

    private UsuarioRepository _usuarioRepository;

    public UsuarioService(Context context) {
        this._usuarioRepository = new UsuarioRepository(context);
    }

    @Override
    public void CriarUsuario(Usuario usuario) {
        _usuarioRepository.SalvarUsuario(usuario);
    }

    @Override
    public Usuario BuscarUsuarioPeloNomeDeUsuario(String nomeDeUsuario) {

        Usuario usuarioBuscado = _usuarioRepository.BuscarUsuarioPeloNomeDeUsuario(nomeDeUsuario);
        return usuarioBuscado;
    }

    @Override
    public Usuario AutenticarUsuario(String nomeDeUsuario, String senha) {

        Usuario usuarioAutenticado = _usuarioRepository.BuscarUsuarioPeloNomeDeUsuario(nomeDeUsuario);

        if (usuarioAutenticado != null && usuarioAutenticado.getSenha().equals(senha)) {
            return usuarioAutenticado;
        }

        return null;
    }

}
