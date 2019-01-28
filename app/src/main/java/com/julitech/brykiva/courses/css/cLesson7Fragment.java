package com.julitech.brykiva.courses.css;


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
public class cLesson7Fragment extends Fragment {

    String code1 = "body{ \n" +
            "   width: 400px;\n" +
            "   font-size: 20px;\n" +
            "}\n";
    String code2 = "\np { width: 50%;}\n";
    String code3 = "\n  strong { font-size: 150%;}  \n";
    String code4 = "body{ font-size: 16px;}\n" +
            "h1{ font-size: 2em;}        /* = 32px */\n" +
            "h2{ font-size: 1.5em;}      /* = 24px */\n" +
            "aside{ font-size: 0.75em;}  /* = 12px */\n";
    String code5 = "body{ font-size: 20px;}\n" +
            "h1{ font-size: 2em;}        /* = 40px */\n" +
            "h2{ font-size: 1.5em;}      /* = 30px */\n" +
            "aside{ font-size: 0.75em;}  /* = 16px */\n";
    String code6 = "html{ font-size: 18px;}\n" +
            "body{ font-size: 1rem;}     /* = 18px */\n" +
            "h1{ font-size: 2rem;}       /* = 36px */\n" +
            "h2{ font-size: 1.5rem;}     /* = 27px */\n";
    String code7 = "html{ font-size: 20px;}\n" +
            "p{ font-size: 0.8rem;}        /* = 16px */\n" +
            "p span{ font-size: 2em;}      /* = 16px * 2 = 32px */\n" +
            "p strong{ font-size: 2rem;}   /* = 20px * 2 = 40px */\n";

    public cLesson7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_lesson7, container, false);
        CodeView codeView = view.findViewById(R.id.code1);
        codeView.setCode(code1)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView2 = view.findViewById(R.id.code2);
        codeView2.setCode(code2)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView3 = view.findViewById(R.id.code3);
        codeView3.setCode(code3)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView4 = view.findViewById(R.id.code4);
        codeView4.setCode(code4)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeview5 = view.findViewById(R.id.code5);
        codeview5.setCode(code5)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView6 = view.findViewById(R.id.code6);
        codeView6.setCode(code6)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        CodeView codeView7 = view.findViewById(R.id.code7);
        codeView7.setCode(code7)
                .setLanguage(Language.CSS)
                .setTheme(Theme.ATELIER_CAVE_LIGHT)
                .apply();
        return view;
    }

}
