# Monitor de Bateria Android

## Descrição
Este aplicativo Android monitora o nível de bateria do dispositivo e exibe informações em tempo real de forma visual e interativa. Ele mostra a porcentagem da bateria, altera a cor da barra de progresso dependendo do nível (vermelho, laranja e verde) e reproduz sons diferentes conforme a faixa de bateria.

O objetivo principal do app é **educativo e de teste**, demonstrando como trabalhar com eventos do sistema, manipulação de UI e reprodução de áudio no Android. O aplicativo funciona tanto em **Kotlin** quanto em **Java**, podendo ser usado como referência para projetos Android.

## Funcionalidades
- Monitoramento contínuo do nível de bateria.
- Indicador de porcentagem da bateria em tempo real.
- Barra de progresso horizontal que muda de cor conforme o nível:
  - **Vermelho**: bateria <= 10%  
  - **Laranja**: bateria 11% - 50%  
  - **Verde**: bateria > 50%
- Reprodução de sons diferentes quando a bateria entra em uma nova faixa.
- Animação suave da barra de progresso.

---

## Como Funciona
1. Ao abrir o aplicativo, ele registra um **BroadcastReceiver** para capturar alterações no nível de bateria.
2. O nível da bateria é exibido em um **TextView**.
3. A **barra de progresso** se ajusta suavemente para o novo valor usando `ObjectAnimator`.
4. Dependendo da faixa da bateria, a barra muda de cor:
   - Vermelho: bateria crítica
   - Laranja: bateria média
   - Verde: bateria cheia
5. Um som correspondente à faixa da bateria é reproduzido **apenas quando a faixa muda**, evitando sons repetitivos.

---

## Tecnologias Utilizadas
- **Kotlin ou Java** → Lógica do app e manipulação do sistema de bateria.
- **XML** → Layout do aplicativo.
- **MediaPlayer** → Para reprodução de sons.
- **BroadcastReceiver** → Para capturar eventos de mudança de bateria.
- **ObjectAnimator** → Para animação suave da barra de progresso.
- **Android Studio** → IDE oficial para desenvolvimento Android.

---

## Observações
- Coloque os arquivos de som na pasta `res/raw/`.
- O app é seguro e educativo; não modifica ou apaga arquivos do dispositivo.
- Ideal para aprender sobre eventos do Android, UI dinâmica e manipulação de áudio.

---

## Conclusão
Este aplicativo é uma ferramenta prática para quem quer aprender sobre **desenvolvimento Android**, monitoramento de eventos do sistema e criação de interfaces interativas. Pode ser expandido para incluir gráficos, notificações e animações avançadas, tornando-o ainda mais profissional.
