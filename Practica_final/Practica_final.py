# Importa las bibliotecas necesarias
import random
from datetime import datetime, timedelta

# Define la clase Nodo
class Nodo:
    def __init__(self, Dia, Nombre, preguntas_correctas, Fecha, comodines, seguro_alcanzado):
        self.Dia = Dia
        self.Nombre = Nombre
        self.preguntas_correctas = preguntas_correctas
        self.Fecha = Fecha
        self.comodines = comodines
        self.Valor_Ganado = 0  # Inicializado en 0
        self.seguro_alcanzado = seguro_alcanzado
        self.siguiente = None

    def calcular_valor_ganado(self):
        # Define la tabla de valores
        tabla_valores = {
            15: 300000000,
            14: 100000000,
            13: 50000000,
            12: 20000000,
            11: 12000000,
            10: 10000000,
            9: 7000000,
            8: 5000000,
            7: 3000000,
            6: 2000000,
            5: 1000000,
            4: 500000,
            3: 300000,
            2: 200000,
            1: 100000
        }

        # Verifica si la pregunta tiene un seguro
        if self.preguntas_correctas == 5 and self.comodines == 1:
            return tabla_valores[5]  # Valor correspondiente a la pregunta 5 con seguro
        elif self.preguntas_correctas == 10 and self.comodines == 2:
            return tabla_valores[10]  # Valor correspondiente a la pregunta 10 con seguro

        # Verifica si la pregunta está en la tabla de valores
        if self.preguntas_correctas in tabla_valores:
            return tabla_valores[self.preguntas_correctas]

        # Si la pregunta no está en la tabla, devuelve 0
        return 0

# Define la clase ListaLigada
class ListaLigada:
    def __init__(self):
        self.cabeza = None

    def agregar_nodo(self, Dia, Nombre, preguntas_correctas, Fecha, comodines, seguro_alcanzado):
        nuevo_nodo = Nodo(Dia, Nombre, preguntas_correctas, Fecha, comodines, seguro_alcanzado)
        nuevo_nodo.Valor_Ganado = nuevo_nodo.calcular_valor_ganado()  # Calcula el valor ganado
        if not self.cabeza:
            self.cabeza = nuevo_nodo
        else:
            actual = self.cabeza
            while actual.siguiente:
                actual = actual.siguiente
            actual.siguiente = nuevo_nodo

    def recorrer_lista(self):
        actual = self.cabeza
        while actual:
            print(
                f"Día: {actual.Dia}, Nombre: {actual.Nombre}, Preguntas correctas: {actual.preguntas_correctas}, Tiempo Gastado: {actual.Fecha.strftime('%H:%M:%S')}, Comodines: {actual.comodines}, Valor Ganado: {actual.Valor_Ganado}, Seguro Alcanzado: {actual.seguro_alcanzado}")
            actual = actual.siguiente

    def buscar_nodo(self, Nombre):
        actual = self.cabeza
        while actual:
            if actual.Nombre == Nombre:
                return actual
            actual = actual.siguiente
        return None

    def eliminar_nodo(self, Nombre):
        if not self.cabeza:
            return

        if self.cabeza.Nombre == Nombre:
            self.cabeza = self.cabeza.siguiente
            return

        actual = self.cabeza
        previo = None
        while actual and actual.Nombre != Nombre:
            previo = actual
            actual = actual.siguiente

        if actual:
            previo.siguiente = actual.siguiente

def generar_hora_aleatoria(dia):
    hora_aleatoria = datetime.now().replace(
        hour=random.randint(0, 23),
        minute=random.randint(0, 59),
        second=random.randint(0, 59),
        microsecond=0
    )
    return hora_aleatoria

# Función principal
def main():
    # Lista de jugadores
    nombres_jugadores = ["Santiago", "Sara", "Alexander", "Gabriela", "Mateo"]
    Dia = ["Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"]

    # Crear una lista ligada para almacenar los jugadores
    ranking_list = ListaLigada()

    # Agregar jugadores a la lista
    for nombre in nombres_jugadores:
        preguntas_correctas = random.randint(1, 15)
        dia = random.choice(Dia)
        fecha = generar_hora_aleatoria(dia)
        comodines = random.randint(0, 3)

        if preguntas_correctas >=5 and preguntas_correctas <= 9:
            seguro_alcanzado = 1
        elif preguntas_correctas >=10 and preguntas_correctas <= 14:
            seguro_alcanzado = 2
        else:
            seguro_alcanzado = 0

        # Para determinar en qué seguro quedará:
        if preguntas_correctas >= 5 and preguntas_correctas <= 9 and seguro_alcanzado == 1:
            seguro_alcanzado = "El primer seguro"  # True si se cumple la condición
        elif preguntas_correctas >= 10 and preguntas_correctas <= 14 and seguro_alcanzado == 2:
            seguro_alcanzado = "El segundo seguro"  # True si se cumple la condición
        elif preguntas_correctas == 15:
            seguro_alcanzado = "Ganó quien quiere ser millonario"
        else:
            seguro_alcanzado = False

        ranking_list.agregar_nodo(dia, nombre, preguntas_correctas, fecha, comodines, seguro_alcanzado)

    # Mostrar la lista de jugadores
    print("\nRecorriendo la lista:")
    ranking_list.recorrer_lista()

    # Buscar un jugador al azar
    jugador_buscar = random.choice(nombres_jugadores)
    busqueda = ranking_list.buscar_nodo(jugador_buscar)
    if busqueda:
        print(
            f"\nNodo encontrado: Día: {busqueda.Dia}, Nombre: {busqueda.Nombre}, Preguntas Correctas: {busqueda.preguntas_correctas}, Tiempo Gastado: {busqueda.Fecha.strftime('%M:%S')}")
    else:
        print("\nNodo no encontrado")

    # Eliminar un jugador al azar
    jugador_eliminar = random.choice(nombres_jugadores)
    ranking_list.eliminar_nodo(jugador_eliminar)
    print("\nLista después de eliminar un nodo:")
    ranking_list.recorrer_lista()

if __name__ == "__main__":
    main()
