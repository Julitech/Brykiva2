package com.julitech.brykiva.courses.html;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julitech.brykiva.R;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;

/**
 * A simple {@link Fragment} subclass.
 */
public class hLesson10Fragment extends Fragment {

    String code = "<table>\n" +
            "  <tr>\n" +
            "    <td>John Lennon</td>\n" +
            "    <td>Rhythm Guitar</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>Paul McCartney</td>\n" +
            "    <td>Bass</td>\n" +
            "  </tr>\n"+
            "</table>\n ";

    public hLesson10Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h_lesson10, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code)
                .setLanguage(Language.HTML)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
