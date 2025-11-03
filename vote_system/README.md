#### Compilação

No diretório raiz do projeto `vote_system`, execute o seguinte comando:

```bash
mvn clean install
```

Isso irá compilar o projeto, incluindo os arquivos do Protocol Buffers, e criar um arquivo JAR no diretório `target`.

#### Executando o Servidor

Para executar o servidor, execute o seguinte comando a partir do diretório raiz do projeto `vote_system`:

```bash
mvn exec:java -Dexec.mainClass="org.example.Server"
```

O servidor será iniciado e aguardará as conexões do cliente.

#### Executando o Cliente

Para executar o cliente, abra um novo terminal e execute o seguinte comando a partir do diretório raiz do projeto `vote_system`:

```bash
mvn exec:java -Dexec.mainClass="org.example.Client"
```
