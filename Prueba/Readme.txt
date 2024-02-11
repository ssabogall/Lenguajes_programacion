El instalador para la librería es, lo pones en consola y se descarga: `pip install automata-lib`
El Python que utilizamos fue: Python 3.11
Referencias para el código de Python: [Enlace al video tutorial](https://www.youtube.com/watch?v=7nENzjQTxCc)

### Ejemplos de uso (Python):

- **Caso 1:**
  - Entrada: 1111
  - Salida: The string 1111 is accepted by the DFA or deterministic automata finite.

- **Caso 2:**
  - Entrada: 0101
  - Salida: The string 0101 is not accepted by the DFA or deterministic automata finite.

- **Caso especial:**
  - Entrada: (Presionar solo enter)
  - Salida: The string is accepted by the DFA or deterministic automata finite.

- **Caso vacío:* *
  - Entrada: (Espacio y luego enter)
  - Salida: The string is accepted by the DFA or deterministic automata finite.

En estos casos, se acepta el "enter" ya que el estado de aceptación está superpuesto en el estado inicial y al mismo tiempo en el estado de aceptación. Es decir, como empieza en q0 y el "enter" no se moverá, se queda en q0, lo cual no presenta problema porque q0 también es el estado de aceptación.

También se acepta el caso vacío, ya que lo agregamos al lenguaje, por lo cual también lo acepta junto con sus variantes.
