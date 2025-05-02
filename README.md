# SpotBuild 💊

**Auxiliador de administrações de medicamentos**  
Backend desenvolvido em **Java 21** com **arquitetura Hexagonal** e uso das melhores práticas modernas de engenharia de software.

---

## 📌 Visão Geral

O **SpotBuild** é uma aplicação backend criada para **gerenciar e auxiliar na administração de medicamentos**, oferecendo uma base sólida, escalável e observável. Foi projetado com foco em qualidade de código, testes automatizados, segurança e modularidade.

---

## 🧱 Stack Tecnológica

### 🔗 Linguagem e Plataforma
- **Java 21 LTS**

### 🚀 Frameworks Principais
- **Spring Boot 3.x**
- **Spring Security** (com JWT)
- **Spring Data JPA (Hibernate)**

### 🏗️ Build & Dependências
- **Maven**

### 💃 Banco de Dados e Persistência
- **PostgreSQL**
- **Redis** (cache)
- **Flyway** (migrations versionadas)

### 🔄 Mapeamento de Objetos
- **MapStruct** (DTO ↔ Entity)

### 🐳 Infraestrutura e DevOps
- **Docker**
- **Docker Compose** (ambiente local completo)

### 🔐 Segurança
- **JWT** (autenticação stateless)
- **Spring Security** (proteção de endpoints)

### 📚 Documentação
- **Swagger / OpenAPI 3.0** (`springdoc-openapi`)

### 📈 Observabilidade
- **Micrometer** (métricas)
- **Prometheus** (coleta de métricas)
- **Grafana** (visualização)
- **Datadog** (observabilidade completa – logs, métricas, traces)

### 🧪 Testes
- **JUnit 5**
- **Mockito**
- **Testcontainers** (testes de integração reais com PostgreSQL, Redis, etc.)

### 📋 Validação
- **Jakarta Bean Validation** (`@NotNull`, `@Size`, etc.)

### 🪐 Utilitários Recomendados
- **Lombok** (boilerplate killer)
- **Spring Retry + Resilience4j** (tolerância a falhas)
- **SLF4J + Logback** (logging estruturado)

---

## 🧠 Arquitetura

Este projeto utiliza a **Arquitetura Hexagonal (Ports and Adapters)**, que garante:

- **Isolamento das regras de negócio**
- **Facilidade para testes unitários e de integração**
- **Baixo acoplamento com frameworks e tecnologias**
- **Facilidade para troca de banco, mensageria, ou APIs externas**

Estrutura básica:

```
spotbuild
├── application (casos de uso)
├── domain (entidades e regras de negócio)
├── infrastructure (implementações técnicas: banco, cache, etc.)
├── web (controllers/rest adapters)
└── config (segurança, beans, etc.)
```

---

## 🧪 Como Rodar Localmente

```bash
git clone https://github.com/seu-usuario/spotbuild.git
cd spotbuild
./mvnw clean install
docker-compose up
```

Acesse:
- API Docs: http://localhost:8080/swagger-ui.html
- Prometheus: http://localhost:9090
- Grafana: http://localhost:3000
- Datadog (se configurado): [sua instância/URL do Datadog]

---

## 🚧 Em Andamento

- [ ] Integração com notificações (ex: e-mail, push)
- [ ] Dashboard administrativo
- [ ] Auditoria de logs com ELK ou Loki

---

## 🧬 Frontend (Angular)

O projeto também conta com um **frontend em Angular 17** que consome a API documentada via Swagger, com estrutura modularizada e suporte à geração automática de clientes REST.

### 📊 Stack do Frontend
- **Angular 17+**
- **TypeScript**
- **RxJS**
- **Swagger TypeScript API** (gerador de clientes tipados via OpenAPI)

### 📁 Estrutura
```
frontend/
├── src/
│   ├── app/
│   │   ├── core/
│   │   │   ├── services/ (API clients)
│   │   │   └── interceptors/
│   │   ├── features/ (módulos funcionais)
│   │   └── app.module.ts
│   └── environments/
├── angular.json
├── package.json
└── tsconfig.json
```

### 🔄 Integração com Swagger
A API do backend é documentada via OpenAPI e usada pelo frontend via:
```bash
npx swagger-typescript-api -p http://localhost:8080/v3/api-docs -o src/app/core/services/api --axios
```

### 🔑 Autenticação JWT
O frontend utiliza um interceptor para enviar automaticamente o token JWT para as requisições autenticadas. O login retorna o token fornecido pela API.

### 🚀 Como rodar o Frontend
```bash
cd frontend
npm install
npm start
```
A aplicação Angular estará acessível em `http://localhost:4200`

---

## 📊 Licença

Este projeto é open source e distribuído sob a licença MIT.

---

> Desenvolvido com ❤️ e obsessão por código limpo.
