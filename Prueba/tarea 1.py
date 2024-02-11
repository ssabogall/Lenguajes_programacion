from automata.fa.dfa import DFA


x = input("Enter a string (valores de 0,1): ")
# Definimos el los valores como los estados, las transiciones de los estados , el lenguaje, estado de inicio y estado de aceptación  
# si agregamos el "none" en el lengueje el programa no aceptara el vacio (yo con esto me refiero al espacio).
# tuve que agregar como tal al lenguaje el espacio para que el programa aceptara el vacio o mejor dicho el que lo contiene.
dfa = DFA(
    states={'q0', 'q1', 'q2'},
    input_symbols={'0', '1', ' '},
    transitions={
        'q0': {'0': 'q0', '1': 'q1', ' ': 'q0'},
        'q1': {'0': 'q2', '1': 'q0', ' ': 'q0'},
        'q2': {'0': 'q1', '1': 'q2', ' ': 'q0'},
    },
    initial_state='q0',
    final_states={'q0'}
)

# Comprobamos si una cadena es aceptada por el DFA
for string in [x]:
    if dfa.accepts_input(string):
        print(f'The string {string} is accepted by the DFA or deterministic automata finite.')
    else:
        print(f'The string {string} is not accepted by the DFA or deterministic automata finite.')
    