#!/bin/bash
date
php symfony doctrine:build --all --and-load --no-confirmation
date
echo "Empezando la carga de datos"
php symfony loading:cargarDatos
date
echo "Empezando la carga de datos de transplantes"
java -jar exportarDatosTrasplante.jar
date
#php symfony loading:cargarDatosTransplante
