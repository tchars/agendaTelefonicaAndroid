package br.com.tchars.agendacomsingleton.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.tchars.agendacomsingleton.R;
import br.com.tchars.agendacomsingleton.models.Contato;

public class ContatoListAdapter extends ArrayAdapter<Contato> {

    public ContatoListAdapter(Context context, ArrayList<Contato> contatos) {
        super(context, 0, contatos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Contato contato = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contato_adapter_layout, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.textViewNome);
        TextView tvTelefone = (TextView) convertView.findViewById(R.id.textViewTelefone);
        TextView tvTipoContato = (TextView) convertView.findViewById(R.id.textViewTipo);

        tvName.setText(contato.getNome());
        tvTelefone.setText(contato.getTelefone());
        tvTipoContato.setText(retornaTipoDeContatoEmString(contato.getTipoContato()));

        return convertView;
    }

    private String retornaTipoDeContatoEmString(int tipoDeContato) {

        if (tipoDeContato == 0)
            return "Casa";

        else if (tipoDeContato == 1)
            return "Telefone";

        else
            return "Outros";
    }
}
