package Jflextest;
import static Jflextest.Token.*;
%%
%class NewLexer
%type Token


white=[ ]
tab=[\t]
contemail = ([A-Z]|[a-z])[A-Za-z0-9"_""-""."]*
conector = [a-z]?[a-z]?[a-z]?[a-z]?"_"
nombre = [A-Z][a-z]+"_"

nombreC = {nombre} {conector}* {nombre}? {conector}* {nombre}? {conector}*	([A-Z][a-z]+)
tellocal = ("("[0-9][0-9]")-")?	([0-9][0-9]"-"[0-9][0-9]"-"[0-9][0-9]"-"[0-9][0-9])
celular = ("["[0-9][0-9][0-9]"]""-"|[0-9][0-9][0-9]"-")?([0-9][0-9]"-"[0-9][0-9]"-"[0-9][0-9]"-"[0-9][0-9]"-"[0-9][0-9])
email = {contemail}"@"{contemail}
mastercard = ("51"]|"52"|"53"|"54"|"55")[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
visa = "4"[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]


%{
	public String lexeme;
%}
%%

{tab} {lexeme=yytext(); return Tab; }
{white} {lexeme=yytext(); return White; }
{nombreC} {lexeme=yytext(); return Nombre; }
{tellocal} {lexeme=yytext(); return Tellocal; }
{celular} {lexeme=yytext(); return Celular; }
{email} {lexeme=yytext(); return Email; }
{mastercard} {lexeme=yytext(); return Mastercard; }
{visa} {lexeme=yytext(); return Visa; }


. {lexeme=yytext(); return ERROR;}