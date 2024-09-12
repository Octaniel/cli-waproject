# Analisador de Hierarquia de Palavras

Esta aplicação Java é uma ferramenta de linha de comando (CLI) que analisa a hierarquia das palavras em uma frase e exibe a análise. Ela utiliza a biblioteca Gson para processar dados JSON.

## Pré-requisitos

- JDK 8 ou superior instalado.
- A biblioteca Gson versão 2.8.8 disponível localmente.

## Como rodar a aplicação

1. Clone o repositório ou faça o download do código-fonte.
2. Baixe a biblioteca Gson (versão 2.8.8) e coloque-a no diretório principal do projeto.
   - [Download Gson](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.8/gson-2.8.8.jar)

3. Compile o código Java utilizando o comando abaixo:

   ```bash
   javac -cp gson-2.8.8.jar src/*.java
   ```

4. Crie o arquivo `jar` da CLI:

   ```bash
   jar cfv cli.jar -C src/ .
   ```

5. Execute o Analisador de Hierarquia de Palavras com o seguinte comando:

   ```bash
   java -cp cli.jar:gson-2.8.8.jar Main analyze 3 "Eu amo papagaios e Zebras" --verbose
   ```

## Parâmetros

- `analyze`: Comando para iniciar a análise da frase.
- `3`: Número de níveis hierárquicos para a análise.
- `"Eu amo papagaios e Zebras"`: A frase que será analisada.
- `--verbose`: Exibe detalhes adicionais sobre a análise.

## Testando a Aplicação

1. Execute o comando de exemplo fornecido na seção anterior para verificar a análise de uma frase.
2. Teste diferentes frases e níveis hierárquicos para explorar as funcionalidades da CLI.

## Estrutura do Projeto

- `src/`: Contém todos os arquivos `.java` do projeto.
- `gson-2.8.8.jar`: Biblioteca externa utilizada para manipulação de JSON.
- `cli.jar`: Arquivo compilado do projeto.

## Autor

Octaniel José
