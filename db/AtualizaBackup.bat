@echo off

echo ## ATUALIZA ARQUIVO DE BACKUP ##
::Pula linha
echo.

set mysqlBin=C:\Program Files\MySQL\MySQL Server 5.7\bin

if exist "%mysqlBin%" (
    echo usando caminho default "%mysqlBin%"
    set prossegue="true"
    set dirAlvo="default"

) else (
    
    if "%MYSQL_BIN%" == "" (
        echo O caminho padrao "C:\Program Files\MySQL\MySQL Server 5.7\bin" da pasta bin do mysql nao foi encontrado. Por favor, defina a variavel de ambiente "MYSQL_BIN" com o caminho da pasta bin no local de instalacao do seu MySql.
        set prossegue="false"

    ) else (
        echo usando MYSQL_BIN = "%MYSQL_BIN%"
        set prossegue="true"
        set dirAlvo="caminhoSetado"
    )
)

::Pula linha
echo.

setlocal EnableDelayedExpansion
    if %prossegue% == "true" (
        set /p nomeUsu= Digite o nome do usuario do DB: 
        set /p nomeDb= Digite o nome do database desejado: 
        set /p caminhoB= Digite o caminho completo para salvar o backup, no final informe nome_do_arquivo.sql: 
    )

    if "%dirAlvo%" == "default" (
        cd %mysqlBin%
    ) else (
        cd %MYSQL_BIN%
    )

    mysqldump -u!nomeUsu! -p !nomeDb! > !caminhoB!
endlocal
pause