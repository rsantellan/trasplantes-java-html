#!/bin/bash
date
php symfony doctrine:build --all --and-load --no-confirmation
date
echo "Empezando la carga de datos"
php symfony loading:cargarDatos
date
echo "Empezando la carga de datos de transplantes (java)"
java -jar exportarDatosTrasplante.jar
date
echo "Empezando la carga de datos de cmv"
php symfony loading:cargarDatosTransplante
date
