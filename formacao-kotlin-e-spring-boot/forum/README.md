# Alura Forum
Projeto criado a partir da formação em kotlin e Spring Boot para explicação das aulas e os diferenciais do framework.

[Formação Kotlin e Spring Boot](https://cursos.alura.com.br/formacao-kotlin-spring-boot) *🚧 Em andamento 🚧*

---

#### P.s. Este projeto possui algumas diferenças do o projeto ensinado no curso.

### Diferenciais dos projetos
1. Utilização do [Liquibase](https://contribute.liquibase.com/extensions-integrations/directory/integration-docs/springboot/springboot/) no lugar do Flyway
2. Utilização do [MySQL](https://spring.io/guides/gs/accessing-data-mysql/) no lugar do H2
3. Utilização do [LoggerFactory](https://www.slf4j.org/api/org/slf4j/LoggerFactory.html)
4. Configuração logging level modificada no application.yml
5. Arquitetura de pastas um pouco distintas
6. Estrutura e comportamentos dos Mappers
7. Utilização de auditoria
8. Implementação do [HibernateStatistics](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#statistics) (Não utilizado)

---

#### TODO: [Spring Boot Admin](https://www.baeldung.com/spring-boot-changing-log-level-at-runtime)
#### TODO: [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)

---

## Requisitos
1. OpenJDK 11
2. Kotlin 1.6.21
3. Docker
4. MySQL

### Definindo as variaveis de ambiente utilizadas no application.yml 
#### IntelliJ IDEA

1. Clique em `Edit Configuration`
2. No input `Environment Variables`
    1. Configure as variáveis no padrão
        ```
        VARIABLE_A=a;VARIABLE_B=b
        ```
    2. Ou clique no ícone a direita `Browse`
        1. Clique no ícone `+`
        2. No campo `name` informe o nome da variável
        3. No campo `value` informe o valor da variável
        4. Clique em `OK`

#### Variaveis necessárias:
1. MYSQL_DATABASE 
2. MYSQL_USER
3. MYSQL_PASSWORD
