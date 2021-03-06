@ECHO OFF

ECHO ## ATUALIZA DATABASE ##
::Pula linha
ECHO.

SETLOCAL ENABLEDELAYEDEXPANSION

    SET MYSQL_BIN5=C:\Program Files\MySQL\MySQL Server 5.7\bin

    IF EXIST "!MYSQL_BIN5!" (
        ECHO usando caminho default "!MYSQL_BIN5!"
        SET prossegue="true"
        SET caminhoCd=!MYSQL_BIN5!

    ) ELSE (
        IF "!MYSQL_BIN!" == "" (
            ECHO O caminho padrao "C:\Program Files\MySQL\MySQL Server 5.7\bin" da pasta bin do mysql nao foi encontrado. Por favor, defina a variavel de ambiente "MYSQL_BIN" com o caminho da pasta bin no local de instalacao do seu MySql.
            SET prossegue="false"
        
        ) ELSE (
            IF EXIST "!MYSQL_BIN!" (
                ECHO usando MYSQL_BIN = "!MYSQL_BIN!"
                SET prossegue="true"
                SET caminhoCd=!MYSQL_BIN!
            ) ELSE (
                ECHO O caminho informado na variavel de ambiente MYSQL_BIN nao existe, por favor verifique!
                SET prossegue="false"
            )
        )
    )

    ::Pula linha
    ECHO.

    IF !prossegue! == "true" (
        SET /p nomeUsu= Digite o nome do usuario do DB: 
        SET /p nomeDb= Digite o nome do database a restaurar: 
        SET /p caminhoB= Digite o caminho completo do arquivo de backup, o final deve conter nome_do_arquivo.sql: 
           
        cd !caminhoCd!
        mysql -u!nomeUsu! -p !nomeDb! < !caminhoB!       
    )   

ENDLOCAL

PAUSE