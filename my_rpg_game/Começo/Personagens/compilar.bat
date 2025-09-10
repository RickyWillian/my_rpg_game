@echo off
echo Compilando o projeto...
javac -cp "src;lib\jackson-core-2.13.3.jar;lib\jackson-databind-2.13.3.jar;lib\jackson-annotations-2.13.3.jar" src/Main.java src/story/*.java src/entities/*.java src/abilities/*.java src/itens/*.java src/services/*.java -encoding UTF-8
echo.
echo Compilacao concluida. Se nao houver mensagens de erro acima, esta tudo certo.
pause