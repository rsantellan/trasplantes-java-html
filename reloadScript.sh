#!/bin/bash
date
php symfony doctrine:build --all --and-load --no-confirmation
date
echo "Empezando la carga de datos"
php symfony loading:cargarDatos
date
