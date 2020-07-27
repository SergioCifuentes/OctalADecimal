
package octaladecimal.jflex;
import octaladecimal.cup.Simbolos;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexico
%cupsym Simbolos
%cup
%cupdebug
%line
%column

/*Identifiers*/
Numero = [01234567]


%%//Reglas Lexicas

<YYINITIAL>{
        {Numero}                 {return new Symbol(Simbolos.OCTAL, yycolumn,yyline,yytext());}
        [ \t\r\n\f]                            {}
        .                                            {return new Symbol(Simbolos.ERROR,yycolumn,yyline,yytext());} 
 
}