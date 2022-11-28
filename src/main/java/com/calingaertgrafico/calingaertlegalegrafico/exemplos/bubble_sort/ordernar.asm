        EXTDEF ordenar
        MACRO
        SWAP elem1 elem2
        COPY tmp &elem1
        COPY &elem1 &elem2
        COPY &elem2 tmp
        MEND
ordenar LOAD @121
        STORE curr_i
        COPY swapped @0
loop    LOAD curr_i
        ADD @1
        STORE curr_i
        ADD @1
        STORE curr_i2
        LOAD &curr_i
        SUB &curr_i2
        BRNEG end
        SWAP curr_i curr_i2
        LOAD swapped
        ADD @1
        STORE swapped
* verificar se atingimos o final do array
end     LOAD curr_i2
        SUB @126
        BRNEG loop
        LOAD swapped
        BRPOS ordenar
        RET
tmp     SPACE   * usado pela macro SWAP
curr_i  SPACE   * endereço do 1º elemento sendo comparado
curr_i2 SPACE   * endereço do 2º elemento sendo comparado
swapped CONST @0      * indica se houve algum swap nesta iteração