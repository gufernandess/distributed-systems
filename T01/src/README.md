## 1. Compilação

Primeiro, você precisa compilar todos os arquivos `.java`. Abra seu terminal, navegue até o diretório `T01/src` e execute o seguinte comando:

```bash
find . -name "*.java" | xargs javac
```

Isso irá compilar todos os arquivos-fonte Java e criar os arquivos `.class` correspondentes em seus respectivos diretórios.

## 2. Execução

Após a compilação, você pode executar as classes principais. Lembre-se de executar o comando `java` a partir do diretório `T01/src`.

### OutputStream

Este programa grava um array de objetos `ScientificInitiationStudent` em um arquivo chamado `students.dat`.

```bash
java OutputStream
```

Isso criará um arquivo `students.dat` no diretório `T01/src`.

### SystemOut

Este programa demonstra o uso de `Student` e suas subclasses, imprimindo seus detalhes no console.

```bash
java SystemOut
```

### communication/Client e communication/Server

Esses programas demonstram uma comunicação cliente-servidor simples.

**1. Inicie o servidor:**

Em um terminal, execute o seguinte comando a partir do diretório `T01/src`:

```bash
java communication.Server
```

O servidor será iniciado e aguardará uma conexão do cliente.

**2. Execute o cliente:**

Em outro terminal, execute o seguinte comando a partir do diretório `T01/src`:

```bash
java communication.Client
```

O cliente enviará um objeto `ScientificInitiationStudent` para o servidor, e o servidor imprimirá as informações recebidas.

### output/TestFile

Este programa lê o arquivo `students.dat` criado por `OutputStream` e imprime as informações do aluno no console. Antes de executar este, certifique-se de que você já executou o programa `OutputStream`.

```bash
java output.TestFile
```

### output/TestStdin

Este programa lê dados serializados de `ScientificInitiationStudent` da entrada padrão. Ele foi projetado para ser usado em um pipeline com um programa que grava dados do aluno em sua saída padrão.

Uma maneira simples de testar o `TestStdin` é usar o arquivo `students.dat` gerado pelo `OutputStream`.

```bash
java output.TestStdin < students.dat
```

Isso redirecionará o conteúdo de `students.dat` para a entrada padrão de `TestStdin`.

### sockets/tcp/StudentTCPClient e sockets/tcp/StudentTCPServer

Esses programas demonstram uma comunicação cliente-servidor sobre soquetes TCP.

**1. Inicie o servidor:**

Em um terminal, execute o seguinte comando a partir do diretório `T01/src`:

```bash
java sockets.tcp.StudentTCPServer
```

O servidor será iniciado e aguardará as conexões do cliente.

**2. Execute o cliente:**

Em outro terminal, execute o seguinte comando a partir do diretório `T01/src`:

```bash
java sockets.tcp.StudentTCPClient
```

O cliente enviará um array de objetos `ScientificInitiationStudent` para o servidor, e o servidor imprimirá as informações recebidas para cada aluno.
