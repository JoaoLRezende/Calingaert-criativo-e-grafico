            EXTR     glob_var   * rótulo externo, definido em outro módulo
            EXTDEF   add_var   * rótulo definido aqui, visível externamente
*
add_var     READ input
            ADD input
            WRITE input
            WRITE @1
            MULT @2
            RET
input       SPACE
