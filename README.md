# Aplicativo de Gerenciamento de Notas Acadêmicas

## Descrição

Este projeto é um aplicativo Android desenvolvido para o gerenciamento de notas acadêmicas do curso de Análise e Desenvolvimento de Sistemas (ADS) de um aluno. O aplicativo conta com um formulário simples de cadastro que permite ao usuário inserir e validar informações acadêmicas, como nome, email, idade, disciplinas e notas bimestrais. O foco é criar uma experiência interativa com validação de campos e exibição de mensagens de erro, utilizando uma única activity.

## Funcionalidades

### 1. Formulário de Cadastro
O formulário contém os seguintes campos de entrada (todos obrigatórios):
- **Nome** (EditText)
- **Email** (EditText)
- **Idade** (EditText)
- **Disciplina** (EditText)
- **Nota 1º Bimestre** (EditText)
- **Nota 2º Bimestre** (EditText)

### 2. Botão de Envio
- Um botão que, ao ser pressionado, valida os dados inseridos. Caso algum campo esteja vazio ou a idade não seja um número válido, será exibida uma mensagem de erro no formato de TextView, indicando o campo incorreto.

### 3. Exibição dos Dados
- Após a validação bem-sucedida, um resumo das informações inseridas será exibido em um TextView abaixo do formulário, no seguinte formato:


### 4. Botão de Reset
- Um segundo botão é responsável por limpar todos os campos do formulário e redefinir a exibição do resumo.

### 5. Layout Responsivo
- O layout será organizado em um **LinearLayout** (orientação vertical) ou **ConstraintLayout**, garantindo que seja fácil de usar e adaptável para diferentes tamanhos de tela.
