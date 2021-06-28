# Jogo Trilha da Glória

# Como executar

## Servidor
Trilha da Glória é um jogo multiplayer de dois jogadores e necessita de um servidor para funcionar.

Execute a classe `mc322.trilhadagloria.serverclient.TrilhaDaGloriaServer.java` para iniciar o servidor.

*Dica:* Pode ser usado um túnel de conexão para disponibilizar seu servidor local a um amigo (ex. [ngrok](https://ngrok.com/)).


## Cliente
Cada player deve iniciar um cliente na sua máquina (pode ser a mesma máquina usada como servidor).

Execute a classe `mc322.trilhadagloria.serverclient.TrilhaDaGloriaClient.java` para iniciar o cliente, informando o endereço e a porta de conexão ao servidor.

O jogo iniciará após que dois clientes tenham se conectado.
