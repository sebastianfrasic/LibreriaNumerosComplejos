import numpy
from numpy import linalg as AL


def crea_matriz(tam_ren, tam_col):
 
    """
    Función que crea y regresa una matriz de tamaño tam_ren X tam_col
    inicializada con 0s. Observa que los subíndices de la matriz son
    valores que van de 0  a tam-1.
    """
    matriz = []
    for ren in range(tam_ren):
        matriz.append([0] * tam_col)
    return matriz
def carga_datos_matriz():
    """
    Función que pide al usuario los datos para una matriz y la regresa.
    """
    ren_mat = int(input('Ingrese cantidad de filas: '))
    col_mat = int(input('Ingrese cantidad de columnas: '))
    matriz = crea_matriz(ren_mat, col_mat)
    for ren in range(ren_mat):
        for col in range(col_mat):
            dato = input(f'Inserta el dato para la fila {ren} y la '
                             f'columna {col}: ')
            matriz[ren][col] = dato
    return matriz

def muestra_matriz(mat):
    """
    Función que muestra en la pantalla los datos de la matriz mat.
    """
    for ren in range(len(mat)):
        for col in range(len(mat[0])):
            print(f'{mat[ren][col]:3}', end='')
        print()
def main():
    x = carga_datos_matriz()
    print(x)
    muestra_matriz(x)
    omega = [[0, -0.5j, -1j, -3.5],
         [0.5j, 0, 3.5, -1j],
         [1j, 3.5, 0, -0.5j],
         [-3.5, 1j, 0.5j, 0]]

    observable = numpy.array(omega)
    (w, v) = AL.eig(observable)
    print("Valores propios:\n")
    print(w)
    print("\nVectores propios:\n")
    print(v)
main()
