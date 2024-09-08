# LastFmApp
Aplicación que muestra los principales artistas más escuchados en Colombia y sus canciones más importantes mediante el consumo de la API last.fm.

# Clonación de repositorio
El proyecto se encuentra en la rama máster, con nivel de nivel de API mínimo requerido para la instalación de la aplicación es: 21 y android gradle plugin versión usada es: 8.5.2.

# Herramientas 
* retrofit2
* Glide
* androidx
* google material

# Aquitectura
Para este proyecto se usó la arquitectura MVVM que es un patrón de arquitectura que ayuda a organizar mejor las aplicaciones Android al separar la lógica de negocio, la interfaz de usuario, y la gestión de datos. El ViewModel actúa como intermediario entre la View (interfaz) y el Model (datos), permitiendo que la vista se actualice automáticamente cuando los datos cambian, sin tener que encargarse de la lógica. Esto hace que el código sea más fácil de mantener, probar y escalar. 

# Endpoints
* Top artistas por país: http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country={pais}&api_key={api_key}&format=json
* Top canciones por artista: https://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&artist={nombre_artista}&api_key={api_key}&format=json
