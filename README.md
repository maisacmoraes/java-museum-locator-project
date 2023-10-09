# Localizador de Museus - API de Busca de Museus

Este projeto é uma API desenvolvida em Java para facilitar a busca de museus com base em sua localização. Os dados utilizados são provenientes da série histórica do Cadastro Nacional de Museus.

## Funcionalidades

- Busca de Museus: A API permite buscar museus com base em critérios como localização geográfica e categoria.
- Detalhes do Museu: Obtém informações detalhadas sobre um museu específico.
- Tratamento de Erros: O projeto inclui um sistema de tratamento de erros robusto para lidar com exceções de forma adequada.

## Tecnologias Utilizadas

- **Spring Boot**: Utilizado para criar a aplicação Java de forma eficiente.
- **Spring Web**: Responsável pela criação de rotas da API.
- **Spring Data JPA**: Implementação de entidades e repositórios para persistência de dados.
- **Spring Dependency Injection**: Para conectar as camadas de controle e serviço.
- **Spring Exception Handling**: Tratamento de exceções na API.
- **JUnit**: Desenvolvimento de testes unitários para garantir a qualidade do código.
- **Docker**: Configuração da aplicação para execução em containers Docker.

## Iniciando

Para executar o projeto, siga os passos abaixo:

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/museufinder.git
cd museufinder
```

2. Construa a imagem Docker:

```bash
docker build -t museufinder .
```

3. Execute o contêiner Docker:

```bash
docker run -p 8080:8080 museufinder
```

Agora, o MuseuFinder estará disponível em `http://localhost:8080`.

## Testes

Certifique-se de que o projeto esteja em execução e execute os testes unitários para garantir que tudo funcione conforme o esperado:

```bash
./mvnw test
```

---

**Nota:** Este é um projeto fictício criado apenas para fins de demonstração e aprendizado. Não se destina a ser usado em produção, mas sim como um exemplo de como aplicar tecnologias Spring em um projeto Java.
