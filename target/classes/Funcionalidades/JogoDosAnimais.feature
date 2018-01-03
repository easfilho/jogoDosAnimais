# language: pt
Funcionalidade: Jogo dos animais
  Como jogador do jogo dos animais
  Quero  jogar o jogo dos animais
  Para ver se o jogo descobre qual animal estou pensando

  Cenário: Deve mostrar Tubarão como primeira opção se escolhido que animal vive na água
    Dado que a lista de opções tem somente os valores iniciais
    E que seleciono que animal vive água
    Quando verificar qual animal estou pensando
    Então deve mostra a opção "Tubarão"

  Cenário: Deve mostrar lista de ações dos animais se escolhido que animal vive na água e informado algumas opções anteriormente
    Dado que a lista de opções tem somente os valores iniciais
    E que seleciono que animal vive água
    E que informo que o animal que estava pensando tem nome "Lambari" que faz "come isca" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Piranha" que faz "morde" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Cachorro" que faz "late" do tipo "TERRESTRE"
    Quando mostrar as opções de ações
    Então deve mostra a lista de ações
      | come isca |
      | morde     |

  Cenário: Deve mostrar animal quando informo ação já existente
    Dado que a lista de opções tem somente os valores iniciais
    E que informo que o animal que estava pensando tem nome "Lambari" que faz "come isca" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Piranha" que faz "morde" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Cachorro" que faz "late" do tipo "TERRESTRE"
    E que seleciono que animal vive água
    E que informo a ação "come isca"
    Quando verificar qual animal estou pensando
    Então deve mostra a opção "Lambari"

  Cenário: Deve mostrar Macaco como primeira opção se escolhido que animal não vive na água
    Dado que a lista de opções tem somente os valores iniciais
    E que seleciono que animal não vive água
    Quando verificar qual animal estou pensando
    Então deve mostra a opção "Macaco"

  Cenário: Deve mostrar lista de ações dos animais se escolhido que animal não vive na água e informado algumas opções anteriormente
    Dado que a lista de opções tem somente os valores iniciais
    E que informo que o animal que estava pensando tem nome "Lambari" que faz "come isca" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Piranha" que faz "morde" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Cachorro" que faz "late" do tipo "TERRESTRE"
    E que seleciono que animal não vive água
    Quando mostrar as opções de ações
    Então deve mostra a lista de ações
      | late |

      Cenário: Deve mostrar animal quando informo ação já existente
    Dado que a lista de opções tem somente os valores iniciais
    E que informo que o animal que estava pensando tem nome "Lambari" que faz "come isca" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Piranha" que faz "morde" do tipo "AQUATICO"
    E que informo que o animal que estava pensando tem nome "Cachorro" que faz "late" do tipo "TERRESTRE"
    E que seleciono que animal não vive água
    E que informo a ação "late"
    Quando verificar qual animal estou pensando
    Então deve mostra a opção "Cachorro"