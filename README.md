# Estrategia de ramas

Este repositorio utiliza un flujo de trabajo con dos ramas principales:

- `master`: rama de **producción estable**.
- `dev`: rama de **integración** de cambios.

## Convención de nombres de ramas

- `feature/<descripcion-corta>` para nuevas funcionalidades.
  - Ejemplos:
    - `feature/inventario-persistente`
    - `feature/dialogos-npc`
- `release/<version-o-fecha>` para preparar una promoción a producción.
  - Ejemplos:
    - `release/v1.2.0`
    - `release/2026-04-03`
- `hotfix/<descripcion-corta>` para correcciones urgentes en producción (opcional, si aplica).

## Flujo recomendado

1. Crear ramas de trabajo desde `dev` (`feature/*`).
2. Integrar cada `feature/*` en `dev` mediante Pull Request.
3. Promover `dev` a `master` mediante Pull Request de release.

## Comandos Git de referencia

### 1) Preparar ramas principales (una sola vez)

```bash
git checkout master
git pull origin master

git checkout -b dev        # si no existe
git push -u origin dev
```

> Si `dev` ya existe en remoto:
>
> ```bash
> git checkout dev
> git pull origin dev
> ```

### 2) Crear una feature desde `dev`

```bash
git checkout dev
git pull origin dev

git checkout -b feature/mi-cambio
```

Realiza commits en tu feature y súbela al remoto:

```bash
git add .
git commit -m "feat: descripción del cambio"
git push -u origin feature/mi-cambio
```

Luego abre un PR: `feature/mi-cambio` ➜ `dev`.

### 3) Integrar features en `dev` por PR

- Revisión de código.
- Checks/CI en verde.
- Merge a `dev`.

### 4) Promover `dev` a `master` por PR de release

Opción directa:

- PR `dev` ➜ `master`.

Opción con rama de release:

```bash
git checkout dev
git pull origin dev

git checkout -b release/vX.Y.Z
git push -u origin release/vX.Y.Z
```

Luego abre PR: `release/vX.Y.Z` ➜ `master`.

## Resumen operativo

- Desarrollo diario: sobre `feature/*` desde `dev`.
- Integración continua: merge a `dev` por PR.
- Salidas a producción: PR de `dev` (o `release/*`) a `master`.
