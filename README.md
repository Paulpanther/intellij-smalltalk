# intellij-smalltalk

![Build](https://github.com/Paulpanther/intellij-smalltalk/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)


<!-- Plugin description -->
Adds Highlighting and RunConfig for the Smalltalk Language
<!-- Plugin description end -->

This is not meant as an actual attempt to create a working Smalltalk Plugin. 
I'm only using this project to learn Intellij Plugin Dev.

## Features
- [x] Incomplete BNF of Smalltalk (Cascates are missing for example)
- [x] Syntax Highlighting
- [x] Run Configuration for Unix

## Setup
1. Clone this repo
2. Install Grammar-Kit
3. Right-click on `Smalltalk.bnf` and `Generate Parser Code` and `Generate Lexer`
4. Right-click the Lexer file and `Run JFlex Lexer`
5. After Updating the BNF you have to delete the generated code and regenerate it
