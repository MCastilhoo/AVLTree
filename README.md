# Implementação de Árvore de Pesquisa Binária 🌲

Este repositório contém a implementação de uma árvore de pesquisa binária (Binary Search Tree - BST) em Java. O objetivo desta atividade é demonstrar o uso de estruturas de dados e algoritmos aprendidos, além de calcular a complexidade de tempo das operações implementadas.  

## Descrição da Atividade 📝

Foi solicitado que fosse implementado o problema da árvore de pesquisa binária utilizando um dos algoritmos aprendidos durante o curso. 

Além disso, esta atividade também abrange a solução de um problema específico disponível no seguinte link:  
[Basecamp Problem 4147](https://basecamp.eolymp.com/en/problems/4147)  

## Linguagem Utilizada 💻

A implementação foi realizada em **Java**, visando aproveitar a robustez da linguagem para trabalhar com estruturas de dados.  

## Funcionalidades Implementadas 🛠️

- **Inserção de Elementos (`insert`)**: Adiciona um novo elemento à árvore e, se necessário, realiza rotações para manter o balanceamento da árvore.
- **Remoção de Elementos (`delete`)**: Remove um elemento da árvore, reestruturando-a para preservar o balanceamento e a propriedade de árvore binária de pesquisa.
- **Verificação de Existência de Elementos (`exists`)**: Verifica se um determinado valor existe na árvore.
- **Próximo Elemento (`next`)**: Retorna o próximo maior elemento na árvore (em ordem crescente) em relação ao valor fornecido.
- **Elemento Anterior (`prev`)**: Retorna o próximo menor elemento na árvore (em ordem crescente) em relação ao valor fornecido.
- **k-ésimo Elemento (`kth`)**: Retorna o k-ésimo menor elemento da árvore em ordem crescente.

No pior caso, a altura da árvore pode ser igual ao número de nós (O(n)), tornando as operações lineares. No melhor caso, com uma árvore balanceada, a altura é O(log n).  

## Solução do Problema 🧠

O código também inclui a solução para o problema proposto no link acima. Essa solução foi implementada utilizando a estrutura de árvore de pesquisa binária para garantir eficiência.  

## Execução ⚙️

1. Certifique-se de ter o **Java Development Kit (JDK)** instalado em sua máquina.  
2. Clone este repositório:  
   ```bash
   git clone https://github.com/MCastilhoo/AVLTree/tree/main
   ```
3. Navegue até o diretório do projeto:
    ```bash
    cd <diretorio-do-projeto>
    ```
4. Compile o código-fonte;
    ```bash
    javac Main.java
    ```
5. Execute o programa:
   ```bash
   java Main
   ```
## Entrada 🚪

O programa aceita comandos no seguinte formato;
- **insert x:** Insereve o valor `x` na árvore.
- **delete x:** Remove o valor `x` da árvore.
- **exists x:** Verifica se o valor `x` existe na árvore.
- **next x:** Retorna o próximo maior elemento em relação a `x`.
- **prev x:** Retorna o próximo menor elemento em relação a `x`.
- **kth x:** Retorna o k-ésimo menor elemento na árvore.

## Exemplo de uso 🌐

Entrada:

![image](https://github.com/user-attachments/assets/39ce4911-fdf6-47dc-8c0e-dc60d85c20a1)

Saída esperada:

![image](https://github.com/user-attachments/assets/490dad81-8dcf-48dd-aabb-4403fdd876e4)


