# SpotBuild 💊  
**Assistente inteligente para administração de medicamentos**  
Frontend mobile desenvolvido em **React Native**, com arquitetura escalável e foco em performance, segurança e usabilidade.

---

## 📌 Visão Geral  
O **SpotBuild** é um aplicativo mobile projetado para **auxiliar pacientes e profissionais da saúde** na administração segura e organizada de medicamentos. Desenvolvido com foco em **UX de qualidade**, **modularidade de código**, **acessibilidade** e **integração fluida com APIs** externas e internas.

---

## 🧱 Stack Tecnológica

### ⚛️ Framework e Linguagem
- **Java (21)**
- **Spring** (3.x)
  
### 🧩 Gerenciamento de Estado
- **Zustand** (leve, performático e moderno)
- **React Context** (para temas, auth, etc.)

### 🌐 Comunicação com API
- **Axios** + interceptors (com JWT)
- **OpenAPI Generator** (clientes tipados)

### 🧑‍🎨 UI/UX
- **React Native Paper** ou **Tamagui** (UI Kit cross-platform)
- **React Navigation** (pilhas, tabs, drawer)
- **Lottie** (animações fluídas e acessíveis)
- **React Native SVG** (ícones e gráficos vetoriais)

### 📱 Funcionalidades Mobile
- **Push Notifications** (Firebase Cloud Messaging)
- **Deep Linking**
- **Geolocalização** (caso necessário)
- **Offline-first** com **MMKV** ou **Redux-Persist**

### 🔒 Segurança
- **Secure Storage** (expo-secure-store ou react-native-keychain)
- **Autenticação com JWT**
- **Biometria** (Face ID, Touch ID) com `expo-local-authentication`

### 🧪 Testes
- **Jest** (unitários)
- **React Native Testing Library** (componentes)
- **Detox** (e2e)

### 🔄 CI/CD
- **EAS** (Expo Application Services) ou **Fastlane** (builds e deploys automatizados)
- **GitHub Actions** (testes, lint, builds automáticos)

---

## 📁 Estrutura do Projeto

```bash
spotbuild-app/
├── src/
│   ├── assets/           # imagens, fontes, lotties
│   ├── components/       # componentes reutilizáveis
│   ├── features/         # módulos funcionais (medicamentos, login, notificações)
│   ├── navigation/       # pilhas e rotas
│   ├── services/         # api, auth, storage, etc.
│   ├── store/            # Zustand stores
│   ├── themes/           # temas e estilos globais
│   ├── hooks/            # custom hooks
│   └── App.tsx           # ponto de entrada
├── app.json              # config do Expo
├── package.json
└── tsconfig.json
````

---

## 🔄 Integração com API via Swagger / OpenAPI

Geramos os clientes tipados com base na especificação OpenAPI do backend:

```bash
npx @openapitools/openapi-generator-cli generate \
  -i http://localhost:8080/v3/api-docs \
  -g typescript-axios \
  -o src/services/api
```

---

## 🔑 Autenticação

O app autentica o usuário via **JWT**. O token é armazenado com segurança e adicionado automaticamente nas requisições autenticadas via interceptor Axios.

Login → Armazena token → Redireciona usuário autenticado.

---

## 🚀 Como Rodar Localmente

```bash
git clone https://github.com/seu-usuario/spotbuild-app.git
cd spotbuild-app
npm install
npx expo start
```

Você pode rodar o app em:

* Android/iOS físicos (via QR Code com Expo Go)
* Emuladores Android Studio / Xcode

---

## 🚧 Em Desenvolvimento

* Integração com notificações push (Firebase)
* Dashboard com gráficos de consumo
* Modo offline com sincronização
* Acessibilidade com VoiceOver e TalkBack

---

## 📊 Monitoramento e Logging

* **Sentry** (erros e performance)
* **Firebase Analytics** ou **Amplitude**
* **react-native-logs** para logging estruturado

---

## 📄 Licença

Este projeto é open source e distribuído sob a licença **MIT**.

---

Desenvolvido com ☕, 💊 e paixão por UX de verdade.
*Código limpo salva mais vidas do que parece.*

```
