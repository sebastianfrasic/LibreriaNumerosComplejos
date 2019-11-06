#!/usr/bin/env python
# coding: utf-8

# In[14]:


from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import numpy as np
import math
get_ipython().run_line_magic('matplotlib', 'notebook')
# Para interactuar con las gráficas  


# In[15]:


#Graficar a Bogotá

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

phi, theta = np.mgrid[0 : 2 * np.pi : 0.1, 0 : np.pi : 0.1]  # Equivale a hacer un doble for

# Para pasar de coordenadas esféricas (phi, theta) a coordenadas cartesianas (x, y, z):


x = np.cos(phi) * np.sin(theta)
y = np.sin(phi) * np.sin(theta)
z = np.cos(theta)

# Para graficar la esfera (estructura de alambre):

ax.plot_wireframe(x, y, z, color='gray', rstride=2, cstride=2, linewidth=0.5, alpha=0.8)

# Para graficar un punto cualquiera en el espacio 3d, en este caso (2, -2, 1):

phi= math.radians(-74.0833)
theta= math.radians(4.5964+90)

x = np.cos(phi) * np.sin(theta)
y = np.sin(phi) * np.sin(theta)
z = np.cos(theta)


ax.scatter(x, y, z, color='red', s=15) # El valor de s modifica el grosor del punto

# Para hacer una etiqueta, en este caso sobre el punto (2, -2, 1):

ax.text(z, y, z, 'Bogotá', color='black')

# Para graficar una flecha, en este caso del origen al punto (2, -2, 1):

ax.quiver(0, 0, 0, x, y, z, color='blue')

# Nombres de los ejes

ax.set_xlabel('Eje X')
ax.set_ylabel('Eje Y')
ax.set_zlabel('Eje Z')

plt.show()


# In[22]:


# El formato de cada entrada de la lista es: [Nombre_Ciudad, Latitud, Longitud]

ciudades = [
    ['Londres', 51.5, -0.1167],
    ['Bogotá', 4.5964, -74.0833],
    ['Roma', 41.8960, 12.4833],
    ['Melbourne', -37.8200, 144.9750],
    ['Nairobi', -1.2833, 36.8167],
    ['Santiago', -33.4500, -70.6670],
    ['Nueva York', 40.6943, -73.9249],
    ['Los Angeles', 34.1139, -118.4068],
    ['Moscú', 55.7522, 37.6155],
    ['Quito', -0.2150, -78.5001],
    ['Tokio', 35.6850, 139.7514],
    ['Lagos', 6.4433, 3.3915],
    ['Atenas', 37.9833, 23.7333],
    ['Belén de Pará', -1.4500, -48.4800],
    ['Budapest', 47.5000, 19.0833],
    ['Vancouver', 49.2734, -123.1216],
    ['París', 48.8667, 2.3333],
    ['Puebla', 19.0500, -98.2000],
    ['Cancún', 21.0833, -86.85],
    ['Honolulu', 21.3069401, -157.8583374],
    ['Bután', 27.4660892, 89.6419067],
    ['Sri Lanka', 6.9319400, 79.8477800],
    ['Dubai', 25.0502900, 55.2379400]
    
]

#Graficar a las ciudades. Wepaaa

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

phi, theta = np.mgrid[0 : 2 * np.pi : 0.1, 0 : np.pi : 0.1]  # Equivale a hacer un doble for

# Para pasar de coordenadas esféricas (phi, theta) a coordenadas cartesianas (x, y, z):

x = np.cos(phi) * np.sin(theta)
y = np.sin(phi) * np.sin(theta)
z = np.cos(theta)

# Para graficar la esfera (estructura de alambre):

ax.plot_wireframe(x, y, z, color='gray', rstride=2, cstride=2, linewidth=0.5, alpha=0.8)




for i in range(len(ciudades)):

    # Para graficar un punto cualquiera en el espacio 3d, en este caso (2, -2, 1):

    phi= math.radians(ciudades[i][2])
    theta= math.radians(ciudades[i][1]-90)

    x = np.cos(phi) * np.sin(theta)
    y = np.sin(phi) * np.sin(theta)
    z = np.cos(theta)


    ax.scatter(x, y, z, color='red', s=15) # El valor de s modifica el grosor del punto

    # Para hacer una etiqueta, en este caso sobre el punto (2, -2, 1):

    ax.text(x, y, z, ciudades[i][0], color='black')

    # Para graficar una flecha, en este caso del origen al punto (2, -2, 1):

    ax.quiver(0, 0, 0, x, y, z, color='blue')

    # Nombres de los ejes

    ax.set_xlabel('Eje X')
    ax.set_ylabel('Eje Y')
    ax.set_zlabel('Eje Z')

    plt.show()


# In[28]:


# El formato de cada entrada de la lista es: [Nombre_Ciudad, Latitud, Longitud]

kets = [
    ['Up', 0, 0],
    ['Down', 90, 0],
    ['In', 45, 90],
    ['Out', 45, -90],
    ['+', 45, 0],
    ['-', 45, 180]
    
    
]

#Graficar a las ciudades. Wepaaa

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

phi, theta = np.mgrid[0 : 2 * np.pi : 0.1, 0 : np.pi : 0.1]  # Equivale a hacer un doble for

# Para pasar de coordenadas esféricas (phi, theta) a coordenadas cartesianas (x, y, z):

x = np.cos(phi) * np.sin(theta)
y = np.sin(phi) * np.sin(theta)
z = np.cos(theta)

# Para graficar la esfera (estructura de alambre):

ax.plot_wireframe(x, y, z, color='gray', rstride=2, cstride=2, linewidth=0.5, alpha=0.8)




for i in range(len(kets)):

    # Para graficar un punto cualquiera en el espacio 3d, en este caso (2, -2, 1):

    phi= math.radians(kets[i][2])
    theta= 2*math.radians(kets[i][1])

    x = np.cos(phi) * np.sin(theta)
    y = np.sin(phi) * np.sin(theta)
    z = np.cos(theta)


    ax.scatter(x, y, z, color='red', s=15) # El valor de s modifica el grosor del punto

    # Para hacer una etiqueta, en este caso sobre el punto (2, -2, 1):

    ax.text(x, y, z, kets[i][0], color='black')

    # Para graficar una flecha, en este caso del origen al punto (2, -2, 1):

    ax.quiver(0, 0, 0, x, y, z, color='blue')

    # Nombres de los ejes

    ax.set_xlabel('Eje X')
    ax.set_ylabel('Eje Y')
    ax.set_zlabel('Eje Z')

    plt.show()


# In[ ]:




