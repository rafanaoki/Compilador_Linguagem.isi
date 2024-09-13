# COMO USAR

<b>Navegue até o direório do projeto pelo terminal e execute:</b>
<br></br>
java -jar antlr-4.13.2-complete.jar -visitor -o antlr SimpleLang.g4

javac -cp ".;antlr-4.13.2-complete.jar" antlr/*.java SimpleLangInterpreter.java

java -cp ".;antlr-4.13.2-complete.jar;antlr" SimpleLangInterpreter

<h1>Documentação da Linguagem SimpleLang</h1>
 
<h2>Visão Geral</h2>
<p><strong>SimpleLang</strong> é uma linguagem de programação simples desenvolvida para fins educativos. Ela suporta operações básicas de controle de fluxo, manipulação de variáveis e entrada/saída.</p>

  <h2>Estrutura do Programa</h2>
  
<p>Um programa em SimpleLang é estruturado da seguinte forma:</p>
<pre><code>programa
    declarações
    instruções
fimprog
</code></pre>
            <ul>
                <li><code>programa</code>: Palavra-chave que inicia o programa.</li>
                <li><code>declarações</code>: Bloco onde as variáveis são declaradas.</li>
                <li><code>instruções</code>: Bloco que contém o código executável.</li>
                <li><code>fimprog</code>: Palavra-chave que termina o programa.</li>
            </ul>

<h2>Declarações</h2>
<p>Variáveis são declaradas no bloco de declarações usando a palavra-chave <code>declare</code>. As variáveis podem ser do tipo <code>inteiro</code>, <code>real</code> ou <code>string</code>.</p>

  <h3>Sintaxe</h3>
<pre><code>declare tipo ID (',' ID)* '.'
</code></pre>
<ul>
   <li><code>tipo</code>: Tipo da variável (<code>inteiro</code>, <code>real</code>, ou <code>string</code>).</li>
   <li><code>ID</code>: Identificador da variável.</li>
</ul>

<h3>Exemplo</h3>
<pre><code>declare inteiro x, y.
declare real z.
declare string nome.
</code></pre>

<h2>Instruções</h2>
 <p>As instruções em SimpleLang incluem atribuições, operações de entrada/saída e estruturas de controle.</p>

 <h3>Atribuição</h3>
<p>Atribuições são feitas usando a palavra-chave <code>:='</code>. A atribuição pode opcionalmente terminar com um ponto.</p>

<h4>Sintaxe</h4>
<pre><code>ID := expr ('.')?
</code></pre>
            <ul>
                <li><code>ID</code>: Identificador da variável.</li>
                <li><code>expr</code>: Expressão que será atribuída à variável.</li>
            </ul>

<h4>Exemplo</h4>
<pre><code>x := 10.
y := x + 5.
</code></pre>

<h3>Saída</h3>
<p>Saída pode ser feita usando <code>escreva</code> para imprimir texto ou valores, e <code>escrevaln</code> para imprimir com uma quebra de linha.</p>

<h4>Sintaxe</h4>
<pre><code>escreva '(' (STRING | ID) ')' '.'
escrevaln '(' (STRING | ID) ')' '.'
</code></pre>
            <ul>
                <li><code>STRING</code>: Texto a ser impresso.</li>
                <li><code>ID</code>: Variável a ser impressa.</li>
            </ul>

<h4>Exemplo</h4>
<pre><code>escreva("O valor de x é ", x).
escrevaln("Linha com quebra").
</code></pre>

<h3>Leitura</h3>
<p>Entrada de dados é realizada com <code>leia</code>.</p>

<h4>Sintaxe</h4>
<pre><code>leia '(' ID ')' '.'
</code></pre>
            <ul>
                <li><code>ID</code>: Variável onde o valor será armazenado.</li>
            </ul>

<h4>Exemplo</h4>
<pre><code>leia(x).
</code></pre>

<h3>Estruturas de Controle</h3>
            <p><strong>SimpleLang</strong> suporta estruturas de controle como <code>if</code>, <code>while</code>, e <code>for</code>.</p>

<h4>If</h4>
<p>Estrutura condicional básica.</p>

<h5>Sintaxe</h5>
<pre><code>if '(' expr ')' '{' stmts '}' 'else' '{' stmts '}'
</code></pre>
            <ul>
                <li><code>expr</code>: Expressão condicional.</li>
                <li><code>stmts</code>: Bloco de instruções a serem executadas.</li>
            </ul>

<h5>Exemplo</h5>
<pre><code>if (x > 10) {
    escrevaln("x é maior que 10").
} else {
    escrevaln("x não é maior que 10").
}
</code></pre>

<h4>While</h4>
<p>Estrutura de repetição com base em condição.</p>

<h5>Sintaxe</h5>
<pre><code>while '(' expr ')' '{' stmts '}'
</code></pre>
            <ul>
                <li><code>expr</code>: Expressão condicional.</li>
                <li><code>stmts</code>: Bloco de instruções a serem executadas.</li>
            </ul>

<h5>Exemplo</h5>
<pre><code>while (x < 10) {
    x := x + 1.
}
</code></pre>

  <h4>For</h4>
            <p>Estrutura de repetição com inicialização, condição e incremento.</p>

<h5>Sintaxe</h5>
            <pre><code>for '(' assignStmt expr '.' assignStmt ')' '{' stmts '}'
</code></pre>
            <ul>
                <li><code>assignStmt</code>: Atribuição inicial e incremento.</li>
            </ul>

<h5>Exemplo</h5>
            <pre><code>for (x := 0 . x < 10 . x := x + 1) {
    escrevaln(x).
}
</code></pre>

<h2>Tipos de Dados</h2>
            <ul>
                <li><code>inteiro</code>: Números inteiros.</li>
                <li><code>real</code>: Números de ponto flutuante.</li>
                <li><code>string</code>: Sequências de caracteres, delimitadas por aspas duplas.</li>
            </ul>

<h3>Literais</h3>
            <ul>
                <li><code>Inteiros</code>: <code>42</code></li>
                <li><code>Reais</code>: <code>3.14</code></li>
                <li><code>Strings</code>: <code>"texto"</code></li>
            </ul>
        </div>
    </div>
</body>
</html>
