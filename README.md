# 📚 Lista 5 — Programação Orientada a Objetos em Java

Guia completo e resolução detalhada de todos os 18 exercícios da **Lista 5**, abordando conceitos centrais da linguagem Java:
- **Passagem por Valor vs. Passagem por Referência (Primitivos e Objetos)**
- **Retorno de Métodos (`return` vs. métodos `void`)**
- **Operador de Identidade (`==`) vs. Método de Igualdade Semântica (`equals()`)**
- **Sobrescrita do Método `equals()` herdado de `Object`**
- **Encapsulamento, Modificadores de Acesso e Regras de Negócio**

---

## 📁 Estrutura dos Exercícios

| Arquivo | Descrição / Tópico Principal |
| :--- | :--- |
| [`Exercicio1.java`](./Exercicio1.java) | **Dobro de um número**: Demonstração de passagem por valor em tipos primitivos e isolamento de escopo. |
| [`Exercicio2.java`](./Exercicio2.java) | **Troca de valores**: Por que Java não permite troca direta de primitivos por valor e solução com arrays. |
| [`Exercicio3.java`](./Exercicio3.java) | **O Cofre Digital**: Métodos com retorno booleano e uso direto de expressões em estruturas `if`. |
| [`Exercicio4.java`](./Exercicio4.java) | **Calculando a pontuação**: Devolução de valores `int` vs. impressão direta em console (`void`). |
| [`Exercicio5.java`](./Exercicio5.java) | **A casa mudou de dono e de tamanho**: Mutação de atributos via referência compartilhada vs. reatribuição local (`new Casa()`). |
| [`Exercicio6.java`](./Exercicio6.java) | **A troca de controle**: Efeito de atribuição local `a = b` e modificação de atributos de objetos no Heap. |
| [`Exercicio7.java`](./Exercicio7.java) | **Rastreamento de referências**: Identificação de apontamentos, objetos órfãos e conceito de `null`. |
| [`Exercicio8.java`](./Exercicio8.java) | **Rastreamento avançado**: Questões Verdadeiro/Falso, novas atribuições e ciclo de vida do Garbage Collector. |
| [`Exercicio9.java`](./Exercicio9.java) | **`equals()` e `==`**: Strings instanciadas com `new` (endereço de memória vs. conteúdo de texto). |
| [`Exercicio10.java`](./Exercicio10.java) | **`equals()` e `==`**: Atribuição de referências (`endereco2 = endereco1`) para o mesmo objeto. |
| [`Exercicio11.java`](./Exercicio11.java) | **`equals()` e `==`**: Comparações múltiplas entre objetos distintos com mesmo valor e referências duplicadas. |
| [`Exercicio12.java`](./Exercicio12.java) | **`equals()` e `==`**: Reatribuição de referências e análise de descarte de objetos pelo Garbage Collector. |
| [`Exercicio13.java`](./Exercicio13.java) | **Sobrescrita do `equals()`**: Teoria da herança de `Object`, comportamento padrão (`==`) e necessidade do `@Override`. |
| [`Exercicio14.java`](./Exercicio14.java) | **Pessoa e CPF**: Implementação de `equals()` usando CPF como chave de negócio de unicidade. |
| [`Exercicio15.java`](./Exercicio15.java) | **Ingressos de cinema**: Sobrescrita de `equals()` por número da poltrona para evitar vendas duplicadas. |
| [`Exercicio16.java`](./Exercicio16.java) | **Funcionário e Salário**: Encapsulamento com controle de acesso diferenciado (Funcionário vs. Gerente). |
| [`Exercicio17.java`](./Exercicio17.java) | **Conta Bancária**: Proteção estrita de saldo sem `setSaldo`, utilizando métodos de negócio `depositar()` e `sacar()`. |
| [`Exercicio18.java`](./Exercicio18.java) | **Sistema de Pedidos de Restaurante**: Modelagem orientada a objetos completa de `Pedido` com itens, taxas, descontos e validação de entrega. |

---

## 📖 Resolução e Respostas Detalhadas das Questões

### Exercício 1 — Dobro de um número
- **Pergunta**: O valor de `numero` será alterado após a execução de `dobrar()`? Explique o motivo.
- **Resposta**: **NÃO**. Em Java, **todos** os parâmetros de tipos primitivos (`int`, `double`, `boolean`, etc.) são passados estritamente **por valor**. Ao invocar `dobrar(numero)`, a JVM copia o valor `10` para uma nova variável local na pilha de execução do método `dobrar`. Qualquer modificação ou cálculo afeta unicamente esse parâmetro local; a variável `numero` pertencente ao método `main()` permanece inalterada com o valor `10`.

---

### Exercício 2 — Troca de valores
- **Pergunta**: É possível realizar essa troca diretamente usando passagem por valor em Java? Explique.
- **Resposta**: **NÃO**. Java não disponibiliza passagem por referência para variáveis primitivas (como os ponteiros `*` ou referências `&` em C++). Ao passar `a` e `b` para `trocar(int a, int b)`, o método recebe apenas cópias independentes dos valores. Reatribuir os valores dentro do método afeta apenas as variáveis locais temporárias.
- **Desafio**: Para viabilizar a troca de dados entre métodos em Java, deve-se utilizar uma estrutura mutável (como um array `int[] valores = {10, 20};` ou uma classe que encapsule os atributos), onde o método recebe a referência para a estrutura e altera seu conteúdo interno, ou retornar os novos valores.

---

### Exercício 3 — O Cofre Digital
- **Desafio**: Usar o método diretamente dentro do `if`, sem criar a variável `acesso`.
- **Código**:
  ```java
  if (verificarSenha(senha)) {
      System.out.println("Acesso liberado!");
  } else {
      System.out.println("Senha incorreta!");
  }
  ```
- **Conceito Chave**: Métodos que possuem um tipo de retorno (como `boolean`) são avaliados em tempo de execução como expressões de seu tipo de retorno. Dessa forma, podem ser consumidos diretamente em condições, atribuições ou expressões matemáticas sem a necessidade de variáveis intermediárias quando o valor não precisar ser reutilizado.

---

### Exercício 4 — Calculando a pontuação
- **Pergunta**: O método `calcularPontos()` imprime a pontuação ou devolve a pontuação para quem o chamou? Explique a diferença entre essas duas situações.
- **Resposta**: O método **DEVOLVE** (retorna) a pontuação para o chamador através da palavra-chave `return`.
- **Diferença**:
  1. **Método `void` que imprime**: Executa uma ação externa (efeito colateral) exibindo o texto no console, mas o dado computado é imediatamente perdido após o término do método. O chamador não consegue utilizá-lo para tomar decisões ou armazená-lo.
  2. **Método com retorno**: Devolve o resultado processado para a instrução chamadora. Isso promove **baixo acoplamento**, flexibilidade e reutilização de código, permitindo que quem chamou decida se quer exibir no terminal, comparar com uma meta (ex.: `if (pontuacao >= 1000)`), salvar em banco de dados ou repassar a outro serviço.

---

### Exercício 5 — A casa mudou de dono e de tamanho
- **Questão para Reflexão**: O método `modificarCasa()` recebe uma cópia da referência para o objeto `Casa`. Por que, então, as alterações (`casa.quartos = casa.quartos + 2;` e `casa.proprietario = "Ana";`) são percebidas no `main()`?
  - **Resposta**: Porque a referência passada por valor contém o **endereço de memória** do objeto alocado na memória **Heap**. Mesmo sendo uma cópia da referência, ela aponta fisicamente para o **mesmo objeto** que a variável do `main()`. Ao acessar e alterar os campos do objeto através dessa referência (`casa.quartos`), estamos modificando o estado interno do objeto compartilhado.
- **Desafio (`casa = new Casa()`)**: Por que a casa original do `main()` não passa a ter "João" e 10 quartos?
  - **Resposta**: A instrução `casa = new Casa()` instancia um *novo* objeto no Heap e faz a variável de parâmetro local `casa` apontar para esse novo endereço. Essa atribuição reescreve apenas o ponteiro local do método; a variável original do `main()` continua apontando para o primeiro objeto (que permaneceu com "Ana" e 5 quartos).

---

### Exercício 6 — A troca de controle
- **a) Qual será o resultado?**
  - `c1.jogador`: `"Maria"`
  - `c2.jogador`: `"Carlos"`
- **b) Por que `c1` não passou a apontar para o mesmo objeto que `c2`, mesmo tendo sido executado `a = b;`?**
  - Porque `a` é uma variável local (cópia da referência `c1`) existente na pilha de execução de `trocar()`. A instrução `a = b` apenas alterou para onde o parâmetro local `a` aponta. A variável original `c1` do `main()` permaneceu inalterada apontando para o objeto de `"Maria"`.
- **c) Por que, mesmo assim, o valor de `c2.jogador` foi alterado para "Carlos"?**
  - Porque após `a = b;`, a variável `a` passou a apontar exatamente para o objeto referenciado por `b` (que é o mesmo objeto de `c2`). Ao executar `a.jogador = "Carlos";`, o estado daquele objeto foi alterado no Heap, refletindo diretamente em `c2.jogador`.

---

### Exercício 7 — Rastreamento de referências
Fragmento:
```java
Casa c1 = new Casa("Ana");       // Objeto A
Casa c2 = new Casa("Bruno");     // Objeto B
Casa c3 = new Casa("Carlos");    // Objeto C
Casa c4 = new Casa("Daniel");    // Objeto D
Casa c5 = new Casa("Eduarda");   // Objeto E

c2 = c1;
c4 = null;
c5 = c3;
c1 = c5;
c3 = c2;
```

#### a. Tabela de Apontamento:
| Referência | Para qual objeto aponta? | Proprietário do objeto |
| :---: | :---: | :---: |
| **`c1`** | Objeto C | Carlos |
| **`c2`** | Objeto A | Ana |
| **`c3`** | Objeto A | Ana |
| **`c4`** | `null` (nenhum) | `null` (nenhum) |
| **`c5`** | Objeto C | Carlos |

- **b. Qual objeto possui mais de uma referência apontando para ele?**
  - **Objeto A ("Ana")**: apontado simultaneamente por `c2` e `c3`.
  - **Objeto C ("Carlos")**: apontado simultaneamente por `c1` e `c5`.
- **c. Existe algum objeto que não possui mais nenhuma referência apontando para ele? Se sim, qual ou quais?**
  - **Sim**. Os objetos **B ("Bruno")**, **D ("Daniel")** e **E ("Eduarda")** perderam todas as suas referências e tornaram-se elegíveis para coleta pelo Garbage Collector.
- **d. O que significa `null` neste contexto?**
  - Significa que a variável de referência não aponta para nenhuma instância de objeto válida na memória Heap (ausência de referência).
- **e. Qual referência está apontando para `null`?**
  - A referência **`c4`**.

---

### Exercício 8 — Rastreamento e Verdadeiro ou Falso

#### b. Verdadeiro ou Falso:
- **i. Depois de `c2 = c1`, `c1` e `c2` apontam para o mesmo objeto.**
  - `( V )` **Verdadeiro**. `c2` recebe uma cópia do endereço guardado em `c1`.
- **ii. `c4 = null` destrói imediatamente o objeto que `c4` referenciava.**
  - `( F )` **Falso**. Em Java, o objeto não é destruído imediatamente; ele torna-se *elegível* para a coleta de lixo, e o Garbage Collector decidirá de forma assíncrona quando liberar a memória.
- **iii. Depois de `c5 = c3`, `c5` e `c3` apontam para o mesmo objeto.**
  - `( V )` **Verdadeiro**. `c5` passa a referenciar o mesmo Objeto C ("Carlos").
- **iv. A instrução `c1 = c5` copia o objeto referenciado por `c5`.**
  - `( F )` **Falso**. A instrução copia apenas o endereço de memória (a referência), não duplicando o objeto na memória Heap.
- **v. Depois de `c1 = c5`, `c1` passa a apontar para o mesmo objeto que `c5`.**
  - `( V )` **Verdadeiro**. Ambas passam a conter o mesmo endereço.

#### c. Novas mudanças: `c2 = c4;` e `c4 = c3;`
- **i) Para onde `c2` está apontando?** -> Para **`null`** (pois `c4` era `null`).
- **ii) Para onde `c4` está apontando?** -> Para o **Objeto A ("Ana")** (pois `c3` apontava para Ana).
- **iii) Quais referências estão apontando para o mesmo objeto?**
  - `c1` e `c5` apontam para o **Objeto C ("Carlos")**.
  - `c3` e `c4` apontam para o **Objeto A ("Ana")**.

#### d. Executando: `c1 = c2; c2 = c3; c3 = c4; c4 = c5; c5 = null;`
Tabela resultante:
| Referência | Aponta para |
| :---: | :---: |
| `c1` | `null` |
| `c2` | Objeto A ("Ana") |
| `c3` | Objeto A ("Ana") |
| `c4` | Objeto C ("Carlos") |
| `c5` | `null` |

**Pergunta adicional: Se executarmos `c1 = c3;`:**
- **Qual referência foi alterada?** -> Apenas a referência **`c1`**.
- **Para qual objeto `c1` passa a apontar?** -> Passa a apontar para o **Objeto A ("Ana")**.
- **`c3` também foi alterada?** -> **Não**. Permanece apontando para o Objeto A ("Ana").
- **Algum objeto passou a não ter nenhuma referência apontando para ele?** -> **Não**. `c1` era `null` e passou a apontar para o Objeto A, enquanto o Objeto C continua apontado por `c4`. Nenhum objeto perdeu referências.

---

### Exercício 9 — `equals()` e `==`
- **a) Qual será a saída?**
  - `false`
  - `true`
- **b) `casa1` e `casa2` possuem o mesmo conteúdo?**
  - **Sim**. Ambas possuem a sequência de caracteres `"Casa Azul"`.
- **c) `casa1` e `casa2` são o mesmo objeto?**
  - **Não**. Por terem sido criadas explicitamente com a palavra-chave `new`, foram alocados dois objetos distintos em endereços diferentes no Heap.
- **d) O que o operador `==` está comparando nesse caso?**
  - Está comparando a **identidade física / referências de memória** (se ambas apontam para a mesma instância).
- **e) O que o método `equals()` está comparando?**
  - Está comparando o **conteúdo semântico** (a equivalência dos caracteres do texto).

---

### Exercício 10 — `equals()` e `==`
- **a) Qual será a saída?**
  - `true`
  - `true`
- **b) Quantos objetos String foram criados?**
  - **Apenas 1 objeto** String (houve apenas uma invocação de `new String("Rua das Flores")`).
- **c) Para qual objeto `endereco1` aponta?**
  - Para o objeto com valor `"Rua das Flores"`.
- **d) Para qual objeto `endereco2` aponta?**
  - Para exatamente o mesmo objeto apontado por `endereco1`.
- **e) Por que `endereco1 == endereco2` resulta em `true`?**
  - Porque a atribuição `endereco2 = endereco1` copiou o endereço de memória. Ambas as variáveis referenciam a mesmíssima instância no Heap.

---

### Exercício 11 — `equals()` e `==`
- **a) Qual será a saída das quatro linhas?**
  ```text
  false   (proprietario1 == proprietario2)
  true    (proprietario1 == proprietario3)
  true    (proprietario1.equals(proprietario2))
  true    (proprietario2.equals(proprietario3))
  ```
- **b) Quais referências apontam para o mesmo objeto?**
  - `proprietario1` e `proprietario3`.
- **c) Quais referências apontam para objetos diferentes?**
  - `proprietario1` e `proprietario2` (e consequentemente `proprietario2` e `proprietario3`).
- **d) Qual comparação verifica se os objetos são o mesmo objeto?**
  - O operador `==`.
- **e) Qual comparação verifica se os objetos possuem o mesmo conteúdo?**
  - O método `equals()`.

---

### Exercício 12 — `equals()` e `==`
- **a) Para qual objeto `cidade1` aponta?** -> Para `"Gurupi"`.
- **b) Para qual objeto `cidade2` aponta depois de `cidade2 = cidade1`?** -> Para `"Gurupi"`.
- **c) Qual será a saída?**
  - `true`
  - `true`
- **d) O objeto "Palmas" continua existindo após a atribuição? Explique considerando as referências.**
  - **Sim**, ele continua existindo temporariamente na memória Heap, mas ficou inacessível (sem nenhuma referência apontando para ele). Ele se torna elegível para descarte pelo Garbage Collector.
- **e) A instrução `cidade2 = cidade1` copia o objeto ou copia a referência?**
  - Copia unicamente a **referência** (o endereço de memória).

---

### Exercício 13 — Sobrescrita do método `equals()`
- **Conceito**: Toda classe em Java herda de `java.lang.Object`. A implementação original de `equals()` na classe `Object` simplesmente executa `(this == obj)`, ou seja, compara apenas se os endereços de memória são idênticos.
- Para comparar objetos pelo seu conteúdo ou por uma chave de negócio (como CPF, código, ID), é indispensável sobrescrever (`@Override`) o método `equals()`.

---

### Exercício 14 — Sobrescrita do `equals()` na classe `Pessoa`
- **a) Qual será a saída?**
  - `false` (`p1 == p2`)
  - `true` (`p1.equals(p2)`)
  - `false` (`p1.equals(p3)`)
- **b) `p1` e `p2` são o mesmo objeto?**
  - **Não**, são duas instâncias alocadas separadamente no Heap.
- **c) Por que `p1.equals(p2)` deve retornar `true`?**
  - Porque o método `equals()` foi sobrescrito para comparar o atributo `cpf`, e ambas possuem o CPF `"111.111.111-11"`.
- **d) O que mudou no comportamento do `equals()` depois da sobrescrita?**
  - Passou de verificação de identidade física de ponteiros (`==`) para verificação de igualdade lógica de atributos (mesmo CPF).
- **e) Por que comparar pessoas apenas com `==` pode ser inadequado?**
  - Porque uma mesma pessoa física pode ser instanciada em momentos ou locais diferentes no sistema (ex.: dados vindos do banco ou de uma API). O `==` diria que são pessoas diferentes por estarem em endereços de memória distintos, ignorando a identidade real do cidadão.
- **f) Qual informação foi escolhida como critério de igualdade?**
  - O atributo **`cpf`**.

---

### Exercício 15 — Ingressos de cinema
- **a) Qual será a saída?**
  - `false` (`i1 == i2`)
  - `true` (`i1.equals(i2)`)
  - `false` (`i1.equals(i3)`)
- **b) Por que `i1 == i2` e `i1.equals(i2)` podem apresentar resultados diferentes?**
  - `i1 == i2` avalia se ocupam o mesmo endereço de memória (são objetos distintos, logo `false`). `i1.equals(i2)` avalia a regra de negócio definida no método sobrescrito (compara se possuem o mesmo número de poltrona, ambos 25, logo `true`).
- **c) Qual é o critério usado para considerar dois ingressos iguais?**
  - O atributo **`numero`** (número da poltrona/ingresso).
- **d) Se o número de `i2` mudar para 30, quais comparações passarão a retornar `true`?**
  - A comparação entre `i2` e `i3` (`i2.equals(i3)` ou `i3.equals(i2)`), pois ambos terão número 30.
- **e) Qual é a vantagem de sobrescrever `equals()` nesse sistema?**
  - Impede que o mesmo assento seja vendido mais de uma vez (detecção automática de duplicidade em listas e conjuntos `Set`).
- **f) Por que o `equals()` padrão de `Object` não seria adequado para esse critério de igualdade?**
  - Porque o padrão compararia apenas referências de memória, permitindo vender duas instâncias diferentes de ingressos para a mesmíssima poltrona número 25.

---

### Exercício 16 — Funcionário e salário
- **1. Quem pode utilizar o método get do salário?**
  - O próprio funcionário titular e qualquer usuário com cargo/perfil de Gerente.
- **2. Quem pode utilizar o método set do salário?**
  - Exclusivamente o Gerente.
- **3. Por que o salário não deve ser um atributo de acesso direto?**
  - Porque atributos públicos não impõem restrições: qualquer parte do código poderia alterar salários para valores arbitrários, negativos ou desproporcionais sem autorização nem auditoria.
- **4. Qual é a importância do encapsulamento nesse caso?**
  - Oculta os dados confidenciais e garante que qualquer consulta ou alteração passe por regras estritas de segurança e validação de permissões.

---

### Exercício 17 — Conta bancária
- **1. Quais atributos devem possuir método get?**
  - Todos: `numeroConta`, `titular` e `saldo`.
- **2. Quais atributos podem possuir método set?**
  - Apenas o `titular` (para permitir correção ou atualização de nome). `numeroConta` e `saldo` não devem possuir método set.
- **3. Por que o saldo não deve possuir um set comum?**
  - Porque um `setSaldo(novoSaldo)` permitiria injetar qualquer quantia na conta, burlando regras de depósito, limites de saque, cálculo de taxas e conferência de saldo disponível.
- **4. Como o encapsulamento ajuda a proteger os dados da conta?**
  - Mantendo o saldo privado e disponibilizando apenas métodos com regras de negócio (`depositar()` e `sacar()`), garantindo que o saldo nunca fique negativo sem autorização e que as transações sejam íntegras.

---

### Exercício 18 — Sistema de Pedidos de Restaurante
- **Modelagem da Classe `Pedido`**:
  - Atributos privados: `nomeCliente`, `itens` (lista de `ItemPedido`), `valorAcumulado`, `desconto`, `taxaEntrega`, `pago`, `entregue`.
  - Métodos implementados:
    - `adicionarItem(nome, preco, quantidade)`: atualiza o subtotal acumulado do pedido.
    - `aplicarDescontoPorcentagem(percentual)`: calcula e armazena o valor do desconto.
    - `calcularTaxaEntrega(distanciaKm)`: calcula o frete com base na quilometragem.
    - `calcularValorFinal()`: calcula `(valorAcumulado - desconto) + taxaEntrega`.
    - `registrarPagamento()`: confirma o recebimento do valor do pedido.
    - `podeSerEntregue()`: verifica se o pedido contém itens, está pago e ainda não foi entregue.
    - `realizarEntrega()`: executa a entrega somente se as condições forem atendidas, emitindo alertas caso contrário.

---

## 🚀 Como Executar os Exercícios

### No VS Code:
1. Abra a pasta `lista_5` ou o workspace [`java-unirg.code-workspace`](../java-unirg.code-workspace).
2. Abra qualquer um dos arquivos `Exercicio1.java` a `Exercicio18.java`.
3. Clique em **Run** no CodeLens acima do método `main()` ou pressione `F5`.

### Pelo Terminal:
```powershell
# Acesse o diretório
cd c:\desenvolvimento\unirg\java\lista_5

# Compile o exercício desejado (ou todos)
javac -encoding UTF-8 Exercicio1.java
java Exercicio1

# Ou para compilar todos de uma vez:
javac -encoding UTF-8 *.java
```

