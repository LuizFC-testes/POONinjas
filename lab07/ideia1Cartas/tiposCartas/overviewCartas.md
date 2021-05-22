# Tipos de cartas

* Classe
> * Não custam mana
> * Devem ser posicionadas no turno do jogador
> * Se uma carta de **Classe** for posicionada ao alcance de uma carta de **Classe** inimiga, é iniciado um combate
> * Chance de cada Classe ser gerada no deck de um jogador: (100/8)% = 12,5%
> * Chance de uma carta de Classe pertencer a cada um de seus domínios possíveis (caso hajam):
>       a = soma de todos os efeitos de Bioma aplicáveis a esse domínio, em porcentagem convertida para decimal
>       b = soma de todos os "a", para cada domínio possível para a Classe
>       N = total de domínios disponíveis para a classe
>       Chance = (1-a)/(N-b) * 100%
>       a mostrado na [tabela](https://docs.google.com/spreadsheets/d/1KCd8NYCPeKlN8TocUbEiz-J65pHxVxKd-FUS_zUa-qk/edit#gid=0)
>       Exemplo: Chance de um Paladino ter Domínio de Luz
>       Paladino pode ter domínio de Luz, Sombra, Fogo e Gelo
        a = 0,2; b = (0,2) + (-0,1) + (0,05) + (0) = 0,15; N = 4
        Chance de ter domínio Luz = (1 - 0,2)/(4 - 0,15) * 100% = 20,78% 

* Armadilha
> * Custam 1 mana
> * Deve ser posicionada no turno do jogador
> * É acionada se uma carta de classe (de qualquer jogador) é posicionada no alcance dela, depois dela
> * Surtindo efeito nessa carta ou não, ela é destruída

* Magia
> * Custam 2 mana
> * Pode ser jogada a qualquer hora