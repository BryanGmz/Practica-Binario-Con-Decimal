package practica.binarios.con.decimal;

import java_cup.runtime.Symbol;

%%
%class Lexico
%type java_cup.runtime.Symbol
%cup
%public
%cupdebug
%full
%line
%column
%char

B = [0-1]
espacio=[\t\r]
salto=[\n]

%{

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
    }

    private Symbol symbol(int type){
        return new Symbol(type, yyline + 1, yycolumn + 1);
    }

%}
%%

<YYINITIAL> {

    /* Espacios*/
    
    {salto}+        {/*Ignore*/}
    {espacio}+      {/*Ignore*/}
    ("â")*        {/*Ignore*/}
    (" ")*          {/*Ignore*/}

    /* Numero Binario */

    {B}                         {return new Symbol(sym.BINARIO, yychar, yyline, new String(yytext()));}
    (".")                       {return new Symbol(sym.PUNTO, yychar, yyline, new String(yytext()));}
 
    /* Error */

    . {
        System.out.println("\nError Lexico: \n"
                + "\tToken: << " + yytext() + " >>\n"
                        + "\tColumna: " + (yycolumn + 1) + "\n"
                                + "\tLinea: " + (yyline + 1));
    } 
}
