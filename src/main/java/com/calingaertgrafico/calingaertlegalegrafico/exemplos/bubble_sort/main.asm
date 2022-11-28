        EXTDEF array
        EXTR ordenar
* ler 5 números do usuário, populando array
* o operando imediato abaixo é o endereço do array, e deve ser alterado
* sempre que o endereço dele mudar
* (i.e. sempre que adicionarmos ou removermos instruções nesta parte inicial).
        LOAD @122
        STORE curr_i
        READ &curr_i
loop    LOAD curr_i
        ADD @1
        STORE curr_i
        READ &curr_i
        SUB @126
        BRNEG loop
        CALL ordenar
        STOP
curr_i  SPACE * endereço do elemento sendo lido
array   CONST @69
        SPACE
        SPACE
        SPACE
        SPACE
