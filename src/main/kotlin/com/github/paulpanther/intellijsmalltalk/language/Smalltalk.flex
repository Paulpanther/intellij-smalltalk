package com.github.paulpanther.intellijsmalltalk.language;

import com.github.paulpanther.intellijsmalltalk.language.psi.SmalltalkTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

%%

%class SmalltalkLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
  StringBuffer string = new StringBuffer();
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

Identifier = [A-Za-z_][A-Za-z0-9_]*
Keyword = [A-Za-z_]+:
Number = [0-9]+
BinaryOperator = [*+\\\-/~<>@=,%|&?!]+

CommentContent = [^\"]*
Comment = \" {CommentContent} \"

%state STRING

%%

<YYINITIAL> {
  "true" { return SmalltalkTypes.TRUE; }
  "false" { return SmalltalkTypes.FALSE; }
  "thisContext" { return SmalltalkTypes.THIS_CONTEXT; }
  "self" { return SmalltalkTypes.SELF; }
  "super" { return SmalltalkTypes.SUPER; }
  "nil" { return SmalltalkTypes.NIL; }
  "[" { return SmalltalkTypes.BLOCK_START; }
  "]" { return SmalltalkTypes.BLOCK_END; }
  "(" { return SmalltalkTypes.PARENTHESIS_START; }
  ")" { return SmalltalkTypes.PARENTHESIS_END; }
  "|" { return SmalltalkTypes.BLOCK_ARGUMENT_SEPERATOR; }
  "." { return SmalltalkTypes.STATEMENT_SEPERATOR; }
  "^" { return SmalltalkTypes.RETURN_OPERATOR; }
  ":=" { return SmalltalkTypes.ASSIGNMENT_OPERATOR; }

  {Comment} { return SmalltalkTypes.COMMENT; }
  {WhiteSpace} { return TokenType.WHITE_SPACE; }
  {Number} { return SmalltalkTypes.NUMBER; }
  {Identifier} { return SmalltalkTypes.IDENTIFIER; }
  {Keyword} { return SmalltalkTypes.KEYWORD; }
  {BinaryOperator} { return SmalltalkTypes.BINARY_OPERATOR; }

  "'" { yybegin(STRING); return SmalltalkTypes.STRING_START; }
}

<STRING> {
  "'" { yybegin(YYINITIAL); return SmalltalkTypes.STRING_END; }
  [^']+ { return SmalltalkTypes.STRING_CONTENT; }
}

[^] { return TokenType.BAD_CHARACTER; }
