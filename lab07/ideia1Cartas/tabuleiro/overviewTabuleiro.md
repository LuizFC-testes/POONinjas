# Tabuleiro

* Gerado aleatoriamente (quanto ao posicionamento dos terrenos)

* Quadrado (n x n casas)

* A borda do lado de cada jogador representa o seu reino

* Cada casa tem um tipo primário de terreno **(bioma)**

* Podem haver tipos secundários **(construções)** de terrenos associados a (poucos) terrenos específicos, os quais conferem bônus ao jogador que os dominar

* Chance de cada terreno ser gerado com certo Bioma:

> * c = [soma](https://docs.google.com/spreadsheets/d/1KCd8NYCPeKlN8TocUbEiz-J65pHxVxKd-FUS_zUa-qk/edit#gid=0) de todos os efeitos aplicáveis pelo Bioma a cada Domínio
> * d = soma dos "c" de todos os biomas
> * Chance de o terreno ser gerado com certo bioma: (1-c)/(8-d) * 100%
> * Exemplo: Chance de qualquer terreno ser gerado com Caverna = (1-(-0,1))/(8-0,25) * 100% = 14,19%