package com.github.paulpanther.intellijsmalltalk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes.*;

%%

%{
  public _SmalltalkLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _SmalltalkLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

LINE_TERMINATOR=\r|\n|\r\n
WHITE_SPACE=[ \t\n\x0B\f\r]+
IDENTIFIER=[a-zA-Z_][a-zA-Z_0-9]*
NUMBER=[0-9]+
KEYWORD=[a-zA-Z_]+:
STRING='[^']*'
BINARY_OPERATOR=[*+\\\-/~<>@=,%&?!]+
COMMENT=\"[^\"]*\"

%%
<YYINITIAL> {
  {WHITE_SPACE}          { return WHITE_SPACE; }

  "."                    { return STATEMENT_SEPERATOR; }
  "("                    { return PARENTHESIS_START; }
  ")"                    { return PARENTHESIS_END; }
  ":="                   { return ASSIGNMENT_OPERATOR; }
  "^"                    { return RETURN_OPERATOR; }
  "|"                    { return BLOCK_VARIABLE_SEPERATOR; }
  "["                    { return BLOCK_START; }
  "]"                    { return BLOCK_END; }
  "nil"                  { return NIL; }
  "true"                 { return TRUE; }
  "false"                { return FALSE; }
  "self"                 { return SELF; }
  "super"                { return SUPER; }
  "BLOCK_ARGUMENT"       { return BLOCK_ARGUMENT; }

  {LINE_TERMINATOR}      { return LINE_TERMINATOR; }
  {WHITE_SPACE}          { return WHITE_SPACE; }
  {IDENTIFIER}           { return IDENTIFIER; }
  {NUMBER}               { return NUMBER; }
  {KEYWORD}              { return KEYWORD; }
  {STRING}               { return STRING; }
  {BINARY_OPERATOR}      { return BINARY_OPERATOR; }
  {COMMENT}              { return COMMENT; }

}

[^] { return BAD_CHARACTER; }
